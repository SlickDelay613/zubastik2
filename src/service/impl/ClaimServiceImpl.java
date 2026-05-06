package service.impl;

import dao.ClaimDao;
import helper.PolicyType;
import model.ClaimDto;
import model.PolicyDto;
import service.ClaimService;
import strategy.PayoutCalculationStrategy;
import strategy.impl.CarPayoutStrategy;
import strategy.impl.PayoutCalculationStrategyRegistry;
import strategy.impl.HealthPayoutStrategy;
import strategy.impl.PropertyPayoutStrategy;
import app_grpc.client.ReferenceGrpcClient;

public class ClaimServiceImpl implements ClaimService {
    private final ClaimDao claimDao;
    private final ReferenceGrpcClient grpcClient;
    private final PayoutCalculationStrategyRegistry payoutCalculationStrategyRegistry = new PayoutCalculationStrategyRegistry();

    public ClaimServiceImpl(ClaimDao claimDao, ReferenceGrpcClient grpcClient){
        this.claimDao = claimDao;
        this.grpcClient = grpcClient;
        payoutCalculationStrategyRegistry.register(new CarPayoutStrategy());
        payoutCalculationStrategyRegistry.register(new PropertyPayoutStrategy());
        payoutCalculationStrategyRegistry.register(new HealthPayoutStrategy());
    }

    @Override
    public ClaimDto createClaim(PolicyDto policy, double damageAmount) {
        grpcClient.validateDamage(damageAmount);
        String claimId = grpcClient.getNewNumberForType(ClaimDto.class);
        return new ClaimDto(claimId, policy, damageAmount);
    }

    @Override
    public void approve(ClaimDto claim, double payoutAmount) {
        grpcClient.validatePayout(payoutAmount);
        claim.getState().approve(claim, payoutAmount);
    }

    @Override
    public void reject(ClaimDto claim) {
        claim.getState().reject(claim);
    }

    @Override
    public void markAsPaid(ClaimDto claim) {
        claim.getState().pay(claim);
    }

    @Override
    public void processClaim(String claimId, boolean approve) {
        ClaimDto claim = claimDao.findById(claimId);
        if (approve) {
            PolicyType policyType = claim.getPolicy().getPolicyType();
            PayoutCalculationStrategy strategy = payoutCalculationStrategyRegistry.getStrategy(policyType);
            double payoutAmount = strategy.calculatePayout(claim);
            approve(claim, payoutAmount);
            markAsPaid(claim);
        } else {
            reject(claim);
        }
        claimDao.save(claim);
    }
}