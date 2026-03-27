package model;

import helper.ClaimStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class ClaimDto {
    String claimNumber;
    PolicyDto policy;
    double damageAmount;
    double payoutAmount;
    ClaimStatus status;

    public ClaimDto(String claimNumber, PolicyDto policy, double damageAmount) {
        this.claimNumber = claimNumber;
        this.policy = policy;
        this.damageAmount = damageAmount;
        this.payoutAmount = 0;
        this.status = ClaimStatus.REGISTERED;
    }
}
