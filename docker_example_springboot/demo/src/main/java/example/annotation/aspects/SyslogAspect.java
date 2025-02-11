package example.annotation.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Component;

import example.annotation.annotations.Syslog;
import example.utils.ResponseUtils;
import lombok.extern.slf4j.Slf4j;

@Aspect
@Component
@Slf4j
public class SyslogAspect {

    /* slfj4 logging starting time and end time
     * log the method name and the arguments
     * catch the exception and log it
     * log the time taken
    */

    @Around("@annotation(syslog)")
    public Object logMethodExecution(ProceedingJoinPoint joinPoint, Syslog syslog) throws Throwable {
        long startTime = System.currentTimeMillis();
        log.info("Method called: {}", joinPoint.getSignature().getName());
        log.info("Method arguments: {}", joinPoint.getArgs());

        Object result = null;
        try {
            result = joinPoint.proceed();
        } catch (IllegalArgumentException e) {
            log.error("IllegalArgumentException thrown in method: {}", joinPoint.getSignature().getName());
            log.error("IllegalArgumentException Message: {}", e.getMessage());
            return ResponseUtils.errorResult("RequestBody Validation Failed");
        } catch (AccessDeniedException e) { 
            log.error("AccessDeniedException thrown in method: {}", joinPoint.getSignature().getName());
            log.error("AccessDeniedException Message: {}", e.getMessage());
            return ResponseUtils.errorResult("Unauthorized Access");
        } catch (Exception e) {
            log.error("Exception thrown in method: {}", joinPoint.getSignature().getName(), e);
            log.error("Exception Message: {}", e.getMessage());
            return ResponseUtils.errorResult("Internal Server Error");
        }

        long endTime = System.currentTimeMillis();
        log.info("Method finished: {}", joinPoint.getSignature().getName());
        log.info("Time taken: {} ms", (endTime - startTime));

        return result;
    }
}