public class Flight {
    private String flightId;
    private String origin;
    private String destination;
    private int year;
    private int month;
    private int day;
    private String time;
    private double price;
    private int seat;

    public Flight(String flightId, String origin, String destination, int year, int month, int day , String time, double price, int seat) {
        this.flightId = flightId;
        this.origin = origin;
        this.destination = destination;
        this.year = year;
        this.month = month;
        this.day = day;
        this.time = time;
        this.price = price;
        this.seat = seat;
    }
}
