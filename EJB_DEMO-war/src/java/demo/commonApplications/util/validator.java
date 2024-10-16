package et.gov.insa.erp.commonApplications.util;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

/**
 * @author Aman
 */
/**
 * validator :- jsf page validator class, error messages (FacesMessage) can be
 * overriden by "validatorMessage" where ever necessary and if the a field is
 * required, you have to add required="true". e.g. inputText id="name"
 * label="Name" value="#{sothing}" validator="#{validator. Code}"
 * required="true" requiredMessage="Please fill Name." validatorMessage="Please
 * provide valid Name.">
 *
 */
@ManagedBean(name = "validator")
public class validator {

    public boolean Empty(String input) {
        return !input.isEmpty();
    }

    public void Code(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        String input;
        input = value.toString();
        if (!input.isEmpty()) {
            if (!input.matches("[A-Za-z]{1,5}[0-9]{1,5}")) {
                FacesMessage msg = new FacesMessage("Invalid input.", "Code Validation failed");
                msg.setSeverity(FacesMessage.SEVERITY_ERROR);
                throw new ValidatorException(msg);
            }
        }
    }

    public void Text(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        String input;
        input = value.toString();
        if (!input.isEmpty()) {
            if (!input.matches("[A-Za-z- ]{3,50}")) {
                FacesMessage msg = new FacesMessage("Invalid input.", "Validation failed");
                msg.setSeverity(FacesMessage.SEVERITY_ERROR);
                throw new ValidatorException(msg);
            }
        }
    }

    public void Phone(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        String input;
        input = value.toString();
        if (!input.isEmpty()) {
            if (!input.matches("^\\+?251\\-?\\-?[1-9][0-9]{2}\\-?[0-9]{6}|$|"
                    + "^[0][1-9][0-9]{2}\\-?[0-9]{6}|$|"
                    + "^\\+?[0-9]{1,3}\\-?\\-?[0-9]{3}\\-?[0-9]{6}$")) {
                FacesMessage msg = new FacesMessage("Invalid input.", "Phone Validation failed");
                msg.setSeverity(FacesMessage.SEVERITY_ERROR);
                throw new ValidatorException(msg);
            }
        }
    }

    public void Email(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        String input;
        input = value.toString();
        if (!input.isEmpty()) {
            if (!input.matches("[a-zA-Z0-9-\\.]+@[a-zA-Z]{2,10}+\\.[a-zA-Z ]"
                    + "{3}+$|^[a-zA-Z0-9-\\.]+@[a-zA-Z]+\\.[a-zA-Z]{2,5}+\\.[a-zA-Z ]{3}")) {
                FacesMessage msg = new FacesMessage("Invalid input.", "Email Validation failed");
                msg.setSeverity(FacesMessage.SEVERITY_ERROR);
                throw new ValidatorException(msg);
            }
        }
    }

    public void Website(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        String input;
        input = value.toString();
        if (!input.isEmpty()) {
            if (!input.matches("^[w]{3}+\\.[a-zA-Z0-9-]+\\.[a-zA-Z]{2,10}+\\.[a-zA-Z ]"
                    + "{2}+$|^[w]{3}+\\.[a-zA-Z0-9-]+\\.[a-zA-Z ]{2,10}+$")) {
                FacesMessage msg = new FacesMessage("Invalid input.", "Website Validation failed");
                msg.setSeverity(FacesMessage.SEVERITY_ERROR);
                throw new ValidatorException(msg);
            }
        }
    }

    public void Remark(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        String input;
        input = value.toString();
        if (!input.isEmpty()) {
            if (!input.matches("[a-zA-Z0-9., \\\\-]{0,200}")) {
                FacesMessage msg = new FacesMessage("Invalid input.", "Validation failed");
                msg.setSeverity(FacesMessage.SEVERITY_ERROR);
                throw new ValidatorException(msg);
            }
        }
    }

    public void Float(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        String input;
        input = value.toString();
        if (!input.isEmpty()) {
            if (!input.matches("[0-9]{1,10}\\\\.?[0-9]{0,10}")) {
                FacesMessage msg = new FacesMessage("Invalid input.", "Validation failed");
                msg.setSeverity(FacesMessage.SEVERITY_ERROR);
                throw new ValidatorException(msg);
            }
        }
    }

    public void Date(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        String input;
        input = value.toString();
        if (!input.isEmpty()) {
            if (!input.matches("[1-9]{1}[0-9]{3}((\\/)|(-))(((([0]{1}[1-9]{1})|"
                    + "([1]{1}[0-2]{1}))((\\/)|(-))(((([0]{1})|([1-2]{1}))[0-9]{1})|([3]{1}[0])))|"
                    + "([1]{1}[3]{1}((\\/)|(-))(([0]{1})[1-6]{1}|[1-6]{1})))")) {
                FacesMessage msg = new FacesMessage("Invalid input.", "Date Validation failed");
                msg.setSeverity(FacesMessage.SEVERITY_ERROR);
                throw new ValidatorException(msg);
            }
        }
    }

    public void Percent(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        String input;
        input = value.toString();
        if (!input.isEmpty()) {
            if (!input.matches("(([0])||([1-9]{1}[0-9]?))")) {
                FacesMessage msg = new FacesMessage("Invalid input.", "Validation failed");
                msg.setSeverity(FacesMessage.SEVERITY_ERROR);
                throw new ValidatorException(msg);
            }
        }
    }

    public void POBOX(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        String input;
        input = value.toString();
        if (!input.isEmpty()) {
            if (!input.matches("^[0-9]{1,16}+[a-zA-Z]{1,20}+[0-9 ]+$|^[0-9 ]+$")) {
                FacesMessage msg = new FacesMessage("Invalid input.", "P.O.BOX Validation failed");
                msg.setSeverity(FacesMessage.SEVERITY_ERROR);
                throw new ValidatorException(msg);
            }
        }
    }

    public void House(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        String input;
        input = value.toString();
        if (!input.isEmpty()) {
            if (!input.matches("[0-9]{1,10}")) {
                FacesMessage msg = new FacesMessage("Invalid input.", "House no Validation failed");
                msg.setSeverity(FacesMessage.SEVERITY_ERROR);
                throw new ValidatorException(msg);
            }
        }
    }

    public void Time(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        String input;
        input = value.toString();
        if (!input.isEmpty()) {
            if (!input.matches("^[0-1]?[1-9]:[0-5][0-9]$")) {
                FacesMessage msg = new FacesMessage("Invalid input.", "Time Validation failed");
                msg.setSeverity(FacesMessage.SEVERITY_ERROR);
                throw new ValidatorException(msg);
            }
        }
    }

    public void Year(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        String input;
        input = value.toString();
        if (!input.isEmpty()) {
            if (!input.matches("[0-9]{4}")) {
                FacesMessage msg = new FacesMessage("Invalid input.", "Year Validation failed");
                msg.setSeverity(FacesMessage.SEVERITY_ERROR);
                throw new ValidatorException(msg);
            }
        }
    }

    public void FullName(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        String input;
        input = value.toString();
        if (!input.isEmpty()) {
            if (!input.matches("[a-zA-z \\.]{2,50}")) {
                FacesMessage msg = new FacesMessage("Invalid input.", "Name Validation failed");
                msg.setSeverity(FacesMessage.SEVERITY_ERROR);
                throw new ValidatorException(msg);
            }
        }
    }

    public void Money(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        String input;
        input = value.toString();
        if (!input.isEmpty()) {
            if (!input.matches("(([0]{1}\\.[0-9]{1,8})||([1-9]{1}[0-9]{0,20}\\.[0-9]{1,8})||([1-9]{1}[0-9]{0,20})||([0]))")) {
                FacesMessage msg = new FacesMessage("Invalid input.", "Validation failed");
                msg.setSeverity(FacesMessage.SEVERITY_ERROR);
                throw new ValidatorException(msg);
            }
        }
    }

    public void Salary(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        String input;
        input = value.toString();
        if (!input.isEmpty()) {
            if (!input.matches("(([1-9]{1}[0-9]{2,20})||([1-9]{1}[0-9]{2,20}\\.[0]?[0-9]{1,3}))")) {
                FacesMessage msg = new FacesMessage("Invalid input.", "Salary Validation failed");
                msg.setSeverity(FacesMessage.SEVERITY_ERROR);
                throw new ValidatorException(msg);
            }
        }
    }

    public void Number(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        String input;
        input = value.toString();
        if (!input.isEmpty()) {
            if (!input.matches("^[0-9 ]+$")) {
                FacesMessage msg = new FacesMessage("Invalid input.", "Number Validation failed");
                msg.setSeverity(FacesMessage.SEVERITY_ERROR);
                throw new ValidatorException(msg);
            }
        }
    }

    public void Double(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        String input;
        input = value.toString();
        if (!input.isEmpty()) {
            if (!input.matches("[0-9]*\\.[0-9]*|[0-9]*|[0-9]*\\.[0-9]*Ee[0-9]*")) {
                FacesMessage msg = new FacesMessage("Invalid input.", "Number Validation failed");
                msg.setSeverity(FacesMessage.SEVERITY_ERROR);
                throw new ValidatorException(msg);
            }
        }
    }

    public void List(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        String input;
        input = value.toString();
        if (!input.isEmpty()) {
            if (!input.matches("[A-Za-z,. ]{2,100}")) {
                FacesMessage msg = new FacesMessage("Invalid input.", "List Validation failed");
                msg.setSeverity(FacesMessage.SEVERITY_ERROR);
                throw new ValidatorException(msg);
            }
        }
    }

    public void FilePath(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        String input;
        input = value.toString();
        if (!input.isEmpty()) {
            if (!input.matches("([a-zA-Z]:)?(\\\\[a-zA-Z0-9_.-]+)+\\\\?")) {
                FacesMessage msg = new FacesMessage("Invalid input.", "FilePath Validation failed");
                msg.setSeverity(FacesMessage.SEVERITY_ERROR);
                throw new ValidatorException(msg);
            }
        }
    }

    public void Grade(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        String input;
        input = value.toString();
        if (!input.isEmpty()) {
            if (!input.matches("[A-F+-]{1,3}")) {
                FacesMessage msg = new FacesMessage("Invalid input.", "Grade Validation failed");
                msg.setSeverity(FacesMessage.SEVERITY_ERROR);
                throw new ValidatorException(msg);
            }
        }
    }
}
