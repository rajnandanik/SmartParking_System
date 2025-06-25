package com.smartparking;

public class main {
    public static void main(String[] args) throws InterruptedException {
        ParkingLot lot = new ParkingLot();

        Vehicle bike = new Vehicle("MH12AB1234", VehicleType.MOTORCYCLE);
        Vehicle car = new Vehicle("MH01YZ9999", VehicleType.CAR);
        Vehicle bus = new Vehicle("MH99BUS4321", VehicleType.BUS);
        Vehicle electric = new Vehicle("MH00EC1000", VehicleType.ELECTRIC_CAR);

        lot.checkIn(bike);
        lot.checkIn(car);
        lot.checkIn(bus);
        lot.checkIn(electric);

        lot.displayAvailableSpots();

        Thread.sleep(1000);

        lot.checkOut("MH12AB1234");
        lot.checkOut("MH00EC1000");

        lot.displayAvailableSpots();

        lot.displayHistory();
        System.out.println("Total Revenue Collected: Rs. " + lot.getTotalRevenue());
    }
}

