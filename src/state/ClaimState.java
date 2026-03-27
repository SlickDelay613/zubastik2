package state;

import model.ClaimDto;
import exception.ClaimProcessingException;

public interface ClaimState {
    void approve(ClaimDto claim, double payoutAmount) throws ClaimProcessingException;
    void reject(ClaimDto claim) throws ClaimProcessingException;
    void pay(ClaimDto claim) throws ClaimProcessingException;
    String getStatusName();
}