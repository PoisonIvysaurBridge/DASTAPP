import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Box {
    
    private int minX, maxX, minY, maxY;
    private Color colorFilled;
    private Color colorBorder;
    private static final Color DEFAULT_COLORED_FILLED = Color.BLACK;
    private static final Color DEFAULT_COLORED_BORDER = Color.YELLOW;
    
    public Box(int x, int y, int width, int height, Color colorFilled, Color colorBorder){
        this.minX = x;
        this.minY = y;
        this.maxX = x + width - 1;
        this.maxY = y + height - 1;
        this.colorBorder = colorBorder;
        this.colorFilled = colorFilled;
    }
    
    public Box(int x, int y, int width, int height){
        this(x, y, width, height, DEFAULT_COLORED_FILLED, DEFAULT_COLORED_BORDER);
    }
    
    public void set(int x, int y, int width, int height){
        this.minX = x;
        this.minY = y;
        this.maxX = x + width - 1;
        this.maxY = y + height - 1;
    }
    
    public void draw(Graphics g){
        g.setColor(colorFilled);
        g.fillRect(minX, minY, maxX - minX -1, maxY - minY - 1);
        g.setColor(colorBorder);
        g.drawRect(minX, minY, maxX - minX - 1, maxY - minY - 1);
    }
    
    public int getMinX(){return minX;}
    public int getMinY(){return minY;}
    public int getMaxX(){return maxX;}
    public int getMaxY(){return maxY;}
    
}
