package nz.ac.auckland.se281.strategy;

import java.util.ArrayList;
import nz.ac.auckland.se281.Utils;

public class RandomStrategy implements Strategy {
  // random strategy generates random number of fingers and random sum
  private int fingers;
  private int sum;

  @Override
  // generates random number of fingers between 1 and 5
  public int getFingers() {
    this.fingers = Utils.getRandomNumber(1, 5);
    return this.fingers;
  }

  @Override
  // retrieves the strategy type
  public String getStrategy() {
    return "Random";
  }

  @Override
  // generates random sum between fingers + 1 and fingers + 5
  public int getSum(ArrayList<Integer> list) {
    this.sum = Utils.getRandomNumber(this.fingers + 1, this.fingers + 5);
    return this.sum;
  }
}
