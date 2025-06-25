package com.smartparking;

public class ParkingSpot {
    final int id;
    final VehicleType type;
    private boolean occupied;
    private Vehicle currentVehicle;
    final boolean hasCharger;
    final boolean reserved;
    final int floor;

    public ParkingSpot(int id, int floor, VehicleType type, boolean hasCharger) {
        this.id = id;
        this.floor = floor;
        this.type = type;
        this.occupied = false;
        this.hasCharger = hasCharger;
        this.reserved = false;
    }

    public int getId() {
        return id;
    }

    public int getFloor() {
        return floor;
    }

    public VehicleType getType() {
        return type;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public boolean hasCharger() {
        return hasCharger;
    }

    public boolean isReserved() {
        return reserved;
    }

   /* public void reserveSpot() {
        this.reserved = true;
    }

    public void unreserveSpot() {
        this.reserved = false;
    }*/

    public void assignVehicle(Vehicle vehicle) {
        this.currentVehicle = vehicle;
        this.occupied = true;
    }

    public Vehicle releaseVehicle() {
        Vehicle temp = this.currentVehicle;
        this.currentVehicle = null;
        this.occupied = false;
        return temp;
    }

    public Vehicle getCurrentVehicle() {
        return currentVehicle;
    }
}
