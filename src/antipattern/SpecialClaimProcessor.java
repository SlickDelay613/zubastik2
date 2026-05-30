package antipattern;

import model.ClaimDto;
import java.util.Collection;

//god class
public class SpecialClaimProcessor {
    /*
    //spaghetti code, hardcoded dependencies, swallowing exceptions
    public static void forcePayBypass(Collection<ClaimDto> allClaims, String claimId) {
        try {
            for (ClaimDto claim : allClaims) {
                if (claim.getClaimNumber().equals(claimId)) {
                    double payment = claim.getDamageAmount()*3 + claim.getPayoutAmount();
                    claim.getState().approve(claim, payment);
                    claim.getState().pay(claim);
                    System.out.println("Специальная выплата в объёме " + payment + " произведена успешно!");
                    return;
                }
            }
        } catch (Exception e) {
            //ля-ля-ля...
        }
    }

    //copy-paste, spaghetti code, hardcoded dependencies
    public static void json(Collection<ClaimDto> claims) {
        System.out.println("JSON-файл (скопировать и вставить):");
        String json = "{\n";
        json += "  \"autoClaims\": [\n";
        boolean isFirstAuto = true;
        for (ClaimDto claim : claims) {
            if (claim.getPolicy().getPolicyType().toString().equals("AUTO")) {
                if (!isFirstAuto) {
                    json += ",\n";
                }
                json += "    {\n";
                json += "      \"id\": \"" + claim.getClaimNumber() + "\",\n";
                json += "      \"amount\": " + claim.getDamageAmount() + "\n";
                json += "    }";
                isFirstAuto = false;
            }
        }
        json += "\n  ],\n";
        json += "  \"healthClaims\": [\n";
        boolean isFirstHealth = true;
        for (ClaimDto claim : claims) {
            if (claim.getPolicy().getPolicyType().toString().equals("HEALTH")) {
                if (!isFirstHealth) {
                    json += ",\n";
                }
                json += "    {\n";
                json += "      \"id\": \"" + claim.getClaimNumber() + "\",\n";
                json += "      \"amount\": " + claim.getDamageAmount() + "\n";
                json += "    }";
                isFirstHealth = false;
            }
        }
        json += "\n  ],\n";
        json += "  \"propertyClaims\": [\n";
        boolean isFirstProperty = true;
        for (ClaimDto claim : claims) {
            if (claim.getPolicy().getPolicyType().toString().equals("PROPERTY")) {
                if (!isFirstProperty) {
                    json += ",\n";
                }
                json += "    {\n";
                json += "      \"id\": \"" + claim.getClaimNumber() + "\",\n";
                json += "      \"amount\": " + claim.getDamageAmount() + "\n";
                json += "    }";
                isFirstProperty = false;
            }
        }
        json += "\n  ]\n";
        json += "}";
        System.out.println(json);
        System.out.println("JSON-файл (конец)");
    }
     */
}