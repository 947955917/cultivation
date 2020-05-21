package com.programming.cultivation.hibernate;

import com.programming.cultivation.base.Book;
import org.apache.commons.collections4.CollectionUtils;
import org.hibernate.validator.HibernateValidator;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

public class ValidatorUtils {

    private static Validator validator = null;

    static {
        // 初始化 validator
        validator = Validation.byProvider(HibernateValidator.class)
                .configure().failFast(true).buildValidatorFactory().getValidator();
    }

    /**
     * 校验通过
     */
    private static final ValidateResult passed = new ValidateResult(true, "通过校验");

    public static ValidateResult validate(Object t) {
        Set<ConstraintViolation<Object>> violations = validator.validate(t);
        return toValidateResult(violations);
    }

    public static ValidateResult validateProperty(Object t, String propertyName) {
        Set<ConstraintViolation<Object>> violations = validator.validateProperty(t, propertyName);
        return toValidateResult(violations);
    }


    private static ValidateResult toValidateResult(Set<ConstraintViolation<Object>> violations) {
        if (CollectionUtils.isEmpty(violations)) {
            // 无冲突，通过校验
            return passed;
        }
        // 封装错误信息
        ValidateResult validateResult = null;
        for (ConstraintViolation<Object> violation : violations) {
            validateResult = new ValidateResult(false, violation.getMessage());
            break;
        }
        return validateResult;
    }

}
