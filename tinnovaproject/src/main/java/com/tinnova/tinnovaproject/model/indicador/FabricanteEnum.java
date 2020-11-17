package com.tinnova.tinnovaproject.model.indicador;

public enum FabricanteEnum {

    RENAULT("Renault"),
    HYUNDAI("Hyundai"),
    FIAT("Fiat"),
    FORD("Ford"),
    VOLKSWAGEN("Volkswagen"),
    CHEVROLET("Chevrolet");

    private String value;

    FabricanteEnum(String value) {
        this.value = value;
    }

    public static FabricanteEnum fromString(String text) {
        for (FabricanteEnum fabricanteEnum : FabricanteEnum.values()) {
            if (fabricanteEnum.value.equalsIgnoreCase(text)) {
                return fabricanteEnum;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return this.value;
    }
}
