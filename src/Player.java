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
    public void incrementyCoord(double y) {
        yCoord -= y;
    }
    public void decreaseyCoord(double y) {
        yCoord += y;
    }
    public void resetSpeed() {
        speed = .1;
    }
    public Image getImage() {
        return new ImageIcon("src/paddle.png").getImage();
    }
}
