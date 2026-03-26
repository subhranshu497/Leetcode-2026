package com.com.leetcode.concept;

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }
    public void insert(String word) {
        TrieNode crawler = root;
        for(char ch:word.toCharArray()){
            int idx = ch-'a';
            if(crawler.children[idx] == null){
                crawler.children[idx] = new TrieNode();
            }
            crawler = crawler.children[idx];
        }
        crawler.endOfWord = true;
    }
    public boolean search(String word) {
        TrieNode crawler = root;
        for(char ch:word.toCharArray()){
            int idx = ch-'a';
            if(crawler.children[idx] == null) {
                return false;
            }
            crawler = crawler.children[idx];
        }
        return crawler.endOfWord==true;
    }
    public boolean startsWith(String prefix){
        TrieNode crawler = root;
        int i =0;
        int n = prefix.length();
        for(char ch:prefix.toCharArray()){
            int idx = ch-'a';
            if(crawler.children[idx]==null) break;
            crawler = crawler.children[idx];
            i++;
        }
        return i==n;
    }

}
class TrieNode{
    TrieNode[] children;
    boolean endOfWord;
    public TrieNode(){
        this.children = new TrieNode[26];
        this.endOfWord = false;
    }
}
