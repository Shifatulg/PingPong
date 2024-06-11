import com.sun.net.httpserver.Filter;

import javax.swing.*;
import javax.swing.plaf.TextUI;
import javax.swing.text.JTextComponent;
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
        twin.setFocusPainted(false);
        twin.setBackground(Color.RED);
        twin.setOpaque(true);
        twin.setBounds(100, 100, 150, 100);
        chaos.setBackground(Color.ORANGE);
        chaos.setOpaque(true);
        chaos.setBounds(550, 100, 150, 100);
        gravity.setBackground(Color.CYAN);
        gravity.setOpaque(true);
        gravity.setBounds(100, 550, 150, 100);
        normal.setBackground(Color.BLUE);
        normal.setOpaque(true);
        normal.setBounds(550, 550, 150, 100);
        panel.setBackground(Color.GRAY);
        JLabel text = new JLabel();
        text.setFont(new Font("Arial", Font.BOLD, 30));
        text.setOpaque(true);
        text.setText("Welcome to Pong");
        text.setBackground(Color.GRAY);
        text.setBounds(275, 325, 400, 200);
        panel.setLayout(null);
        panel.add(twin);
        panel.add(chaos);
        panel.add(gravity);
        panel.add(normal);
        panel.add(text);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);
        frame.setLocationRelativeTo(null);
        frame.add(panel);
        time = new Timer(5, this);
        frame.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (Player.getPlayer1Score() == 9) {
            System.out.println("Player one wins");
            System.exit(0);
        }
        if (Player.getPlayer2Score() == 9) {
            System.out.println("Player two wins");
            System.exit(0);
        }
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
