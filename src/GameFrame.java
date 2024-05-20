import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
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
        panel = new GamePanel();
        panel.setBackground(Color.BLACK);
        frame.add(panel);

        frame.setVisible(true);
        run();
    }

    private void run() {
        while (true) {
            panel.repaint();
            panel.getBall().incrementXSpeed(0.000015);
        }
    }
}
