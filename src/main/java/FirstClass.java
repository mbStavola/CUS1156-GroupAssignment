public class FirstClass{
  boolean[] seat;

  public FirstClass(int numberOfSeats){
    seat = new boolean[numberOfSeats];
  }

  //Searches for the first available seat based on preference (0 or 1)
  boolean setSingleSeat(int pref){ //The array is arranged Window(W) Aisle(A) WAWAWA for computations but when printed out, reflects an actual airplace "WA AW"
    for(int i = pref;i < seat.length;i+=2) //Searches only for the preferred seat
      if(!seat[i]){
        seat[i] = true;
        return true;
      }
    return false;
  }

  boolean setCoupleSeat(){
    for(int i = 0;i < seat.length;i+=2)
      if(!seat[i])
        if(!seat[i+1]){  //Since there are only a max of two people sitting together, seat preference doesn't matter, so find the first available seats together
          seat[i] = true;
          seat[i+1] = true;
          return true;
        }
    return false;
  }

  String printSeats(){
    String seats = "";

    for(int i=0;i<seat.length;i++){  //There is no problem print out the left row because they are in order in the array (WA)
      seats += " ";
      for(int j=0;j<2;j++,i++){
        if(seat[i])
          seats+="X";
        else
          seats+="O";
      }
      i++;

      if(seat[i])  //This reads the end of the row first (A) and adds it to the string to make (WA A)
        seats += " X";
      else
        seats += " O";

      if(seat[i-1])  //This reads the previous element i the array to make the string (WA AW) now the elements are in order
        seats += "X \n";
      else
        seats += "O \n";
    }
    return seats;
  }
}