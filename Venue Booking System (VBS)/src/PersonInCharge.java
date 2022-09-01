public class PersonInCharge {
    private String name;
    private String ID;
    private String address;
    private String contactNumber;
    private Event event;

    // default constructor
    public PersonInCharge() {
        name = " ";
        ID = " ";
        address = " ";
        contactNumber = " ";
        event = new Event();
    }

    // normal constructor
    public PersonInCharge(String name, String ID, String address, String contactNumber, Event event) {
        this.name = name;
        this.ID = ID;
        this.address = address;
        this.contactNumber = contactNumber;
        this.event = event;
    }

    // retriever method
    public String getID() {
        return ID;
    }

    public Event getEvent() {
        return event;
    }

    // toString method
    public String toString() {
        return ("Person in Charge Detail: " + "\nName: " + name + "\nIC Number: " + ID + "\nAddress: " + address
                + "\nContact Number: " + contactNumber + "\n\nEvent Detail: " + event.toString());
    }
}
