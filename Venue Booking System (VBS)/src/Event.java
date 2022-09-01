public class Event {
    private String name;
    private String venue;
    private String date;
    private String startTime;
    private String endTime;
    private Booking booking;
    private double charge;

    // default constructor;
    public Event() {
        name = " ";
        venue = " ";
        date = " ";
        startTime = " ";
        endTime = " ";
        booking = new Booking();
        charge = 0;
    }

    // normal constructor
    public Event(String name, String venue, String date, String startTime, String endTime, Booking booking,
            double charge) {
        this.name = name;
        this.venue = venue;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.booking = booking;
        this.charge = charge;
    }

    // retriever method
    public String getVenue() {
        return venue;
    }

    public String getStartTime() {
        return startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public Booking getBooking() {
        return booking;
    }

    // method to calculate usage hour for hours
    public int calculateDurationInHour(String startTime, String endTime) {
        // to change startTime from string to integer number
        int eventStartTime = Integer.parseInt(startTime);
        // to change endTime from string to integer number
        int eventEndTime = Integer.parseInt(endTime);
        int durationInHour = (eventEndTime - eventStartTime) / 100;
        return durationInHour;
    }

    // method to calculate usage hour for minutes
    public int calculateDurationInMinute(String startTime, String endTime) {
        // to get last two index of startTime string to become minutes integer
        String startMin = startTime.substring(2, 4);
        int startMinInt = Integer.parseInt(startMin);
        // to get last two index of endTime string to become minutes integer
        String endMin = endTime.substring(2, 4);
        int endMinInt = Integer.parseInt(endMin);
        int Min = 0;
        if (startMinInt > endMinInt)
            Min = ((endMinInt + 60) - startMinInt);
        else
            Min = (endMinInt - startMinInt);
        return Min;
    }

    // method to calculate total duration in minutes
    public double totalDurationInMinutes() {
        double totDurationInMinutes = (calculateDurationInHour(startTime, endTime) * 60)
                + calculateDurationInMinute(startTime, endTime);
        return totDurationInMinutes;
    }

    // method to calculate total duration in hours
    public double totalDurationInHours() {
        double totDurationInHours = totalDurationInMinutes() / 60;
        return totDurationInHours;
    }

    // method to calculate charge for uitm student or staff
    public void calculateCharge_forUiTMStudentOrStaff() {
        charge = calculateDurationInHour(startTime, endTime) * 0;
    }

    // for non-uitm, venue: Dewan Titiwangsa
    public double calculateCharge_forNonUiTM_DT() {
        charge = totalDurationInHours() * 300;
        return charge;
    }

    // for non-uitm, venue: Dewan Kuliah 300
    public double calculateCharge_forNonUiTM_DK300() {
        charge = totalDurationInHours() * 150;
        return charge;
    }

    // for non-uitm, venue: Dewan Kuliah 200
    public double calculateCharge_forNonUiTM_DK200() {
        charge = totalDurationInHours() * 100;
        return charge;
    }

    // toString method
    public String toString() {
        return ("\nEvent Name: " + name + "\nVenue: " + venue.toString() + "\nDate: " + date
                + "\nBooking time (starting): " + startTime + "\nBooking time (ending): " + endTime + "\nUsage hour: "
                + calculateDurationInHour(startTime, endTime) + " hours "
                + calculateDurationInMinute(startTime, endTime) + " Minutes" + "\nBooking charge: RM "
                + String.format("%.2f", charge));
    }
}
