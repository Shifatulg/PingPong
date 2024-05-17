import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    private Ball ball;
    private Player player1;
    private Player player2;
    public GamePanel() {
        ball = new Ball(4,5);
        player1 = new Player();
        player1.getPaddle().setLocation(-5,400);
        player2 = new Player();
        player2.getPaddle().setLocation(1440,400);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(ball.getImage(), 700,425,null);
        g.drawImage(player1.getImage(),-5,400,null);
        g.drawImage(player2.getImage(),-5,400,null);
    }
}
