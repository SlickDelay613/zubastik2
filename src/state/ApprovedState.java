package state;

import helper.ClaimStatus;
import model.ClaimDto;

public class ApprovedState implements ClaimState {
    @Override
    public void approve(ClaimDto claim, double payoutAmount) {
        throw new IllegalStateException("Случай уже одобрен!");
    }

    @Override
    public void reject(ClaimDto claim) {
        throw new IllegalStateException("Нельзя отклонить одобренный случай!");
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