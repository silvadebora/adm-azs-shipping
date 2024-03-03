package com.admazsshipping.infrastructure.adapters.entities;

public enum ShipmentStatus {

    PENDENTE, EM_TRANSITO, ENTREGUE, CANCELADO;

    public static ShipmentStatus fromString(String status) {
        for (ShipmentStatus s : ShipmentStatus.values()) {
            if (s.name().equalsIgnoreCase(status)) {
                return s;
            }
        }
        throw new IllegalArgumentException("Status inválido: " + status);
    }

    @Override
    public String toString() {
        return this.name();
    }
}
