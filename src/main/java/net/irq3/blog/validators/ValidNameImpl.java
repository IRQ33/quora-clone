package net.irq3.blog.validators;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ValidNameImpl implements ConstraintValidator<ValidName, String> {
    @Override public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return s.matches("^[a-zA-Z0-9_-ąęłćźżńóĄĘŁĆŹŻŃÓ]+$");
    }
}
