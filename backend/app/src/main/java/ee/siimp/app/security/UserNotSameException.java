package ee.siimp.app.security;

class UserNotSameException extends RuntimeException {
    UserNotSameException(String message) {
        super(message);
    }
}
