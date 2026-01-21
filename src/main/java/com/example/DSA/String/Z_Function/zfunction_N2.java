package com.example.DSA.String.Z_Function;

import java.util.Arrays;
import java.util.Scanner;

public class zfunction_N2 {

    // My original Soultion - first go
    public void calcAns(String inp) {
        System.out.println("input string is " + inp);
        int arr[];
        int n = inp.length();
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            int cnt = 0;
            int l = 0;
            int j = i;
            for (; j < n;) {
                if (inp.charAt(l) != inp.charAt(j)) {
                    // System.out.println(inp.charAt(l)+ "" + inp.charAt(j));
                    break;
                }
                // System.out.println(inp.charAt(l)+ "-" + inp.charAt(j));
                l++;
                j++;
                ++cnt;
            }
            // System.out.println("cnt-" + cnt);
            arr[i] = cnt;
        }
        arr[0] = 0;
        System.out.println("calcAns ans : " + Arrays.toString(arr));
    }

    // 2nd solution - copied
    public void calcAns2(String inp) {
        int n = inp.length();
        int arr[] = new int[n];

        for (int i = 1; i < n; i++) {
            while ((arr[i] + i < n) && inp.charAt(arr[i]) == inp.charAt(arr[i] + i)) {
                arr[i]++;
            }
        }
        System.out.println("calcAns2 ans: " + Arrays.toString(arr));
    }

    public void run() {
        Scanner myObj = new Scanner(System.in);
        String inp = myObj.nextLine();
        calcAns(inp);
        calcAns2(inp);
    }
}