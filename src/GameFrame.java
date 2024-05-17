import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameFrame {
    private GamePanel panel;

    public GameFrame() {
        JFrame frame = new JFrame("Welcome");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1500, 1000);
        frame.setLocationRelativeTo(null); // auto-centers frame in screen

        // create and add panel
        panel = new GamePanel();
        panel.setBackground(Color.BLACK);
        frame.add(panel);

        // display the frame
        frame.setVisible(true);
        run();
        // no thread needed here since we aren't doing animation for this frame/panel
    }

    private void run() {
        while (true) {
            panel.repaint();
            panel.getBall().incrementXSpeed(0.000015);
            panel.getPlayer1().incrementyCoord(.00001);
        }
    }
}
