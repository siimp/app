package ee.siimp.app.security.logging;


import ee.siimp.app.security.AppUserDetails;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.MDC;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class MdcContextAspect {

    @Pointcut("within(@org.springframework.web.bind.annotation.RestController *)")
    public void restController() {
        // pointcut declaration
    }

    @Around("restController()")
    public Object mdc(ProceedingJoinPoint joinPoint) throws Throwable {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        AppUserDetails appUserDetails = (AppUserDetails) authentication.getPrincipal();
        MDC.put("USER", String.format("[user=%s; id=%d]", appUserDetails.getUsername(), appUserDetails.getUserId()));
        return joinPoint.proceed();
    }
}
