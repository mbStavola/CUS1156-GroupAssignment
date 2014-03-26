/**
 * @author kevin, matt, brian
 * @date 3/26/14
 */
public class Airplane {
    public static final int NUMBER_OF_FIRST_CLASS_ROWS = 5;
    public static final int NUMBER_OF_ECON_ROWS = 30;

    public static final int SEATS_IN_ECON_ROW = 3;
    public static final int SEATS_IN_FIRST_CLASS_ROW = 2;

    FirstClassRow[] firstClassRow;
    EconRow[] econRow;


    public Airplane() {
        // Multiply by 2 because we separated rows by side
        this.firstClassRow = new FirstClassRow[NUMBER_OF_FIRST_CLASS_ROWS*2];
        this.econRow = new EconRow[NUMBER_OF_ECON_ROWS*2];

        for (int i = 0; i < this.firstClassRow.length; i++) {
            this.firstClassRow[i] = new FirstClassRow(SEATS_IN_FIRST_CLASS_ROW);
            this.econRow[i] = new EconRow(SEATS_IN_ECON_ROW);
        }
    }

    public static void main(String[] args) {

    }

    public void searchSeats(int numberOfPassengers, boolean firstClass, int preference) {
        boolean passengersSeated = false;
        if (preference < 0 || preference > 2){
            throw new IllegalArgumentException("Invalid seat preference");
        }
        else {
            if (firstClass) {
                if (numberOfPassengers < 0 || numberOfPassengers > SEATS_IN_FIRST_CLASS_ROW){
                    throw new IllegalArgumentException("Invalid number of passengers.");
                }
            }
            else {
                if (numberOfPassengers < 0 || numberOfPassengers > SEATS_IN_ECON_ROW){
                    throw new IllegalArgumentException("Invalid number of passengers.");
                }
            }
            if(!passengersSeated){
                System.out.println("Cannot book seats for class, number of passengers, and preference. Change a parameter and try again.")
            }
        }
    }

    public void printSeats{
        for(int i = 0; i < firstClassRow.length; i++){
            if(i % 2 == 0){
                for(int j = 0; j < firstClassRow[i].length; j++){
                    System.out.print(firstClassRow[i].getStateOfAisleSeat());
                    System.out.println(firstClassRow[i].getStateOfWindowSeat());
                }
            }
            else{
                for(int j = 0; j < firstClassRow[i].length; j++){
                    System.out.print(firstClassRow[i].getStateOfWindowSeat());  
                    System.out.println(firstClassRow[i].getStateOfAisleSeat());  
                }
            }
        }
        System.out.println();
        for(int i = 0; i < econRow.length; i++){
            if(i % 2 == 0){
                for(int j = 0; j < econRow[i].length; j++){
                    System.out.print(econRow[i].getStateOfAisleSeat());
                    System.out.print(econRow[i].getStateOfCenterSeat());
                    System.out.println(econRow[i].getStateOfWindowSeat());
                }
            }
            else{
                for(int j = 0; j < econRow[i].length; j++){
                    System.out.print(econRow[i].getStateOfWindowSeat()); 
                    System.out.print(econRow[i].getStateOfCenterSeat());
                    System.out.println(econRow[i].getStateOfAisleSeat());  
                }
            }
        }
    }

    public void quit(){
        System.exit(0);
    }
}
