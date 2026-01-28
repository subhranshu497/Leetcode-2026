package com.com.leetcode.marathan.blind.seventyfive.partOne;

import java.util.*;

public class EncodeandDecodeStrings {
    Map<String, List<String>> map = new HashMap<>();
    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        map.put(strs.toString(), strs);
        return strs.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        return map.get(s);
    }

    public static void main(String[] args) {
        EncodeandDecodeStrings encode = new EncodeandDecodeStrings();
        List<String> dummy_input = List.of("","");
        encode.encode(dummy_input);
        List<String> list = encode.decode(encode.encode(dummy_input));
        System.out.println(list);
    }
}
