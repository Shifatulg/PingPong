import javax.swing.*;
import java.awt.*;

public class GameFrame {
    private GamePanel panel;

    public GameFrame() {
        JFrame frame = new JFrame("Welcome");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setLocationRelativeTo(null); // auto-centers frame in screen

        // create and add panel
        panel = new GamePanel();
        panel.setBackground(Color.BLACK);
        frame.add(panel);

        // display the frame
        frame.setVisible(true);

        // no thread needed here since we aren't doing animation for this frame/panel
    }
}
