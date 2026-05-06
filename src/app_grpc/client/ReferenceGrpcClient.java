package app_grpc.client;

import exception.ValidationException;
import grpc.reference.*;
import helper.PolicyType;
import io.grpc.ManagedChannel;
import io.grpc.StatusRuntimeException;
import java.util.UUID;

public class ReferenceGrpcClient {
    private final ReferenceServiceGrpc.ReferenceServiceBlockingStub stub;

    public ReferenceGrpcClient(ManagedChannel channel) {
        this.stub = ReferenceServiceGrpc.newBlockingStub(channel);
    }

    public void validateCustomer(String name) {
        String traceId = UUID.randomUUID().toString();
        try {
            ValidationResponse response = stub.validateCustomer(
                    CustomerValidationRequest.newBuilder().setName(name).setTraceId(traceId).build()
            );
            if (!response.getIsValid()) throw new ValidationException(response.getErrorMessage());
        } catch (StatusRuntimeException e) {
            System.out.println("[ID: " + traceId + "] ВНИМАНИЕ: Сервер недоступен. Проверка клиента пропущена.");
        }
    }

    public void validateDamage(double amount) {
        String traceId = UUID.randomUUID().toString();
        try {
            ValidationResponse response = stub.validateDamage(
                    DamageValidationRequest.newBuilder().setDamageAmount(amount).setTraceId(traceId).build()
            );
            if (!response.getIsValid()) throw new ValidationException(response.getErrorMessage());
        } catch (StatusRuntimeException e) {
            System.out.println("[ID: " + traceId + "] ВНИМАНИЕ: Сервер недоступен. Проверка объёма ущерба пропущена.");
        }
    }

    public PolicyType resolveType(String typeName) {
        String traceId = UUID.randomUUID().toString();
        try {
            PolicyTypeResponse response = stub.resolvePolicyType(
                    PolicyTypeRequest.newBuilder().setTypeCode(typeName).setTraceId(traceId).build()
            );
            return response.getExists() ? PolicyType.valueOf(response.getInternalType()) : PolicyType.UNSPECIFIED;
        } catch (StatusRuntimeException e) {
            System.out.println("[ID: " + traceId + "] ВНИМАНИЕ: Сервер недоступен. Установлен неопределённый тип полиса.");
            return PolicyType.UNSPECIFIED;
        }
    }

    public double calculatePremium(double coverageAmount, double baseRatePercent) {
        String traceId = UUID.randomUUID().toString();
        try {
            PremiumResponse response = stub.calculatePremium(
                    PremiumRequest.newBuilder().setCoverageAmount(coverageAmount).setBaseRatePercent(baseRatePercent).setTraceId(traceId).build()
            );
            if (!response.getIsValid()) throw new ValidationException(response.getErrorMessage());
            return response.getPremiumAmount();
        } catch (StatusRuntimeException e) {
            System.out.println("[ID: " + traceId + "] ВНИМАНИЕ:  Сервер недоступен. Присвоена нулевая премия.");
            return coverageAmount * 0;
        }
    }

    public void validatePayout(double amount) {
        String traceId = UUID.randomUUID().toString();
        try {
            ValidationResponse response = stub.validatePayout(
                    PayoutValidationRequest.newBuilder().setPayoutAmount(amount).setTraceId(traceId).build()
            );
            if (!response.getIsValid()) throw new ValidationException(response.getErrorMessage());
        } catch (StatusRuntimeException e) {
            System.out.println("[ID: " + traceId + "] ВНИМАНИЕ:  Сервер недоступен. Проверка суммы выплаты пропущена.");
        }
    }

    public String getNewNumberForType(Class<?> someClass) {
        try {
            NumberResponse response = stub.generateNumber(
                    NumberRequest.newBuilder().setClassName(someClass.getSimpleName()).build()
            );
            return response.getGeneratedNumber();
        } catch (StatusRuntimeException e) {
            System.out.println("ВНИМАНИЕ: Справочник недоступен. Не удалось сгенерировать новый номер объекта.");
            return "-1";
        }
    }
}