package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.UtilsRandom;

public class Progression {
    private static final String GAME_RULE = "What number is missing in the progression?";
    private static final int PROGRESSION_LENGTH = 10;
    private static final int MAX_LIMIT = 5;
    private static final int MIN_LIMIT = 1;

    private static String[][] getGameData() {
        String[] questions = new String[Engine.TURNS_COUNT];
        String[] rightAnswers = new String[Engine.TURNS_COUNT];

        for (var i = 0; i < Engine.TURNS_COUNT; i += 1) {
            int startNumber = UtilsRandom.getRandomNumber(MIN_LIMIT, MAX_LIMIT);
            int step = UtilsRandom.getRandomNumber(MIN_LIMIT, MAX_LIMIT);
            int blankPosition = UtilsRandom.getRandomNumber(0, PROGRESSION_LENGTH - 1);
            String[] progression = makeProgression(startNumber, step, PROGRESSION_LENGTH);

            rightAnswers[i] = progression[blankPosition];
            progression[blankPosition] = "..";
            questions[i] = String.join(" ", progression);
        }
        return new String[][]{questions, rightAnswers};
    }

    private static String[] makeProgression(int startNumber, int step, int progressionLength) {
        String[] progression = new String[progressionLength];
        for (int i = 0, num = startNumber; i < progressionLength; num += step, i += 1) {
            progression[i] = Integer.toString(num);
        }
        return progression;
    }

    public static void start() {
        String[][] gameData = getGameData();
        Engine.startGame(GAME_RULE, gameData);
    }

}
