package lab11.graphs;
import edu.princeton.cs.algs4.Stack;

/**
 *  @author Josh Hug
 */
public class MazeCycles extends MazeExplorer {
    /* Inherits public fields:
    public int[] distTo;
    public int[] edgeTo;
    public boolean[] marked;
    */
    private boolean cycleFound = false;

    public MazeCycles(Maze m) {
        super(m);
    }

    @Override
    public void solve() {
        int s = maze.xyTo1D(1,1);
        distTo[s] = 0;
        findcycle(s);
    }

    // Helper methods go here
    public void findcycle(int v){ //stack + dfs
        Stack path = new Stack();

        path.push(v);
        marked[v] = true;
        announce();

        while (!path.isEmpty()) {
            int visited = (int)path.pop();
            for (int w : maze.adj(visited)) {
                edgeTo[w] = visited;
                announce();
                if (marked[w]) {
                    if (w != edgeTo[visited]) {
                        cycleFound = true;
                        return;
                    }
                } else {
                    distTo[w] = distTo[visited] + 1;
                    findcycle(w);
                    if (cycleFound) {
                        return;
                    }
                }
            }
        }



    }
}

