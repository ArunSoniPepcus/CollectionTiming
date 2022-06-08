package com.pepcus;

import java.util.ArrayList;

public class MissingNumberInArrayList {
  private int count;

  public void find() {
    // add number
    long startTime = System.nanoTime();
    ArrayList<Integer> input = new ArrayList<>();
    for (int i = 0; i < 100; i++) {
      input.add(i);
    }
    long endTime = System.nanoTime();
    System.out.println("Adding number total time-------" + (endTime - startTime));
   
    
    // remove number
    long startTime1 = System.nanoTime();
    input.remove(1);
    long endTime1 = System.nanoTime();
    System.out.println("Remove time--------" + (endTime1 - startTime1));
   
    
    // find the missing number
    long startTime2 = System.nanoTime();
    for (Integer i : input) {
      if (i != count) {
        System.out.println("Missing Number is------"+ count);
        count++;
      }
      count++;
    }
    long endTime2 = System.nanoTime();
    System.out.println("Missing Number finding time -----" + (endTime2 - startTime2));
  }

  public static void main(String[] args) {
    MissingNumberInArrayList checkMissingNumber = new MissingNumberInArrayList();
    checkMissingNumber.find();
  }
}
