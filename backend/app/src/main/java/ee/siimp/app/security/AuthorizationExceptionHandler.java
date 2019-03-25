package ee.siimp.app.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.lang.invoke.MethodHandles;
import java.util.Collections;
import java.util.Map;

@ControllerAdvice
public class AuthorizationExceptionHandler {

    private static final Logger LOG = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    private static final Map FORBIDDEN_RESPONSE = Collections.singletonMap("error", "request not allowed");

    @ExceptionHandler(UserNotSameException.class)
    public ResponseEntity<Map> handleContentNotAllowedException(UserNotSameException e) {
        LOG.error(e.getMessage(), e);
        LOG.info("returning forbidden response");
        return new ResponseEntity<>(FORBIDDEN_RESPONSE, HttpStatus.FORBIDDEN);
    }
}
