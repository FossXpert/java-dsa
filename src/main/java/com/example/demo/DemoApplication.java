package com.example.demo;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.DSA.String.Z_Function.zfunction_N2;

@SpringBootApplication
public class DemoApplication {
  public static void main(String[] args) {
    zfunction_N2 z = new zfunction_N2();
    z.run();
  }

}
