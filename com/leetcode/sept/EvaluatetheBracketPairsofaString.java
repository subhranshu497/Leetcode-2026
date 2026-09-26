package com.com.leetcode.sept;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EvaluatetheBracketPairsofaString {
    public static void main(String[] args) {
        String s = "(name)is(age)yearsold";
        List<List<String>> knowledge = new ArrayList<>();
        List<String> l = List.of("name","bob");
        knowledge.add(l);
        List<String> l1 = List.of("age","two");
        knowledge.add(l1);
        String res = evaluateI(s, knowledge);
        System.out.println(res);
    }

    private static String evaluateI(String s, List<List<String>> knowledge) {
        StringBuilder sb = new StringBuilder();
        Map<String, String> keyVal = new HashMap<>();
        for(List<String> l:knowledge){
            keyVal.put(l.get(0),l.get(1));
        }
        System.out.println(keyVal);
        //start parsing the s
        int i =0;
        int n = s.length();
        int st =0;
        while(i<n){
            if(s.charAt(i)=='('){
                StringBuilder key = new StringBuilder();
                i +=1;
                while(s.charAt(i) != ')'){
                    key.append(s.charAt(i));
                    i++;
                }
                String val = "?";
                if(keyVal.containsKey(key.toString()))
                    val = keyVal.get(key.toString());
                sb.append(val);
                st = i+1;
            }else{
                sb.append(s.charAt(i));
            }
            i++;
        }
        return sb.toString();
    }
}
