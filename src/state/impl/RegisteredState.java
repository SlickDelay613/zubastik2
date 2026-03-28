package state.impl;

import helper.ClaimStatus;
import model.ClaimDto;
import state.ClaimState;

public class RegisteredState implements ClaimState {
    @Override
    public void approve(ClaimDto claim, double payoutAmount) {
        claim.setPayoutAmount(payoutAmount);
        claim.setStatus(ClaimStatus.APPROVED);
        claim.setState(new ApprovedState());
    }

    @Override
    public void reject(ClaimDto claim) {
        claim.setPayoutAmount(0);
        claim.setStatus(ClaimStatus.REJECTED);
        claim.setState(new RejectedState());
    }

    @Override
    public void pay(ClaimDto claim) {
        throw new IllegalStateException("Нельзя оплатить неодобренный случай!");
    }

    @Override
    public String getStatusName() {
        return ClaimStatus.REGISTERED.name();
    }
}