public class Booking {
    private String type;

    // default constructor
    public Booking() {
        type = " ";
    }

    // normal constructor
    public Booking(String bookingType) {
        this.type = bookingType;
    }

    // setter method
    public void setType(String type) {
        this.type = type;
    }

    // retriever method
    public String getType() {
        return type;
    }
}