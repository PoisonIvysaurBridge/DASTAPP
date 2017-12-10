/**
 *
 * @author Yuta
 */
import java.awt.*;
import java.awt.event.*;
public class Ball {
    
    private float x, y, speedX, speedY, radius;
    private Color color;
    public static final Color DEFAULT_COLOR = Color.BLUE;
    
    public Ball(float x, float y, float radius, float speed, float angleInDegree, Color color){
        this.x = x;
        this.y = y;
        this.speedX = (float)(speed * Math.cos(Math.toRadians(angleInDegree)));
        this.speedY = (float)(-speed * (float)Math.sin(Math.toRadians(angleInDegree)));
        this.radius = radius;
        this.color = color;
    }
    
    public Ball(float x, float y, float radius, float speed, float angleInDegree){
        this(x, y, radius, speed, angleInDegree, DEFAULT_COLOR);
    }
    
    public void draw(Graphics g){
        g.setColor(color);
        g.fillOval((int)(x - radius), (int)(y - radius), (int)(2 * radius), (int)(2 * radius));
    }
    
    public void moveOneStepWithCollisionDetection(ContainerBox b, Animation anime, Racqet racqet){
        float ballMinX = b.getMinX() + radius;
        float ballMinY = b.getMinY() + radius;
        float ballMaxX = b.getMaxX() - radius;
        float ballMaxY = b.getMaxY() - radius;
        
        x += speedX;
        y += speedY;
        
        if(x < ballMinX){
            speedX = -speedX;
            x = ballMinX;
        }
        else if(x > ballMaxX){
            speedX = -speedX;
            x = ballMaxX;
        }
        if(y < ballMinY){
            speedY = -speedY;
            y = ballMinY;
        }
        else if(y > ballMaxY){
            speedY = -speedY;
            y = ballMaxY;
        }
        if(anime.ballRacqetCollision()){
            if(x > ballMinX){
                speedX = speedX;
            }
            else if(x < ballMaxX){
                speedX = -speedX;
            }
            if(x > ballMinY){
                speedY = -speedY;
            }
            else if(x < ballMaxY){
                speedY = -speedY;
            }
        }
    }
    
    public float getX(){return x;}
    public float getY(){return y;}
    public float getRadius(){return radius;}
}
