/**
 *
 * @author Yuta
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
public class Animation extends JPanel implements ActionListener, KeyListener {
    
    private Ball ball;
    private Racqet racqet;
    private ContainerBox containerBox;
    private int width, height;
    
    public Animation(int width, int height){
        this.width = width;
        this.height = height;
        
        Random rand = new Random();
        int radius = 25;
        int x = rand.nextInt(width - radius * 2 - 20) + radius + 10;
        int y = rand.nextInt(height - radius * 2 - 20) + radius + 10;
        int speed = 5;
        int angleInDegree = rand.nextInt(360);
        ball = new Ball((float)x, (float)y, (float)radius, (float)speed, (float)angleInDegree);
        
        x = 50 * 2;
        y = 100 * 2;
        racqet = new Racqet((float)x, (float)y, (float)20, (float)50, (float)20);
        
        containerBox = new ContainerBox(0, 0, width, height);
        
        addKeyListener(this);
        setFocusable(true);
        
        Timer t = new Timer(10, this);
        t.start();
    }
    
    @Override
    public void paint(Graphics g){
        super.paint(g);
        ball.draw(g);
        ball.moveOneStepWithCollisionDetection(containerBox, this, racqet);
        racqet.draw(g);
    }
    
    public boolean ballRacqetCollision(){
        float distX = Math.abs(ball.getX() - racqet.getX() - racqet.getWidth() / 2);
        float distY = Math.abs(ball.getY() - racqet.getY() - racqet.getHeight()/ 2);
        
        if(distX > (racqet.getWidth() / 2 + ball.getRadius())){return false;}
        if(distY > (racqet.getHeight()/ 2 + ball.getRadius())){return false;}
        
        if(distX < (racqet.getWidth() / 2)){return true;}
        if(distY < (racqet.getHeight()/ 2)){return true;}
        
        float dx = distX - racqet.getWidth() / 2;
        float dy = distY - racqet.getHeight() / 2;
        return (dx * dx + dy * dy <= (ball.getRadius() * ball.getRadius()));
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }
    
    public static void main(String[] args) {
        Animation a = new Animation(500, 500);
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
        f.getContentPane().setPreferredSize(new Dimension(500, 500));
        f.pack();
        f.add(a);
        f.setVisible(true);
    }

    @Override
    public void keyTyped(KeyEvent e){}
    @Override
    public void keyPressed(KeyEvent e){
        racqet.keyPressed(e, containerBox);
    }
    @Override
    public void keyReleased(KeyEvent e){}
}
