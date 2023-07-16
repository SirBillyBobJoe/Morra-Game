package nz.ac.auckland.se281.ai;

import nz.ac.auckland.se281.Main.Difficulty;

public class LevelFactory {
  public static Level createLevel(Difficulty difficulty) {
    // use switch case to create level using factory design pattern
    switch (difficulty) {
      case EASY:
        return new EasyLevel();

      case MEDIUM:
        return new MediumLevel();

      case HARD:
        return new HardLevel();

      case MASTER:
        return new MasterLevel();

      default:
        return null;
    }
  }
}
