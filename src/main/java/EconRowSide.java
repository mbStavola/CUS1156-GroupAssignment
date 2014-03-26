/**
 * @author kevin
 * @date 3/26/14
 */
public class EconRowSide extends RowSide {

    public EconRowSide(char rowSide, int numOfSeats) {
        super(rowSide, numOfSeats);
    }

    // This method needs to be here because econ rows have a center seat
    public boolean getStateofCenterSeat() {
        return seats[1];
    }

}
