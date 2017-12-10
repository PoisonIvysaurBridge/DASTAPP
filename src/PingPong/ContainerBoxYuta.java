/**
 *
 * @author Yuta
 */
import java.awt.*;
import javax.swing.*;
public class ContainerBox extends JPanel {
    
    private int minX, minY, maxX, maxY;
    private Color colorFilled, colorBorder;
    public static final Color DEFAULT_COLOR_FILLED = Color.BLACK;
    public static final Color DEFAULT_COLOR_BORDER = Color.YELLOW;
    
    public ContainerBox(int x, int y, int width, int height){
        this.minX = x;
        this.minY = y;
        this.maxX = x + width - 1;
        this.maxY = y + height - 1;
        this.colorFilled = DEFAULT_COLOR_FILLED;
        this.colorBorder = DEFAULT_COLOR_BORDER;
    }
    
    public void setSize(int x, int y, int width, int height){
        this.minX = x;
        this.minY = y;
        this.maxX = x + width - 1;
        this.maxY = y + height - 1;
    }
    
    public void draw(Graphics g){
        g.setColor(colorFilled);
        g.fillRect(minX, minY, maxX - minX - 1, maxY - minY - 1);
        g.setColor(colorBorder);
        g.drawRect(minX, minY, maxX - minX - 1, maxY - minY - 1);
    }
    
    public int getMinX(){return this.minX;}
    public int getMinY(){return this.minY;}
    public int getMaxX(){return this.maxX;}
    public int getMaxY(){return this.maxY;}
    
}
