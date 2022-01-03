package com.hibernaut.katas.rank_4kyu;

/**
 * Task
 *
 * You are at position [0, 0] in maze NxN and you can only move in one of the four cardinal directions
 * (i.e. North, East, South, West). Return the minimal number of steps to exit position [N-1, N-1]
 * if it is possible to reach the exit from the starting position. Otherwise, return -1.
 *
 * Empty positions are marked .. Walls are marked W. Start and exit positions are guaranteed to be empty
 * in all test cases.
 */

public class PathFinder {
    private final static int INF = Integer.MAX_VALUE;
    private static int[][] graph;

    public static int pathFinder(String maze) {
        fillGraph(maze);
        moveTo(0, 0, 0);

        if(graph[graph.length -1][graph.length - 1] == INF) {
            return -1;
        }

        return graph[graph.length -1][graph.length - 1];
    }

    private static void fillGraph(String maze) {
        String[] linesArray = maze.split("\n");
        graph = new int[linesArray.length][linesArray.length];

        for (int y = 0; y < linesArray.length; y++) {
            for (int x = 0; x < linesArray.length; x++) {
                if(linesArray[y].charAt(x) == 'W') {
                    graph[y][x] = -1;
                } else {
                    graph[y][x] = INF;
                }
            }
        }
    }

    private static void moveTo(int y, int x, int step) {
        if(x == -1 || y == -1 || x == graph.length || y == graph.length || graph[y][x] <= step) {
            return;
        }

        graph[y][x] = step;
        moveTo(y, x - 1, step + 1);
        moveTo(y, x + 1, step + 1);
        moveTo(y + 1, x, step + 1);
        moveTo(y - 1, x, step + 1);
    }
}
