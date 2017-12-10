import java.util.*;
import java.awt.*;
public class Ball {
    
    private float x, y;
    private float speedX, speedY, radius;
    private Color color;
    private static final Color DEFAULT__COLOR = Color.BLUE;
    
    public Ball(float x, float y, float radius, float speed, float angleInDegree, Color color){
        this.x = x;
        this.y = y;
        this.speedX = (float)(speed * Math.cos(Math.toRadians(angleInDegree)));
        this.speedY = (float)(-speed * (float)Math.sin(Math.toRadians(angleInDegree)));
        this.radius = radius;
        this.color = color;
    }
    
    public Ball(float x, float y, float radius, float speed, float angleInDegree) {
        this(x, y, radius, speed, angleInDegree, DEFAULT__COLOR);
    }
    
    public void draw(Graphics g){
        g.setColor(color);
        g.fillOval((int)(x - radius), (int)(y - radius), (int)(2 * radius), (int)(2 * radius));
    }
    
    public void moveOneStepWithCollisionDetection(Box b){
        float ballMinX = b.getMinX() + radius;
        float ballMinY = b.getMinY() + radius;
        float ballMaxX = b.getMaxX() - radius;
        float ballMaxY = b.getMaxY() - radius;
        
        x += speedX;
        y += speedY;
        
        if(x < ballMinX){
            speedX = -speedX;
            x = ballMinX;
			this.color = Color.GREEN;
        }
        else if(x > ballMaxX){
            speedX = -speedX;
            x = ballMaxX;
			this.color = Color.RED;
        }
        if(y < ballMinY){
            speedY = -speedY;
            y = ballMinY;
			this.color = Color.BLUE;
        }
        else if(y > ballMaxY){
            speedY = -speedY;
            y = ballMaxY;
			this.color = Color.YELLOW;
        }
        
    }
    
    public float getSpeed() {
       return (float)Math.sqrt(speedX * speedX + speedY * speedY);
    }
    
    public float getMoveAngle() {
       return (float)Math.toDegrees(Math.atan2(-speedY, speedX));
    }
    
    public float getMass() {
       return radius * radius * radius / 1000f;  // Normalize by a factor
    }
    
    public float getKineticEnergy() {
       return 0.5f * getMass() * (speedX * speedX + speedY * speedY);
    }
    
    @Override
    public String toString() {
       sb.delete(0, sb.length());
       formatter.format("@(%3.0f,%3.0f) r=%3.0f V=(%2.0f,%2.0f) " +
             "S=%4.1f \u0398=%4.0f KE=%3.0f", 
             x, y, radius, speedX, speedY, getSpeed(), getMoveAngle(),
             getKineticEnergy());  // \u0398 is theta
       return sb.toString();
    }
	
	public void setColor(Color c){this.color = color;}
    
    private StringBuilder sb = new StringBuilder();
    private Formatter formatter = new Formatter(sb);
    
}
