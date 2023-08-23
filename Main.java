import java.util.ArrayList;
import java.util.Scanner;

class Flight {
    String id, from, to;
    int price;

    Flight(String id, String from, String to, int price) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.price = price;
    }
}

class FlightDatabase {
    ArrayList<Flight> flights = new ArrayList<>();

    void addFlight(Flight flight) {
        flights.add(flight);
    }

    ArrayList<Flight> searchFlights(String city) {
        ArrayList<Flight> result = new ArrayList<>();
        for (Flight flight : flights) {
            if (flight.from.equals(city) || flight.to.equals(city)) {
                result.add(flight);
            }
        }
        return result;
    }

    ArrayList<Flight> searchFlights(String from, String to) {
        ArrayList<Flight> result = new ArrayList<>();
        for (Flight flight : flights) {
            if (flight.from.equals(from) && flight.to.equals(to)) {
                result.add(flight);
            }
        }
        return result;
    }

    ArrayList<Flight> searchFlightsFromCity(String fromCity) {
        ArrayList<Flight> result = new ArrayList<>();
        for (Flight flight : flights) {
            if (flight.from.equals(fromCity)) {
                result.add(flight);
            }
        }
        return result;
    }
}

public class Main {
    public static void main(String[] args) {
        FlightDatabase database = new FlightDatabase();
        Scanner scanner = new Scanner(System.in);

        database.addFlight(new Flight("AI161E90", "BLR", "BOM", 5600));
        database.addFlight(new Flight("BR161F91", "BOM", "BBI", 6750));
        database.addFlight(new Flight("AI161F99", "BBI", "BLR", 8210));
        database.addFlight(new Flight("VS171E20", "JLR", "BBI", 5500));
        database.addFlight(new Flight("AS171G30", "HYD", "JLR", 4400));
        database.addFlight(new Flight("AI131F49", "HYD", "BOM", 3499));

        System.out.println("Available Flights:");
        displayFlights(database.flights);

        System.out.println("\nChoose search option:");
        System.out.println("1. Flights for a particular City");
        System.out.println("2. Flights between two cities");
        System.out.println("3. Flights from a particular city");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                System.out.println("Enter the city name:");
                searchAndPrint(database.searchFlights(scanner.next()));
                break;
            case 2:
                System.out.println("Enter the departure city:");
                String fromCity = scanner.next();
                fromCity.trim();
                fromCity.toUpperCase();
                System.out.println("Enter the destination city:");
                searchAndPrint(database.searchFlights(fromCity, scanner.next()));
                break;
            case 3:
                System.out.println("Enter the departure city:");
                searchAndPrint(database.searchFlightsFromCity(scanner.next()));
                break;
            default:
                System.out.println("Invalid choice");
        }

        scanner.close();
    }

    static void displayFlights(ArrayList<Flight> flights) {
        System.out.println("Flight ID\tFrom\tTo\tPrice");
        for (Flight flight : flights) {
            System.out.println(
                    flight.id + "\t" +
                            flight.from + "\t" +
                            flight.to + "\t" +
                            flight.price);
        }
    }

    static void searchAndPrint(ArrayList<Flight> flights) {
        if (flights.isEmpty()) {
            System.out.println("No flights found.");
            return;
        }
        System.out.println("Flight ID\tFrom\tTo\tPrice");
        for (Flight flight : flights) {
            System.out.println(
                    flight.id + "\t" +
                            flight.from + "\t" +
                            flight.to + "\t" +
                            flight.price);
        }
    }
}
