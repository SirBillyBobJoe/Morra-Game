package nz.ac.auckland.se281.ai;

import nz.ac.auckland.se281.strategy.ProcessStrategy;
import nz.ac.auckland.se281.strategy.RandomStrategy;
import nz.ac.auckland.se281.strategy.TopStrategy;

public class HardLevel implements Level {

  // hard level implements Random Strategy and Top Strategy after 3 rounds
  private ProcessStrategy processStrategy = new ProcessStrategy(new RandomStrategy());
  private int count = 1;

  @Override
  public int getFingers() {
    // change strategy to average strategy after 3 rounds
    if (count > 3) {
      processStrategy.setStrategy(new TopStrategy());
    }
    count++;
    return processStrategy.getFingers();
  }

  @Override
  // returns sum generated by the strategy
  public int getSum(int num) {
    return processStrategy.getSum(num);
  }
}