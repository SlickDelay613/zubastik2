package exception;

public class EntityNotFoundException extends GeneralApplicationException {
    public EntityNotFoundException(String message) {
        super("Сущность не найдена!" + message);
    }
}


