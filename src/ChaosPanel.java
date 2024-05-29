import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class ChaosPanel extends JPanel implements KeyListener, ActionListener {
    private Ball ball;
    private Player player1;
    private Player player2;
    private Timer time;
    private Boolean[] directions;
    public ChaosPanel() {
        directions = new Boolean[]{false, false, false, false};
        ball = new Ball(2.5,6, 700,425);
        player1 = new Player(10, 400);
        player2 = new Player(1460, 400);
        time = new Timer(40, this);
        this.addKeyListener(this);
        setFocusable(true);
        requestFocusInWindow();
        time.start();
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
    public Color getColor(int score) {
        score %= 7;
        if (score == 0) {
            return Color.RED;
        } else if (score == 1) {
            return Color.ORANGE;
        } else if (score == 2) {
            return Color.YELLOW;
        } else if (score == 3) {
            return Color.GREEN;
        } else if (score == 4) {
            return Color.CYAN;
        } else if (score == 5) {
            return Color.BLUE;
        } else {
            return Color.MAGENTA;
        }
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(ball.getImage(),ball.getxCoord(),ball.getyCoord(),null);
        g.drawImage(player1.getImage(),player1.getXCoord(),player1.getYCoord(),null);
        g.drawImage(player2.getImage(),player2.getXCoord(),player2.getYCoord(),null);
        g.setFont(new Font("Arial", Font.BOLD, 30));
        g.setColor(getColor(Player.getPlayer1Score()));
        g.drawString(String.valueOf(Player.getPlayer1Score()), 500, 200);
        g.setColor(getColor(Player.getPlayer2Score()));
        g.drawString(String.valueOf(Player.getPlayer2Score()), 1000, 200);

        if (directions[0]) {
            player1.incrementSpeed(.4);
            player1.incrementYCoord();
        }

        // player moves right (D)
        if (directions[1]) {
            player1.decreaseSpeed(.4);
            player1.incrementYCoord();
        }

        // player moves up (W)
        if (directions[2]) {
            player2.incrementSpeed(.4);
            player2.incrementYCoord();
        }

        // player moves down (S)
        if (directions[3]) {
            player2.decreaseSpeed(.4);
            player2.incrementYCoord();
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
    public void actionPerformed(ActionEvent e) {
        if ((int) (Math.random() * 250) + 1 == 1) {
            ball.inverseX();
        }
        if ((int) (Math.random() * 150) + 1 == 1) {
            ball.changeSpeed(13);
        }
        if ((int) (Math.random() * 150) + 1 == 1) {
            ball.changeSpeed(-13);
        }
        if ((int) (Math.random() * 150) + 1 == 1) {
            ball.inverseY();
        }
        if ((int) (Math.random() * 150) + 1 == 1) {
            ball.inverseY();
        }
        if ((int) (Math.random() * 300) + 1 == 1) {
            ball.killYSpeed();
        }
        if ((int) (Math.random() * 200) + 1 == 1) {
            ball.incrementXSpeed(1);
        }
        ball.incrementXSpeed(.016);
        if (player1.playerRect().intersects(ball.ballRect())) {
            ball.inverseX();
            ball.setXCoord(20);
            ball.changeSpeed(player1.getSpeed());
        }
        if (player2.playerRect().intersects(ball.ballRect())) {
            ball.inverseX();
            ball.setXCoord(1400);
            ball.changeSpeed(player2.getSpeed());
        }
    }
}
