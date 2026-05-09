package com.com.leetcode.may;

import java.util.Arrays;

public class RobotRoomCleaner {
    //0 - right, 1 - down, 2 - left, 3 - up
    private final int[][] DIRECTIONS = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; // right, down, left, up

    public void cleanRoom(Robot robot){
    //since the max(m,n) => 200, we can use a 2D boolean array to keep track of the visited cells
        boolean[][] visited = new boolean[201][201];
        //start cleaning from the initial position (0,0) and facing right (direction index 0)
        cleanRoomDfs(robot, visited, 0,0, 3);
    }

    private void cleanRoomDfs(Robot robot, boolean[][] visited, int i, int j, int currentDirection) {
        //clean and mark visited
        robot.clean();
        visited[i][j] = true;
        //try all 4 directions
        for(int dir=0;dir<4;dir++){
            int newDirection = (currentDirection + dir) % 4; // calculate the new direction index
            int i_ = i + DIRECTIONS[newDirection][0];
            int j_ = j + DIRECTIONS[newDirection][1];
            //check i_ and j_ are within bounds of the grid
            if(i_ >= 0 && i_ < visited.length && j_ >= 0 && j_ < visited[0].length){
                //check if the next cell is not visited and can be moved to
                if(!visited[i_][j_] && robot.move()){
                    cleanRoomDfs(robot, visited, i_, j_,newDirection);
                    //backtrack to the previous cell and direction
                    goBack(robot);
                }
            }
            robot.turnRight(); //turn right to try the next direction
        }
    }

    private void goBack(Robot robot) {
        //turn 180 degree
        robot.turnLeft();
        robot.turnLeft();
        //move forward to go back to the previous cell
        robot.move();
        //turn 180 degree again to restore the original direction
        robot.turnLeft();
        robot.turnLeft();
    }
}
interface Robot {
    public boolean move();
    public void turnLeft();
    public void turnRight();
    public void clean();
}


