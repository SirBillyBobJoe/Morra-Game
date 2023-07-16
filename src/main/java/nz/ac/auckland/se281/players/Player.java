package nz.ac.auckland.se281.players;

import nz.ac.auckland.se281.MessageCli;

public abstract class Player {
  protected String name;
  protected Boolean matchSum;
  protected int score;
  protected int numFingers;
  protected int sum;

  public Player(String name) {
    this.name = name;
    this.matchSum = false;
    this.score = 0;
    this.numFingers = 0;
    this.sum = 0;
  }

  public String getName() {
    return this.name;
  }

  public int getScore() {
    return this.score;
  }

  public void setScore(int score) {
    this.score = score;
  }

  public int getFingers() {
    return this.numFingers;
  }

  public void getInfo() {
    // prints Player <name>: fingers: <numFingers>, sum: <sum>
    MessageCli.PRINT_INFO_HAND.printMessage(
        name, Integer.toString(numFingers), Integer.toString(sum));
  }

  // checks to see if the sum matches actual sum
  public void setMatchSum(int actualSum) {
    this.matchSum = (this.sum == actualSum) ? true : false;
  }

  public Boolean isMatchSum() {
    return this.matchSum;
  }

  // prints the statistics of the game to see how well the player did
  public void printStats(int pointsToWin) {
    MessageCli.PRINT_PLAYER_WINS.printMessage(
        name, Integer.toString(score), Integer.toString(pointsToWin - score));
  }

  public abstract void addScore();
}
