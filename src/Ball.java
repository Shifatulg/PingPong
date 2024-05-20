import javax.swing.*;
import java.awt.*;

public class Ball {
    private JLabel ball;
    private double xSpeed;
    private double ySpeed;
    private double xCoord;
    private double yCoord;
    public Ball(double xSpeed, double ySpeed, int xCoord, int yCoord) {
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
    public double getXSpeed() {
        return xSpeed;
    }
    public double getYSpeed() {
        return ySpeed;
    }
    public void inverseX() {
        xSpeed *= -1;
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
    public void incrementYSpeed(double y) {
        ySpeed += y;
    }
    public void incrementXCoord() {
        if (xCoord <= -25 || xCoord >= 1450) {
            xSpeed *= -1;
        }
        xCoord += xSpeed;
    }
    public void incrementYCoord() {
        if (yCoord <= 0 || yCoord >= 900) {
            ySpeed *= -1;
        }
        yCoord += ySpeed;
    }
    public Rectangle ballRect() {
        int imageHeight = getImage().getHeight(null);
        int imageWidth = getImage().getWidth(null);
        Rectangle rect = new Rectangle((int) xCoord, (int) yCoord, imageWidth, imageHeight);
        return rect;
    }
}
