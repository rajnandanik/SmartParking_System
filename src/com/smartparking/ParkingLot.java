package com.smartparking;

import java.time.Duration;
import java.util.*;
import java.util.logging.Logger;

public class ParkingLot {
    List<ParkingSpot> spots;
    private int totalRevenue = 0;
    List<String> parkingHistory = new ArrayList<>();
    private static final Logger logger = Logger.getLogger(ParkingLot.class.getName());

    public ParkingLot() {
        this.spots = new ArrayList<>();
        initializeSpots();
    }

    private void initializeSpots() {
        spots.add(new ParkingSpot(1, 1, VehicleType.MOTORCYCLE, false));
        spots.add(new ParkingSpot(2, 1, VehicleType.MOTORCYCLE, false));
        spots.add(new ParkingSpot(3, 1, VehicleType.CAR, false));
        spots.add(new ParkingSpot(4, 1, VehicleType.CAR, false));
        spots.add(new ParkingSpot(5, 2, VehicleType.CAR, false));
        spots.add(new ParkingSpot(6, 2, VehicleType.BUS, false));
        spots.add(new ParkingSpot(7, 3, VehicleType.ELECTRIC_CAR, true));
        spots.add(new ParkingSpot(8, 3, VehicleType.ELECTRIC_CAR, true));
    }

    public synchronized boolean checkIn(Vehicle vehicle) {
        if (!Vehicle.isValidPlate(vehicle.getNumber())) {
            logger.warning("Invalid vehicle number: " + vehicle.getNumber());
            return false;
        }
        for (ParkingSpot spot : spots) {
            if (!spot.isOccupied() && !spot.isReserved() && spot.getType() == vehicle.getType()) {
                if (vehicle.getType() == VehicleType.ELECTRIC_CAR && !spot.hasCharger()) continue;
                spot.assignVehicle(vehicle);
                logger.info("Vehicle " + vehicle.getNumber() + " parked at spot #" + spot.getId() + " (Floor: " + spot.getFloor() + ") Token: " + vehicle.getToken());
                return true;
            }
        }
        logger.warning("No spot available for vehicle type: " + vehicle.getType());
        return false;
    }

    public synchronized void checkOut(String vehicleNumber) {
        for (ParkingSpot spot : spots) {
            if (spot.isOccupied() && spot.getCurrentVehicle().getNumber().equals(vehicleNumber)) {
                Vehicle vehicle = spot.releaseVehicle();
                long hours = Duration.between(vehicle.getEntryTime(), java.time.LocalDateTime.now()).toHours();
                hours = Math.max(1, hours);
                int fee = calculateFee(vehicle.getType(), hours);
                totalRevenue += fee;
                String record = "Vehicle " + vehicle.getNumber() + " exited. Fee: Rs. " + fee;
                parkingHistory.add(record);
                logger.info("Checked out: " + record);
                return;
            }
        }
        logger.warning("Vehicle not found in parking lot.");
    }

    private int calculateFee(VehicleType type, long hours) {
        switch (type) {
            case MOTORCYCLE: return (int) hours * 20;
            case CAR: return (int) hours * 40;
            case BUS: return (int) hours * 60;
            case ELECTRIC_CAR: return (int) hours * 30;
            default: return 0;
        }
    }

    public void displayAvailableSpots() {
        logger.info("-- Real-Time Parking Spot Availability --");
        for (ParkingSpot spot : spots) {
            logger.info("Spot #" + spot.getId() + " (Floor " + spot.getFloor() + ") [" + spot.getType() + (spot.hasCharger() ? ", Charger" : "") + "] - " + (spot.isOccupied() ? "Occupied" : spot.isReserved() ? "Reserved" : "Available"));
        }
    }

    public int getTotalRevenue() {
        return totalRevenue;
    }

    public void displayHistory() {
        logger.info("-- Parking History --");
        for (String record : parkingHistory) {
            logger.info(record);
        }
    }
}

