package LOGIC;
/**
 *
 * @author Yuta 11512709
 */
import GUI.Maze;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JFrame;
import javax.swing.Timer;
import java.util.ArrayList;
import javax.swing.JOptionPane;
public class Algorithm implements ActionListener {
    
    private Stack myStack;
    private Maze maze;
    private ArrayList <Node> visitedNodes;
    public final static int NORTH = 0;
    public final static int SOUTH = 1;
    public final static int EAST = 2;
    public final static int WEST = 3;
    private Timer t;
    
    public Algorithm(Maze maze){
        this.myStack = new Stack();
        this.maze = maze;
        this.visitedNodes = new ArrayList<>();
        this.t = new Timer(100, this);
    }
    
    public void solveMaze(Maze maze){
        Rat r = maze.findRat();
        if(isPath(maze, NORTH) && !hasPassed(new Node(r.getPosX(), r.getPosY() - 1))){
            myStack.push(new Node(r.getPosX(), r.getPosY()));
            visitedNodes.add(new Node(r.getPosX(), r.getPosY()));
            r.moveUp(maze);
        }
        
        else if(isPath(maze, SOUTH) && !hasPassed(new Node(r.getPosX(), r.getPosY() + 1))){
            myStack.push(new Node(r.getPosX(), r.getPosY()));
            visitedNodes.add(new Node(r.getPosX(), r.getPosY()));
            r.moveDown(maze);
        }
        
        else if(isPath(maze, WEST) && !hasPassed(new Node(r.getPosX() + 1, r.getPosY()))){
            myStack.push(new Node(r.getPosX(), r.getPosY()));
            visitedNodes.add(new Node(r.getPosX(), r.getPosY()));
            r.moveRight(maze);
        }
        
        else if(isPath(maze, EAST) && !hasPassed(new Node(r.getPosX() - 1, r.getPosY()))){
            myStack.push(new Node(r.getPosX(), r.getPosY()));
            visitedNodes.add(new Node(r.getPosX(), r.getPosY()));
            r.moveLeft(maze);
        }
        
        else{
            visitedNodes.add(new Node(r.getPosX(), r.getPosY()));
            
            if(myStack.isEmpty()){
                JOptionPane.showMessageDialog(null, "No PATH to GOAL", "Machine Project", JOptionPane.WARNING_MESSAGE);
                stop();
                maze.getFrame().dispose();
            }
            else{
                stepBack(maze,(Node)myStack.pop());
            }
        }
        /*
        System.out.println("Passed Nodes");
        for(Node print : visitedNodes)
            System.out.println(print);
*/
    }
    
    private void stepBack(Maze maze, Node node){
        Rat r = maze.findRat();
        if(r.getPosX() == node.getX() && r.getPosY() == node.getY() - 1){
            r.moveDown(maze);
        }
        
        if(r.getPosX() == node.getX() && r.getPosY() == node.getY() + 1){
            r.moveUp(maze);
        }
        
        if(r.getPosX() == node.getX() + 1 && r.getPosY() == node.getY()){
            r.moveLeft(maze);
        }
        
        if(r.getPosX() == node.getX() - 1 && r.getPosY() == node.getY()){
            r.moveRight(maze);
        }
    }
    
    private boolean hasPassed(Node check){
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
    
    private boolean isPath(Maze maze, int direction){
        Rat r = maze.findRat();
        Cell[][] cells = maze.getTiles();
        switch(direction){
            case NORTH://up
                if(r.getPosY() > 0){
                    if(cells[r.getPosY() - 1][r.getPosX()] instanceof Cheese){
                        r.moveUp(maze);
                        stop();
                    }
                    if (cells[r.getPosY() - 1][r.getPosX()] instanceof Tile) {
                        if (!((Tile) cells[r.getPosY() - 1][r.getPosX()]).getWall()) {
                            return true;
                        }
                        else{
                            //System.out.println("CANNOT PASS(N1)");
                            return false;
                        }
                    }
                }
                else{
                    //System.out.println("CANNOT PASS(N2)");
                    return false;
                }
                break;
                
            case SOUTH://down
                if(r.getPosY() < maze.getMap().getColums() - 1){
                    if(cells[r.getPosY() + 1][r.getPosX()] instanceof Cheese){
                        r.moveDown(maze);
                        stop();
                    }
                    if (cells[r.getPosY() + 1][r.getPosX()] instanceof  Tile) {
                        if (!((Tile) cells[r.getPosY() + 1][r.getPosX()]).getWall()) {
                            return true;
                        }
                        else{
                            //System.out.println("CANNOT PASS(S1)");
                            return false;
                        }
                    }
                }
                else{
                    //System.out.println("CANNOT PASS(S2)");
                    return false;
                }
                break;
                
            case EAST://left
                if(r.getPosX() > 0){
                    if(cells[r.getPosY()][r.getPosX() - 1] instanceof Cheese){
                        r.moveLeft(maze);
                        stop();
                    }
                    if(maze.getTiles()[r.getPosY()][r.getPosX() - 1] instanceof Tile){
                        if (!((Tile) cells[r.getPosY()][r.getPosX() - 1]).getWall()) {
                            return true;
                        }
                        else{
                            //System.out.println("CANNOT PASS(E1)");
                            return false;
                        }
                    }
                }
                else{
                   //System.out.println("CANNOT PASS(E2)");
                    return false;
                }
                break;
                
            case WEST://right
                if(r.getPosX() < maze.getMap().getRows() - 1){
                    if(cells[r.getPosY()][r.getPosX() + 1] instanceof Cheese){
                        r.moveRight(maze);
                        stop();
                    }
                    if(maze.getTiles()[r.getPosY()][r.getPosX() + 1] instanceof Tile){
                        if(!((Tile) cells[r.getPosY()][r.getPosX() + 1]).getWall()){
                            return true;
                        }
                        else{
                            //System.out.println("CANNOT PASS(W1)");
                        }
                    }
                }
                else{
                    //System.out.println("CANNOT PASS(W2)");
                    return false;
                }
                break;
        }
        return false;
    }
    
    public void start(){
        t.start();
    }
    
    public void stop(){
        t.stop();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        solveMaze(maze);
    }
    
}
