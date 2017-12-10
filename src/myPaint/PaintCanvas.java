package myPaint;
/*
 * Decompiled with CFR 0_118.
 */
//package dastapp.labactivity;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.LayoutManager;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class PaintCanvas {
    private JFrame frame = new JFrame();
    private MPanel panel;
    private int cellX;
    private int cellY;

    public PaintCanvas() {
        this.frame.setSize(600, 480);
        this.frame.setLocationRelativeTo(null);
        this.frame.setLayout(null);
        this.frame.setTitle("Paint");
        this.frame.setResizable(false);
        this.frame.setDefaultCloseOperation(3);
        this.panel = new MPanel();
        this.panel.setLayout(null);
        this.panel.setSize(this.frame.getWidth(), this.frame.getHeight());
        this.frame.add(this.panel);
        this.frame.setVisible(true);
    }

    public void leftMousePressed() {
    }

    public int getCellRow() {
        return this.cellY;
    }

    public int getCellColumn() {
        return this.cellX;
    }

    public void setBlack(int row, int column) {
        this.panel.setColor(row, column, Color.BLACK);
    }

    public void setRed(int row, int column) {
        this.panel.setColor(row, column, Color.RED);
    }

    public void rightMouseClicked() {
    }

    public int getColor(int row, int column) {
        Color x = this.panel.getColor(row, column);
        if (x == null) {
            return 0;
        }
        if (x.equals(Color.BLACK)) {
            return 1;
        }
        return 2;
    }

    static /* synthetic */ void access$0(PaintCanvas paintCanvas, int n) {
        paintCanvas.cellX = n;
    }

    static /* synthetic */ void access$1(PaintCanvas paintCanvas, int n) {
        paintCanvas.cellY = n;
    }

    private class MPanel extends JPanel implements MouseListener, MouseMotionListener {
        private final int SIZE = 5;
        private boolean leftPressed;
        private Color[][] colors;

        public MPanel() {
            //this.SIZE = 5;
            this.leftPressed = false;
            this.colors = new Color[96][120];
            this.addMouseListener(this);
            this.addMouseMotionListener(this);
        }

        public void paint(Graphics g) {
            this.drawBackground(g);
            this.drawColors(g);
            this.drawGrid(g);
        }

        public void drawBackground(Graphics g) {
            g.setColor(Color.WHITE);
            g.fillRect(0, 0, this.getWidth(), this.getHeight());
        }

        public void drawGrid(Graphics g) {
            g.setColor(new Color(180, 180, 180));
            int i = 0;
            while (i <= 600) {
                g.drawLine(i, 0, i, this.getHeight());
                i += 5;
            }
            i = 0;
            while (i <= 480) {
                g.drawLine(0, i, this.getWidth(), i);
                i += 5;
            }
        }

        public void drawColors(Graphics g) {
            int i = 0;
            while (i < 96) {
                int j = 0;
                while (j < 120) {
                    Color c = this.colors[i][j];
                    if (c != null) {
                        g.setColor(c);
                    } else {
                        g.setColor(Color.WHITE);
                    }
                    g.fillRect(j * 5, i * 5, 5, 5);
                    ++j;
                }
                ++i;
            }
        }

        public void mouseClicked(MouseEvent e) {
            PaintCanvas.access$0(PaintCanvas.this, e.getX() / 5);
            PaintCanvas.access$1(PaintCanvas.this, e.getY() / 5);
            if (e.getButton() == 3) {
                PaintCanvas.this.rightMouseClicked();
            }
        }

        public void setColor(int row, int column, Color color) {
            this.colors[row][column] = color;
            this.repaint();
        }

        public void mousePressed(MouseEvent e) {
            PaintCanvas.access$0(PaintCanvas.this, e.getX() / 5);
            PaintCanvas.access$1(PaintCanvas.this, e.getY() / 5);
            if (e.getButton() == 1) {
                this.leftPressed = true;
                PaintCanvas.this.leftMousePressed();
            }
        }

        public void mouseReleased(MouseEvent e) {
            if (e.getButton() == 1) {
                this.leftPressed = false;
            }
        }

        public void mouseEntered(MouseEvent e) {
        }

        public void mouseExited(MouseEvent e) {
        }

        public void mouseDragged(MouseEvent e) {
            PaintCanvas.access$0(PaintCanvas.this, e.getX() / 5);
            PaintCanvas.access$1(PaintCanvas.this, e.getY() / 5);
            if (this.leftPressed) {
                PaintCanvas.this.leftMousePressed();
            }
        }

        public void mouseMoved(MouseEvent e) {
        }

        public Color getColor(int row, int column) {
            return this.colors[row][column];
        }
    }

}

