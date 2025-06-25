package com.smartparking;

import java.time.LocalDateTime;
import java.util.UUID;

public class Vehicle {
    final String number;
    final VehicleType type;
    final LocalDateTime entryTime;
    final UUID token;

    public Vehicle(String number, VehicleType type) {
        this.number = number;
        this.type = type;
        this.entryTime = LocalDateTime.now();
        this.token = UUID.randomUUID();
    }

    public String getNumber() {
        return number;
    }

    public VehicleType getType() {
        return type;
    }

    public LocalDateTime getEntryTime() {
        return entryTime;
    }

    public UUID getToken() {
        return token;
    }

    public static boolean isValidPlate(String number) {
        return number.matches("[A-Z]{2}\\d{2}[A-Z]{2}\\d{4}");
    }
}
