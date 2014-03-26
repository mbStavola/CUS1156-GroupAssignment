/**
 * @author kevin
 * @date 3/26/14
 */
public class Airplane {
    public static final int NUMBER_OF_FIRST_CLASS_ROWS = 5;
    public static final int NUMBER_OF_ECON_ROWS = 30;

    public static final int SEATS_IN_ECON_ROW = 3;
    public static final int SEATS_IN_FIRST_CLASS_ROW = 2;

    public static final char LEFT = 'L';
    public static final char RIGHT = 'R';

    RowSide[] firstClassRowSide;
    RowSide[] econRowSide;


    public Airplane() {
        // Multiply by 2 because we separated rows by side
        this.firstClassRowSide = new RowSide[NUMBER_OF_FIRST_CLASS_ROWS*2];
        this.econRowSide = new RowSide[NUMBER_OF_ECON_ROWS*2];

        for (int i = 0; i < this.firstClassRowSide.length; i++) {
            if (i % 2 == 0) {
                this.firstClassRowSide[i] = new FirstClassRowSide(LEFT, SEATS_IN_FIRST_CLASS_ROW);
                this.econRowSide[i] = new EconRowSide(LEFT, SEATS_IN_ECON_ROW);
            }
            else {
                this.firstClassRowSide[i] = new FirstClassRowSide(RIGHT, SEATS_IN_FIRST_CLASS_ROW);
                this.econRowSide[i] = new EconRowSide(RIGHT, SEATS_IN_ECON_ROW);
            }
        }
    }

    public static void main(String[] args) {

    }

    public void searchSeats(int numberOfPassengers, boolean firstClass, int preference) {

    }
}
