package nz.ac.auckland.se281.strategy;

import java.util.ArrayList;

public interface Strategy {
  // interface for the strategy classes
  public int getSum(ArrayList<Integer> list);

  public int getFingers();

  public String getStrategy();
}
