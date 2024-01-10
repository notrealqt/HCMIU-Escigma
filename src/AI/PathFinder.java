package AI;

import java.util.ArrayList;

import entity.Entity;
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
        this.node = new Node[this.gp.maxWorldCol][this.gp.maxWorldRow];
        int col = 0;
        int row = 0;
  
        while(col < this.gp.maxWorldCol && row < this.gp.maxWorldRow) {
           this.node[col][row] = new Node(col, row);
           ++col;
           if (col == this.gp.maxWorldCol) {
              col = 0;
              ++row;
           }
        }
  
     }

    public void resetNodes() {
        int col = 0;
        int row = 0;

        while(col < this.gp.maxWorldCol && row < this.gp.maxWorldRow) {
            this.node[col][row].open = false;
            this.node[col][row].checked = false;
            this.node[col][row].solid = false;
            ++col;
            if (col == this.gp.maxWorldCol) {
                col = 0;
                ++row;
            }
        }

        this.openList.clear();
        this.pathList.clear();
        this.goalReached = false;
        this.step = 0;
    }

    public void setNodes(int startCol, int startRow, int goalCol, int goalRow) {
        this.resetNodes();
        this.startNode = this.node[startCol][startRow];
        this.currentNode = this.startNode;
        this.goalNode = this.node[goalCol][goalRow];
        this.openList.add(this.currentNode);
        int col = 0;
        int row = 0;
  
        int i;
        while(col < this.gp.maxWorldCol && row < this.gp.maxWorldRow) {
           i = this.gp.tileM.mapTileNum[this.gp.currentMap][col][row];
           if (this.gp.tileM.tile[i].collision) {
              this.node[col][row].solid = true;
           }
  
           this.getCost(this.node[col][row]);
           ++col;
           if (col == this.gp.maxWorldCol) {
              col = 0;
              ++row;
           }
        }
   
    }

    public void getCost(Node node) {
        int xDistance = Math.abs(node.col - this.startNode.col);
        int yDistance = Math.abs(node.row - this.startNode.row);
        node.gCost = xDistance + yDistance;
        xDistance = Math.abs(node.col - this.goalNode.col);
        yDistance = Math.abs(node.row - this.goalNode.row);
        node.hCost = xDistance + yDistance;
        node.fCost = node.gCost + node.hCost;
    }

    public boolean search() {
        while (goalReached == false && step < 500) {
            int col = currentNode.col;
            int row = currentNode.row;

            //check current node
            currentNode.checked = true;
            openList.remove(currentNode);

            //open Up node
            if (row -1 >= 0) {
                openNode(node[col][row-1]);
            }
            //Left node
            if (col -1 >= 0) {
                openNode(node[col-1][row]);
            }
            //Down node
            if (row + 1 >= gp.maxWorldRow) {
                openNode(node[col][row+1]);
            }
            //right node
            if (row -1 >= gp.maxWorldCol) {
                openNode(node[col+1][row]);
            }
            //Find best node
            int bestNodeIndex = 0;
            int bestNodefCost = 999;
            for (int i = 0; i< openList.size(); i++) {
                //check if this nodes' F cost is better
                if (openList.get(i).fCost < bestNodefCost) {
                    bestNodeIndex = i;
                    bestNodefCost = openList.get(i).fCost;

                }
                //f cost is equal, check G cost
                else if (openList.get(i).fCost == bestNodefCost) {
                    if (openList.get(i).gCost < openList.get(bestNodeIndex).gCost) {
                        bestNodeIndex =i;
                    }
                }
            }
            //if no node -> end
            if (openList.size() == 0 ) {
                break;
            }
            currentNode = openList.get(bestNodeIndex);

            if (currentNode == goalNode) {
                goalReached = true;
                trackThePath();
            }
            step++;
        }
        return goalReached;
    }

    public void openNode(Node node) {
        if(node.open == false && node.checked == false && node.solid == false) {
            node.open = true;
            node.parent = currentNode;
            openList.add(node);
        }
    }

    public void trackThePath() {
        Node current = goalNode;
        while (current != startNode) {
            pathList.add(0,current);
            current = current.parent;

        }
    }
        
}

