package com.contable.contable.domain.enums;

public enum ValidationError {
    NAME_REQUIRED("El nombre es obligatorio"),
    DESCRIPTION_REQUIRED("La descripción es obligatoria"),
    ICON_REQUIRED("El ícono es obligatorio"),
    COLOR_REQUIRED("El color es obligatorio"),
    TYPE_REQUIRED("El tipo es obligatorio"),
    EMPTY(""),
    NAME_ALREADY_EXISTS("El nombre ya existe"),
    SUCCESS("Categoria Creada correctamente");

    private final String message;

    ValidationError(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
