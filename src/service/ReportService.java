package service;

import model.ClaimDto;

import java.util.Collection;

public interface ReportService {
    String buildPayoutReport(Collection<ClaimDto> claims);
}
