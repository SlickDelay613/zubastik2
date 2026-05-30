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

    /*
    нынешний подход фактически работает как REST, передавая лишь справочную информацию по поводу ошибок
    внутри ответа, который всегда имеет код OK
    по сути, извне, всё выглядит так, что все запросы выполняются без сучка и без задоринки, так как
    дешифрование ответа происходит лишь на клиенте
    это не позволяет использовать всякие мониторящие технологии или же автоматически повторять запрос по 100 раз,
    а также утяжеляет код со стороны клиента
     */

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

    /* как можно было написать, используя коды ошибок GRPC
    public void validateCustomer(String name) {
        String traceId = UUID.randomUUID().toString();
        try {
            // вызов сервера - переменная response больше не нужна, так как факт успешного выполнения метода — это уже успех
            stub.validateCustomer(
                    CustomerValidationRequest.newBuilder().setName(name).setTraceId(traceId).build()
            );
        } catch (StatusRuntimeException e) {
            io.grpc.Status.Code code = e.getStatus().getCode();
            // при возникновении бизнес-ошибки происходит перевод ошибки по коду GRPC в известное клиенту исключение
            if (code == io.grpc.Status.Code.INVALID_ARGUMENT) {
                throw new ValidationException(e.getStatus().getDescription());
            }
            // недоступность сервера или превышение времени ожидания приводит к игнорированию проверки клиента
            if (code == io.grpc.Status.Code.UNAVAILABLE || code == io.grpc.Status.Code.DEADLINE_EXCEEDED) {
                System.out.println("[ID: " + traceId + "] ВНИМАНИЕ: Сервер недоступен. Проверка клиента пропущена.");
                return;
            }
            // серьёзные ошибки выплёвываются как есть
            throw new RuntimeException("ОШИБКА РАБОТЫ СЕРВЕРА - [ID: " + traceId + "]", e);
        }
    }
     */

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