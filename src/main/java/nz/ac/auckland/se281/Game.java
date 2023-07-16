package nz.ac.auckland.se281;

public class Game {
  private int numRound;
  private int actualSum;

  private int pointsToWin;
  private Boolean started = false;

  // starts the game and resets all values
  public void start(int pointsToWin) {
    this.started = true;
    this.pointsToWin = pointsToWin;
    this.numRound = 0;
    actualSum = 0;
  }

  // checks to see if the games started
  public Boolean isStarted() {
    if (!this.started) {
      // prints "Error! Game not started yet. Please start a new game first"
      MessageCli.GAME_NOT_STARTED.printMessage();
    }
    return this.started;
  }

  public void startRound() {
    this.numRound++;

    // prints Start Round #<numRound>:
    MessageCli.START_ROUND.printMessage(String.valueOf(numRound));
  }

  public void setActualSum(int actualSum) {
    this.actualSum = actualSum;
  }

  public int getActualSum() {
    return this.actualSum;
  }

  public int getPointsToWin() {
    return this.pointsToWin;
  }

  public void end(String name) {

    // prints End game! <name> won in <numRound> rounds
    MessageCli.END_GAME.printMessage(name, Integer.toString(numRound));
    this.started = false;
  }
}
