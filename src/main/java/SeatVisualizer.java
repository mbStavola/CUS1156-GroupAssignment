import javax.swing.*;
import java.awt.*;

/**
 * @author kevin
 * @date 4/3/14
 */

public class SeatVisualizer extends JPanel {
Color thisColor;
int numberSeats = 20;
FirstClass firstCabin = new FirstClass(numberSeats);
String seats = firstCabin.printSeats();

    public SeatVisualizer() {
        System.out.println(seats);
        this.setLayout(new GridLayout(0, 6));



        for (int i = 0; i < numberSeats; i++) {
            if (seats.charAt(i) == 'O') {
                wowILoveColors(Color.GREEN);
            }
            else if (seats.charAt(i) == 'X') {
                wowILoveColors(Color.RED);
            }
            else if (seats.charAt(i) == ' ') {
                wowILoveColors(Color.GRAY);
            }
            else {
                wowILoveColors(Color.ORANGE);
            }
           /* if (i%2 == 1) {
                wowILoveColors(airplane.getFirstClassRows()[i].getStateOfAisleSeat());
                wowILoveColors(airplane.getFirstClassRows()[i].getStateOfWindowSeat());
            }*/
        }
/*
        for (int i = 0; i < airplane.getEconRows().length; i++) {
            if (i%2 == 0) {
                wowILoveColors(airplane.getEconRows()[i].getStateOfWindowSeat());
                wowILoveColors(airplane.getEconRows()[i].getStateofCenterSeat());
                wowILoveColors(airplane.getEconRows()[i].getStateOfAisleSeat());
            }
            else {
                wowILoveColors(airplane.getEconRows()[i].getStateOfAisleSeat());
                wowILoveColors(airplane.getEconRows()[i].getStateofCenterSeat());
                wowILoveColors(airplane.getEconRows()[i].getStateOfWindowSeat());
            }
        }*/
    }

    public void wowILoveColors(Color colorOfSeat) {
        this.add(new JButton("") {{
            setOpaque(true);
            setBackground(colorOfSeat);
        }});

    }
}