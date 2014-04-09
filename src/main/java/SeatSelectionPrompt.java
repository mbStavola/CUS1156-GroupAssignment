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
    public SeatSelectionPrompt(Airplane plane) throws HeadlessException {

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



        this.add(new JLabel("Please indicate your seating preferences: "));
        // Creates a group of buttons for the number of seats, and adds them to the panel
        ButtonGroup seatPreferenceButtonGroup = new ButtonGroup();

        List<JRadioButton> seatPreferenceButtons = new ArrayList<JRadioButton>() {{
            add(new JRadioButton("Aisle", false));
            add(new JRadioButton("Center", false));
            add(new JRadioButton("Window", false));
        }};

        for (JRadioButton button : seatPreferenceButtons) {
            button.setEnabled(false);
            seatPreferenceButtonGroup.add(button);
            this.add(button);
        }


        JButton submitButton = new JButton("Submit");
        this.add(submitButton);


        JButton showSeatVisualizerButton = new JButton("Show seat visualizer");
        this.add(showSeatVisualizerButton);

        JButton quitButton = new JButton("Quit");
        this.add(quitButton);

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
                if (classButtons.get(0).isSelected()) { // Two passengers in first class; disable all buttons because we can infer that they want both seats in this aisle
                    toggleButtonsInList(seatPreferenceButtons, false, false, false);
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
                else { // Three passengers in economy; disable all buttons because we can infer that they want all 3 seats in this aisle
                    toggleButtonsInList(seatPreferenceButtons, false, false, false);
                }
            }
        });

        // TODO: Grey out the submit button in certain instances
        submitButton.addActionListener(ae -> {
            int classIndex = 0;
            for (int i = 0; i < classButtons.size(); i++) {
                if (classButtons.get(i).isSelected()) {
                    classIndex = i;
                }
            }

            int numberOfPassengersIndex = 0;
            for (int i = 0; i < numberOfPassengersButtons.size(); i++) {
                if (classButtons.get(i).isSelected()) {
                    numberOfPassengersIndex = i;
                }
            }

            int seatPreferenceIndex = -1; // This is -1 by default because the user does not even select a seat in some cases
            if (seatPreferenceButtons.get(2).isSelected()) {
                seatPreferenceIndex = 0;
            }
            else if (seatPreferenceButtons.get(1).isSelected()) {
                if (classButtons.get(1).isSelected()) {
                    seatPreferenceIndex = 1;
                }
            }
            else {
                if (classButtons.get(0).isSelected()) {
                    seatPreferenceIndex = 1;
                }
                else {
                    seatPreferenceIndex = 2;
                }
            }

            searchForSeats(plane, classIndex, numberOfPassengersIndex, seatPreferenceIndex);
        });

        showSeatVisualizerButton.addActionListener(ae -> {
            JFrame frame = new JFrame("Seat Visualizer");
            frame.add(new SeatVisualizer(plane));
            frame.pack();
            frame.setVisible(true);
        });

        quitButton.addActionListener(ae -> {
            System.exit(0);
        });
    }

    // END OF BUTTON SETUP

    // Search algorithm
    public boolean searchForSeats(Airplane plane, int classIndex, int numberOfPassengersIndex, int seatPreferenceIndex) {
        int row, column;
        if (classIndex == 0){
            if(numberOfPassengersIndex == 1) {
                for (int i = seatPreferenceIndex; i < plane.getFirstClassRows().length * Airplane.SEATS_IN_FIRST_CLASS_SIDE; i += 2) { //Searches only for the preferred seat
                    row = i / Airplane.SEATS_IN_FIRST_CLASS_SIDE;
                    column = i % Airplane.SEATS_IN_FIRST_CLASS_SIDE;
                    if (!plane.getFirstClassRows()[row].getSeats()[column]) {
                        plane.getFirstClassRows()[row].getSeats()[column] = true;
                        return true;
                    }
                }
                return false;
            }
            else {
                for(int i = 0;i < plane.getFirstClassRows().length * Airplane.SEATS_IN_FIRST_CLASS_SIDE;i+=2) {
                    row = i / Airplane.SEATS_IN_FIRST_CLASS_SIDE;
                    column = i % Airplane.SEATS_IN_FIRST_CLASS_SIDE;
                    if (!plane.getFirstClassRows()[row].getSeats()[column])
                        if (!plane.getFirstClassRows()[row].getSeats()[column + 1]) {  //Since there are only a max of two people sitting together, seat preference doesn't matter, so find the first available seats together
                            plane.getFirstClassRows()[row].getSeats()[column] = true;
                            plane.getFirstClassRows()[row].getSeats()[column + 1] = true;
                            return true;
                        }
                }
                return false;
            }
        }
            // TODO literally everything
    }

    // Pass in a list of buttons and then whether you want each button to be enabled
    public void toggleButtonsInList (List<? extends AbstractButton> listOfButtons, boolean... eachButtonState) {
        for (int i = 0; i < listOfButtons.size(); i++) {
            listOfButtons.get(i).setSelected(false);
            listOfButtons.get(i).setEnabled(eachButtonState[i]);
        }
    }

}