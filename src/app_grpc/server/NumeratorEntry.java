package app_grpc.server;

public class NumeratorEntry {
    private String entryClass;
    private int createdCount;

    public NumeratorEntry(String entryClass) {
        this.entryClass = entryClass;
    }

    public String getEntryClass() { return entryClass; }
    public int getCreatedCount() { return createdCount; }
    public void setCreatedCount(int createdCount) { this.createdCount = createdCount; }
}