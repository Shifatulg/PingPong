import javax.swing.*;
import java.awt.*;

public class Ball {
    private JLabel ball;
    private int xSpeed;
    private int ySpeed;
    public Ball(int x, int y) {
        ball = new JLabel(new ImageIcon("src/ball.png"));
        xSpeed = x;
        ySpeed = y;
    }
    public Component getBall() {
        return ball;
    }
    public ImageIcon getImage() {
        return new ImageIcon("src/ball.png");
    }
    public int getXSpeed() {
        return xSpeed;
    }
    public int getYSpeed() {
        return ySpeed;
    }
    public void incrementXSpeed(int x) {
        xSpeed += x;
    }
    public void incrementYSpeed(int y) {
        ySpeed += y;
    }
}
