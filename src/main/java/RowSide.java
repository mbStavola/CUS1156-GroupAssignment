/**
 * @author kevin
 * @date 3/26/14
 */
public class RowSide {
    protected boolean[] seats;
    protected char rowSide;


    public RowSide(char rowSide, int numOfSeats) {
        if (rowSide != 'L' ^ rowSide != 'R') {
            throw new IllegalArgumentException("You can only pass L or R as your row side");
        }
        this.rowSide = rowSide;
        this.seats = new boolean[numOfSeats];
    }

    public boolean getStateOfWindowSeat() {
        if (rowSide == 'L') {
            return seats[0];
        }
        else {
            return seats[seats.length-1];
        }
    }

    public boolean getStateOfAisleSeat() {
        if (rowSide == 'L') {
            return seats[seats.length-1];
        }
        else {
            return seats[0];
        }
    }
}
