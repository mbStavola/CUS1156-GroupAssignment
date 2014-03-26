/**
 * @author kevin, matt, brian
 * @date 3/26/14
 */
public class EconRow extends Row {

    public EconRow(int numOfSeats) {
        super(numOfSeats);
    }

    // This method needs to be here because econ rows have a center seat
    public boolean getStateofCenterSeat() {
        return seats[1];
    }

}
