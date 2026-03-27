package exception;

public class PolicyNotFoundException extends EntityNotFoundException {
    public PolicyNotFoundException(String policyNumber) {
        super("Полис с номером " + policyNumber + " не найден!");
    }
}


