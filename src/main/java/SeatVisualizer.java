import javax.swing.*;
import java.awt.*;

/**
 * @author kevin
 * @date 4/3/14
 */
public class SeatVisualizer extends JPanel {

    public SeatVisualizer(Airplane airplane) {
        this.setLayout(new GridLayout(0, 6));

        for (int i = 0; i < airplane.getFirstClassRows().length; i++) {
            if (i%2 == 0) {
                wowILoveColors(airplane.getFirstClassRows()[i].getStateOfWindowSeat());
                System.out.println("This seat status is " + airplane.getFirstClassRows()[i].getStateOfWindowSeat());
                wowILoveColors(airplane.getFirstClassRows()[i].getStateOfAisleSeat());
            }
            this.add(new JButton(" ") {{this.setBackground(Color.GRAY);}});

            if (i%2 == 1) {
                wowILoveColors(airplane.getFirstClassRows()[i].getStateOfAisleSeat());
                wowILoveColors(airplane.getFirstClassRows()[i].getStateOfWindowSeat());
            }
        }
    }

    public void wowILoveColors(boolean seat) {
        Color thisColor;
        if (seat) { // Seat is filled, use red
            thisColor = Color.RED;
        }
        else {
            thisColor = Color.GREEN;
        }
        this.add(new JButton("") {{
            setOpaque(true);
            setBackground(thisColor);
        }});

    }
}