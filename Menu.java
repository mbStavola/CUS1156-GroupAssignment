import java.util.Scanner;

public class Menu  //Eventually will have method to recall the menu but for now, just this.
{
  public static void main(String[] args)
  {
    int pref = 0;
    int ppl;
    int cabin;

boolean successOrFaIlUrE;

//Remember, if 3, can't do first class.
//Just follow guidlines of the program.

    ClassyCabin rich = new ClassyCabin();
    CrappyCabin poor = new CrappyCabin();
    Scanner input = new Scanner(System.in);

while(true){
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
      poor.setCoupleSeat(pref);
      }
else if(ppl==3){

poor.setThirdWheel();}
else{
      System.out.println("0: Window seat");
      System.out.println("1: Aisle seat");
      System.out.println("Enter a seating preference: ");
      pref = input.nextInt();
poor.setSingleSeat(pref);
}}
else
if(ppl == 1)
{
      System.out.println("0: Window seat");
      System.out.println("1: Aisle seat");
      System.out.println("Enter a seating preference: ");
      pref = input.nextInt();
rich.setSingleSeat(pref);}
else if(ppl == 3){System.out.println("3 peeps?? ain't no time to be a baller!");
poor.setThirdWheel();
}else
rich.setCoupleSeat();


System.out.print(rich.printSeats());
System.out.print(poor.printSeats());
}


  }

}