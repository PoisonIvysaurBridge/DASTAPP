package GUI;
/**
 *
 * @author Yuta
 */
import LOGIC.*;
import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.util.ArrayList;
import java.io.*;
public class Maze extends JPanel implements ActionListener {
    
    private ArrayList<Cell> tiles;
    
    public Maze(File f){
        this.tiles = new ArrayList<>();
        this.generateMaze(Map.loadMap(f));
        Timer t = new Timer(1, this);
        t.start();
    }
    
    public ArrayList<Cell> getTiles(){return this.tiles;}
    
    public void generateMaze(Map map){
        int x = 0, y = 0;
        for(int i = 0; i < map.getColums(); i++){
            for(int j = 0; j < map.getRows(); j++){
                if(map.getMap()[i][j] == Map.PATH){
                    Tile t = new Tile(x, y);
                    t.setWall(Tile.NOT_WALL);
                    tiles.add(t);
                }
                else if(map.getMap()[i][j] == Map.WALL){
                    Tile t = new Tile(x, y);
                    t.setWall(Tile.IS_WALL);
                    tiles.add(t);
                }
                else if(map.getMap()[i][j] == Map.RAT){
                    Rat r = new Rat(x, y);
                    tiles.add(r);
                }
                else if(map.getMap()[i][j] == Map.CHEESE){
                    Cheese c = new Cheese(x, y);
                    tiles.add(c);
                }
                x +=42;
            }
            y += 42;
            x = 0;
        }
    }
    
    @Override
    public void paint(Graphics g){
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        
        for (Cell c : tiles){
            if(c instanceof Tile){
                if(((Tile) c).getWall())
                    g2d.setColor(Tile.WALL_COLOR);
                else
                    g2d.setColor(Tile.PATH_COLOR);
            }
            else if(c instanceof Rat){
                g2d.setColor(Rat.RAT_COLOR);
            }
            else if(c instanceof Cheese){
                g2d.setColor(Cheese.CHEESE_COLOR);
            }
            g2d.draw(c);
            g2d.fill(c);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }
    
    public static void main(String[] args){
        Maze app = new Maze(new File("C:\\Users\\Yuta\\Documents\\2nd year 1st term\\default.txt"));
        JFrame f = new JFrame("Hello world!");
        
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(950, 950);
        
        f.add(app);
        
        f.setVisible(true);
        
    }
    
}
