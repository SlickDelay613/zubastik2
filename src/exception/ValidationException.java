package exception;

public class ValidationException extends GeneralApplicationException {
    public ValidationException(String message) {
        super("Ошибка ввода!" + message);
    }
}


