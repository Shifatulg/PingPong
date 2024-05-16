import javax.swing.*;
public class Ball {
    private JLabel ball;
    private int xSpeed;
    private int ySpeed;
    public Ball(int x, int y) {
        ball = new JLabel(new ImageIcon("src/ball.png"));
        xSpeed = x;
        ySpeed = y;
    }
    public JLabel getBall() {
        return ball;
    }
    public int getXSpeed() {
        return xSpeed;
    }
    public int getYSpeed() {
        return ySpeed;
    }
    public void setXSpeed(int x) {
        xSpeed += x;
    }
    public void setYSpeed(int y) {
        ySpeed += y;
    }
}
