package com.example.demo;
import java.util.Scanner;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {
  public static void main(String[] args) {
    Scanner myObj = new Scanner(System.in);
    System.out.println("Enter an Integer");
    int a = myObj.nextInt();
    System.out.println("Hello World " + a);
  }

}
