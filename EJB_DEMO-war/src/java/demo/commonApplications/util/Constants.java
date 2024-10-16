/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package demo.commonApplications.util;

import java.util.Locale;
import java.util.ResourceBundle;
import javax.faces.context.FacesContext;

/**
 *
 * @author yohanis
 */
public class Constants {

    public Constants() {
    }
    public final static int ROW_ADDED = 1;
    public final static int ROW_UPDATED = 2;
    public final static int ROW_DELETED = 3;
    public final static int ROW_FETCHED = 4;

    public final static int PREPARE_VALUE = 0;
    public final static int APPROVE_VALUE = 2;
    public final static int REJECT_VALUE = 3;
    public final static int CHECK_VALUE = 1;

    public final static String DOCUMENT_ACTIVE_STATUS = "Active";
    public final static String DOCUMENT_INACTIVE_STATUS = "inActive";

    private static final String COMPONENT_BUNDLE = "demo.controller.Bundle";

    public static String getComponentBundle(String key) {
        FacesContext context = FacesContext.getCurrentInstance();
        Locale locale = context.getViewRoot().getLocale();
        ResourceBundle bndl = ResourceBundle.getBundle(COMPONENT_BUNDLE,
                locale);
        return bndl.getString(key);
    }

    public String englishAction() {
        FacesContext context = FacesContext.getCurrentInstance();
        context.getViewRoot().setLocale(Locale.ENGLISH);
        return null;
    }

}
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
