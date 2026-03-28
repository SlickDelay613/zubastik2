package state.impl;

import exception.ClaimProcessingException;
import helper.ClaimStatus;
import model.ClaimDto;
import state.ClaimState;

public class ApprovedState implements ClaimState {
    @Override
    public void approve(ClaimDto claim, double payoutAmount) {
        throw new ClaimProcessingException("Случай уже одобрен!");
    }

    @Override
    public void reject(ClaimDto claim) {
        throw new ClaimProcessingException("Нельзя отклонить одобренный случай!");
    }

    @Override
    public void pay(ClaimDto claim) {
        claim.setStatus(ClaimStatus.PAID);
        claim.setState(new PaidState());
    }

    @Override
    public String getStatusName() {
        return ClaimStatus.APPROVED.name();
    }
}