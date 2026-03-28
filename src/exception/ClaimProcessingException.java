package exception;

public class ClaimProcessingException extends GeneralApplicationException {
    public ClaimProcessingException(String message) {
        super("Ошибка обработки страхового случая!" + message);
    }
}


