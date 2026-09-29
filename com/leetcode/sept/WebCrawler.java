package com.com.leetcode.sept;

import java.util.*;

public class WebCrawler {

    public List<String> crawl(String startUrl, HtmlParser htmlParser) {
        String hostName = getHostName(startUrl);
        Queue<String> q = new LinkedList<>();
        q.offer(startUrl);

        Set<String> res = new HashSet<>();
        res.add(startUrl);

        while(!q.isEmpty()){
            String url = q.poll();
            for(String next: htmlParser.getUrls(url)){
                if(next.startsWith(hostName) && res.add(next))
                    q.offer(next);
            }
        }
        return new ArrayList<>(res);
    }
    private String getHostName(String url){
        int idx = url.indexOf("/",7);
        return idx==-1?url:url.substring(0,idx);
    }

}
interface HtmlParser{
    public default List<String> getUrls(String url){
        return new ArrayList<>();
    }
}
