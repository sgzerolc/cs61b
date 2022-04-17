package lab11.graphs;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 *  @author Josh Hug
 */
public class MazeAStarPath extends MazeExplorer {
    private int s;
    private int t;
    private boolean targetFound = false;
    private Maze maze;
    private int distance;

    public MazeAStarPath(Maze m, int sourceX, int sourceY, int targetX, int targetY) {
        super(m);
        maze = m;
        distance = Math.abs(sourceX - targetX) + Math.abs(sourceY - targetY);
        s = maze.xyTo1D(sourceX, sourceY);
        t = maze.xyTo1D(targetX, targetY);
        distTo[s] = 0;
        edgeTo[s] = s;
    }

    /** Estimate of the distance from v to the target. */
    private int h(int visited) {
        return distance;
    }

    /** Finds vertex estimated to be closest to target. */
    private int findMinimumUnmarked() {
        return -1;
        /* You do not have to use this method. */
    }

    /** Performs an A star search from vertex s. */
    private void astar(int s) {
        Queue path = new PriorityQueue();
        path.add(s);
        marked[s] = true;
        announce();

        while (!path.isEmpty()) {
            int visted = (int)path.poll();
            for (int w: maze.adj(visted)) {
                if (!marked[w]) {
                    edgeTo[w] = visted;
                    announce();
                    distTo[w] = distTo[visted] + h(visted);
                    marked[w] = true;
                    announce();
                    path.add(w);
                    if (w == t) {
                        targetFound = true;
                        return;
                    }
                }
            }

        }

    }

    @Override
    public void solve() {
        astar(s);
    }

}

