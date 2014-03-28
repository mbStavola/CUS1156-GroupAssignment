//Just the luxury seats
//Just 20 seats in a specific way
//Hard coded

import java.util.Scanner;

public class ClassyCabin
{
  boolean[] seat = new boolean[20];

  /*public static void main(String[] args)
  {
    Scanner userInput = new Scanner(System.in);
    ClassyCabin mine = new ClassyCabin();

    System.out.print("0: Window\n1: Aisle\nEnter a preference: ");
    int pref = userInput.nextInt();

    //for(int i = 0;i < 11;i++)
    //System.out.println(mine.setSingleSeat(pref));

    for(int i = 0;i < 11;i++)
    System.out.println(mine.setCoupleSeat());

    System.out.print(mine.printSeats());

  }*/

  boolean setSingleSeat(int pref)
  {
    for(int i = pref;i < 20;i+=2)
      if(!seat[i])
      {
        seat[i] = true;
        return true;
      }
    return false;
  }

  boolean setCoupleSeat()
  {
    for(int i = 0;i < 20;i+=2)  //no reason to start at 1...int i = 0. then seat+1 down there...ummm yes there is. if you were checking the lastnot her
      if(!seat[i])
        if(!seat[i+1])
        {
          seat[i] = true;
          seat[i+1] = true;
          return true;
        }
    return false;
  }

  String printSeats()
  {
    String seats = "";

    for(int i=0;i<20;i++)
    {seats += " ";
      for(int j=0;j<2;j++,i++)
      {
        if(seat[i])
          seats+="X";
        else
          seats+="O";
      }
      i++;

      if(seat[i])
        seats += " X";
      else
        seats += " O";

      if(seat[i-1])
        seats += "X\n";
      else
        seats += "O\n";
    }
    return seats;
  }

}