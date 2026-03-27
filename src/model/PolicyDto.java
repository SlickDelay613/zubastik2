package model;

import lombok.Data;

@Data
public class PolicyDto {
    String policyNumber;
    CustomerDto customer;
    double coverageAmount;
    double premium;
    boolean active;
    String policyType;

    public PolicyDto(String policyNumber, CustomerDto customer, double coverageAmount, double premium, String policyType) {
        this.policyNumber = policyNumber;
        this.customer = customer;
        this.coverageAmount = coverageAmount;
        this.premium = premium;
        this.active = true;
        this.policyType = policyType;
    }
}
