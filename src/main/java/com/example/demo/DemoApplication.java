package com.example.demo;

import com.example.learning.zfunction;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {
  public static void main(String[] args) {
    zfunction z = new zfunction();
    z.run();
  }

}
