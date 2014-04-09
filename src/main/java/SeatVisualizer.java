import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

/**
 * @author kevin
 * @date 4/3/14
 */

public class SeatVisualizer extends JPanel {
    private final Border LINE_BORDER = BorderFactory.createLineBorder(Color.BLACK, 2);
    String seats;

    public SeatVisualizer(Airplane plane) {
        this.setLayout(new GridLayout(0, 7));

        seats = (plane.firstClassCabin.printSeats() + plane.econCabin.printSeats()).replaceAll("\\n", "");


        for (int i = 0; i < seats.length(); i++) {
            final Color thisSeatColor;
            String thisSeatName = "";
            if (seats.charAt(i) == 'O') {
                thisSeatColor = Color.GREEN;
                thisSeatName = " open ";
            }
            else if (seats.charAt(i) == 'X') {
                thisSeatColor = Color.RED;
                thisSeatName = " taken ";
            }
            else if (seats.charAt(i) == ' ') {
                thisSeatColor = Color.LIGHT_GRAY;
            }
            else {
                thisSeatColor = Color.MAGENTA;
            }

            this.add(new JLabel(thisSeatName) {{
                setOpaque(true);
                setBackground(thisSeatColor);
                setBorder(LINE_BORDER);
                setFont(new Font("sans-serif", Font.PLAIN, 30));
            }});

        }
    }
}