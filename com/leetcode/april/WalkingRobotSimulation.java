package com.com.leetcode.april;

import java.util.HashSet;
import java.util.Set;

public class WalkingRobotSimulation {
    public static void main(String[] args) {
        int [] commands = {4,-1,4,-2,4};
        int [][] obstacles = {{2,4}};
        int dist = robotSim(commands, obstacles);
        System.out.println(dist);
    }

    private static int robotSim(int[] commands, int[][] obstacles) {
        //step1: prepare the obstacles set
        Set<String> set = new HashSet<>();
        for(int [] obstacle : obstacles){
            set.add(obstacle[0]+"_"+obstacle[1]);
        }
        //step2: prepare the directions
        //as mentioned int the problem robot is pointing to north at start , so
        int[] direction={0,1};
        int x=0, y=0;
        int maxDist = 0;
        //step 3 - iterate the commands and move the robot
        for(int cmd:commands){
            if(cmd==-2){ // move right
               direction = new int[]{-direction[1], direction[0]};
            }else if(cmd==-1) { // move left
                direction = new int[]{direction[1], -direction[0]};
            }else{
                for(int step=0;step<cmd; step++){
                    int nextX = x+direction[0];
                    int nextY = y+direction[1];
                    if(set.contains(nextX+"_"+nextY)){
                        break;
                    }else{
                        x=nextX;
                        y=nextY;
                        maxDist = Math.max(maxDist, x*x+y*y);
                    }
                }
            }
        }
        return maxDist;
    }
}
