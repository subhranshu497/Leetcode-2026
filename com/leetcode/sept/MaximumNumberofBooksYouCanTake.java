package com.com.leetcode.sept;
import java.util.ArrayDeque;

public class MaximumNumberofBooksYouCanTake {
    public static void main(String[] args) {
        int [] books = {8,5,2,7,9};
        long res = maximumBooks(books);
        System.out.println(res);
    }
    public static long maximumBooks(int[] books) {
        int len = books.length;
        long[] maxEndingAt = new long[len];
        long res = maxEndingAt[0] = books[0];
        var candidateIndexes = new ArrayDeque<Integer>();
        candidateIndexes.push(0);
        for (int i = 1; i < len; i++) {
            while (!candidateIndexes.isEmpty()) {
                int j = candidateIndexes.peek();
                if (books[j] <= books[i] - i + j) {
                    break;
                }
                candidateIndexes.pop();
            }
            int j = candidateIndexes.isEmpty() ? -1 : candidateIndexes.peek();
            long maxEndingAti = (j >= 0 ? maxEndingAt[j] : 0) +
                    triangularNumber(books[i]) - triangularNumber(books[i] - i + j);
            res = Math.max(res, maxEndingAti);
            maxEndingAt[i] = maxEndingAti;
            candidateIndexes.push(i);
        }
        return res;
    }

    private static long triangularNumber(int n) {
        if (n <= 0) return 0;
        return n * (n + 1L) / 2;
    }
}
