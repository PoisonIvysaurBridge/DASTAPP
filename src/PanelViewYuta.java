import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class PanelViewYuta extends JPanel implements ActionListener{
    
    private Polygon poly;
    private int steps;
    private JTextField tf;
    
    public PanelViewYuta (Polygon p, int steps, JTextField tf){
        this.poly = p;
        this.steps = steps;
        this.tf = tf;
        Timer t = new Timer(1000, this);
        t.start();
    }
    
    @Override
    public void paint (Graphics g){
       // super.paint(g);
        PointXY var1 = null;
        PointXY var2 = null;
        Graphics2D d = (Graphics2D)g;
        boolean check = true;
        int ctr = 0;
        int distX, distY;
        
        do{
            if(poly.getVertexAt(ctr) != null){
                var1 = poly.getVertexAt(ctr);
                if(poly.getVertexAt(ctr + 1) != null){
                    var2 = poly.getVertexAt(ctr + 1);
                    d.drawLine(var1.getX(), var1.getY(), var2.getX(), var2.getY());
                }
                else{
                    d.drawLine(var1.getX(), var1.getY(), var1.getX(), var1.getY());
                }
            }
            else{
                check = false;
            }
            ctr++;
        }while(check);
        check = true;
        ctr = 0;
        var1 = null;
        var2 = null;
        do{
            if(poly.getVertexAt(ctr) != null){
                var1 = poly.getVertexAt(ctr);
                if(poly.getVertexAt(ctr + 1) != null){
                    var2 = poly.getVertexAt(ctr + 1);
                    distX = var2.getX() - var1.getX();
                    distY = var2.getY() - var1.getY();
                    int w;
                    int q;
                    int tempX;
                    int tempY;
                    switch(findDirection(distX, distY)){
                        case 1:
                            System.out.println("DOWN");
                            for(int i = 0; i < steps; i++){
                                w = (distY / steps) * i;
                                g.drawRect(var1.getX() - 3, var1.getY() + w, 6, 6);
                            }
                            break;
                        case 2:
                            System.out.println("UP");
                            for(int i = 0; i < steps; i++){
                                w = (distY / steps) * i;
                                g.drawRect(var1.getX() - 3, var1.getY() + w, 6, 6);
                            }
                            break;
                        case 3:
                            System.out.println("LEFT");
                            for(int i = 0; i < steps; i++){
                                w = (distX / steps) * i;
                                g.drawRect(var1.getX() + w, var1.getY() - 3, 6, 6);
                            }
                            break;
                        case 4:
                            System.out.println("RIGHT");
                            for(int i = 0; i < steps; i++){
                                w = (distX / steps) * i;
                                g.drawRect(var1.getX() + w, var1.getY() - 3, 6, 6);
                            }
                            break;
                        case 5:
                            System.out.println("Diagonal Up Right");
                            for(int i = 0; i < steps; i++){
                                w = (distX / steps) * i;
                                q = (distY / steps) * i;
                                g.drawRect(var1.getX() + w - 3, var1.getY() + q - 3, 6, 6);
                            }
                            break;
                        case 6:
                            System.out.println("Diagonal Down Left");
                            for(int i = 0; i < steps; i++){
                                w = (distX / steps) * i;
                                q = (distY / steps) * i;
                                g.drawRect(var1.getX() + w - 3, var1.getY() + q - 3, 6, 6);
                            }
                            break;
                        case 7:
                            System.out.println("Diagonal Down Right");
                            for(int i = 0; i < steps; i++){
                                w = (distX / steps) * i;
                                q = (distY / steps) * i;
                                g.drawRect(var1.getX() + w - 3, var1.getY() + q - 3, 6, 6);
                            }
                            break;
                        case 8:
                            System.out.println("Digonal Up Left");
                            for(int i = 0; i < steps; i++){
                                w = (distX / steps) * i;
                                q = (distY / steps) * i;
                                g.drawRect(var1.getX() + w - 3, var1.getY() + q - 3, 6, 6);
                            }
                            break;
                    }
                }
                else{
                    //Nothing happens
                }
            }
            else{
                check = false;
            }
            ctr++;
        }while(check);
        
    }
    
    public int findDirection(int distX, int distY){
        if(distX == 0 && distY > 0){
            return 1;/*DOWN*/
        }
        else if(distX == 0 && distY < 0){
            return 2;/*UP*/
        }
        else if(distX < 0 && distY == 0){
            return 3;/*LEFT*/
        }
        else if(distX > 0 && distY == 0){
            return 4;/*RIGHT*/
        }
        else if(distX > 0 && distY < 0){
            return 5;/*Diagonal up Right*/
        }
        else if(distX < 0 && distY > 0){
            return 6;/*Diagnal down left*/
        }
        else if(distX > 0 && distY > 0){
            return 7;/*Diagonal down right*/
        }
        else if(distX < 0 && distY < 0){
            return 8;/*Diagonal up left*/
        }
        return 0;
    }
    
    public void setSteps(int steps){this.steps = steps;}
    @Override
    public void actionPerformed (ActionEvent e){
        repaint();
    }
}
