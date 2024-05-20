import javax.swing.*;
import java.awt.*;

public class Ball {
    private JLabel ball;
    private int xSpeed;
    private int ySpeed;
    private double xCoord;
    private double yCoord;
    public Ball(int xSpeed, int ySpeed, int xCoord, int yCoord) {
        ball = new JLabel(new ImageIcon("src/ball.png"));
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
        this.xCoord = xCoord;
        this.yCoord = yCoord;
    }
    public Component getBall() {
        return ball;
    }
    public Image getImage() {
        return new ImageIcon("src/ball.png").getImage();
    }
    public int getXSpeed() {
        return xSpeed;
    }
    public int getYSpeed() {
        return ySpeed;
    }
    public int getxCoord() {
        return (int) xCoord;
    }
    public int getyCoord() {
        return (int) yCoord;
    }
    public void incrementXSpeed(double x) {
        xCoord += x;
    }
    public void incrementYSpeed(int y) {
        ySpeed += y;
    }
    public Rectangle ballRect() {
        int imageHeight = getImage().getHeight(null);
        int imageWidth = getImage().getWidth(null);
        Rectangle rect = new Rectangle((int) xCoord, (int) yCoord, imageWidth, imageHeight);
        return rect;
    }
}
