import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;

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
}
