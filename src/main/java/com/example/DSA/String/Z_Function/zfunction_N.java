package com.example.DSA.String.Z_Function;

import java.util.Arrays;
import java.util.Scanner;

public class zfunction_N {

    public void calcAns(String inp) {
        // this method is time complexity of O(n)

        int L = 0, R = 0, n = inp.length();
        int arr[] = new int[n];
        for (int i = 1; i < n; i++) {

            if (i <= R) {
                arr[i] = Math.min(arr[i - L], R - i + 1);
            }
            while (arr[i] + i < n && inp.charAt(arr[i]) == inp.charAt(arr[i] + i)) {
                arr[i]++;
            }
            if (arr[i] + i - 1 > R) {
                L = i;
                R = arr[i] + i - 1;
            }
        }
        System.out.println("calcAns2 ans: " + Arrays.toString(arr));
    }

    public void run() {
        Scanner myObj = new Scanner(System.in);
        String inp = myObj.nextLine();
        calcAns(inp);
    }
}
