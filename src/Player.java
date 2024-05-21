import javax.swing.*;
import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

public class Player {
    private JLabel paddle;
    private double speed;
    private double xCoord;
    private double yCoord;
    private static int player1Score = 0;
    private static int player2Score = 0;
    private Timer time;
    public Player(int x, int y) {
        paddle = new JLabel(new ImageIcon("src/paddle.png"));
        paddle.setSize(50,200);
        speed = 0;
        xCoord = x;
        yCoord = y;
    }
    public static int getPlayer1Score() {
        return player1Score;
    }
    public static int getPlayer2Score() {
        return player2Score;
    }    public static void incrementPlayer1Score() {
        player1Score++;
    }
    public static void incrementPlayer2Score() {
        player2Score++;
    }

    public double getSpeed() {
        return speed;
    }
    public void decreaseSpeed(double speed) {
        this.speed += speed;
        if (speed > 2) {
            this.speed = 2;
        }
    }
    public void incrementSpeed(double speed) {
        this.speed -= speed;
        if (speed < -2) {
            this.speed = -2;
        }
    }

    public int getxCoord() {
        return (int) xCoord;
    }
    public int getyCoord() {
        return (int) yCoord;
    }
    public void incrementyCoord() {
        if (yCoord + speed < 0 || yCoord + speed > 750) {
            yCoord += 0;
        } else {
            yCoord += speed;
        }
    }
    public void resetSpeed() {
        speed = 0;
    }
    public Image getImage() {
        return new ImageIcon("src/paddle.png").getImage();
    }
    public Rectangle playerRect() {
        int imageHeight = getImage().getHeight(null);
        int imageWidth = getImage().getWidth(null);
        Rectangle rect = new Rectangle((int) xCoord, (int) yCoord, imageWidth, imageHeight);
        return rect;
    }
}
