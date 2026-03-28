package state.impl;

import helper.ClaimStatus;
import model.ClaimDto;
import state.ClaimState;

public class RejectedState implements ClaimState {
    @Override
    public void approve(ClaimDto claim, double payoutAmount) {
        throw new IllegalStateException("Нельзя одобрить отклонённый случай!");
    }

    @Override
    public void reject(ClaimDto claim) {
        throw new IllegalStateException("Случай уже отклонён!");
    }

    @Override
    public void pay(ClaimDto claim) {
        throw new IllegalStateException("Нельзя оплатить отклонённый случай!");
    }

    @Override
    public String getStatusName() {
        return ClaimStatus.REJECTED.name();
    }
}