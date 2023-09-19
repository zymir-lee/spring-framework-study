package pers.zymir.spring.mvc.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Objects;

public class GenderChecker implements ConstraintValidator<Gender, Integer> {

    @Override
    public boolean isValid(Integer integer, ConstraintValidatorContext constraintValidatorContext) {
        if (Objects.equals(integer, 1) || Objects.equals(integer, 0)) {
            return true;
        }
        return false;
    }
}
