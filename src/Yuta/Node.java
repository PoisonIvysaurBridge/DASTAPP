package LOGIC;
/**
 *
 * @author Yuta 11512709
 */
public class Node {
    
    private int x, y;
    //private boolean hasVisited;
    
    public Node(int x, int y){
        this.x = x;
        this.y = y;
    }
    
    public int getX(){return this.x;}
    public int getY(){return this.y;}
    //public void setHasVisited(boolean b){this.hasVisited = b;}
    //public boolean getIsIntersect(){return this.hasVisited;}
    
    @Override
    public boolean equals(Object o){
        if(o instanceof Node){
            Node node = (Node) o;
            if(this.x == node.x && this.y == node.y){
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
        return "(x, y) = (" + x + ", " + y + ")";
    }
    
}
