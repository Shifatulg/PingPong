import javax.swing.*;
import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

public class Player {
    private JLabel paddle;
    private double speed;
    private double xCoord;
    private double yCoord;
    private int score;
    private Timer time;
    public Player(int x, int y) {
        paddle = new JLabel(new ImageIcon("src/paddle.png"));
        paddle.setSize(50,200);
        speed = .1;
        score = 0;
        xCoord = x;
        yCoord = y;

    }
    public JLabel getPaddle() {
        return paddle;
    }
    public int getScore() {
        return score;
    }
    public void incrementScore() {
        score++;
    }
    public void decreaseSpeed(double speed) {
        this.speed += speed;
    }
    public void incrementSpeed(double speed) {
        this.speed -= speed;
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
        speed = .1;
    }
    public Image getImage() {
        return new ImageIcon("src/paddle.png").getImage();
    }
    // we use a "bounding Rectangle" for detecting collision
    public Rectangle playerRect() {
        int imageHeight = getImage().getHeight(null);
        int imageWidth = getImage().getWidth(null);
        Rectangle rect = new Rectangle((int) xCoord, (int) yCoord, imageWidth, imageHeight);
        return rect;
    }
}
