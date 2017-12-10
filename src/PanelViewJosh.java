import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.Timer;
public class PanelViewJosh extends JPanel implements ActionListener
{
        private Polygon p;
        private int steps;
        private JTextField tf;
        private int x=0;
        private int y=0;
        private int step = 0;
        private int points = 0;
        
   //     private int RealTime = 1;
	public PanelViewJosh (Polygon p, int steps, JTextField tf)
	{
		this.p = p;
        this.steps = steps;
        this.tf = tf;
        while(p.getVertexAt(points) != null){
            points++;
        }
        System.out.println(points);
        Timer timer = new Timer(500,this);
        timer.start();
	}
	
	
	public void paint (Graphics g)
	{
		super.paint(g);
		g.setColor(Color.blue);
		int i = 0;
        while(p.getVertexAt(i+1) != null){
            PointXY a = p.getVertexAt(i);
            PointXY b = p.getVertexAt(i+1);
            g.drawLine(a.getX(), a.getY(), b.getX(), b.getY());
            i++;
        }
       /* 
        g.setColor(Color.GRAY);
        for(i = 0; i<y ; i++){
            g.drawLine(p.getVertexAt(i).getX(), p.getVertexAt(i).getY(), p.getVertexAt(i+1).getX(), p.getVertexAt(i+1).getY());
        }*/
        g.setColor(Color.red);
        for(i = 0; i<y;i++){
            for(double z = 0; z < steps; z++){
                double firstX = p.getVertexAt(i).getX();
                double firstY = p.getVertexAt(i).getY();
                double secondX = p.getVertexAt(i+1).getX();
                double secondY = p.getVertexAt(i+1).getY();
                double xx = (firstX - secondX) *(z/steps);
                double xy = (firstY - secondY) *(z/steps);
                double xz = firstX - xx;
                double yz = firstY - xy;
                g.drawRect((int)xz-4, (int)yz-4, 8, 8);
            }
        }
        g.setColor(Color.gray);
        for(i = 0; i<x;i++){
            double firstX = p.getVertexAt(y).getX();
            double firstY = p.getVertexAt(y).getY();
            double secondX = p.getVertexAt(y+1).getX();
            double secondY = p.getVertexAt(y+1).getY();
            double xx = (firstX - secondX) *((double)i/steps);
            double xy = (firstY - secondY) *((double)i/steps);
            double xz =  firstX - xx;
            double yz = firstY - xy;
            tf.setText("("+xz+","+yz+")");
         //   System.out.println(xz);
            g.drawRect((int)xz-5, (int)yz-5, 10, 10);
            //System.out.println("LMAO");
            
        }
      /*  g.setColor(Color.blue);
        if (x >0){
            double firstX = p.getVertexAt(y).getX();
            double firstY = p.getVertexAt(y).getY();
            double secondX = p.getVertexAt(y+1).getX();
            double secondY = p.getVertexAt(y+1).getY();
            double xx = (firstX - secondX) *((double)(i-1)/steps);
            double xy = (firstY - secondY) *((double)(i-1)/steps);
            xx += (firstX - secondX) *(1.0/steps)*(((double)RealTime)/8.0);
            xy += (firstY - secondY) *(1.0/steps)*(((double)RealTime)/8.0);
            xz =  firstX - xx;
            yz = firstY - xy;
            g.drawLine(p.getVertexAt(y).getX(), p.getVertexAt(y).getY(), (int)xz, (int)yz);
        }
		// Insert paint logic here*/
	}
	
	public void actionPerformed (ActionEvent e)
	{
        //    if(RealTime == 8){
       //         RealTime = 1;
        if(y+1 < points){
            if(x<steps){
                x++;
                //repaint();
            }
            else{
	            x=0;
	            y++;
            //repaint();
            }
        }
       //     }
         //   else{
           //     RealTime++;
         //   }
            repaint();
	}
}
