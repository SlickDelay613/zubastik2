package state;

import helper.ClaimStatus;
import model.ClaimDto;

public class PaidState implements ClaimState {
    @Override
    public void approve(ClaimDto claim, double payoutAmount) {
        throw new IllegalStateException("Нельзя изменить оплаченный случай!");
    }

    @Override
    public void reject(ClaimDto claim) {
        throw new IllegalStateException("Нельзя изменить оплаченный случай!");
    }

    @Override
    public void pay(ClaimDto claim) {
        throw new IllegalStateException("Случай уже оплачен!");
    }

    @Override
    public String getStatusName() {
        return ClaimStatus.PAID.name();
    }
}