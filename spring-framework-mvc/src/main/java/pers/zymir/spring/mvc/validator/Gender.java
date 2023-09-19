package pers.zymir.spring.mvc.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Target({ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.PARAMETER, ElementType.TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = GenderChecker.class)
public @interface Gender {
    String message() default "性别填写错误";

    Class<?>[] groups() default {};

    boolean required() default true;

    Class<? extends Payload>[] payload() default {};
}
