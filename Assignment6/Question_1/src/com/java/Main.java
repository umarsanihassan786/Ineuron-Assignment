package com.java;

public class Main {
    public static int[] findPermutation(String s) {
        int n = s.length();
        int countD = 0;
        int[] perm = new int[n + 1];
        
        for (int i = 0; i <= n; i++) {
            if (i < n && s.charAt(i) == 'D') {
                countD++;
            } else {
                for (int j = i - countD; j <= i; j++) {
                    perm[j] = i - j + n;
                }
                countD = 0;
            }
        }
        
        return perm;
    }

    public static void main(String[] args) {
        String s = "IDID";
        int[] perm = findPermutation(s);
        for (int num : perm) {
            System.out.print(num + " ");
        }
    }
}
