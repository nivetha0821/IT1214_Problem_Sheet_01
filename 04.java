class Ticket {
    private int ticketNumber;
    private String customerName;
    private int seatNumber;

    public Ticket(int ticketNumber, String customerName, int seatNumber) {
        this.ticketNumber = ticketNumber;
        this.customerName = customerName;
        this.seatNumber = seatNumber;
    }

    public int getTicketNumber() {
        return ticketNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public int getSeatNumber() {
        return seatNumber;
    }
}
class BookingSystem {
    Ticket[] t1= new Ticket[10];
    int count = 0;

    public void bookTicket(int ticketNumber, String customerName, int seatNumber) {
        if (count >= 10) {
            System.out.println("All seats are booked.");
            
        }

       
        for (int i = 0; i < count; i++) {
            if (t1[i].getSeatNumber() == seatNumber) {
                System.out.println("Seat " + seatNumber + " is already booked.");
              
            }
        }

        t1[count] = new Ticket(ticketNumber, customerName, seatNumber);
        count++;
        System.out.println("Ticket booked for " + customerName + " at seat " + seatNumber);
    }

    public void cancelTicket(int ticketNumber) {
        boolean found = false;
        for (int i = 0; i < count; i++) {
            if (t1[i].getTicketNumber() == ticketNumber) {
                for (int j = i; j < count - 1; j++) {
                    t1[j] = t1[j + 1];
                }
                t1[count - 1] = null;
                count--;
                found = true;
                System.out.println("Ticket " + ticketNumber + " cancelled.");
                
            }
        }

        if (!found) {
            System.out.println("Ticket not found.");
        }
    }

    public void displayTickets() {
        if (count == 0) {
            System.out.println("No tickets booked.");
            return;
        }

        for (int i = 0; i < count; i++) {
            System.out.println("Ticket " + t1[i].getTicketNumber() +", Name: " + t1[i].getCustomerName() +", Seat: " + t1[i].getSeatNumber());
        }
    }
}
class Main {
    public static void main(String[] args) {
        BookingSystem system = new BookingSystem();
        system.bookTicket(1, "Alice Smith", 1);
        system.bookTicket(2, "Bob Jones", 2);
        system.bookTicket(3, "Carol Lee", 3);
        system.cancelTicket(2);
        system.bookTicket(4, "Daniel Hudson", 2);
        system.displayTickets();
    }
}
