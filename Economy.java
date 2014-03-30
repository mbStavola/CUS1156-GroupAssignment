public class Economy
{
  boolean[] seat;

  public Economy(int numberOfSeats){
    seat = new boolean[numberOfSeats];
  }

  boolean setSingleSeat(int pref){
    for(int i = pref;i < seat.length;i+=3)  //Only need to check for the preferred seat this i+=3 (WCAWCA)
      if(!seat[i]){
        seat[i] = true;
        return true;
      }
    return false;
  }

  boolean setCoupleSeat(int pref){  //preference is 0,1, or 2.
    pref -= 1;  //1 is subtracted to make the preference a -1, 0, or 1.

    for(int i = 1;i < seat.length;i+=3)  //We set the default seat to check the center (W>C<A)
      if(!seat[i+pref])  //Now we check either the window or aisle availability
        if(pref!=0){  //but if the preference is center, we have to check both window and aisle
          if(!seat[i]){  //Every seat will be adjacent to a center seat
            seat[i+pref] = true;
            seat[i] = true;
            return true;
          }
        }
        else if(!seat[i-1]){  //Checking window seat
          seat[i]=true;
          seat[i-1]=true;
          return true;
        }

        else if(!seat[i+1]){  //Checking aisle seat
          seat[i]=true;
          seat[i+1]=true;
          return true;
        }
      return false;
  }

  boolean setTripleSeat(){  //There is no preference for triple seats, so we just iterate through the seats (every 3rd seat).
    for(int i = 0;i < seat.length;i+=3)
      if(!seat[i])
        if(!seat[i+1])
          if(!seat[i+2])  //If all the seats are available, take them.
          {
            seat[i] = true;
            seat[i+1] = true;
            seat[i+2] = true;
            return true;
          }
    return false;
  }

  String printSeats(){  //There is no trouble printing the left row because the array is (WCAWCAWCA) but the right rows need to be reversed
    String seats = "";

    for(int i=0;i<seat.length;i++){
      for(int j=0;j<3;j++,i++){
        if(seat[i])
          seats+="X";
        else
          seats+="O";
      }
      i+=2;  //We have to skip to the last seat in the row, so we add 2. Since we require special elements \n, " " we don't use a loop.

      if(seat[i])  //Print to the string so we have (WCA A)
        seats += " X";
      else
        seats += " O";

      if(seat[i-1])  //Print the previous element in the array (WCAW>C<A) so the string is (WCA AC)
        seats += "X";
      else
        seats += "O";

      if(seat[i-2])  //Print the element before that(WCA>W<CA) to complete the row (WCA ACW)
        seats += "X\n";
      else
        seats += "O\n";
    }
    return seats;
  }
}