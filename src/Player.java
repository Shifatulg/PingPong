import javax.swing.*;

public class Player {
    private JLabel paddle;
    private double speed;
    private int score;
    public Player() {
        paddle = new JLabel(new ImageIcon("src/paddle.png"));
        speed = .1;
        score = 0;
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
    public void incrementSpeed(double speed) {
        this.speed += speed;
    }
    public void resetSpeed() {
        speed = .1;
    }
}
