import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.security.Key;
import java.util.TimerTask;

public class GamePanel extends JPanel implements KeyListener, ActionListener {
    private Ball ball;
    private Player player1;
    private Player player2;
    private Timer time;
    private Boolean[] directions;
    public GamePanel() {
        directions = new Boolean[]{false, false, false, false};
        ball = new Ball(1,1, 700,425);
        player1 = new Player(10, 400);
        player2 = new Player(1460, 400);
        time = new Timer(50, (ActionListener) this);
        time.start();
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
        g.drawImage(ball.getImage(),ball.getxCoord(),ball.getyCoord(),null);
        g.drawImage(player1.getImage(),player1.getxCoord(),player1.getyCoord(),null);
        g.drawImage(player2.getImage(),player2.getxCoord(),player2.getyCoord(),null);
        if (player2.playerRect().intersects(ball.ballRect()) || player2.playerRect().intersects(ball.ballRect())) {
            ball.inverseX();
        }
        if (directions[0]) {
            player1.incrementSpeed(.1);
            player1.incrementyCoord();
        }

        // player moves right (D)
        if (directions[1]) {
            player1.decreaseSpeed(.1);
            player1.incrementyCoord();
        }

        // player moves up (W)
        if (directions[2]) {
            player2.incrementSpeed(.1);
            player2.incrementyCoord();
        }

        // player moves down (S)
        if (directions[3]) {
            player2.decreaseSpeed(.1);
            player2.incrementyCoord();
        }
        ball.incrementXCoord();
        ball.incrementYCoord();
    }
    @Override
    public void keyTyped(KeyEvent e) { }
    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_W) {
            directions[0] = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_S) {
            directions[1] = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            directions[2] = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            directions[3] = true;
        }
    }
    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_W) {
            directions[0] = false;
            player1.resetSpeed();
        }
        if (e.getKeyCode() == KeyEvent.VK_S) {
            directions[1] = false;
            player1.resetSpeed();
        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            directions[2] = false;
            player2.resetSpeed();
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            directions[3] = false;
            player2.resetSpeed();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) { }
}
