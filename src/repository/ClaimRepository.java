package repository;

import model.ClaimDto;

import java.util.Collection;
import java.util.List;

public interface ClaimRepository {
    void put(ClaimDto claim);
    ClaimDto getById(String id);
    Collection<ClaimDto> getAll();
}
