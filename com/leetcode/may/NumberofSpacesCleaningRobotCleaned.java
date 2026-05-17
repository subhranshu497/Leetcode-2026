package com.com.leetcode.may;

public class NumberofSpacesCleaningRobotCleaned {
    public static void main(String[] args) {
        int [][] room = {{0,0,0},{1,1,0},{0,0,0}};
        int cleanedRooms = numberOfCleanRooms(room);
        System.out.println(cleanedRooms);
    }

    private static int numberOfCleanRooms(int[][] room) {
        int m = room.length;
        int n = room[0].length;
        // Index 0=Right, 1=Down, 2=Left, 3=Up
        boolean [][][] visitedWithDir = new boolean[m][n][4];
        return cleanRoomDfs(room,visitedWithDir, 0,0,m,n,true, false, false, false);
    }

    private static int cleanRoomDfs(int[][] room,boolean [][][] visitedWithDir, int i, int j, int m, int n, boolean isRight, boolean isDown, boolean isLeft, boolean isUp) {
        //check for vistied room in direction
        int idx = isRight?0:(isDown?1:(isLeft?2:3));
        if(visitedWithDir[i][j][idx])return 0;
        int count =0;
        if(!visitedWithDir[i][j][0] &&!visitedWithDir[i][j][1] &&!visitedWithDir[i][j][2] &&!visitedWithDir[i][j][3]){
            visitedWithDir[i][j][idx] = true;
            count =1;
        }

        //move right
        if(isRight){
            if(j+1 <n && room[i][j+1]==0){
                return count + cleanRoomDfs(room,visitedWithDir,i,j+1,m,n,true,false,false,false);
            }else {
                //path is blocked move down
                return count + cleanRoomDfs(room,visitedWithDir,i,j,m,n,false,true,false,false);
            }
        }else if(isDown){
            if (i + 1 < m && room[i + 1][j] == 0) {
                return count + cleanRoomDfs(room,visitedWithDir,i+1,j,m,n,false,true,false,false);
            }else{
                //path blocked - move left
                return count + cleanRoomDfs(room,visitedWithDir,i,j,m,n,false,false,true,false);
            }
        }else if(isLeft){
            if (j - 1 >=0 && room[i][j-1] == 0) {
                return count + cleanRoomDfs(room,visitedWithDir,i,j-1,m,n,false,false,true,false);
            }else{
                //path blocked move up
                return count + cleanRoomDfs(room,visitedWithDir,i,j,m,n,false,false,false,true);
            }
        }else if(isUp){
            if (i - 1 >= 0 && room[i - 1][j] == 0) {
                return count + cleanRoomDfs(room,visitedWithDir,i-1,j,m,n,false,false,false,true);
            }else return count + cleanRoomDfs(room,visitedWithDir,i,j,m,n,true,false,false,false);
        }
        return count;
    }
}
