import java.awt.event.*;
import java.awt.*;
import java.util.Random;
import javax.swing.*;
public class BallWorld extends JPanel implements MouseListener {
    
    private static final int UPDATE_RATE = 30;
    private Ball ball;
    private Box box;
    private DrawCanvas canvas;
    private int canvasWidth;
    private int canvasHeight;
    
    public BallWorld(int width, int height) {
        canvasWidth = width;
        canvasHeight = height;
        this.addMouseListener(this);
        Random rand = new Random();
        int radius = 100;
        int x = rand.nextInt(canvasWidth - radius * 2 - 20) + radius + 10;
        int y = rand.nextInt(canvasHeight - radius * 2 - 20) + radius + 10;
        int speed = 5;
        int angleInDegree = rand.nextInt(360);
        ball = new Ball(x, y, radius, speed, angleInDegree, Color.BLUE);
        
        box = new Box(0, 0, canvasWidth, canvasHeight, Color.BLACK, Color.WHITE);
        
        canvas = new DrawCanvas();
        this.setLayout(new BorderLayout());
        this.add(canvas, BorderLayout.CENTER);
        
        this.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                Component c = (Component)e.getSource();
                Dimension dim = c.getSize();
                canvasWidth = dim.width;
                canvasHeight = dim.height;
                box.set(0, 0, canvasWidth, canvasHeight);
            }
        }
        );
        
        gameStart();
    }
    
    public void gameStart() {
        
        Thread gameThread = new Thread() {
            @Override
            public void run() {
                while (true) {
                    gameUpdate();
                    repaint();
                    try {
                        Thread.sleep(1000 / UPDATE_RATE);
                    } 
                    catch (InterruptedException ex) {}
                }
            }
        };
        gameThread.start();
   }
    
    public void gameUpdate() {
        ball.moveOneStepWithCollisionDetection(box);
    }
    
    class DrawCanvas extends JPanel {
        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            box.draw(g);
            ball.draw(g);
            g.setColor(Color.WHITE);
            g.setFont(new Font("Courier New", Font.PLAIN, 12));
            g.drawString("Ball " + ball.toString(), 20, 30);
        }
        
        @Override
        public Dimension getPreferredSize() {
            return (new Dimension(canvasWidth, canvasHeight));
        }
    }
	
	@Override
    public void mouseClicked(MouseEvent e) {
		Color c = Color.MAGENTA;
		ball.setColor(c);
    }

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}
    
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new JFrame("A World of Balls");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setContentPane(new BallWorld(640, 480));
                frame.pack();
                frame.setVisible(true);
            }
        }
        );
    }
}