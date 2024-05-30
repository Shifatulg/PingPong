import com.sun.net.httpserver.Filter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GameFrame implements ActionListener {
    private JPanel panel;
    private Timer time;
    public GameFrame() {
        JFrame frame = new JFrame("Pong");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1500, 1000);
        frame.setLocationRelativeTo(null); // auto-centers frame in screen
        time = new Timer(5, this);
        panel = new TwinPanel();
        panel.setBackground(Color.BLACK);
        frame.add(panel);

        frame.setVisible(true);
        time.start();
    }
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        panel.repaint();
    }
}
