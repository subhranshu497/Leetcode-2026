package com.com.leetcode.marathan.blind.seventyfive.partOne;

public class DesignAddandSearchWordsDataStructure {
    Trie1 root;
    public DesignAddandSearchWordsDataStructure() {
        root = new Trie1();
    }

    public void addWord(String word) {
        Trie1 crawl = root;
        for(char ch:word.toCharArray()){
            int idx = ch-'a';
            if(crawl.children[idx]==null)
                crawl.children[idx] = new Trie1();
            crawl = crawl.children[idx];
        }
        crawl.endOfWord = true;
    }

    public boolean search(String word) {
        return searchUtil(root,word);
    }
    public boolean searchUtil(Trie1 root, String word){
        Trie1 crawl = root;
        int i=0;
        while(i<word.length()){
            char ch = word.charAt(i);
            if(ch=='.'){
                for(int j=0;j<26;j++){
                    if(crawl.children[j] !=null){
                        if(searchUtil(crawl.children[j], word.substring(i+1))) return true;
                    }
                }
                return false;
            }else if(crawl.children[ch-'a']==null) return false;
            crawl = crawl.children[ch-'a'];
            i++;
        }
        return (crawl !=null && crawl.endOfWord);
    }
}
class Trie1{
    Trie1[] children = new Trie1[26];
    boolean endOfWord = false;
    public Trie1(){}
}