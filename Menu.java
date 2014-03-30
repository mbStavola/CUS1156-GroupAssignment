import java.util.Scanner;

public class Menu{
  public static void main(String[] args){
    int seatPreference = 0;
    int passengers;
    int cabinChoice;
    boolean foundSeat;

    FirstClass frontCabin = new FirstClass(4);  //Number of seats must be in multiples of 4 (Cannot have half a row!).
    Economy backCabin = new Economy(18);  //Number of seats must be in multiples of 6.

    Scanner userInput = new Scanner(System.in);

    while(true){
      System.out.print("0: Economy\n1: First Class\n\nEnter the class you want to travel with: ");
      cabinChoice = userInput.nextInt();

      if(cabinChoice==0){
        System.out.print("Enter the number of passengers traveling together(1, 2, or 3): ");
        passengers = userInput.nextInt();

        System.out.print("0: Window seat\n1: Center seat\n2: Aisle seat\n\nEnter a seating preference: ");
        seatPreference = userInput.nextInt();

        if(passengers==1){
          foundSeat = backCabin.setSingleSeat(seatPreference);
        }
        else if(passengers==2){
          foundSeat = backCabin.setCoupleSeat(seatPreference);
        }
        else if(passengers==3){
          foundSeat = backCabin.setTripleSeat();  //Preference doesn't matter if 3 people are sitting next to each other.
        }
        /*else{
          INVALID INPUT. USER FAILED.
        }*/
      }
      else if(cabinChoice==1){
        System.out.print("Enter the number of passengers traveling together(1 or 2): ");
        passengers = userInput.nextInt();

        System.out.print("0: Window seat\n1: Aisle seat\n\nEnter a seating preference: ");
        seatPreference = userInput.nextInt();

        if(passengers==1){
          frontCabin.setSingleSeat(seatPreference);
        }
        else if(passengers==2){
          frontCabin.setCoupleSeat();  //Preference doesn't matter since there are a max of two seats together.
        }
        /*else{
          INVALID INPUT. USER FAILED.
        }*/
      }
      /*else
        INVALID INPUT. USER FAILED.
      }*/


      System.out.println("\n"+frontCabin.printSeats()+backCabin.printSeats());
    }
  }
}