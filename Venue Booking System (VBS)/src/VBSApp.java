import java.util.Scanner;

public class VBSApp {
    public static void main(String args[]) {
        Scanner inputNum = new Scanner(System.in);
        Scanner inputText = new Scanner(System.in);

        // declare variables
        String personName, personID, personAddress, personContactNumber, eventName, venue, eventDate, eventStartTime,
                eventEndTime;
        PersonInCharge customer[] = new PersonInCharge[20];
        double totalCollection = 0;
        int countDT = 0, countDK200 = 0, countDK300 = 0, currentBookingNumber = 0;

        // starting the venue booking system
        String nextBooking = " ";
        System.out.println("Welcome to our Venue Booking System\n\nMENU\n[Y] BOOKING\n[N] EXIT");
        nextBooking = inputText.nextLine();

        // the program will keep continue until the user want to stop or the booking
        // have reached the limit of 20 booking
        for (int i = 0; nextBooking.equalsIgnoreCase("y") && i < 20; i++) {
            if (i != 0) {
                System.out.println("\n\nNext customer");
            }
            System.out.print("\nEnter Name:");
            personName = inputText.nextLine();
            System.out.print("Enter IC/personal ID Number:");
            personID = inputText.nextLine();
            System.out.print("Enter Address:");
            personAddress = inputText.nextLine();
            System.out.print("Enter Contact Number:");
            personContactNumber = inputText.nextLine();
            System.out.print("Enter Event Name:");
            eventName = inputText.nextLine();
            System.out.print("Enter Venue (DT-Dewan Titiwangsa / DK300-Dewan Kuliah 300 / DK200-Dewan Kuliah 200):");
            venue = inputText.nextLine();
            System.out.print("Enter Event date(DD/MM/YYYY):");
            eventDate = inputText.nextLine();
            System.out.print("Enter Starting Time Of the Event(in 24 h):");
            eventStartTime = inputText.nextLine();
            System.out.print("Enter Ending Time of the Event (in 24 h):");
            eventEndTime = inputText.nextLine();
            customer[i] = new PersonInCharge(personName,
                    personID, personAddress, personContactNumber, new Event(eventName,
                            venue, eventDate, eventStartTime, eventEndTime, new Booking(" "), 0));

            // identify whether the customer is UiTM member or non-UiTM
            if (customer[i].getID().length() <= 10) {
                customer[i].getEvent().getBooking().setType("UiTM Member");
            } else if (customer[i].getID().length() > 10) {
                customer[i].getEvent().getBooking().setType("Non-UitM");
            }

            // calculating booking charge base on booking type (member or non-uitm)
            if (customer[i].getEvent().getBooking().getType().equalsIgnoreCase("UiTM Member")) {

                customer[i].getEvent().calculateCharge_forUiTMStudentOrStaff();
                // dewan titiwangsa

                if (customer[i].getEvent().getVenue().equalsIgnoreCase("DT")) {
                    countDT++;
                }
                // dewan kuliah 300
                else if (customer[i].getEvent().getVenue().equalsIgnoreCase("DK300")) {
                    countDK300++;
                }
                // dewan kuliah 200
                else if (customer[i].getEvent().getVenue().equalsIgnoreCase("DK200")) {
                    countDK200++;
                }
            } else if (customer[i].getEvent().getBooking().getType().equalsIgnoreCase("Non-UitM")) {
                // dewan titiwangsa

                if (customer[i].getEvent().getVenue().equalsIgnoreCase("DT")) {

                    customer[i].getEvent().calculateCharge_forNonUiTM_DT();

                    totalCollection = totalCollection + customer[i].getEvent().calculateCharge_forNonUiTM_DT();
                    countDT++;
                }
                // dewan kuliah 300
                else if (customer[i].getEvent().getVenue().equalsIgnoreCase("DK300")) {

                    customer[i].getEvent().calculateCharge_forNonUiTM_DK300();

                    totalCollection = totalCollection + customer[i].getEvent().calculateCharge_forNonUiTM_DK300();
                    countDK300++;
                }
                // dewan kuliah 200
                else if (customer[i].getEvent().getVenue().equalsIgnoreCase("DK200")) {

                    customer[i].getEvent().calculateCharge_forNonUiTM_DK200();

                    totalCollection = totalCollection + customer[i].getEvent().calculateCharge_forNonUiTM_DK200();
                    countDK200++;
                }
            }
            // display
            System.out.println("\n\n*********************UiTM’s Venues Booking System********************************");
            currentBookingNumber = i + 1;
            System.out.println("\nBooking " + currentBookingNumber);
            System.out.println(customer[i].toString());

            // asking whether the user wanted to continue or not
            System.out.println("\n\nContinue booking?(Y/N)");
            nextBooking = inputText.nextLine();

        }

        System.out.println("Total Booking: " + currentBookingNumber + "\nDewan Titiwangsa: " + countDT
                + "\nDewan Kuliah 300: " + countDK300 + "\nDewan Kuliah 200: " + countDK200 + "\nTotal Collection: RM"
                + String.format("%.2f", totalCollection));
        System.out.println("\nEnd Of Program");
    }
}
