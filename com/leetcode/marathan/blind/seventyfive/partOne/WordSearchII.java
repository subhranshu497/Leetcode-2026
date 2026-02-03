package com.com.leetcode.marathan.blind.seventyfive.partOne;

import java.util.ArrayList;
import java.util.List;

public class WordSearchII {
    private static int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) {
        char[][] board = {{'o', 'a', 'a', 'n'}, {'e', 't', 'a', 'e'}, {'i', 'h', 'k', 'r'}, {'i', 'f', 'l', 'v'}};
        String[] words = {"oath", "pea", "eat", "rain"};
        List<String> res = findWords(board, words);
        System.out.println(res);
    }

    private static List<String> findWords(char[][] board, String[] words) {
        Trie2 root = new Trie2();
        Trie2 crawler = root;
        int m = board.length;
        int n = board[0].length;
        boolean [][] visited = new boolean[m][n];
        //step 1- traverse the words and build the trie
        for(String word:words){
            insertAndBuildTrie(root, word);
        }
        List<String> res = new ArrayList<>();
        //dfs the board and find the word
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                char ch = board[i][j];
                int idx = ch-'a';
                if(crawler.children[idx] != null){
                    //cal the dfs
                    dfs(board, i,j,m,n,crawler, res,visited );
                }
            }
        }
        return res;
    }

    private static void dfs(char[][] board, int i, int j, int m, int n, Trie2 crawler, List<String> res, boolean[][] visited) {
        //oob
        if(i<0 || i>=m || j<0 || j>=n || visited[i][j])return;
        char currCh = board[i][j];
        int idx = currCh-'a';
        if(crawler.children[idx]==null) return;
        crawler = crawler.children[idx];
        if(crawler.endOfWord){
            res.add(crawler.word);
            crawler.endOfWord = false;
        }
        //start backtracking
        visited[i][j] = true;
        for(int [] direction:directions){
            int i_ = i+direction[0];
            int j_ = j+direction[1];
            dfs(board, i_,j_,m,n,crawler, res,visited);
        }
        visited[i][j]= false;
    }

    private static void insertAndBuildTrie(Trie2 root, String word) {
        Trie2 crawler = root;
        for(char ch:word.toCharArray()){
            int i = ch-'a';
            if(crawler.children[i]==null){
                crawler.children[i] = new Trie2();
            }
            crawler = crawler.children[i];
        }
        crawler.endOfWord=true;
        crawler.word = word;
    }
}
class Trie2{
    Trie2[] children = new Trie2[26];
    String word;
    boolean endOfWord= false;
}

//this is backtrackig , but gave TLE so optimizing the solution with the help of TRIE
//    private static List<String> findWords(char[][] board, String[] words) {
//        int m=board.length;
//        int n = board[0].length;
//        boolean [][] visited = new boolean[m][n];
//        List<String> list = new ArrayList<>();
//       for(String word:words){
//           boolean flag = false;
//           for(int i=0;i<m;i++){
//               for(int j=0;j<n;j++){
//                   if(board[i][j]==word.charAt(0)){
//                       if(wordSearchIIDFS(board, visited, word, i,j,0,m,n)){
//                           flag = true;
//                           break;
//                       }
//                   }
//               }if(flag){
//                   list.add(word);
//                   break;
//               }
//           }
//       }
//       return list;
//    }
//
//    private static boolean wordSearchIIDFS(char[][] board, boolean[][] visited, String word, int i, int j, int wordIdx, int m, int n) {
//        //check out of index
//        if(wordIdx>word.length()|| wordIdx <0)return false;
//        if(i<0 || i>=m || j<0 || j>=n || visited[i][j]) return false;
//        if(board[i][j] != word.charAt(wordIdx))return false;
//        if(wordIdx==word.length()-1) return true;
//        //backtrack starts - do
//        visited[i][j] = true;
//        //explore
//        for(int [] direction:directions){
//            int i_ = i+direction[0];
//            int j_ = j+direction[1];
//           if(wordSearchIIDFS(board, visited, word,i_,j_,wordIdx+1,m,n)){
//               visited[i][j] = false;
//               return true;
//           }
//        }
//        visited[i][j] = false;
//        return false;
//    }

