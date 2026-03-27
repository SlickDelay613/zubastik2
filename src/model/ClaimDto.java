package model;

import helper.ClaimStatus;
import lombok.Data;
import state.ClaimState;
import state.RegisteredState;

@Data
public class ClaimDto {
    String claimNumber;
    PolicyDto policy;
    double damageAmount;
    double payoutAmount;
    ClaimStatus status;
    ClaimState state;

    public ClaimDto(String claimNumber, PolicyDto policy, double damageAmount) {
        this.claimNumber = claimNumber;
        this.policy = policy;
        this.damageAmount = damageAmount;
        this.payoutAmount = 0;
        this.status = ClaimStatus.REGISTERED;
        this.state = new RegisteredState();
    }
}
