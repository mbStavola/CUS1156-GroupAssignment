//Can easily change number of seats, in increments of 6. or actually...even 3 i believe...but this is an airplane not a democracy.

public class CrappyCabin
{
  boolean[] seat = new boolean[180];

  /*public static void main(String[] args)
  {
    CrappyCabin mine = new CrappyCabin();
    int i = 0;
mine.setCoupleSeat(1);
mine.setSingleSeat(1);


    while(mine.setThirdWheel()){  //0,1,or2
      System.out.println(i);i++;}

    System.out.println(mine.printSeats());

  }*/

  boolean setSingleSeat(int pref)  //Same as Classy, except += 3 (possible to make one cabin class then, and use a constructor to day luxury or not...but whatever for now.
  {
    for(int i = pref;i < 180;i+=3)
      if(!seat[i])
      {
        seat[i] = true;
        return true;
      }
    return false;
  }

  boolean setCoupleSeat(int pref)
  {
    pref -= 1;

    for(int i = 1;i < 180;i+=3)
      if(!seat[i+pref])
        if(pref!=0)
        {
          if(!seat[i])
          {
            seat[i+pref] = true;
            seat[i] = true;
            return true;
          }
        }
        else if(!seat[i-1])
        {
          seat[i]=true;
          seat[i-1]=true;
          return true;
        }

        else if(!seat[i+1])
        {
          seat[i]=true;
          seat[i+1]=true;
          return true;
        }


      return false;
  }

  boolean setThirdWheel()  //nested loops reduce checks!
  {
    for(int i = 0;i < 180;i+=3)
      if(!seat[i])
        if(!seat[i+1])
          if(!seat[i+2])
          {
            seat[i] = true;
            seat[i+1] = true;
            seat[i+2] = true;
            return true;
          }
    return false;
  }

  String printSeats()
  {
    String seats = "";

    for(int i=0;i<180;i++)
    {
      for(int j=0;j<3;j++,i++)
      {
        if(seat[i])
          seats+="X";
        else
          seats+="O";
      }
      i+=2;

      if(seat[i])
        seats += " X";
      else
        seats += " O";

      if(seat[i-1])
        seats += "X";
      else
        seats += "O";

      if(seat[i-2])
        seats += "X\n";
      else
        seats += "O\n";
    }
    return seats;
  }
  

}