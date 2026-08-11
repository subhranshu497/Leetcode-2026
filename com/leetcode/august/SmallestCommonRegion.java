package com.com.leetcode.august;

import java.util.*;

public class SmallestCommonRegion {
    public static void main(String[] args) {
        List<List<String>> regions = List.of(
                List.of("United States", "California", "Texas"),
                List.of("California", "Los Angeles", "San Francisco"),
                List.of("South America", "Brazil", "Argentina"),
                List.of("North America", "United States", "Canada"),
                List.of("Earth", "North America", "South America")
        );
        String region1 = "Los Angeles";
        String region2 = "Brazil";
        String res = findSmallestRegion(regions, region1, region2);
        System.out.println(res);
    }

    private static String findSmallestRegion(List<List<String>> regions, String region1, String region2) {
        Map<String, String> map = new LinkedHashMap<>();
        for(List<String> l:regions){
            int i = l.size()-1;
            for(;i>0;i--){
                map.put(l.get(i),l.get(0));
            }
        }
        // Store all ancestors of region1
        Set<String> ancestors = new HashSet<>();
        while (region1 != null) {
            ancestors.add(region1);
            region1 = map.get(region1);
        }

        // Find the first matching ancestor starting from region2
        while (region2 != null) {
            if (ancestors.contains(region2)) {
                return region2;
            }
            region2 = map.get(region2);
        }

        return "";
    }
}
