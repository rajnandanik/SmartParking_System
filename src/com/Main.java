package com.smartparking;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        ParkingLot lot = new ParkingLot();

        Vehicle bike = new Vehicle("MH12AB1234", VehicleType.MOTORCYCLE);
        Vehicle car = new Vehicle("MH01YZ9999", VehicleType.CAR);
        Vehicle bus = new Vehicle("MH99BUS4321", VehicleType.BUS);

        lot.checkIn(bike);
        lot.checkIn(car);
        lot.checkIn(bus);

        lot.displayAvailableSpots();

        Thread.sleep(1000); // simulate 1-second stay

        lot.checkOut("MH12AB1234");
        lot.displayAvailableSpots();
    }
}
