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

    public String getDestination() {
        return destination;
    }

    public Flight(String flightId, String origin, String destination, int year, int month, int day, String time, double price, int seat) {
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

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getFlightId() {
        return flightId;
    }

    public void setFlightId(String flightId) {
        this.flightId = flightId;
    }

    public String getOrigin() {
        return origin;
    }

    public void setDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public String getTime() {
        return time;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getSeat() {
        return seat;
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    @Override
    public String toString() {
        return flightId + "\t" + origin + "\t\t" + destination + "\t\t\t" + String.valueOf(year) + "\\" + String.valueOf(month) + "\\" + String.valueOf(day) + "\t\t" + time + "\t\t" + String.valueOf(price) + "\t\t" + String.valueOf(seat);
    }
}