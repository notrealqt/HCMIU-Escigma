package AI;

import java.util.ArrayList;

import main.GamePanel;

public class PathFinder {
    GamePanel gp;
    Node[][] node;
    ArrayList<Node> openList = new ArrayList<>();
    public ArrayList<Node> pathList = new ArrayList<>();

    Node startNode, goalNode, currentNode;

    boolean goalReached = false;
    int step = 0;

    public PathFinder (GamePanel gp) {
        this.gp = gp
    }
    public void instantiateNodes() {
        node = new Node[gp.maxScreenCol][gp.maxWorldRow];

        int col = 0;
        int row = 0;

        while (col < gp.maxWorldCol && row < gp.maxWorldRow) {
            node[col][row ] = new Node(col,row);
            col++;
            if (col == gp.maxWorldCol) {
                col = 0;
                row++;
            }
        }
    }

    public void resetNode () {
        int col = 0;
        int row = 0;

        while (col < gp.maxWorldCol && row < gp.maxWorldRow) {
            //reset all state
            node[col][row].open = false;
            node[col][row].checked = false;
            node[col][row].solid = false;
            col++;

            if (col == gp.maxWorldCol) {
                col = 0;
                row++;
            }
        }

        openList.clear();
        pathList.clear();
        goalReached = false;
        step = 0;
    }

    public void setNodes(int startCol, int startRow, int goalCol, int goalRow) {
        resetNode();

        //set start and goal node

        startNode = node[startCol][startRow];
        currentNode = startNode;
        goalNode = node[goalCol][goalRow];
        openList.add(currentNode);
        int col = 0;
        int row = 0;
        while (col < gp.maxWorldCol && row < gp.maxWorldRow) {
            //solid node
            //check tile
            //int tileNum = gp.tileM;
        }
 
    }
}
