import javax.swing.*;

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
        SeatSelectionPrompt prompt = new SeatSelectionPrompt();
        JFrame frame = new JFrame();
        frame.add(prompt);
        frame.pack();
        frame.setVisible(true);
    }

    public void promptUserForPreferences() {

    }

    // TODO: Literally everything in this method
    public void searchSeats(boolean firstClass, int numberOfPassengers, int preference) throws IllegalArgumentException {
        // I love ternary operators.
        // If statement returns true if the number of passengers and the preference given are both valid for the given class (economy vs first-class)
        // If statement returns false if one of the parameters was invalid, and throws an exception
        if (firstClass
                ? ((numberOfPassengers <= SEATS_IN_FIRST_CLASS_SIDE && numberOfPassengers > 0) && (preference < SEATS_IN_FIRST_CLASS_SIDE && preference > 0))
                : ((numberOfPassengers <= SEATS_IN_ECON_SIDE && numberOfPassengers > 0)) && (preference < SEATS_IN_ECON_SIDE && preference > 0)) {



        }
        else {
            throw new IllegalArgumentException("You specified either an invalid number of passengers, or specified that you \"prefer\" a seat that does not exist. You specified that you wanted " + numberOfPassengers + " seats in " + (firstClass ? "first class" : "economy") + ", and that you wanted the seat at index " + preference);
        }
        System.err.println();
    }


    // Prints the status of each thing
    public void printSeats() {
        String printFormat = "%-10s";

        // For each row in the first-class section, print each seat's status
        System.out.println("First-class seats: ");
        for (int i = 0; i < firstClassRows.length; i++) {
            if (i % 2 == 0) {
                for (int j = 0; j < firstClassRows[i].getSeats().length; j++) {
                    System.out.format(printFormat, firstClassRows[i].getSeats()[j]);
                }
                System.out.println();
            }
            else {
                for (int j = firstClassRows[i].getSeats().length-1; j >= 0; j--) {
                    System.out.format(printFormat, firstClassRows[i].getSeats()[j]);
                }
                System.out.println();
            }
        }

        // For each row in the economy section, print each seat's status
        System.out.println("Economy seats: ");
        for (int i = 0; i < econRows.length; i++) {
            if (i % 2 == 0) {
                for (int j = 0; j < econRows[i].getSeats().length; j++) {
                    System.out.format(printFormat, econRows[i].getSeats()[j]);
                }
                System.out.println();
            }
            else {
                for (int j = econRows[i].getSeats().length-1; j >= 0; j--) {
                    System.out.format(printFormat, econRows[i].getSeats()[j]);
                }
                System.out.println();
            }
        }

    }

    public void quit(){
        System.exit(0);
    }
}
