package com.com.leetcode.may;

public class LongestCommonSuffixQueries {
    public static void main(String[] args) {
        String [] wordContainer = {"abcd","bcd","xbcd"};
        String []wordsQuery = {"cd","bcd","xyz"};
        int [] result = longestCommonSuffixQueries(wordContainer, wordsQuery);
        for(int i:result){
            System.out.print(i+" ");
        }
    }

    private static int[] longestCommonSuffixQueries(String[] wordContainer, String[] wordsQuery) {
        TrieNode root = new TrieNode();

        // Step 1: build the trie inserting each word reversed.
        // At every node along the path, keep the best word index
        // (shortest word; on tie, lowest index wins).
        for (int i = 0; i < wordContainer.length; i++) {
            String word = wordContainer[i];
            TrieNode crawler = root;
            // Update root: it must cover the "0-suffix" (whole-container) fallback
            if (root.idx == -1 || wordContainer[i].length() < wordContainer[root.idx].length()) {
                root.idx = i;
            }
            for (int j = word.length() - 1; j >= 0; j--) {
                char c = word.charAt(j);
                int childIdx = c - 'a';
                if (crawler.children[childIdx] == null) {
                    crawler.children[childIdx] = new TrieNode();
                }
                crawler = crawler.children[childIdx];
                if (crawler.idx == -1 || wordContainer[i].length() < wordContainer[crawler.idx].length()) {
                    crawler.idx = i;
                }
            }
        }

        // Step 2: for each query, traverse reversed query as deep as possible;
        // the deepest reachable node already holds the best-matching word index.
        int[] result = new int[wordsQuery.length];
        for (int i = 0; i < wordsQuery.length; i++) {
            String query = wordsQuery[i];
            TrieNode crawler = root;
            result[i] = root.idx; // fallback: shortest word in container
            for (int j = query.length() - 1; j >= 0; j--) {
                char c = query.charAt(j);
                int childIdx = c - 'a';
                if (crawler.children[childIdx] == null) break;
                crawler = crawler.children[childIdx];
                result[i] = crawler.idx; // longer suffix match found
            }
        }
        return result;
    }

    static class TrieNode{
        TrieNode [] children;
        int idx;
        public TrieNode(){
            children = new TrieNode[26];
            idx = -1;
        }
    }


//    private static int[] longestCommonSuffixQueries(String[] wordContainer, String[] wordsQuery) {
//        int containerLength = wordContainer.length;
//        int queryLength = wordsQuery.length;
//        int [] result = new int[queryLength];
//        //find the idx of smallest string in the container
//        int minLength = Integer.MAX_VALUE;
//        int smallestIdx = -1;
//        for(int i=0;i<containerLength;i++){
//            if(wordContainer[i].length() < minLength){
//                minLength = wordContainer[i].length();
//                smallestIdx = i;
//            }
//        }
//        //find the longest common suffix for each query with the smallest string in the container
//        for(int i=0;i<queryLength;i++){
//            String query = wordsQuery[i];
//            int len = -1;
//            int idx =smallestIdx;
//            for(int j=0;j<containerLength;j++){
//                String word = wordContainer[j];
//                //find the longest common suffix between query and word
//                    int k = word.length()-1;
//                    int m = query.length()-1;
//                    while(k>=0 && m>=0 && word.charAt(k) == query.charAt(m)){
//                        k--;
//                        m--;
//                    }
//                     int commonSuffixLen = word.length()-1-k;
//                    if(commonSuffixLen > len){
//                         len = commonSuffixLen;
//                         idx = j;
//                     }else if(commonSuffixLen == len) {
//                            if(wordContainer[idx].length() > word.length()){
//                                idx = j;
//                            }
//                        }
//
//            }
//            result[i] = idx;
//        }
//        return result;
//    }
}
