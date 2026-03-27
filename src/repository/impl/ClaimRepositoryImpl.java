package repository.impl;

import model.ClaimDto;
import repository.ClaimRepository;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ClaimRepositoryImpl implements ClaimRepository {
    private final Map<String, ClaimDto> claimRepository = new HashMap<>();

    @Override
    public void put(ClaimDto claim) {
        claimRepository.put(claim.getClaimNumber(), claim);
    }

    @Override
    public ClaimDto getById(String id) {
        return claimRepository.get(id);
    }

    @Override
    public Collection<ClaimDto> getAll() {
        return Collections.unmodifiableCollection(claimRepository.values());
    }
}
