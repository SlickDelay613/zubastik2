package state.impl;

import exception.ClaimProcessingException;
import helper.ClaimStatus;
import model.ClaimDto;
import state.ClaimState;

public class PaidState implements ClaimState {
    @Override
    public void approve(ClaimDto claim, double payoutAmount) {
        throw new IllegalStateException("Нельзя изменить оплаченный случай!");
    }

    @Override
    public void reject(ClaimDto claim) {
        throw new ClaimProcessingException("Нельзя изменить оплаченный случай!");
    }

    @Override
    public void pay(ClaimDto claim) {
        throw new ClaimProcessingException("Случай уже оплачен!");
    }

    @Override
    public String getStatusName() {
        return ClaimStatus.PAID.name();
    }
}