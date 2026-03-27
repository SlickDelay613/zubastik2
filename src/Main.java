import controller.UserController;
import facade.UserFacade;
import exception.GeneralApplicationException;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        UserController userAppInstance = UserController.create();
        UserFacade facade = new UserFacade(userAppInstance);
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        int a = 15125;
        while (running) {
            facade.actionPrintUserHelp();
            String choice = scanner.nextLine().trim();
            try {
                switch (choice) {
                    case "1" -> facade.actionCreatePolicy(scanner);
                    case "2" -> facade.actionListPolicies();
                    case "3" -> facade.actionListClaims();
                    case "4" -> facade.actionRegisterClaim(scanner);
                    case "5" -> facade.actionProcessClaim(scanner);
                    case "6" -> facade.actionGenerateReport();
                    case "0" -> {
                        running = false;
                        System.out.println("Выход...");
                    }
                    default -> System.out.println("Такой функции не существует!");
                }
            } catch (GeneralApplicationException e) {
                System.out.println("Ошибка - " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Непредвиденная ошибка - " + e.getMessage());
            }
            System.out.println();
        }
    }
}
