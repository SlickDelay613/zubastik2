package helper;

import lombok.Getter;
import lombok.Setter;

@Getter
public class NumeratorEntry {
    @Setter
    private int createdCount;
    private final Class<?> entryClass;

    public NumeratorEntry(Class<?> newClass){
        createdCount = 0;
        entryClass = newClass;
    }

}
