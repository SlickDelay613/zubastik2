package helper;

import java.util.ArrayList;

public final class Numerator {
    static ArrayList<NumeratorEntry> inUse = new ArrayList<>();

    public static int makeNewNumberForType(Class<?> someClass){
        int res = 0;
        if (newType(someClass)) {
            inUse.add(new NumeratorEntry(someClass));
            res = 1;
            inUse.get(inUse.size()-1).setCreatedCount(res);
        }
        else{
            int index = findNumeratorEntryByClass(someClass);
            res = inUse.get(index).getCreatedCount() + 1;
            inUse.get(index).setCreatedCount(res);
        }
        return res-1;
    }

    private static int findNumeratorEntryByClass(Class<?> someClass){
        int targetIndex = 0;
        for (int i = 0; i < inUse.size(); i++){
            if (inUse.get(i).getEntryClass() == someClass){
                targetIndex = i;
            }
        }
        return targetIndex;
    }

    private static boolean newType(Class<?> someClass) {
        boolean res = true, a;
        for (NumeratorEntry numeratorEntry : inUse) {
            a = numeratorEntry.getEntryClass() != someClass;
            if (!a)
                res = false;
        }
        return res;
    }
}
