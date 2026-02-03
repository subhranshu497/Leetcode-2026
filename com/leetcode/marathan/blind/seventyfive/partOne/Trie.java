package com.com.leetcode.marathan.blind.seventyfive.partOne;

public class Trie {

    TrieNode root;
    public Trie(){
        root = new TrieNode();
    }
    public void insert(String word){
        //first i will take a new node
        TrieNode crawl = root;
        for(char ch:word.toCharArray()){
            int idx = ch-'a';
            if(crawl.children[idx]==null){
                crawl.children[idx] = new TrieNode();
            }
            crawl = crawl.children[idx];
        }
        crawl.endOfWord= true;
    }
    public boolean search(String word) {
        TrieNode crawl = root;
        for(char ch:word.toCharArray()){
            int idx = ch-'a';
            if(crawl.children[idx] ==null)return false;
            crawl = crawl.children[idx];
        }
        return crawl.endOfWord==true;
    }
    boolean startsWith(String prefix){
        TrieNode crawl = root;
        int i=0;
        for(;i<prefix.length();i++){
            char ch = prefix.charAt(i);
            int idx = ch-'a';
            if(crawl.children[idx]==null)break;
            crawl = crawl.children[idx];
        }
        return i==prefix.length();
    }
}
class TrieNode{
    TrieNode [] children = new TrieNode[26];
    boolean endOfWord = false;

    public TrieNode(){}
}
