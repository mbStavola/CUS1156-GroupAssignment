import javax.swing.*;

/**
 * @author kevin
 * @date 4/3/14
 */
public class SeatPlanner {



    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        Airplane plane = new Airplane();
        SeatSelectionPrompt prompt = new SeatSelectionPrompt(plane);


        frame.add(prompt);
        frame.pack();
        frame.setVisible(true);
    }
}
