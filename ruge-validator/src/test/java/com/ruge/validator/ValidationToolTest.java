package com.ruge.validator;


import lombok.extern.slf4j.Slf4j;
import org.assertj.core.util.Arrays;
import org.hibernate.validator.HibernateValidator;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.constraints.NotNull;
import javax.validation.executable.ExecutableValidator;
import javax.validation.groups.Default;
import java.lang.reflect.Method;
import java.util.Set;

@Slf4j
@SpringBootTest
public class ValidationToolTest {
    private Validator validator;
    private ExecutableValidator executableValidator;
    private UserInfo userInfo = new UserInfo();

    @Before
    public void initValidator() {
        validator = Validation.buildDefaultValidatorFactory().getValidator();
        /*快速失败*/
        validator = Validation.byProvider(HibernateValidator.class).configure().failFast(true).buildValidatorFactory().getValidator();
        /*校验入参或返回值*/
        executableValidator = validator.forExecutables();
        userInfo.setAge(12);
        userInfo.setName("张三");
        userInfo.setGrade(new Grade());
    }

    @Test
    public void test1() {
        /*
         * 分组校验
         */
        Set<ConstraintViolation<UserInfo>> validate = validator.validate(userInfo, UserInfo.Update.class, Default.class);
        validate.forEach(e -> {
            log.info("属性:{},提示:{},模板:{}", e.getPropertyPath(), e.getMessage(), e.getMessageTemplate());
        });
    }

    /**
     * @param mobile 参数
     * @return 非bean入参校验
     */
    public Set<ConstraintViolation<ValidationToolTest>> getUserIdByMobile(@NotNull String mobile) {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        Method declaredMethod = null;
        try {
            declaredMethod = this.getClass().getDeclaredMethod(methodName, String.class);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return testNotBean(this, declaredMethod, new Object[]{mobile}, Default.class);
    }

    /**
     * 非bean入参校验  junit测试
     */
    @Test
    public void test2() {
        Set<ConstraintViolation<ValidationToolTest>> validate = getUserIdByMobile(null);
        validate.forEach(e -> {
            log.info("属性:{},提示:{},模板:{}", e.getPropertyPath(), e.getMessage(), e.getMessageTemplate());
        });
    }

    /**
     * @param object          对象
     * @param method          方法
     * @param parameterValues 参数
     * @param groups          组
     * @param <T>             泛型
     * @return 非bean入参校验 拦截器
     */
    public <T> Set<ConstraintViolation<T>> testNotBean(T object,
                                                       Method method,
                                                       Object[] parameterValues,
                                                       Class<?>... groups) {
        return executableValidator.validateParameters(object, method, parameterValues, groups);
    }
}