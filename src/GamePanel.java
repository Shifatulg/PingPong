import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    private Ball ball;
    private Player player1;
    private Player player2;
    private JFrame frame;
    private JPanel field;
    public GamePanel() {
        frame = new JFrame("Pong");
        frame.setSize(1500,1000);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        field = new JPanel();
        field.setLayout(null);
        field.setSize(1500,1000);
        field.setBackground(Color.BLACK);

        ball = new Ball(4,5);
        player1 = new Player();
        player1.getPaddle().setLocation(-5,400);
        player2 = new Player();
        player2.getPaddle().setLocation(1440,400);

        field.add(ball.getBall());
        field.add(player1.getPaddle());
        field.add(player2.getPaddle());
        frame.add(field);
        frame.setVisible(true);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(ball.getImage().getImage(), 700,425,null);
    }
}
