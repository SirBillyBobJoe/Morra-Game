package nz.ac.auckland.se281.players;

import nz.ac.auckland.se281.MessageCli;
import nz.ac.auckland.se281.Utils;

public class Human extends Player {
  public Human(String name) {
    super(name);
  }

  public void determineFingersAndSum() {

    // prints Give <fingers> <sum> and press enter
    MessageCli.ASK_INPUT.printMessage();

    String nums = Utils.scanner.nextLine();
    String[] numsArray = nums.split(" ");

    while (isValidFingers(numsArray[0]) == false || isValidSum(numsArray[1]) == false) {
      // prints Error! Invalid input, you should give two integers numbers: <fingers> <sum>,
      // <fingers> should be between 1 and 5 (inclusive) and <sum> should be between 1 and 10
      // (inclusive), please try again
      MessageCli.INVALID_INPUT.printMessage();
      nums = Utils.scanner.nextLine();
      numsArray = nums.split(" ");
    }

    numFingers = Integer.parseInt(numsArray[0]);
    sum = Integer.parseInt(numsArray[1]);
  }

  @Override
  public void addScore() {
    this.score++;
    // prints Result: HUMAN_WINS
    MessageCli.PRINT_OUTCOME_ROUND.printMessage("HUMAN_WINS");
  }

  // method to check if its a Fingers number
  private Boolean isValidFingers(String str) {
    // tries to convert to int if you cant then return false
    // also if its less than 1 or greater than 5 return false
    try {
      int num = Integer.parseInt(str);
      if (num < 1 || num > 5) {
        return false;
      }
    } catch (NumberFormatException e) {
      return false;
    }
    return true;
  }

  // method to check if its a Sum number
  private Boolean isValidSum(String str) {
    // tries to convert to int if you cant then return false
    // also if its less than 1 or greater than 10 return false
    try {
      int num = Integer.parseInt(str);
      if (num < 1 || num > 10) {
        return false;
      }
    } catch (NumberFormatException e) {
      return false;
    }
    return true;
  }
}
