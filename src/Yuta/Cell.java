package LOGIC;
/**
 *The basic object on the map
 * @author Yuta
 */
import java.awt.Rectangle;
public abstract class Cell extends Rectangle{
    
    private double x, y;
    public final static int DEFAULT_PANEL_SIZE = 25;
    
    public Cell(double x, double y){
        this.x = x;
        this.y = y;
        this.width = 40;
        this.height = 40;
    }
    
    public Cell(){}
    
    @Override
    public double getX(){return this.x;}
    @Override
    public double getY(){return this.y;}
}
