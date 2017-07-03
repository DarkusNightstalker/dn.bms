package cs.bms.enumerated;

public enum TaxpayerType {

    NATURAL_PERSON("Persona natural", null, null),
    NATURAL_PERSON_WITHOUT_BUSINESS("Persona natural sin negocio", null, Integer.valueOf(167)),
    NATURAL_PERSON_WITH_BUSINESS("Persona natural con negocio", null, Integer.valueOf(167)),
    OTHERS("Otros", Integer.valueOf(131), Integer.valueOf(158));

    private final String description;
    protected final Integer otherData;
    protected final Integer addressRow;

    private TaxpayerType(String descripction, Integer otherData, Integer addressRow) {
        this.description = descripction;
        this.otherData = otherData;
        this.addressRow = addressRow;
    }

    public String getDescription() {
        return this.description;
    }

    public static TaxpayerType getByDescription(String term) {
        TaxpayerType[] types = values();
        for (TaxpayerType type : types) {
            if (type.getDescription().equalsIgnoreCase(term)) {
                return type;
            }
        }
        return null;
    }

    public Integer getOtherData() {
        return this.otherData;
    }

    public Integer getAddressRow() {
        return this.addressRow;
    }
}
