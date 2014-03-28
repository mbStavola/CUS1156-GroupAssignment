import java.util.Scanner;

public class Menu  //Eventually will have method to recall the menu but for now, just this.
{
  public static void main(String[] args)
  {
    int pref = 0;
    int ppl;
    int cabin;
//Remember, if 3, can't do first class.
//Just follow guidlines of the program.

    ClassyCabin rich = new ClassyCabin();
    CrappyCabin poor = new CrappyCabin();
    Scanner input = new Scanner(System.in);
    System.out.print("Are you poor or a baller? 0 for poor. 1 for baller: ");
    cabin = input.nextInt();
    System.out.print("How many passengers are traveling? (Enter 1, 2, or 3: ");
    ppl = input.nextInt();

if(cabin==0)
{    if(ppl==2){
      System.out.println("0: Window seat");
      System.out.println("1: Center seat");
      System.out.println("2: Aisle seat");
      System.out.println("Enter a seating preference: ");
      pref = input.nextInt();
      rich.setCoupleSeat();
      }
else if(ppl==3)
poor.setThirdWheel();
else
poor.setSingleSeat(pref);
}
else
if(ppl == 1)
rich.setSingleSeat(pref);
else
rich.setCoupleSeat();


System.out.print(rich.printSeats());
System.out.print(poor.printSeats());



  }

}