package facade;

import controller.UserController;
import exception.ValidationException;
import model.ClaimDto;
import model.PolicyDto;
import lombok.RequiredArgsConstructor;

import java.util.Scanner;

@RequiredArgsConstructor
public class UserFacade {
    private final UserController clientInstance;

    public void actionCreatePolicy(Scanner scanner) {
        System.out.println("Введите ФИО клиента");
        String customerName = scanner.nextLine().trim();
        System.out.println("Введите тип полиса (АВТО, ЗДОР или НЕДВИЖ)");
        String policyType = scanner.nextLine().trim().toUpperCase();
        System.out.println("Введите страховую сумму");
        double coverage;
        if (scanner.hasNextLine()) {
            try {
                coverage = Double.parseDouble(scanner.nextLine().trim());
            }
            catch (NumberFormatException e){
                throw new ValidationException("Не удалось найти сумму покрытия в строке!");
            }
        }
        else
            throw new ValidationException("Сумма покрытия не может быть пустой!");
        System.out.println("Введите процент страховой премии от суммы");
        double baseRatePercent;
        if (scanner.hasNextLine()) {
            try {
                baseRatePercent = Double.parseDouble(scanner.nextLine().trim());
            }
            catch (NumberFormatException e){
                throw new ValidationException("Не удалось найти процент премии в строке!");
            }
        }
        else
            throw new ValidationException("Процент премии не может быть пустым!");
        PolicyDto policy = clientInstance.createPolicy(customerName, coverage, baseRatePercent, policyType);
        System.out.println("Зарегистрирован новый страховой полис! Его номер - " + policy.getPolicyNumber());
    }

    public void actionListPolicies() {
        System.out.println("==========================СТРАХОВЫЕ ПОЛИСЫ==================================");
        System.out.println("|-Номер-|------------ФИО---------------|---Премия---|---Покрытие---|--Тип--|");
        for (PolicyDto policy : clientInstance.getAllPolicies()) {
            System.out.printf("|%-7s|%-30s|%-12s|%-14s|%-7s|%n",policy.getPolicyNumber(), policy.getCustomer().getName(), policy.getPremium(), policy.getCoverageAmount(), policy.getPolicyType());
        }
    }

    public void actionListClaims() {
        System.out.println("========================СТРАХОВЫЕ СЛУЧАИ==========================");
        System.out.println("|-Номер-|------------ФИО---------------|---Ущерб---|---Выплата---|");
        for (ClaimDto claim : clientInstance.getAllClaims()) {
            System.out.printf("|%-7s|%-30s|%-12s|%-15s|%n", claim.getClaimNumber(), claim.getPolicy().getCustomer().getName(), claim.getDamageAmount(), claim.getPayoutAmount());
        }
    }

    public void actionRegisterClaim(Scanner scanner) {
        System.out.println("Введите номер страхового полиса");
        String policyNumber = scanner.nextLine().trim();
        System.out.println("Введите сумму ущерба");
        double damageAmount;
        if (scanner.hasNextLine()) {
            try {
                damageAmount = Double.parseDouble(scanner.nextLine().trim());
            }
            catch (NumberFormatException e){
                throw new ValidationException("Не удалось найти сумму ущерба в строке!");
            }
        }
        else
            throw new ValidationException("Сумма ущерба не может быть пустой!");
        ClaimDto claim = clientInstance.registerClaim(policyNumber, damageAmount);
        System.out.println("Зарегистрирован новый страховой случай! Его номер - " + claim.getClaimNumber());
    }

    public void actionProcessClaim(Scanner scanner) {
        System.out.println("Введите номер страхового случая");
        String claimId = scanner.nextLine().trim();
        System.out.println("Одобрить выплату? Введите букву \"д\" для одобрения или любую другую для отказа");
        String decision = scanner.nextLine().trim().toLowerCase();
        boolean approve = decision.equals("д");
        clientInstance.processClaim(claimId, approve);
        System.out.println("Страховой случай обработан!");
    }

    public void actionPrintUserHelp(){
        System.out.println("==========ИНФОРМАЦИОННАЯ СИСТЕМА СТРАХОВОЙ КОМПАНИИ==========");
        System.out.println("1 - Зарегистрировать новый страховой полис");
        System.out.println("2 - Показать все зарегистрированные полисы");
        System.out.println("3 - Показать все зарегистрированные страховые случаи");
        System.out.println("4 - Зарегистрировать новый страховой случай");
        System.out.println("5 - Обработать существующий страховой случай");
        System.out.println("6 - Сформировать отчёт по страховым выплатам");
        System.out.println("0 - Выход");
        System.out.println("Введите номер функции для выполнения (приведены выше)");
    }

    public void actionGenerateReport() {
        System.out.println(clientInstance.generatePayoutReport());
    }
}
