package pi.lab3.chat.validator.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pi.lab3.chat.entity.Message;
import pi.lab3.chat.exception.ValidationException;
import pi.lab3.chat.validator.IValidator;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;

/**
 * Yuliia Vovk
 * 17.11.15
 */
@Component
public class MessageValidator implements IValidator<Message> {

    @Autowired
    private Validator validator;

    @Override
    public void validate(Message obj) {
        Set<ConstraintViolation<Message>> constraintViolations = validator.validate(obj);
        if (!constraintViolations.isEmpty()) {
            StringBuilder errors = new StringBuilder();
            for (ConstraintViolation<Message> constraintViolation : constraintViolations) {
                errors.append(constraintViolation.getMessage());
            }
            throw new ValidationException(errors.toString());
        }
    }
}
