import java.util.ArrayList;

public class AirLine {
    protected static ArrayList <Flight> flights;

    public AirLine() {
        flights = new ArrayList <Flight>();
    }

    public static void setFlights(Flight flights) {
        AirLine.flights.add(flights);
    }
}
