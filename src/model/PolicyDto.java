package model;

import lombok.Data;

@Data
public class PolicyDto {
    String policyNumber;
    CustomerDto customer;
    double coverageAmount;
    double premium;
    boolean active;

    public PolicyDto(String policyNumber, CustomerDto customer, double coverageAmount, double premium) {
        this.policyNumber = policyNumber;
        this.customer = customer;
        this.coverageAmount = coverageAmount;
        this.premium = premium;
        this.active = true;
    }
}
