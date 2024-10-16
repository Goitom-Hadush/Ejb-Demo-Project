/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo.mapper;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.Id;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Yem
 */
public abstract class AbstractFacade<T> {

    private final Class<T> entityClass;

    public AbstractFacade(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    protected abstract EntityManager getEntityManager();

    public void create(T entity) {

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<T>> constraintViolations = validator.validate(entity);
        if (constraintViolations.size() > 0) {
            Iterator<ConstraintViolation<T>> iterator = constraintViolations.iterator();
            while (iterator.hasNext()) {
                ConstraintViolation<T> cv = iterator.next();
                System.err.println(cv.getRootBeanClass().getName() + "." + cv.getPropertyPath() + " " + cv.getMessage());

                JsfUtil.addErrorMessage(cv.getRootBeanClass().getSimpleName() + "." + cv.getPropertyPath() + " " + cv.getMessage());
            }
        } else {
            getEntityManager().persist(entity);
        }
        refresh();
    }

    public void edit(T entity) {
        getEntityManager().merge(entity);
        refresh();
    }

    public void remove(T entity) {
        getEntityManager().remove(getEntityManager().merge(entity));
    }

    public T find(Object id) {
        refresh();
        return getEntityManager().find(entityClass, id);
    }

    public List<T> findAll() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        return getEntityManager().createQuery(cq).getResultList();
    }

    public List<T> findRange(int[] range) {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        q.setMaxResults(range[1] - range[0] + 1);
        q.setFirstResult(range[0]);
        return q.getResultList();
    }

    public int count() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        javax.persistence.criteria.Root<T> rt = cq.from(entityClass);
        cq.select(getEntityManager().getCriteriaBuilder().count(rt));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        return ((Number) q.getSingleResult()).intValue();
    }

    public T saveOrUpdate(@NotNull T entity) {
        for (Field field : entity.getClass().getDeclaredFields()) {
            for (Annotation annotation : field.getDeclaredAnnotations()) {
                if (annotation instanceof Id) {
                    try {
                        Id id = Id.class.cast(annotation);
                        field.setAccessible(true); // so we can access the private fields for bean type
                        if (!isContainingValue(field.get(entity))) {
                            //TODO  if  any
                            // so we can access the private fields for bean type  
                            create(entity);
                            return entity;

                        } else {
                            edit(entity);
                            return entity;
                        }
                    } catch (IllegalArgumentException | IllegalAccessException ex) {
                        Logger.getLogger(entityClass.getName()).log(Level.SEVERE, null, ex);
                    }
                }

            }
        }

        return entity;
    }

    private boolean isContainingValue(Object value) {
        boolean containsValue = false;
        if (value != null) {
            if (value instanceof String) {
                containsValue = !String.class.cast(value).trim().isEmpty();
            } else if ((value instanceof Integer)) {
                containsValue = !Integer.class.cast(value).equals(0);
            } else {
                containsValue = true;
            }
        }

        return containsValue;
    }

    public void refresh() {
        getEntityManager().getEntityManagerFactory().getCache().evictAll();
    }

}
