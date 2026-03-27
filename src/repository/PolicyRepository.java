package repository;

import model.PolicyDto;

import java.util.Collection;

public interface PolicyRepository {
    void put(PolicyDto policy);
    PolicyDto getByNumber(String policyNumber);
    Collection<PolicyDto> getAll();
}
