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

   public PathFinder(GamePanel gp) {
      this.gp = gp;
      this.node = new Node[gp.maxWorldCol][gp.maxWorldRow];
      instantiateNodes();
   }

   /**
   * Initializes the 2D array of Nodes representing the grid.
   */
   public void instantiateNodes() {
      for (int col = 0; col < gp.maxWorldCol; col++) {
         for (int row = 0; row < gp.maxWorldRow; row++) {
               node[col][row] = new Node(col, row);
         }
      }
   }  

   /**
   * Resets the state of all nodes, clearing open list, path list, and other flags.
   */
   public void resetNodes() {
      for (Node[] nodes : node) {
         for (Node n : nodes) {
               n.reset();
         }
      }

      openList.clear();
      pathList.clear();
      goalReached = false;
      step = 0;
   }

   /**
   * Sets up the start and goal nodes, initializes costs, and marks solid nodes.
   */
   public void setNodes(int startCol, int startRow, int goalCol, int goalRow) {
      resetNodes();
        
      startNode = node[startCol][startRow];
      currentNode = startNode;
      goalNode = node[goalCol][goalRow];
      openList.add(currentNode);

      for (int col = 0; col < gp.maxWorldCol; col++) {
         for (int row = 0; row < gp.maxWorldRow; row++) {
               Node currentNode = node[col][row];
               currentNode.solid = gp.tileM.tile[gp.tileM.mapTileNum[gp.currentMap][col][row]].collision;
               getCost(currentNode);
         }
      }
   }

    /**
     * Calculates and sets the g, h, and f costs for a given node.
     */
    public void getCost(Node node) {
        int xDistance = Math.abs(node.col - startNode.col);
        int yDistance = Math.abs(node.row - startNode.row);

        node.gCost = xDistance + yDistance;

        xDistance = Math.abs(node.col - goalNode.col);
        yDistance = Math.abs(node.row - goalNode.row);
        node.hCost = xDistance + yDistance;

        node.fCost = node.gCost + node.hCost;
    }

    /**
     * Executes the A* search algorithm until the goal is reached or a limit is reached.
     *
     * @return true if the goal is reached, false otherwise.
     */
    public boolean search() {
        while (!goalReached && step < 500) {
            currentNode.checked = true;
            openList.remove(currentNode);

            openAdjacentNodes(currentNode.col, currentNode.row);

            if (openList.isEmpty()) {
                break;
            }

            currentNode = findBestNode();
            if (currentNode == goalNode) {
                goalReached = true;
                trackThePath();
            }

            step++;
        }

        return goalReached;
    }

    /**
     * Opens adjacent nodes for the given coordinates.
     */
    private void openAdjacentNodes(int col, int row) {
        openNodeIfExists(col, row - 1);
        openNodeIfExists(col - 1, row);
        openNodeIfExists(col, row + 1);
        openNodeIfExists(col + 1, row);
    }

    /**
     * Opens a node if it exists and is not solid or checked.
     */
    private void openNodeIfExists(int col, int row) {
        if (isValidCoordinate(col, row)) {
            openNode(node[col][row]);
        }
    }

    /**
     * Checks if a coordinate is within the bounds of the grid.
     */
    private boolean isValidCoordinate(int col, int row) {
        return col >= 0 && col < gp.maxWorldCol && row >= 0 && row < gp.maxWorldRow;
    }

/**
 * Finds the node with the best fCost from the open list.
 *
 * @return The node with the best fCost.
 */
   private Node findBestNode() {
      Node bestNode = null;
      int bestNodefCost = Integer.MAX_VALUE;

      for (Node currentNode : openList) {
         if (currentNode.fCost < bestNodefCost) {
            bestNode = currentNode;
            bestNodefCost = currentNode.fCost;
         } else if (currentNode.fCost == bestNodefCost && currentNode.gCost < bestNode.gCost) {
            bestNode = currentNode;
         }
      }

   return bestNode;
}

/**
 * Opens a node if it is not open, checked, or solid.
 */
   public void openNode(Node node) {
      if (!node.open && !node.checked && !node.solid) {
         node.open = true;
         node.parent = currentNode;
         openList.add(node);
      }
   }

/**
 * Traces the path from the goal node back to the start node and populates the path list.
 */
public void trackThePath() {
   Node current = goalNode;

   while (current != startNode) {
       pathList.add(0, current);
       current = current.parent;
   }
}
}
