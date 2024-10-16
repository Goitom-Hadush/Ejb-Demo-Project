/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package et.gov.insa.erp.commonApplications.util;

import java.util.Map;
import java.util.regex.Pattern;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import org.primefaces.validate.ClientValidator;

/**
 *
 * @author Tsehayu Tilahun
 */
@FacesValidator("validatorUtil")
public class ValidatorUtil implements Validator, ClientValidator {

    public final static String NO_PATTERN = "NO_PATTERN";
    public final static String NAME_PATTERN = "NAME_PATTERN";
    public final static String PHONE_PATTERN = "PHONE_PATTERN";
    public final static String EMAIL_PATTERN = "EMAIL_PATTERN";
    public final static String WEBSITE_PATTERN = "WEBSITE_PATTERN";
    public final static String REMARK_PATTERN = "REMARK_PATTERN";
    public final static String FLOAT_PATTERN = "FLOAT_PATTERN";
    public final static String DATE_PATTERN = "DATE_PATTERN";
    public final static String TEXT_PATTERN = "TEXT_PATTERN";
    public final static String PERCENT_PATTERN = "PERCENT_PATTERN";
    public final static String POBOX_PATTERN = "POBOX_PATTERN";
    public final static String HOUSE_NUMBER_PATTERN = "HOUSE_NUMBER_PATTERN";
    public final static String TIME_PATTERN = "TIME_PATTERN";
    public final static String YEAR_PATTERN = "YEAR_PATTERN";
    public final static String FULL_NAME_PATTERN = "FULL_NAME_PATTERN";
    public final static String MONEY_PATTERN = "MONEY_PATTERN";
    public final static String SALARY_PATTERN = "SALARY_PATTERN";
    public final static String NUMBER_PATTERN = "NUMBER_PATTERN";
    public final static String DOUBLE_PATTERN = "DOUBLE_PATTERN";
    public final static String ETHIOPIAN_NAME_PATTERN = "ETHIOPIAN_NAME_PATTERN";

    private static String getPattern(String patternIndex) {
        String pattern;
        switch (patternIndex) {
            case NO_PATTERN:
                pattern = "NO_PATTERN";
                break;
            case YEAR_PATTERN:
                pattern = "(^19[0-9]{2}$|^20[0-9]{2}$)";
                break;
            case DATE_PATTERN:
                pattern = "((^(19[0-9]{2}|20[0-9]{2})((\\/)|(-))(((0[1-9]|1[0-2])((\\/)|(-))"
                        + "(0[1-9]|[1-2][0-9]|30))|(([1]{1}[3]{1}((\\/)|(-))(([0]{1})[1-6]{1}"
                        + "))))$)|(^((((0[1-9]|[1-2][0-9]|30)((\\/)|(-))(0[1-9]|1[0-2]))|((([0]{1})[1-6]{1}"
                        + ")((\\/)|(-))[1]{1}[3]{1}))((\\/)|(-))(19[0-9]{2}|20[0-9]{2}))$))";
                break;
            case EMAIL_PATTERN:
                pattern = "^[a-zA-Z0-9-\\.]+@[a-zA-Z]{2,5}+\\.[a-zA-Z ]"
                        + "{3}+$|^[a-zA-Z0-9-\\.]+@[a-zA-Z]+\\."
                        + "[a-zA-Z]{2,5}+\\.[a-zA-Z ]{3}$";
                break;
            case PHONE_PATTERN:
                pattern = "^\\+?251\\-?\\-?[1-9][0-9]{2}\\-?[0-9]{6}|$|"
                        + "^[0][1-9][0-9]{2}\\-?[0-9]{6}|$|"
                        + "^\\+?[0-9]{1,3}\\-?\\-?[0-9]{3}\\-?[0-9]{6}$";
                break;
            case WEBSITE_PATTERN:
                pattern = "^[w]{3}+\\.[a-zA-Z0-9-]+\\.[a-zA-Z]{2,10}"
                        + "+\\.[a-zA-Z ]{2}+$|^[w]{3}+\\.[a-zA-Z0-9-]"
                        + "+\\.[a-zA-Z ]{2,10}+$";
                break;
            case PERCENT_PATTERN:
                pattern = "(^([0])||([1-9]{1}[0-9]?)$)";
                break;
            case POBOX_PATTERN:
                pattern = "^[0-9]{1,16}+[ሀ-ፖa-zA-Z]{1,20}+[0-9 ]+$|^[0-9 ]+$";
                break;
            case TIME_PATTERN:
                pattern = "^[0-1]?[1-9]:[0-5][0-9]$";
                break;
            case SALARY_PATTERN:
                pattern = "(^([1-9]{1}[0-9]{2,20})$||^([1-9]{1}[0-9]{2,20}"
                        + "\\.[0]?[0-9]{1,3})$)";
                break;
            case DOUBLE_PATTERN:
                pattern = "^[0-9]*\\.[0-9]*|[0-9]*|[0-9]*\\.[0-9]*Ee[0-9]*$";
                break;
            case MONEY_PATTERN:
                pattern = "(^([0]{1}\\.[0-9]{1,8})||([1-9]{1}[0-9]{0,20}"
                        + "\\.[0-9]{1,8})||([1-9]{1}[0-9]{0,20})||([0])$)";
                break;
            case HOUSE_NUMBER_PATTERN:
                pattern = "^[0-9]*$";
                break;
            case FLOAT_PATTERN:
                pattern = "^[0-9]*$|"
                        + "^[0-9]*\\.[0-9]{0,3}$";
                break;
            case NAME_PATTERN:
                pattern = "^[ሀ-ፖA-Za-z- ]*$";
                break;
            case REMARK_PATTERN:
                pattern = "^[ሀ-ፖa-zA-Z0-9 \\-]*$";
                break;
            case ETHIOPIAN_NAME_PATTERN:
                pattern = "^[ሀ-ፖa-zA-Z!,\\+\\/ \\.\\-]*$";
                break;
            case TEXT_PATTERN:
                pattern = "^[ሀ-ፖa-zA-Z0-9!,\\+\\/ \\.\\-]*$";
                break;
            case FULL_NAME_PATTERN:
                pattern = "^[ሀ-ፖa-zA-z \\.]*$";
                break;

            case NUMBER_PATTERN:
                pattern = "^[0-9 ]*$";
                break;
            default:
                pattern = "Error";
        }
        return pattern;
    }

    public static String getValidationMessage(String patternIndex) {
        String message = "";
        switch (patternIndex) {
            case NO_PATTERN:
                message = "";
                break;
            case YEAR_PATTERN:
                message = ": Value should be YYYY format";
                break;
            case DATE_PATTERN:
                message = ": Value should be DD/MM/YYYY or YYYY/MM/DD format";
                break;
            case EMAIL_PATTERN:
                message = ": The value should be ends with .com ex abc@yahoo.com";
                break;
            case PHONE_PATTERN:
                message = ": Value Should be Phone Number Format";
                break;
            case WEBSITE_PATTERN:
                message = ":  Value should be a Website Format";
                break;
            case PERCENT_PATTERN:
                message = ": Value should be a number";
                break;
            case POBOX_PATTERN:
                message = ": Value should be a number";
                break;
            case TIME_PATTERN:
                message = ": Value should be HH:MM format";
                break;
            case SALARY_PATTERN:
                message = ": Value should be a number";
                break;
            case DOUBLE_PATTERN:
                message = ": Value should be a number";
                break;
            case MONEY_PATTERN:
                message = ": Value should be a number";
                break;
            case HOUSE_NUMBER_PATTERN:
                message = ": Value should be a number";
                break;
            case FLOAT_PATTERN:
                message = ": Value should be a number";
                break;
            case NAME_PATTERN:
                message = ": Value should be a Text";
                break;
            case ETHIOPIAN_NAME_PATTERN:
                message = ": Value should be a Text";
                break;
            case REMARK_PATTERN:
                message = ": Value should be a Alphanumeric";
                break;
            case TEXT_PATTERN:
                message = ": Value should be a Alphanumeric";
                break;
            case FULL_NAME_PATTERN:
                message = ": Value should be a Text";
                break;
            case NUMBER_PATTERN:
                message = ": Value should be a number";
                break;
        }
        return message;
    }
    private Pattern pattern;
    private String message;

    public ValidatorUtil() {
    }

    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        String patternIndex = component.getAttributes().values().toString().split(",")[0].substring(1);
        pattern = Pattern.compile(getPattern(patternIndex));
        message = getValidationMessage(patternIndex);
        if ((value != null) && (!"".equals(value))) {
            if (!pattern.matcher(value.toString()).matches()) {
                throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Validation Error",
                        value + message));
            }
        }
    }

    public Map<String, Object> getMetadata() {
        return null;
    }

    public String getValidatorId() {
        return "validatorUtil";
    }

}
