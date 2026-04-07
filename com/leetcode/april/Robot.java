package com.com.leetcode.april;

import java.util.ArrayList;
import java.util.List;

public class Robot {
    int idx = 0;
    boolean moved = false;
    private List<int[]> position;
    public Robot(int width, int height) {
        position = new ArrayList<>();
        //left to right
        for(int x =0;x<width;x++){
            position.add(new int[]{x,0,0});
        }
        //bottom to top
        for(int y=1;y<height;y++){
            position.add(new int[]{width-1,y,1});
        }
        //right to left
        for(int x=width-2;x>=0;x--){
            position.add(new int[]{x,height-1,2});
        }
        //top to bottom
        for(int y=height-2;y>0;y--){
            position.add(new int[]{0,y,3});
        }
        position.get(0)[2] = 3;
    }
    public void step(int num) {
        moved = true;
        idx = (idx+num)%position.size();
    }

    public int[] getPos() {
        int [] pos = position.get(idx);
        return new int[]{pos[0],pos[1]};
    }

    public String getDir() {
        if(!moved) return "East";
        int dir = position.get(idx)[2];
        switch (dir) {
            case 0: return "East";
            case 1: return "North";
            case 2: return "West";
            case 3: return "South";
            default: return "";
        }
    }
}
