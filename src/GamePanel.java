import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.security.Key;

public class GamePanel extends JPanel implements KeyListener {
    private Ball ball;
    private Player player1;
    private Player player2;
    public GamePanel() {
        ball = new Ball(4,5, 700,425);
        player1 = new Player(10, 400);
        player2 = new Player(1460, 400);
        this.addKeyListener(this);
        setFocusable(true);
        requestFocusInWindow();
    }
    public Ball getBall() {
        return ball;
    }
    public Player getPlayer1() {
        return player1;
    }
    public Player getPlayer2() {
        return player2;
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(ball.getImage(), ball.getxCoord(),ball.getyCoord(),null);
        g.drawImage(player1.getImage(),player1.getxCoord(),player1.getyCoord(),null);
        g.drawImage(player2.getImage(),player2.getxCoord(),player2.getyCoord(),null);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            player2.incrementyCoord(5);
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            player2.decreaseyCoord(5);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
