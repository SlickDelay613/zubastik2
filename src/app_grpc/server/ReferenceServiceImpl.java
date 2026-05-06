package app_grpc.server;

import grpc.reference.*;
import io.grpc.stub.StreamObserver;

public class ReferenceServiceImpl extends ReferenceServiceGrpc.ReferenceServiceImplBase {

    @Override
    public void resolvePolicyType(PolicyTypeRequest request, StreamObserver<PolicyTypeResponse> responseObserver) {
        String traceId = request.getTraceId();
        System.out.println("[Service B] TraceID: " + traceId + " | Преобразование следующего типа полиса: " + request.getTypeCode());
        String type = request.getTypeCode().toUpperCase();
        PolicyTypeResponse.Builder response = PolicyTypeResponse.newBuilder();

        switch (type) {
            case "АВТО" -> response.setExists(true).setInternalType("AUTO");
            case "ЗДОР" -> response.setExists(true).setInternalType("HEALTH");
            case "НЕДВИЖ" -> response.setExists(true).setInternalType("PROPERTY");
            default -> response.setExists(false).setInternalType("UNSPECIFIED");
        }
        responseObserver.onNext(response.build());
        responseObserver.onCompleted();
    }

    @Override
    public void validateCustomer(CustomerValidationRequest request, StreamObserver<ValidationResponse> responseObserver) {
        String traceId = request.getTraceId();
        System.out.println("[Service B] TraceID: " + traceId + " | Проверка следующего имени клиента: " + request.getName());

        boolean isValid = request.getName() != null && !request.getName().trim().isEmpty();
        responseObserver.onNext(ValidationResponse.newBuilder()
                .setIsValid(isValid)
                .setErrorMessage(isValid ? "" : "ОШИБКА - Имя клиента не может быть пустым!")
                .build());
        responseObserver.onCompleted();
    }

    @Override
    public void validateDamage(DamageValidationRequest request, StreamObserver<ValidationResponse> responseObserver) {
        String traceId = request.getTraceId();
        System.out.println("[Service B] TraceID: " + traceId + " | Проверка следующей суммы ущерба: " + request.getDamageAmount());

        boolean isValid = request.getDamageAmount() > 0;
        responseObserver.onNext(ValidationResponse.newBuilder()
                .setIsValid(isValid)
                .setErrorMessage(isValid ? "" : "ОШИБКА - Сумма ущерба должна быть положительной!")
                .build());
        responseObserver.onCompleted();
    }

    @Override
    public void calculatePremium(PremiumRequest request, StreamObserver<PremiumResponse> responseObserver) {
        String traceId = request.getTraceId();
        System.out.println("[Service B] TraceID: " + traceId + " | Расчёт страховой премии...");

        double coverage = request.getCoverageAmount();
        double ratePercent = request.getBaseRatePercent();

        if (coverage <= 0 || ratePercent <= 0) {
            responseObserver.onNext(PremiumResponse.newBuilder()
                    .setIsValid(false)
                    .setErrorMessage("ОШИБКА - Страховая сумма и тариф должны быть положительными!")
                    .build());
        } else {
            double premium = coverage * (ratePercent / 100.0);
            responseObserver.onNext(PremiumResponse.newBuilder()
                    .setIsValid(true)
                    .setPremiumAmount(premium)
                    .build());
        }
        responseObserver.onCompleted();
    }

    @Override
    public void validatePayout(PayoutValidationRequest request, StreamObserver<ValidationResponse> responseObserver) {
        String traceId = request.getTraceId();
        System.out.println("[Service B] TraceID: " + traceId + " | Валидация суммы выплаты: " + request.getPayoutAmount());

        boolean isValid = request.getPayoutAmount() > 0;
        responseObserver.onNext(ValidationResponse.newBuilder()
                .setIsValid(isValid)
                .setErrorMessage(isValid ? "" : "Сумма выплаты должна быть положительной!")
                .build());
        responseObserver.onCompleted();
    }

    @Override
    public void generateNumber(NumberRequest request, StreamObserver<NumberResponse> responseObserver) {
        String className = request.getClassName();
        // Вызываем твой алгоритм
        int newNumber = ServerNumerator.makeNewNumberForType(className);

        System.out.println("[Service B] Numerator сгенерировал номер: " + newNumber + " для " + className);

        responseObserver.onNext(NumberResponse.newBuilder()
                .setGeneratedNumber(String.valueOf(newNumber))
                .build());
        responseObserver.onCompleted();
    }
}