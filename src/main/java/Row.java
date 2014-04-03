/**
 * @author kevin, matt, brian
 * @date 3/26/14
 */
public class Row {
    protected boolean[] seats;

    public Row(int numOfSeats) {
        this.seats = new boolean[numOfSeats];
    }

    public boolean getStateOfWindowSeat() {
        return seats[0];
    }

    public void setWindowSeat() {
        seats[0] = true;
    }

    public boolean getStateOfAisleSeat() {
        return seats[seats.length-1];
    }

    public void setAisleSeat() {
        seats[seats.length - 1] = true;
    }

    public boolean[] getSeats(){
        return seats;
    }


}
