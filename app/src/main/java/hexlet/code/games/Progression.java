package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.UtilsRandom;

import java.util.Arrays;

public class Progression {
    static String gameRule = "What number is missing in the progression?";
    static int progressionLength = 10;
    static String[] questions = new String[Engine.turnsCount];
    static String[] rightAnswers = new String[Engine.turnsCount];

    private static void setGameData() {
        String[] progression = new String[progressionLength];

        for (var i = 0; i < Engine.turnsCount; i += 1) {
            int startNumber = UtilsRandom.getRandomNumber(1, 5);
            int step = UtilsRandom.getRandomNumber(1, 5);
            int blankPosition = UtilsRandom.getRandomNumber(0, progressionLength - 1);

            for (int j = 0, num = startNumber; j < progressionLength; num += step, j += 1) {
                progression[j] = Integer.toString(num);
            }

            rightAnswers[i] = progression[blankPosition];
            progression[blankPosition] = "..";
            questions[i] = String.join(" ",progression);
        }

    }

    public static void start() {
        setGameData();
        Engine.startGame(gameRule, questions, rightAnswers);
    }

}
