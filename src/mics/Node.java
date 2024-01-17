package mics;

public class Node {
    Node parent;
    public int col;
    public int row;
    int gCost;
    int hCost;
    int fCost;
    boolean solid;
    boolean open;
    boolean checked;


    public Node (int col, int row) {
        this.col = col;
        this.row = row;
    
    }
    public void reset() {
        open = false;
        checked = false;
        solid = false;
        parent = null;
        gCost = 0;
        hCost = 0;
        fCost = 0;
    }
    
}
