package com.example.DSA.String.KMP;
// hello
import java.util.Arrays;
import java.util.Scanner;

public class kmp {

    public int[] computeLps(String pattArr) {
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
        return lpsArr;
    }

    public void KMPSearch(String text, String pattArray) {
        // calculating lps array
        // text : abxabcabcaby
        // pattern : abcaby
        int i = 0;
        int length = 0;
        int m = pattArray.length();
        int n = text.length();
        int lpsArr[] = computeLps(pattArray);
        boolean foundPatt = false;

        while (i < n) {
            // case 1: When text[i] === pattArray[length]
            if (text.charAt(i) == pattArray.charAt(length)) {
                i++;
                length++;
            }
            // case 2: if pattern found, we can find the occurence or number of occurence of
            // that pattern
            // here
            if (length == m) {
                foundPatt = true;
                System.out.println("index at which pattern found : " + (i - m));
                length = lpsArr[length - 1];// moving length back to find the next occurence
            } else if (i<n && text.charAt(i) != pattArray.charAt(length)) { // case 3: when text[i] !=
                                                                                   // pattArray[length]
                // moving length back
                if (length != 0) {
                    length = lpsArr[length - 1];
                } else {
                    i++;
                }
            }
        }
        if(!foundPatt){
            System.out.println("No ocurence of pattern occured in text");
        }
    }

    public void run() {
        Scanner myObj = new Scanner(System.in);
        System.out.println("Enter Text string : ");
        String text = myObj.nextLine();
        System.out.println("Enter Pattern string : ");
        String pattern = myObj.nextLine();
        KMPSearch(text, pattern);
    }
}
