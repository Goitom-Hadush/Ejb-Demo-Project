/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo.mapper;

import demo.entity.Address;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Yem
 */
@Stateless
public class AdressFacade extends AbstractFacade<Address> {

    @PersistenceContext(unitName = "EJB_DEMO-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AdressFacade() {
        super(Address.class);
    }
    
}
