package com.com.leetcode.july;

import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;

public class BoldWordsinString {
    public static void main(String[] args) {
        String [] words = {"ab","bc"};
        String s = "aabcd";
        String res = boldWords(words, s);
        System.out.println(res);
    }

    private static String boldWords(String[] words, String s) {
        HashSet<String> hset=new HashSet<String>();
        for(int i=0;i<words.length;i++)
        {
            hset.add(words[i]);
        }
        HashMap<Integer,Integer> h=new HashMap<Integer,Integer>();
        PriorityQueue<Integer> pq=new PriorityQueue<Integer>();
        PriorityQueue<Integer> pq2=new PriorityQueue<Integer>();
        for(int i=0;i<s.length();i++)
        {
            for(int j=s.length();j>=i+1;j--)
            {
                String str=s.substring(i,j);
                if(hset.contains(str))
                {
                    h.put(i,j-1);
                    pq.add(i);
                    break;
                }
            }
        }
        if(pq.size()>0)
        {
            int start=pq.poll();
            int end=h.get(start);
            while(pq.size()>0)
            {
                int x=pq.poll();
                int y=h.get(x);
                if(x==end+1)
                {
                    end=y;
                    h.remove(x);
                }
                else
                {
                    if(x>end)
                    {
                        h.put(start,end);
                        pq2.add(start);
                        start=x;
                        end=y;
                    }
                    else
                    {
                        if(end<y)
                        {
                            end=y;
                            h.remove(x);
                        }
                    }
                }
            }

            h.put(start,end);
            pq2.add(start);
            int i=0;
            start=pq2.poll();
            end=h.get(start);
            StringBuffer res=new StringBuffer("");
            while(i<s.length())
            {
                res.append(s.substring(i,start)).append("<b>").append(s.substring(start,end+1)).append("</b>");
                i=end+1;
                if(pq2.size()>0)
                {

                    start=pq2.poll();
                    end=h.get(start);
                }
                else
                {
                    break;
                }
            }
            res.append(s.substring(end+1));
            return new String(res);

        }
        else
        {
            return s;
        }
    }
}
