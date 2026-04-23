package com.com.leetcode.april;

import java.util.ArrayList;
import java.util.List;

public class WordsWithinTwoEditsofDictionary {
    public static void main(String[] args) {
        String[] queries = {"tsl","sri","yyy","rbc","dda","qus","hyb","ilu","ahd"};
        String[] dictionary = {"uyj","bug","dba","xbe","blu","wuo","tsf","tga"};
        List<String> res = twoEditWords(queries, dictionary);
        System.out.println("Words within two edits of the dictionary: " + res); // Output the result
    }

    private static List<String> twoEditWords(String[] queries, String[] dictionary) {
        List<String> res = new ArrayList<>();
        for (String query : queries) {
            for (String dict : dictionary) {
                int count = 2;
                for (int i = 0; i < query.length(); i++) {
                    if (query.charAt(i) == dict.charAt(i)) {
                        continue;
                    } else count--;
                }
                if (count >= 0) {
                    res.add(query);
                    break;
                }
            }
        }
        return res;
    }
}
//tsl, yyy, rbc, dda, qus, hyb, ilu
//"tsl","yyy","rbc","dda","qus","hyb","ilu"
