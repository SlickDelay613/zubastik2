package helper;

public final class PolicyDecipher {
    public static PolicyType decipher(String toDecipher){
        return switch (toDecipher) {
            case "АВТО" -> PolicyType.AUTO;
            case "ЗДОР" -> PolicyType.HEALTH;
            case "НЕДВИЖ" -> PolicyType.PROPERTY;
            default -> PolicyType.UNSPECIFIED;
        };
    }
}
