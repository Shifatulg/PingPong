import com.sun.net.httpserver.Filter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GameFrame implements ActionListener {
    private JPanel panel;
    private Timer time;
    private JButton normal;
    private JButton twin;
    private JButton chaos;
    private JButton gravity;
    private JFrame frame;
    public GameFrame() {
        frame = new JFrame("Pong");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1500, 1000);
        frame.setLocationRelativeTo(null);
        time = new Timer(5, this);
        panel = new ChaosPanel();
        panel.setBackground(Color.BLACK);
        frame.add(panel);
        frame.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource() == time) {
            panel.repaint();
        } else {
            if (actionEvent.getSource() == normal){

            } else if (actionEvent.getSource() == chaos) {

            } else if (actionEvent.getSource() == twin) {

            } else if (actionEvent.getSource() == gravity) {

            }
            time.start();
        }
    }
}
