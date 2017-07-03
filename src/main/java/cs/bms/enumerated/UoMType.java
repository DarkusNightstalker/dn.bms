package cs.bms.enumerated;

public enum UoMType {

    LESS("Menor a la unidad base", ""), BASE("Unidad Base", ""), HIGH("Mayor a la unidad base", "");

    private final String description;
    private final String appLabel;

    private UoMType(String description, String appLabel) {
        this.description = description;
        this.appLabel = appLabel;
    }

    public String getDescription() {
        return this.description;
    }

    public String getAppLabel() {
        return this.appLabel;
    }
}
