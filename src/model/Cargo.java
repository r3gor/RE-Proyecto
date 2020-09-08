package model;

public enum Cargo {
    RECEPCIONISTA("Recepcionista"),
    ABOG_JEFE("Abogado Jefe"),
    ABOG_ESPE("Abogado Especialista"),
    CAJERO("Cajero");

    private String str = this.name();

    Cargo(String strName) {
        str = strName;
    }
}
