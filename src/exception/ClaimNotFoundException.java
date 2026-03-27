package exception;

public class ClaimNotFoundException extends EntityNotFoundException {
    public ClaimNotFoundException(String claimId) {
        super("Страховой случай с номером " + claimId + " не найден!");
    }
}


