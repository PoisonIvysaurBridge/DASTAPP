package Yuta;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.io.*;
import java.util.Scanner;
import java.util.Vector;

public class SwitchingColors extends JPanel implements MouseListener, ActionListener, KeyListener, MouseMotionListener
{
    ArrayList<Color> colors;
    ArrayList<Rectangle2D> rects;
    Vector<String> files;
    int columns, rows, level;
    int area;
    Scanner sc;
    final int WIDTH, HEIGHT, SPACE;
    Builder b;
    
    public SwitchingColors(int columns, int rows, Builder b)
    {
        WIDTH = 20;
        HEIGHT = 20;
        SPACE = 22;
        
        sc = new Scanner(System.in);
        files = new Vector();
        
        this.columns = columns;
        this.rows = rows;
        area = columns * rows;
        
        this.b = b;
        initialize();
        
        addMouseListener(this);
        addKeyListener(this);
        addMouseMotionListener(this);
        
        Timer t = new Timer(1, this);
        t.start();
    }
    
    public void play()
    {
        int i, player = 0, goal = 0;
        
        for (i = 0; i < colors.size(); i ++)
        {
            if (colors.get(i) == Color.YELLOW)
                player ++;
            else if (colors.get(i) == Color.CYAN)
                goal ++;
        }
        
        if (player == 1 && goal == 1)
            requestFocusInWindow();
        else
            JOptionPane.showMessageDialog(b, "ERROR.", "SAD ERROR", JOptionPane.WARNING_MESSAGE);
    }
    
    public void initialize()
    {
        int i, x, y;
        
        colors = new ArrayList<>();
        
        for (i = 0; i < area; i ++)
        {
            colors.add(Color.BLACK);
        }
        
        rects = new ArrayList<>();
        x = 0;
        y = 0;
        
        for (i = 0; i < area; i ++)
        {
            if (i % columns == 0 && i != 0)
            {
                y += SPACE;
                x = 0;
            }
            
            rects.add(new Rectangle2D.Double(x, y, WIDTH, HEIGHT));
            x += SPACE;
        }
    }
    
    public void setLevel(int level)
    {
        this.level = level;
    }
    
    public void paint(Graphics g)
    {
        super.paint(g);
        
        Graphics2D g2d = (Graphics2D) g;
        
        int i;
        
        for (i = 0; i < rects.size(); i ++)
        {
            if (colors.get(i) == Color.BLACK)
                g2d.setColor(Color.WHITE);
            else
                g2d.setColor(Color.BLACK);
            g2d.draw(rects.get(i));
            
            g2d.setColor(colors.get(i));
            g2d.fill(rects.get(i));
        }
    }
    
    public void saveVect()
    {
        BufferedWriter bw;
        File f = new File("Filenames.txt");
        int i;
        
        try
        {
            bw = new BufferedWriter(new FileWriter(f));
            
            for (i = 0; i < files.size(); i ++)
            {
                bw.write(files.get(i));
                bw.newLine();
            }
            bw.flush();
            bw.close();
        }
        catch (Exception e) {}
    }
    
    public void save()
    {
        System.out.print("Filename: ");
        String name = sc.next();
        
        files.add(name);
        
        BufferedWriter bw;
        File f = new File(name + ".txt");
        
        try
        {
            bw = new BufferedWriter(new FileWriter(f));
            int i;
            String str = "";
            
            bw.write(rows + " " + columns);
            bw.newLine();
            
            for (i = 0; i < colors.size(); i ++)
            {
                if (i % columns == 0 && i != 0)
                    bw.newLine();
                
                switch (colors.get(i).getRGB())
                {
                    case -16777216: str = "#"; break;
                    case -4144960: str = " "; break;
                    case -256: str = "S"; break;
                    case -16711681: str = "G"; break;
                }
                bw.write(str);
            }
            bw.flush();
            bw.close();
            
            updateList();
        }
        catch (Exception e) {}
    }
    
    public Vector<String> loadVect()
    {
        BufferedReader br;
        
        String line;
        
        try
        {
            File f = new File("Filenames.txt");
            br = new BufferedReader(new FileReader(f));
            
            files.removeAll(files);
            
            while ((line = br.readLine()) != null)
            {
                files.add(line);
            }
            br.close();
            
            updateList();
        }
        catch (Exception e) {}
        
        return files;
    }
    
    public void load()
    {
        BufferedReader br;
        
        String line;
        double x, y;
        boolean first = true;
        int i;
        
        x = 0;
        y = 0;
        
        try
        {
            File f = new File(files.get(level) + ".txt");
            br = new BufferedReader(new FileReader(f));
            
            colors.removeAll(colors);
            rects.removeAll(rects);
            
            while ((line = br.readLine()) != null)
            {
                if (first)
                {
                    rows = Integer.parseInt(line.substring(0, line.indexOf(" ")));
                    columns = Integer.parseInt(line.substring(line.indexOf(" ") + 1));
                    first = false;
                }
                else
                {
                    i = 0;
                    while (i < columns)
                    {
                        switch (line.charAt(i))
                        {
                            case '#': colors.add(Color.BLACK); break;
                            case ' ': colors.add(Color.LIGHT_GRAY); break;
                            case 'S': colors.add(Color.YELLOW); break;
                            case 'G': colors.add(Color.CYAN); break;
                        }
                        rects.add(new Rectangle2D.Double(x, y, WIDTH, HEIGHT));
                        x += SPACE;
                        i ++;
                    }
                    y += SPACE;
                    x = 0;
                }
            }
            br.close();
        }
        catch (Exception e) {}
    }
    
    public void updateList()
    {
        int i, j;
        
        for (i = 0; i < files.size(); i ++)
        {
            for (j = i + 1; j < files.size(); j ++)
            {
                if (files.get(i).equals(files.get(j)))
                {
                    files.remove(j);
                }
            }
        }
        //b.list.setListData(files);
        
    }
    public void mouseClicked(MouseEvent e) 
    {
        int i;
        
        for (i = 0; i < rects.size(); i ++)
        {
            if (rects.get(i).contains(e.getPoint()))
            {
                if (colors.get(i).equals(Color.BLACK))
                    colors.set(i, Color.LIGHT_GRAY);
                else if (colors.get(i).equals(Color.LIGHT_GRAY))
                    colors.set(i, Color.YELLOW);
                else if (colors.get(i).equals(Color.YELLOW))
                    colors.set(i, Color.CYAN);
                else if (colors.get(i).equals(Color.CYAN))
                    colors.set(i, Color.BLACK);
            }
        }
    }
    
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {} 
    public void mousePressed(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}
    
    public void keyPressed(KeyEvent e)
    {
        int i, icopy;
        
        i = 0;
        
        while (i < colors.size() && !colors.get(i).equals(Color.YELLOW))
            i ++;
        
        icopy = i;
        
        if (i != rects.size())
        {   
            colors.set(i, Color.LIGHT_GRAY);
            
            switch (e.getKeyCode())
            {
                case KeyEvent.VK_LEFT: i --; break;
                case KeyEvent.VK_RIGHT: i ++; break;
                case KeyEvent.VK_UP: i -= columns; break;
                case KeyEvent.VK_DOWN: i += columns; break;
            }
            
            if (colors.get(i).equals(Color.CYAN))
            {
                colors.set(i, Color.YELLOW);
                JOptionPane.showMessageDialog(b, "YOU WON!", "GAME SET", JOptionPane.INFORMATION_MESSAGE);
            }
            
            if (colors.get(i).equals(Color.LIGHT_GRAY))
                colors.set(i, Color.YELLOW);
            else
                colors.set(icopy, Color.YELLOW);
        }
    }
    
    public void keyReleased(KeyEvent e) {}
    public void keyTyped(KeyEvent e) {}
    
    public void actionPerformed(ActionEvent e)
    {
        repaint();
    }
    
    public void mouseDragged(MouseEvent e)
    {
        int i;
        
        for (i = 0; i < rects.size(); i ++)
        {
            if (rects.get(i).contains(e.getPoint()))
            {
                if (colors.get(i).equals(Color.BLACK))
                    colors.set(i, Color.LIGHT_GRAY);
            }
        }
    }
    
    public void mouseMoved(MouseEvent e) {}
}
