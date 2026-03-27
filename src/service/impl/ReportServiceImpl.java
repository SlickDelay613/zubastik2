package service.impl;

import model.ClaimDto;
import exception.ReportGenerationException;
import helper.ClaimStatus;
import service.ReportService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ReportServiceImpl implements ReportService {
    @Override
    public String buildPayoutReport(Collection<ClaimDto> claims) {
        if (claims == null) {
            throw new ReportGenerationException("Невозможно сформировать отчёт - нет страховых случаев!");
        }
        List<String> lines = new ArrayList<>();
        lines.add("==========ОТЧЁТ ПО СТРАХОВЫМ ВЫПЛАТАМ==========");
        double totalPaid = 0;
        for (ClaimDto claim : claims) {
            if (claim.getStatus() == ClaimStatus.PAID) {
                lines.add("Случай " + claim.getClaimNumber() + ", полис " + claim.getPolicy().getPolicyNumber()
                        + ", выплата: " + claim.getPayoutAmount() + ", тип полиса: " + claim.getPolicy().getPolicyType());
                totalPaid += claim.getPayoutAmount();
            }
        }
        lines.add("===============================================");
        lines.add("Итого выплачено: " + totalPaid);
        String result = "";
        for (String line : lines) {
            result = result + line + "\n";
        }
        return result;
    }
}
