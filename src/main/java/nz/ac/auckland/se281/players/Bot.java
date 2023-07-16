package nz.ac.auckland.se281.players;

import nz.ac.auckland.se281.MessageCli;
import nz.ac.auckland.se281.ai.Level;

public class Bot extends Player {
  private Level level;

  public Bot(Level level) {
    super("Jarvis");
    this.level = level;
  }

  // passes human fingers to store in history and determine fingers and sum
  public void determineFingersAndSum(int humanFingers) {
    this.numFingers = level.getFingers();
    this.sum = level.getSum(humanFingers);
  }

  @Override
  public void addScore() {
    this.score++;
    // prints Result: AI_WINS
    MessageCli.PRINT_OUTCOME_ROUND.printMessage("AI_WINS");
  }
}
