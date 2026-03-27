package service.impl;

import helper.Numerator;
import model.ClaimDto;
import model.PolicyDto;
import exception.ClaimProcessingException;
import exception.ValidationException;
import helper.ClaimStatus;
import service.ClaimService;

public class ClaimServiceImpl implements ClaimService {
    @Override
    public ClaimDto createClaim(PolicyDto policy, double damageAmount) {
        if (damageAmount <= 0) {
            throw new ValidationException("Сумма ущерба должна быть положительной!");
        }
        String claimId = String.valueOf(Numerator.makeNewNumberForType(ClaimDto.class));
        return new ClaimDto(claimId, policy, damageAmount);
    }

    @Override
    public void approve(ClaimDto claim, double payoutAmount) {
        if (payoutAmount <= 0) {
            throw new ValidationException("Сумма выплаты должна быть положительной!");
        }
        claim.getState().approve(claim, payoutAmount);
    }

    @Override
    public void reject(ClaimDto claim) {
        claim.getState().reject(claim);
    }

    @Override
    public void markAsPaid(ClaimDto claim) {
        claim.getState().pay(claim);
    }
}