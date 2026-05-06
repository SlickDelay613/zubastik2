package app_grpc.server;

import java.util.ArrayList;

public final class ServerNumerator {
    static ArrayList<NumeratorEntry> inUse = new ArrayList<>();

    public static int makeNewNumberForType(String someClass){
        int res;
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

    private static int findNumeratorEntryByClass(String someClass){
        int targetIndex = 0;
        for (int i = 0; i < inUse.size(); i++){
            if (inUse.get(i).getEntryClass().equals(someClass)){
                targetIndex = i;
            }
        }
        return targetIndex;
    }

    private static boolean newType(String someClass) {
        boolean res = true, a = true;
        for (NumeratorEntry numeratorEntry : inUse) {
            a = !numeratorEntry.getEntryClass().equals(someClass);
            if (!a)
                res = false;
        }
        return res;
    }
}