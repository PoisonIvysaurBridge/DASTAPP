package myPaint;

import dastapp.labactivity.PaintCanvas;
//import LOGIC.Stack;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.Timer;
public class MyGraph extends PaintCanvas implements ActionListener {
    
    public static final int ROW = 91;
    public static final int COL = 119;
    public static final int WHITE = 0;
    public static final int BLACK = 1;
    public static final int RED = 2;
    public final static int NORTH = 10;
    public final static int SOUTH = 20;
    public final static int EAST = 30;
    public final static int WEST = 40;
    private Stack myStack;
    private Node curNode;
    private ArrayList<Node> visitedNodes;
    private Timer t;
    
    public MyGraph(){
        this.myStack = new Stack();
        this.visitedNodes = new ArrayList<>();
        this.t = new Timer(1, this);
    }
    
    @Override
    public void leftMousePressed(){
        if(ok()){
            int row = this.getCellRow();
            int col = this.getCellColumn();
            if(getColor(row, col) == 0){
                this.setBlack(row, col);
            }
            if(getColor(row, col) == 2){
                this.setBlack(row, col);
            }
        }
    }
    
    @Override
    public void rightMouseClicked(){
        if(ok()){
            curNode = new Node(getCellRow(), getCellColumn());
            
            int row = this.getCellRow();
            int col = this.getCellColumn();
            
            if(getColor(row, col) == WHITE){
                this.setRed(row, col);
                t.start();
                //solveCanvas();
            }
        }
    }
    
    public void solveCanvas(){
        if(isPath(curNode, NORTH) && !hasPassed(new Node(curNode.getRow() - 1, curNode.getCol()))){
            myStack.push(new Node(curNode.getRow(), curNode.getCol()));
            visitedNodes.add(new Node(curNode.getRow(), curNode.getCol()));
            curNode = new Node(curNode.getRow() - 1, curNode.getCol());
            this.setRed(curNode.getRow(), curNode.getCol());
            //System.out.println("NORTH OPEN");
        }//if
        else if(isPath(curNode, SOUTH)){
            myStack.push(new Node(curNode.getRow(), curNode.getCol()));
            visitedNodes.add(new Node(curNode.getRow(), curNode.getCol()));
            curNode = new Node(curNode.getRow() + 1, curNode.getCol());
            this.setRed(curNode.getRow(), curNode.getCol());
            //System.out.println("SOUTH OPEN");
        }//eles if
        else if(isPath(curNode, EAST)){
            myStack.push(new Node(curNode.getRow(), curNode.getCol()));
            visitedNodes.add(new Node(curNode.getRow(), curNode.getCol()));
            curNode = new Node(curNode.getRow(), curNode.getCol() + 1);
            this.setRed(curNode.getRow(), curNode.getCol());
            //System.out.println("EAST OPEN");
        }//else if
        else if(isPath(curNode, WEST)){
            myStack.push(new Node(curNode.getRow(), curNode.getCol()));
            visitedNodes.add(new Node(curNode.getRow(), curNode.getCol()));
            curNode = new Node(curNode.getRow(), curNode.getCol() - 1);
            this.setRed(curNode.getRow(), curNode.getCol());
            //System.out.println("WEST OPEN");
        }//else if
        else{
            visitedNodes.add(new Node(curNode.getRow(), curNode.getCol()));
            
            if(myStack.isEmpty()){
                t.stop();
            }
            else{
                stepBack((Node)myStack.pop());
            }
        }
        
    }
    
    public void stepBack(Node node){
        if(curNode.getRow() == node.getRow() - 1 && curNode.getCol() == node.getCol())
            curNode = node;
        if(curNode.getRow() == node.getRow() + 1 && curNode.getCol() == node.getCol())
            curNode = node;
        if(curNode.getRow() == node.getRow() && curNode.getCol() == node.getCol() + 1)
            curNode = node;
        if(curNode.getRow() == node.getRow() && curNode.getCol() == node.getCol() - 1)
            curNode = node;
    }
    
    public boolean isPath(Node curNode, int direction){
        
        switch(direction){
            case NORTH:
                if(curNode.getRow() > 0){
                    if(getColor(curNode.getRow() - 1, curNode.getCol()) == WHITE){
                        //System.out.println("NORTH PASS");
                        return true;
                    }//if
                }//if
                else
                    return false;
                break;
                
            case SOUTH:
                if(curNode.getRow() < ROW - 1){
                    if(getColor(curNode.getRow() + 1, curNode.getCol()) == WHITE){
                        //System.out.println("SOUTH PASS");
                        return true;
                    }//if
                }//if
                break;
                
            case EAST:
                if(curNode.getCol() < COL - 1){
                    if(getColor(curNode.getRow(), curNode.getCol() + 1) == WHITE){
                        //System.out.println("EAST PASS");
                        return true;
                    }
                }
                else
                    break;
                break;
                
            case WEST:
                if(curNode.getCol() > 0){
                    if(getColor(curNode.getRow(), curNode.getCol() - 1) == WHITE){
                        //System.out.println("WEST PASS");
                        return true;
                    }
                }
                else
                    break;
                break;
        }
        
        return false;
    }
    
    public boolean hasPassed(Node check){
        if(visitedNodes.isEmpty()){
            //System.out.println("Empty");
            return false;
        }
        else{
            for(Node n : visitedNodes){
                if(check.equals(n)){
                    //System.out.println("Found Node");
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean ok(){
        int x = getCellRow();
        int y = getCellColumn();
        return x >= 0 && x < ROW && y >= 0 && y < COL;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        solveCanvas();
    }
    
    public static void main(String[] args) {
        new MyGraph();
    }
    
}

class Node{
    
    private int row, col;
    
    public Node(int row, int col){
        this.row = row;
        this.col = col;
    }
    
    public int getRow(){return this.row;}
    public int getCol(){return this.col;}
    
    @Override
    public boolean equals(Object o){
        if(o instanceof Node){
            Node node = (Node) o;
            if(this.row == node.row && this.col == node.col){
                return true;
            }
        }
        else{
            return false;
        }
        return false;
    }
    
    @Override
    public String toString(){
        return "ROW: " + row + "\nCOL: " + col;
    }
    
    
}
