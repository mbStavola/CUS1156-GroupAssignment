import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;

/**
 * @author kevin
 * @date 3/26/14
 */
public class SeatSelectionPrompt extends JPanel {
    public SeatSelectionPrompt() throws HeadlessException {
        super(new FlowLayout());

        JRadioButton firstClassButton = new JRadioButton("First Class", true);
        JRadioButton economyButton = new JRadioButton("Economy", false);

        ButtonGroup classButtons = new ButtonGroup();
        classButtons.add(firstClassButton);
        classButtons.add(economyButton);


        firstClassButton.addItemListener(ae -> {
            if (ae.getStateChange() == ItemEvent.SELECTED) { // Happens when the button is selected
                System.err.println("WOW I GUESS YOU WANT TO BE IN FIRST CLASS YOU RICH FUCK");
            } else { // Happens when the button is deselected
                System.err.println("WOW ECONOMY CLASS? WHAT A FUCKING PEASANT");
            }
        });

        this.add(firstClassButton);
        this.add(economyButton);

    }
}