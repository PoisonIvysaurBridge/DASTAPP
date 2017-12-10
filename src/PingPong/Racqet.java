/**
 *
 * @author Yuta
 */
import java.awt.*;
import java.awt.event.*;
public class Racqet {
    
    private float x, y, speedX, width, height;
    private Color color;
    public static final Color DEFAULT_COLOR = Color.BLACK;
    
    public Racqet(float x, float y, float speed, float width, float height, Color color){
        this.x = x;
        this.y = y;
        this.speedX = speed;
        this.width = width;
        this.height = height;
        this.color = color;
    }
    
    public Racqet(float x, float y, float speed, float width, float height){
        this(x, y, speed, width, height, DEFAULT_COLOR);
    }
    
    public void draw(Graphics g){
        g.setColor(color);
        g.fillRect((int)x, (int)y, (int)width, (int)height);
    }
    
    public void moveOneStepWithCollision(ContainerBox box){
        float racMinX = box.getMinX();
        float racMaxX = box.getMaxX();
        
        x += speedX;
        
        if(x < racMinX){
            speedX = -speedX;
            x = racMinX;
        }
        else if(x > racMaxX){
            speedX = -speedX;
            x = racMaxX;
        }
    }
    public float getX(){return x;}
    public float getY(){return y;}
    public float getWidth(){return width;}
    public float getHeight(){return height;}
    public void setX(float x){this.x = x;}
    public void setY(float y){this.y = y;}
    
    public void keyPressed(KeyEvent e, ContainerBox box) {
        float racMinX = box.getMinX();
        float racMaxX = box.getMaxX();
        if(e.getKeyCode() == KeyEvent.VK_LEFT){
            x -= speedX;
            if(x < racMinX){
                x = racMaxX;
            }
        }
        if(e.getKeyCode() == KeyEvent.VK_RIGHT){
            x += speedX;
            if(x > racMaxX){
                x = racMinX;
            }
        }
    }
    
    public void keyReleased(KeyEvent e, ContainerBox box){
        float racMinX = box.getMinX();
        float racMaxX = box.getMaxX();
        
        x += speedX;
        
        
    }
    
    
}
