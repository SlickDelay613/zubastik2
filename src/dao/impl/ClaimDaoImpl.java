package dao.impl;

import dao.ClaimDao;
import model.ClaimDto;
import exception.ClaimNotFoundException;
import lombok.RequiredArgsConstructor;
import repository.ClaimRepository;

import java.util.Collection;
import java.util.List;

@RequiredArgsConstructor
public class ClaimDaoImpl implements ClaimDao {
    private final ClaimRepository repository;

    @Override
    public void save(ClaimDto claim) {
        repository.put(claim);
    }

    @Override
    public ClaimDto findById(String id) {
        ClaimDto claim = repository.getById(id);
        if (claim == null) {
            throw new ClaimNotFoundException(id);
        }
        return claim;
    }

    @Override
    public Collection<ClaimDto> findAll() {
        return repository.getAll();
    }
}
