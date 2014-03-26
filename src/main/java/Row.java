/**
 * @author kevin, matt, brian
 * @date 3/26/14
 */
public class Row {
    protected boolean[] seats;
    protected isFull;

    public Row(int numOfSeats) {
        this.seats = new boolean[numOfSeats];
        isFull = false;
    }

    public boolean getStateOfWindowSeat() {
        return seats[0];
    }

    public boolean getStateOfAisleSeat() {
        return seats[seats.length-1];
    }

    public boolean[] getSeats(){
        return seats;
    }

    public void setSeatStatus(int index){
        seats[index] = !seats[index]
    }
}
