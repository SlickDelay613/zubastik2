package state.impl;

import exception.ClaimProcessingException;
import helper.ClaimStatus;
import model.ClaimDto;
import state.ClaimState;

public class RejectedState implements ClaimState {
    @Override
    public void approve(ClaimDto claim, double payoutAmount) {
        throw new ClaimProcessingException("Нельзя одобрить отклонённый случай!");
    }

    @Override
    public void reject(ClaimDto claim) {
        throw new ClaimProcessingException("Случай уже отклонён!");
    }

    @Override
    public void pay(ClaimDto claim) {
        throw new ClaimProcessingException("Нельзя оплатить отклонённый случай!");
    }

    @Override
    public String getStatusName() {
        return ClaimStatus.REJECTED.name();
    }
}