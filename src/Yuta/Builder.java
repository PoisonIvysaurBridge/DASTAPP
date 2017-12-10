package Yuta;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ItemListener;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JComboBox;
import java.awt.event.ItemEvent;
import java.util.Scanner;

public class Builder extends JFrame implements ActionListener, ListSelectionListener, ItemListener
{
    SwitchingColors app;
    JList list;
    JComboBox cb;
    Scanner sc = new Scanner(System.in);
    int columns, rows;
        
    public Builder()
    {
        super("Hello World!");
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        columns = sc.nextInt();
        rows = sc.nextInt();
        
        setSize(23 * columns, 28 * rows);
        build();
        
        //setResizable(false);
        setVisible(true);
        
    }
    
    public void build()
    {
        JPanel pnl;
        JScrollPane scroll;
        JButton btn;
        
        pnl = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        
        c.gridx = 0;
        c.gridy = 0;
        c.ipadx = 650;
        c.ipady = 650;
        
        app = new SwitchingColors(rows, columns, this);
        pnl.add(app, c);
        
        /*list = new JList();
        list.addListSelectionListener(this);
        
        scroll = new JScrollPane(list);
        scroll.setPreferredSize(new Dimension(200, 200));*/
        
        add(pnl);
        
        pnl = new JPanel();
        
        btn = new JButton("Save");
        btn.addActionListener(this);
        
        pnl.add(btn, BorderLayout.SOUTH);
        
        btn = new JButton("GO");
        btn.addActionListener(this);
        
        pnl.add(btn, BorderLayout.SOUTH);
        
        
        cb = new JComboBox(app.loadVect());
        cb.addItemListener(this);
        
        pnl.add(cb, BorderLayout.SOUTH);
        
        btn = new JButton("Load");
        btn.addActionListener(this);
        
        pnl.add(btn, BorderLayout.SOUTH);
        add(pnl, BorderLayout.SOUTH);
        
        btn = new JButton("Reset");
        btn.addActionListener(this);
        
        pnl.add(btn, BorderLayout.SOUTH);
        add(pnl, BorderLayout.SOUTH);
    }
    
    public void valueChanged(ListSelectionEvent e)
    {
        if (e.getValueIsAdjusting())
            app.setLevel(list.getSelectedIndex());
    }
    
    public void itemStateChanged(ItemEvent e)
    {
        app.setLevel(cb.getSelectedIndex());
    }
    
    public void actionPerformed(ActionEvent e)
    {
        switch (e.getActionCommand()) 
        {
            case "Save":
                app.save();
                app.saveVect();
                break;
            case "Load":
                app.load();
                break;
            case "GO":
                app.play();
                break;
            case "Reset":
                app.initialize();
                break;
            default:
                break;
        }
    }
    
    public static void main(String[] args) throws Exception 
    {
        Builder b = new Builder();
    }
}
