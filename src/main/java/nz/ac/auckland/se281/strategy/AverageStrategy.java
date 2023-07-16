package nz.ac.auckland.se281.strategy;

import java.util.ArrayList;
import nz.ac.auckland.se281.Utils;

public class AverageStrategy implements Strategy {
  private int fingers;

  // retrieves the strategy type
  @Override
  public String getStrategy() {
    return "Average";
  }

  // generates random number of fingers
  @Override
  public int getFingers() {
    this.fingers = Utils.getRandomNumber(1, 5);

    return this.fingers;
  }

  // applys average strategy to determine the sum
  @Override
  public int getSum(ArrayList<Integer> list) {
    // determines average
    int average = 0;
    for (int i : list) {
      average += i;
    }

    // adds average to fingers and rounds it to return sum
    average = (int) Math.round(average / (double) list.size());
    return this.fingers + average;
  }
}
