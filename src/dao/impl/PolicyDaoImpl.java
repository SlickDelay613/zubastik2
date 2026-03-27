package dao.impl;

import dao.PolicyDao;
import model.PolicyDto;
import exception.PolicyNotFoundException;
import lombok.RequiredArgsConstructor;
import repository.PolicyRepository;

import java.util.Collection;

@RequiredArgsConstructor
public class PolicyDaoImpl implements PolicyDao {
    private final PolicyRepository repository;

    @Override
    public void save(PolicyDto policy) {
        repository.put(policy);
    }

    @Override
    public PolicyDto findByNumber(String policyNumber) {
        PolicyDto policy = repository.getByNumber(policyNumber);
        if (policy == null) {
            throw new PolicyNotFoundException(policyNumber);
        }
        return policy;
    }

    @Override
    public Collection<PolicyDto> findAll() {
        return repository.getAll();
    }
}
