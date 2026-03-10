package com.com.leetcode.march;

import java.util.*;

public class LogSystem {
    Map<Integer, String[]> storage;

    public LogSystem() {
        storage = new HashMap<>();
    }

    public void put(int id, String timestamp) {
        String[] strs = timestamp.split(":");
        storage.put(id, strs);
    }


    public List<Integer> retrieve(String start, String end, String granularity) {
        List<Integer> res = new ArrayList<>();
        String[] stArr = start.split(":");
        String[] endArr = end.split(":");
        int idx = -1;
        switch (granularity) {
            case "Year":
                idx = 0;
                break;
            case "Month":
                idx = 1;
                break;
            case "Day":
                idx = 2;
                break;
            case "Hour":
                idx = 3;
                break;
            case "Minute":
                idx = 4;
                break;
            case "Second":
                idx = 5;
                break;
        }
        StringBuilder stSb = new StringBuilder();
        StringBuilder endSb = new StringBuilder();
        for (int i = 0; i <= idx; i++) {
            stSb.append(stArr[i]);
            endSb.append(endArr[i]);
        }
        for (Map.Entry<Integer, String[]> entry : storage.entrySet()) {
            Integer key = entry.getKey();
            String[] value = entry.getValue();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i <= idx; i++) {
                sb.append(value[i]);
            }

            if ((stSb.toString()).compareTo(sb.toString()) <= 0 && (endSb.toString()).compareTo(sb.toString()) >= 0) {
                res.add(key);
            }
        }

        return res;
    }
}
