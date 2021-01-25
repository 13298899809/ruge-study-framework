package com.ruge.validator.anno;

import org.junit.platform.commons.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author 嘿丷如歌
 * @version V1.0
 * @Description: 手机号校验
 * @date 2021/1/25 23:30
 */
public class IsMobileValidator implements ConstraintValidator<IsMobile, String> {


    /**
     * Initializes the validator in preparation for
     * calls.
     * The constraint annotation for a given constraint declaration
     * is passed.
     * <p>
     * This method is guaranteed to be called before any use of this instance for
     * validation.
     * <p>
     * The default implementation is a no-op.
     *
     * @param constraintAnnotation annotation instance for a given constraint declaration
     */
    @Override
    public void initialize(IsMobile constraintAnnotation) {

    }

    /**
     * Implements the validation logic.
     * The state of {@code value} must not be altered.
     * <p>
     * This method can be accessed concurrently, thread-safety must be ensured
     * by the implementation.
     *
     * @param value   object to validate
     * @param context context in which the constraint is evaluated
     * @return {@code false} if {@code value} does not pass the constraint
     */
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        boolean flag = false;
        String regex = "^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(17[013678])|(18[0,5-9]))\\d{8}$";
        if (StringUtils.isBlank(value) || value.length() != 11) {
            flag = false;
            System.out.println("手机号应为11位数");
        } else {
            Pattern p = Pattern.compile(regex);
            Matcher m = p.matcher(value);
            boolean isMatch = m.matches();
            if (isMatch) {
                System.out.println("您的手机号" + value + "是正确格式@——@");
                flag = true;
            } else {
                flag = false;
                System.out.println("您的手机号" + value + "是错误格式！！！");
            }
        }
        return flag;
    }
}
