package nz.ac.auckland.se281.strategy;

import java.util.ArrayList;
import java.util.HashMap;
import nz.ac.auckland.se281.Utils;

public class TopStrategy implements Strategy {
  private int fingers;
  private int max = Integer.MIN_VALUE;

  @Override
  // retrieves the strategy type
  public String getStrategy() {
    return "Top";
  }

  @Override
  // applys top strategy to determine the sum
  public int getSum(ArrayList<Integer> list) {
    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    // loops through list and adds every value to a HashMap if it dosent exist set value to 1 if
    // already exists adds 1 to value
    for (int i : list) {
      map.put(i, map.getOrDefault(i, 0) + 1);
    }
    // loops through HashMap and finds the max frequency of the fingers used by the human in the
    // list
    for (HashMap.Entry<Integer, Integer> entry : map.entrySet()) {
      if (entry.getValue() > max) {
        max = entry.getKey().intValue();
      }
    }
    // returns the max frequency + random fingers we generated
    return max + this.fingers;
  }

  @Override
  // generates random number of fingers
  public int getFingers() {
    this.fingers = Utils.getRandomNumber(1, 5);

    return this.fingers;
  }
}
