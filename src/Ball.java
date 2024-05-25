import javax.swing.*;
import java.awt.*;

public class Ball {
    private JLabel ball;
    private double xSpeed;
    private double ySpeed;
    private double xCoord;
    private double yCoord;
    private int gameNum;
    public Ball(double xSpeed, double ySpeed, int xCoord, int yCoord) {
        ball = new JLabel(new ImageIcon("src/ball.png"));
        gameNum = 1;
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
        this.xCoord = xCoord;
        this.yCoord = yCoord;
    }
    public Image getImage() {
        return new ImageIcon("src/ball.png").getImage();
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
        if (xSpeed < 0) {
            xSpeed -= x;
        } else {
            xSpeed += x;
        }
    }
    public void incrementXCoord() {
        if (xCoord <= -25 || xCoord >= 1450) {
            if (xCoord <= -25) {
                Player.incrementPlayer2Score();
            }
            if (xCoord >= 1450) {
                Player.incrementPlayer1Score();
            }
            xCoord = 700;
            yCoord = 425;
            xSpeed = -2.5;
            ySpeed = 6;
            gameNum++;
            xSpeed *= Math.pow(-1,gameNum);
        }
        xCoord += xSpeed;
    }
    public void incrementYCoord() {
        if (yCoord <= 0 || yCoord >= 900) {
            ySpeed *= -1;
        }
        yCoord += ySpeed;
    }
    public void changeSpeed(double speed) {
        ySpeed = (ySpeed + speed) / 1.575;

        if (ySpeed > 6) {
            ySpeed = 6;
        }
        if (ySpeed < -6) {
            ySpeed = -6;
        }
    }
    public Rectangle ballRect() {
        int imageHeight = getImage().getHeight(null);
        int imageWidth = getImage().getWidth(null);
        Rectangle rect = new Rectangle((int) xCoord, (int) yCoord, imageWidth, imageHeight);
        return rect;
    }
}
