import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.util.ArrayList;
import java.util.List;

/**
 * @author kevin
 * @date 3/26/14
 */
public class SeatSelectionPrompt extends JPanel {
    public SeatSelectionPrompt() throws HeadlessException {

        // Uses a vertically-laid out box layout
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));




        this.add(new JLabel("Please choose a seating class: "));
        // Creates a group of buttons for the class, and adds them to the panel
        ButtonGroup classButtonGroup = new ButtonGroup();

        List<JRadioButton> classButtons = new ArrayList<JRadioButton>() {{ // Creates the buttons for economy vs first class
            add(new JRadioButton("First Class", false));
            add(new JRadioButton("Economy", false));
        }};

        for (JRadioButton button : classButtons) { // Adds these buttons to the panel and ButtonGroup
            classButtonGroup.add(button);
            this.add(button);
        }



        this.add(new JLabel("Please indicate the number of passengers: "));
        // Creates a group of buttons for the number of seats, and adds them to the panel
        ButtonGroup numberOfPassengersButtonGroup = new ButtonGroup();

        List<JRadioButton> numberOfPassengersButtons = new ArrayList<JRadioButton>() {{
            add(new JRadioButton("1", false));
            add(new JRadioButton("2", false));
            add(new JRadioButton("3", false));
        }};

        for (JRadioButton button : numberOfPassengersButtons) { // Disables these buttons, adds them to the panel and ButtonGroup
            button.setEnabled(false);
            numberOfPassengersButtonGroup.add(button);
            this.add(button);
        }



        this.add(new JLabel("Please indicate your seating preferences. Only check off as many boxes as seats that you requested: "));
        // Creates a group of buttons for the number of seats, and adds them to the panel
        List<JCheckBox> seatPreferenceButtons = new ArrayList<JCheckBox>() {{
            add(new JCheckBox("Aisle", false));
            add(new JCheckBox("Center", false));
            add(new JCheckBox("Window", false));
        }};

        for (JCheckBox button : seatPreferenceButtons) {
            button.setEnabled(false);
            this.add(button);
        }


        JButton submitButton = new JButton("Submit");
        this.add(submitButton);


        // Item listeners for every button to do what they need to do
        classButtons.get(0).addItemListener(ae -> {
            if (ae.getStateChange() == ItemEvent.SELECTED) { // If we selected "First Class"...
                toggleButtonsInList(numberOfPassengersButtons, true, true, false); // Enable just 1 and 2 seats as options. Disable 3 seats
                toggleButtonsInList(seatPreferenceButtons, false, false, false); // Disable all seat preferences just to be safe
            }
        });
        classButtons.get(1).addItemListener(ae -> { // Economy button
            if (ae.getStateChange() == ItemEvent.SELECTED) {
                toggleButtonsInList(numberOfPassengersButtons, true, true, true);
                toggleButtonsInList(seatPreferenceButtons, false, false, false); // Disable all seat preferences just to be safe
            }
        });


        numberOfPassengersButtons.get(0).addItemListener(ae -> {
            if (ae.getStateChange() == ItemEvent.SELECTED) {
                if (classButtons.get(0).isSelected()) { // One passenger in first class; enable aisle and window
                    toggleButtonsInList(seatPreferenceButtons, true, false, true);
                } else { // One passenger in economy; enable all three
                    toggleButtonsInList(seatPreferenceButtons, true, true, true);
                }
            }
        });

        numberOfPassengersButtons.get(1).addItemListener(ae -> {
            if (ae.getStateChange() == ItemEvent.SELECTED) {
                if (classButtons.get(0).isSelected()) { // Two passengers in first class; enable aisle and window
                    toggleButtonsInList(seatPreferenceButtons, true, false, true);
                }
                else { // Two passengers in economy; enable all buttons
                    toggleButtonsInList(seatPreferenceButtons, true, true, true);
                }
            }
        });

        numberOfPassengersButtons.get(2).addItemListener(ae -> {
            if (ae.getStateChange() == ItemEvent.SELECTED) {
                if (classButtons.get(0).isSelected()) { // Three passengers in first class; this is not a thing. We should never get here but just in case, disable everything
                    toggleButtonsInList(seatPreferenceButtons, false, false, false);
                }
                else { // Three passengers in economy; enable all buttons
                    toggleButtonsInList(seatPreferenceButtons, true, true, true);
                }
            }
        });

        submitButton.addActionListener(ae -> {
            int numberRequested = 0;
            for (JRadioButton button : numberOfPassengersButtons) {
                if (button.isSelected()) {
                    numberRequested = Integer.parseInt(button.getText());
                }
            }

            int numberSelected = 0;
            for (JCheckBox button : seatPreferenceButtons) {
                if (button.isSelected()) {
                    numberSelected++;
                }
            }

            if (numberRequested == numberSelected) {
                // TODO : This is where we actually put all the big stuff. The code here is what happens when we determine that the user has made a valid request
                System.err.println("pls");
                JOptionPane.showMessageDialog(null, "Yay, it didn't blow up.");
            }
            else {
                System.err.println("wow");
                JOptionPane.showMessageDialog(null, "ERROR: You either checked off too few or too many seat position requests, based on the number of seats you requested");
            }

        });

    }

    // Pass in a list of buttons and then whether you want each button to be enabled
    public void toggleButtonsInList (List<? extends AbstractButton> listOfButtons, boolean... eachButtonState) {
        for (int i = 0; i < listOfButtons.size(); i++) {
            listOfButtons.get(i).setEnabled(eachButtonState[i]);
            listOfButtons.get(i).setSelected(false);
        }
    }
}