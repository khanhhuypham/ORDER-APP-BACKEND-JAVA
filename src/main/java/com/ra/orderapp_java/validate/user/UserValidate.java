package com.ra.orderapp_java.validate.user;



import com.ra.orderapp_java.repository.UserRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserValidate implements ConstraintValidator<UserUnique,String> {
    @Autowired
    private UserRepository userRepo;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return !userRepo.existsUserByEmail(value);
    }
}