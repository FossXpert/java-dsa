package com.example.DSA.String.KMP;

import java.util.Arrays;
import java.util.Scanner;

public class kmp {

    public void lps(String pattArr) {
        // calculating lps array
        // text : abxabcabcaby
        // pattern : abcaby
        int n = pattArr.length();
        int length = 0;
        int index = 1;      
        int lpsArr[] = new int[n];
        lpsArr[0] = 0;

        while (index < n) {
            if (pattArr.charAt(length) == pattArr.charAt(index)) {
                length = length + 1;
                lpsArr[index] = length;
                index += 1;
            } else {
                if (length == 0) {
                    lpsArr[index] = 0;
                    index += 1;
                } else if (length != 0) {
                    length = lpsArr[length - 1];
                }
            }
        }
        System.out.println("lpsArr" + Arrays.toString(lpsArr));
    }

    public void run() {
        Scanner myObj = new Scanner(System.in);
        String inp = myObj.nextLine();
        lps(inp);
    }
}
