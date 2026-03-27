package dao;

import model.ClaimDto;

import java.util.Collection;

public interface ClaimDao {
    void save(ClaimDto claim);
    ClaimDto findById(String id);
    Collection<ClaimDto> findAll();
}
