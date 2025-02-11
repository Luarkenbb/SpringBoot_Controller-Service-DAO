package example.annotation.aspects;

import java.util.ArrayList;
import java.util.List;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import example.annotation.annotations.RequestValidation;
import jakarta.validation.Validation;
import jakarta.validation.ValidatorFactory;
import lombok.extern.slf4j.Slf4j;

@Aspect
@Component
@Slf4j
public class RequestValidationAspect {
    @Around("@annotation(requestValidation)")
    public Object validateRequest(ProceedingJoinPoint joinPoint, RequestValidation requestValidation) throws Throwable {
        //get the method arguments
        Object[] args = joinPoint.getArgs();
        List<String> violation_msg = new ArrayList<>();
        //validate the arguments by checking the jakarta.validation.constraints
        for (Object arg : args) {
            //build the validator
            ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
            //validate the object
            factory.getValidator().validate(arg).forEach(violation -> {
                violation_msg.add(violation.getMessage());
            });
        }
        //if there is any violation, throw an exception
        if (!violation_msg.isEmpty()) {
            throw new IllegalArgumentException(String.join(", ", violation_msg));
        }
        return joinPoint.proceed();
    }
}
