/** COMP160 Lab2 2019
 * FillRestaurant.java
 * A restaurant caters for large tour groups and takes
 * bookings by the bus and van load each evening.
 * This class records the data and calculates the number of unallocated seats.
 */

public class FillRestaurant{
    public static void main(String[]args){
        final int MAX_OCCUPANCY = 300;    // number of seats in restaurant
        final int BUS_CAPACITY = 35;      // number of seats in a bus
        final int VAN_CAPACITY = 8;       // number of seats in  a van
        final String DATE = "30th July 2019";  // dining date
       
        int numBusBooked =  4;            // number of buses expected on DATE
        int numVanBooked = 2;             // number of vans expected on DATE
       
        int busDiners = numBusBooked * BUS_CAPACITY;  // number of diners expected from buses
        int vanDiners = numVanBooked * VAN_CAPACITY;  // number of diners expected from vans
        System.out.println("Seats left for " + DATE + " : " + (MAX_OCCUPANCY - (busDiners + vanDiners)));

    }
}