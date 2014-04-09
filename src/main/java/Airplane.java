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
