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

        // Make UI less ugly
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | UnsupportedLookAndFeelException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }

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

    public FirstClassRow[] getFirstClassRows() {
        return firstClassRows;
    }

    public void setFirstClassRows(FirstClassRow[] firstClassRows) {
        this.firstClassRows = firstClassRows;
    }

    public EconRow[] getEconRows() {
        return econRows;
    }

    public void setEconRows(EconRow[] econRows) {
        this.econRows = econRows;
    }
}
