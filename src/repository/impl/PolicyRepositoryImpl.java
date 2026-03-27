package repository.impl;

import model.PolicyDto;
import repository.PolicyRepository;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class PolicyRepositoryImpl implements PolicyRepository {
    private final Map<String, PolicyDto> policyRepository = new HashMap<>();

    @Override
    public void put(PolicyDto policy) {
        policyRepository.put(policy.getPolicyNumber(), policy);
    }

    @Override
    public PolicyDto getByNumber(String policyNumber) {
        return policyRepository.get(policyNumber);
    }

    @Override
    public Collection<PolicyDto> getAll() {
        return Collections.unmodifiableCollection(policyRepository.values());
    }
}
