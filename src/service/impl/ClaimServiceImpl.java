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
        if (payoutAmount > claim.getPolicy().getCoverageAmount() + claim.getPolicy().getPremium()) {
            throw new ClaimProcessingException("Сумма выплаты не может превышать страховую сумму по полису!");
        }
        claim.setPayoutAmount(payoutAmount);
        claim.setStatus(ClaimStatus.APPROVED);
    }

    @Override
    public void reject(ClaimDto claim) {
        claim.setPayoutAmount(0);
        claim.setStatus(ClaimStatus.REJECTED);
    }

    @Override
    public void markAsPaid(ClaimDto claim) {
        if (claim.getStatus() != ClaimStatus.APPROVED) {
            throw new ClaimProcessingException("Оплатить можно только одобренный страховой случай!");
        }
        claim.setStatus(ClaimStatus.PAID);
    }
}
