package net.irq3.blog.validators;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import net.irq3.blog.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UniqueEmailImpl implements ConstraintValidator<UniqueEmail, String> {
    @Autowired UserRepository userRepository;

    @Override public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return !userRepository.existsByEmail(s);
    }
}
