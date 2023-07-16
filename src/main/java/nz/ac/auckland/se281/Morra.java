package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Difficulty;
import nz.ac.auckland.se281.ai.LevelFactory;
import nz.ac.auckland.se281.players.Bot;
import nz.ac.auckland.se281.players.Human;

public class Morra {
  private Game game = new Game();
  private Bot jarvis;
  private Human human;

  public void newGame(Difficulty difficulty, int pointsToWin, String[] options) {
    // start the game
    game.start(pointsToWin);

    // create the players
    human = new Human(options[0]);
    jarvis = new Bot(LevelFactory.createLevel(difficulty));

    // prints Welcome <Name>!
    MessageCli.WELCOME_PLAYER.printMessage(human.getName());
  }

  public void play() {

    if (!game.isStarted()) {
      return;
    }

    game.startRound();

    jarvis.determineFingersAndSum(human.getFingers());
    human.determineFingersAndSum();

    human.getInfo();
    game.setActualSum(jarvis.getFingers() + human.getFingers());

    // prints Player Jarvis: fingers: <numFingers>, sum: <sum>
    jarvis.getInfo();

    // determines truth values if matching guess to sum or not
    human.setMatchSum(game.getActualSum());
    jarvis.setMatchSum(game.getActualSum());

    if (human.isMatchSum() == jarvis.isMatchSum()) {
      // prints Result: DRAW
      MessageCli.PRINT_OUTCOME_ROUND.printMessage("DRAW");
    } else if (human.isMatchSum()) {
      human.addScore();
    } else if (jarvis.isMatchSum()) {
      jarvis.addScore();
    }

    if (human.getScore() == game.getPointsToWin()) {
      game.end(human.getName());
      return;
    } else if (jarvis.getScore() == game.getPointsToWin()) {
      game.end(jarvis.getName());
      return;
    }
  }

  public void showStats() {

    if (!game.isStarted()) {
      return;
    }

    // if games started then print out the stats
    human.printStats(game.getPointsToWin());
    jarvis.printStats(game.getPointsToWin());
  }
}
