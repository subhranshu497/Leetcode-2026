package com.com.leetcode.march;

import java.util.*;

public class AutocompleteSystem {
    private TrieNode root;
    private StringBuilder currentInput;
    private TrieNode currentCrawler;

    public AutocompleteSystem(String[] sentences, int[] times){
        root = new TrieNode();
        currentInput = new StringBuilder();
        currentCrawler = root;

        for (int i = 0; i < sentences.length; i++) {
            insert(sentences[i], times[i]);
        }
    }
    private void insert(String sentence, int count) {
        TrieNode crawler = root;
        for(char ch:sentence.toCharArray()){
            crawler.children.putIfAbsent(ch, new TrieNode());
            crawler = crawler.children.get(ch);
            // Every node in the path stores the frequency of the full sentence
           crawler.sentenceCount.put(sentence, crawler.sentenceCount.getOrDefault(sentence,0)+count);
        }
    }
    public List<String> input(char c) {
        if(c=='#'){
            insert(currentInput.toString(),1);
            currentInput.setLength(0);
            currentCrawler = root; // reset for the next seq
            return new ArrayList<>();
        }
        currentInput.append(c);
        if(currentCrawler!=null)
            currentCrawler = currentCrawler.children.get(c);
        if(currentCrawler==null)
            return new ArrayList<>();
        //code to get last 3 entries
        //write the comparator to sort 1. higher freq 2. if tie then lexicographically
        Comparator<Map.Entry<String, Integer>> customComp = Comparator
                // 1. Sort by value descending (Higher frequency first)
                .<Map.Entry<String, Integer>, Integer>comparing(Map.Entry::getValue, Comparator.reverseOrder())
                // 2. If values are equal, sort by key ascending (Alphabetical order)
                .thenComparing(Map.Entry::getKey);
        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(customComp);
        pq.addAll(currentCrawler.sentenceCount.entrySet());
        List<String> res = new ArrayList<>();
        int i=0;
        while(i<3 && !pq.isEmpty()){
            res.add(pq.poll().getKey());
            i++;
        }
        return res;
    }

}
class TrieNode{
    //use map instead of 26 to handle spaces and any other character
    Map<Character, TrieNode> children;
    //store the sentence and the freq
    Map<String, Integer> sentenceCount;

    public TrieNode(){
        children = new HashMap<>();
        sentenceCount = new HashMap<>();
    }
}
