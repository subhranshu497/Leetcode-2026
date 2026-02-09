package com.com.leetcode.marathan.blind.seventyfive.parttwo;

import java.util.LinkedList;
import java.util.Queue;

public class DotaTwoSenate {
    public static void main(String[] args) {
        String senate = "RDD";
        String winner = predictPartyVictory(senate);
        System.out.println(winner);
    }

    private static String predictPartyVictory(String senate) {
        int n = senate.length();
        Queue<Integer> rq= new LinkedList<>();
        Queue<Integer> dq = new LinkedList<>();
        for(int i=0;i<n;i++){
            if(senate.charAt(i)=='D')dq.add(i);
            else rq.add(i);
        }
        //now start polling
        //the q which remain filled at the end , will be the winner
        while(!dq.isEmpty() && !rq.isEmpty()){
            int r_idx = rq.poll();
            int d_idx = dq.poll();
            if(r_idx < d_idx)rq.add(r_idx+n);
            else dq.add(d_idx+n);
        }
        return rq.isEmpty()?"Dire":"Radiant";
    }

//    private static String predictPartyVictory(String senate) {
//        //first calculate the r and d count
//        int r_count =0;
//        int d_count =0;
//        int n = senate.length();
//        for(char ch:senate.toCharArray()){
//            if(ch=='R') r_count++;
//            else d_count++;
//        }
//        //start the traversal and find the candidate for deletion
//        int i=0;
//        boolean [] removed = new boolean[senate.length()];
//        while (r_count>0 && d_count >0) {
//            if(i>=n) i=i%n;
//            if (!removed[i]) {
//                char currSenetor = senate.charAt(i);
//                //check for R removal
//                if(currSenetor=='D'){
//                    removeSenetor(senate,currSenetor, n,i+1,removed);
//                    r_count--;
//                }else{
//                    removeSenetor(senate,currSenetor, n,i+1,removed);
//                    d_count--;
//                }
//            }
//            i++;
//        }
//        return r_count==0?"Dire":"Radiant";
//    }
//
//    private static void removeSenetor(String senate, char currentSenetor, int n, int i, boolean[] removed) {
//
//        while(true){
//            //check for circular array
//            if(i>=n) i=i%n;
//            if(!removed[i] && senate.charAt(i) !=currentSenetor){
//                removed[i]=true;
//                break;
//            }
//            i++;
//        }
//    }
}
