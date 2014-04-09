/**
 * @author kevin, matt, brian
 * @date 3/26/14
 */
public class Airplane {
    public static final int NUMBER_OF_FIRST_CLASS_ROWS = 5;
    public static final int NUMBER_OF_ECON_ROWS = 30;

    public static final int SEATS_IN_ECON_SIDE = 3;
    public static final int SEATS_IN_FIRST_CLASS_SIDE = 2;


    FirstClass firstClassCabin;
    Economy econCabin;



    public Airplane() {
        firstClassCabin = new FirstClass(NUMBER_OF_FIRST_CLASS_ROWS * SEATS_IN_FIRST_CLASS_SIDE * 2);
        econCabin = new Economy(NUMBER_OF_ECON_ROWS * SEATS_IN_ECON_SIDE * 2);
    }

    public boolean searchForSeats(int classIndex, int numberOfSeatsIndex, int seatPreferenceIndex) {
        if (classIndex == 0) { // If first-class
            if (numberOfSeatsIndex == 0) { // If first-class and 1 seat
                return firstClassCabin.setSingleSeat(seatPreferenceIndex);
            }
            else if (numberOfSeatsIndex == 1) { // If first-class and 2 seats
                return firstClassCabin.setCoupleSeat();
            }
        }
        else if (classIndex == 1) { // If economy-class
            if (numberOfSeatsIndex == 0) { // If economy and 1 seat
                return econCabin.setSingleSeat(seatPreferenceIndex);
            }
            else if (numberOfSeatsIndex == 1) { // If economy and 2 seats
                return econCabin.setCoupleSeat(seatPreferenceIndex);
            }
            else if (numberOfSeatsIndex == 2) {
                return econCabin.setTripleSeat();
            }
        }
        return false;
    }

    public void updateSeatVisualizer() {

    }
}
