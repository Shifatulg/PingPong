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
        panel = new JPanel();
        frame = new JFrame("Pong");
        normal = new JButton("Normal");
        twin = new JButton("Twin");
        chaos = new JButton("Chaos");
        gravity = new JButton("Gravity");
        normal.addActionListener(this);
        twin.addActionListener(this);
        chaos.addActionListener(this);
        gravity.addActionListener(this);
        panel.add(twin);
        panel.add(chaos);
        panel.add(gravity);
        panel.add(normal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 110);
        frame.setLocationRelativeTo(null);
        frame.add(panel);
        time = new Timer(5, this);
        frame.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource() == time) {
            panel.repaint();
        } else {
            frame.setVisible(false);
            frame = new JFrame();
            if (actionEvent.getSource() == normal) {
                panel = new NormalPanel();
            } else if (actionEvent.getSource() == chaos) {
                panel = new ChaosPanel();
            } else if (actionEvent.getSource() == twin) {
                panel = new TwinPanel();
            } else if (actionEvent.getSource() == gravity) {
                panel = new GravityPanel();
            }
            frame = new JFrame("Pong");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(1500, 1000);
            frame.setLocationRelativeTo(null);
            panel.setBackground(Color.BLACK);
            frame.add(panel);

            frame.setVisible(true);
            time.start();
        }
    }
}
