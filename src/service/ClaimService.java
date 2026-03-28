package service;

import model.ClaimDto;
import model.PolicyDto;

public interface ClaimService {
    ClaimDto createClaim(PolicyDto policy, double damageAmount);
    void approve(ClaimDto claim, double payoutAmount);
    void reject(ClaimDto claim);
    void markAsPaid(ClaimDto claim);
    void processClaim(String claimId, boolean approve);
}
