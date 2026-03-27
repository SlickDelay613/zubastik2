package dao;

import model.PolicyDto;

import java.util.Collection;

public interface PolicyDao {
    void save(PolicyDto policy);
    PolicyDto findByNumber(String policyNumber);
    Collection<PolicyDto> findAll();
}
