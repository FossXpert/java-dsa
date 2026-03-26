package com.example.demo;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.DSA.String.Z_Function.zfunction_N;
import com.example.DSA.String.Z_Function.zfunction_N2;
import com.example.DSA.String.KMP.kmp;


@SpringBootApplication
public class DemoApplication {
  public static void main(String[] args) {
    kmp z = new kmp();
    z.run();
  }

}
