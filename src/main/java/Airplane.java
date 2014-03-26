/**
 * @author kevin, matt, brian
 * @date 3/26/14
 */
public class Airplane {
    public static final int NUMBER_OF_FIRST_CLASS_ROWS = 5;
    public static final int NUMBER_OF_ECON_ROWS = 30;

    public static final int SEATS_IN_ECON_SIDE = 3;
    public static final int SEATS_IN_FIRST_CLASS_SIDE = 2;

    FirstClassRow[] firstClassRows;
    EconRow[] econRows;


    public Airplane() {
        // Each "row" is actually just one side of a physical row, so we need twice as many "row" objects here.
        // Programmatically, there is no need to differentiate between a row on the left of the plane or on the right.
        // Later, we can print these rows out, and the only thing we will have to do to differentiate between left and right sides will be to check if the row is even or odd
        firstClassRows = new FirstClassRow[NUMBER_OF_FIRST_CLASS_ROWS*2];
        econRows = new EconRow[NUMBER_OF_ECON_ROWS*2];

        for (int i = 0; i < firstClassRows.length; i++) {
            firstClassRows[i] = new FirstClassRow(SEATS_IN_FIRST_CLASS_SIDE);
        }
        for (int i = 0; i < econRows.length; i++) {
            econRows[i] = new EconRow(SEATS_IN_ECON_SIDE);
        }
    }

    public static void main(String[] args) {
        Airplane malaysianAirlinesFlight370 = new Airplane(); // I am literally going to hell
        malaysianAirlinesFlight370.printSeats();
    }

    // TODO: Literally everything in this method
    public void searchSeats(int numberOfPassengers, boolean firstClass, int preference) {
        if (preference < 0 || preference > 2){
            throw new IllegalArgumentException("Invalid seat preference");
        }
        else {
            if (firstClass) {
                if (numberOfPassengers < 0 || numberOfPassengers > SEATS_IN_FIRST_CLASS_SIDE){
                    throw new IllegalArgumentException("Invalid number of passengers.");
                }
            }
            else {
                if (numberOfPassengers < 0 || numberOfPassengers > SEATS_IN_ECON_SIDE){
                    throw new IllegalArgumentException("Invalid number of passengers.");
                }
            }
        }
    }

    // Prints the status of each thing
    public void printSeats() {
        String printFormat = "%-10s";
        // For each row in the first-class section, print each seat's status
        System.out.println("First-class seats: ");
        for (FirstClassRow firstClassRow : firstClassRows) {
            for (boolean seat : firstClassRow.getSeats()) {
                System.out.format(printFormat, seat + " ");
            }
            System.out.println();
        }

        // For each row in the economy section, print each seat's status
        System.out.println("Economy seats: ");
        for (EconRow econRow : econRows) {
            for (boolean seat : econRow.getSeats()) {
                System.out.format(printFormat, seat + " ");
            }
            System.out.println();
        }
    }

    public void quit(){
        System.exit(0);
    }
}
