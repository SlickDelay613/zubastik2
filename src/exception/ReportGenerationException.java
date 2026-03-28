package exception;

public class ReportGenerationException extends GeneralApplicationException {
    public ReportGenerationException(String message) {
        super("Ошибка создания отчёта!" + message);
    }
}


