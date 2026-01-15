package com.example.DSA.String;

import java.util.Arrays;
import java.util.Scanner;

public class zfunction_N2 {

    public void calcAns(String inp){
        System.out.println("input string is " + inp);
        int arr[];
        int n = inp.length();
        arr = new int[n];
        for(int i=0;i<n;i++){
            int cnt = 0;
            int l =0;
            int j=i;
            for (;j<n;){
                if(inp.charAt(l) != inp.charAt(j)){
                    // System.out.println(inp.charAt(l)+ "" + inp.charAt(j));
                    break;
                }
                // System.out.println(inp.charAt(l)+ "-" + inp.charAt(j));
                l++;j++;++cnt;
            }
            // System.out.println("cnt-"  + cnt);
            arr[i] = cnt;
        }
        arr[0] = 0;
        System.out.println("ans : " + Arrays.toString(arr));
    }
    public void run() {
        Scanner myObj = new Scanner(System.in);
        String inp = myObj.nextLine();
        calcAns(inp);
    }
}