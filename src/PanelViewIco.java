import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class PanelViewIco extends JPanel implements ActionListener
{
    private Polygon p;
    private int steps;
    private JTextField tf;
    private double x2;
    private double y2;
    private int ctr;
    private int ctr2;
    private int ctr3;
    private int ctr4;

    public PanelViewIco (Polygon p, int steps, JTextField tf)
    {
        this.p = p;
        this.steps = steps;
        this.tf = tf;
        ctr = 0;
        ctr2 = 0; //b
        ctr3 = 1; //a
        ctr4 = 1;
        Timer t = new Timer (500, this);
        t.start();
    }

    public void paint (Graphics g)
    {
        if (p.getVertexAt(ctr+1) != null)
        {
            int x = p.getVertexAt(ctr).getX();
            int y = p.getVertexAt(ctr).getY();
            int x1 = p.getVertexAt(ctr+1).getX();
            int y1 = p.getVertexAt(ctr+1).getY();
            g.drawLine (x,y,x1,y1);
            ctr ++;	
        }
        else if (ctr3 <= steps * (ctr+1) && p.getVertexAt(ctr2+1) != null)
        {
            g.setColor (Color.red);
            double xSpot = ((double)(p.getVertexAt(ctr2+1).getX()) - (double)(p.getVertexAt(ctr2).getX())) / (double)(steps);
            double ySpot = ((double)(p.getVertexAt(ctr2+1).getY()) - (double)(p.getVertexAt(ctr2).getY())) / (double)(steps);
            if (ctr3 % steps != 1)
            {
                x2 += xSpot;
                y2 += ySpot;
                g.drawRect ((int)(x2) - 5,(int)(y2) - 5,10,10);
                if (ctr3 / ctr4 == steps)
                {
                    ctr2 ++;
                    ctr4 ++;
                }
            }
            else
            {
                x2 = p.getVertexAt(ctr2).getX();
                y2 = p.getVertexAt(ctr2).getY();
                g.drawRect ((int)(x2) - 5,(int)(y2) - 5,10,10);
            }
            tf.setText(x2 + ", " + y2);
            System.out.println(ctr3);
            ctr3 ++;
        }
    }

    public void actionPerformed (ActionEvent e)
    {
        repaint ();	
    }
}