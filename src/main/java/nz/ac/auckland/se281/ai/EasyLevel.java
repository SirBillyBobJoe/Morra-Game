package nz.ac.auckland.se281.ai;

import nz.ac.auckland.se281.strategy.ProcessStrategy;
import nz.ac.auckland.se281.strategy.RandomStrategy;

public class EasyLevel implements Level {

  private ProcessStrategy processStrategy = new ProcessStrategy(new RandomStrategy());

  // easy level only uses random strategy
  // gets random fingers
  @Override
  public int getFingers() {

    return processStrategy.getFingers();
  }

  // gets random sum
  @Override
  public int getSum(int num) {
    return processStrategy.getSum(num);
  }
}
