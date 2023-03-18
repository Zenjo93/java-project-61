package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.UtilsRandom;

public class Progression {
    private static final String GAME_RULE = "What number is missing in the progression?";
    static int progressionLength = 10;
    private static final int MAX_LIMIT = 5;
    private static final int MIN_LIMIT = 1;
    private static String[] questions = new String[Engine.getTurnsCount()];
    private static String[] rightAnswers = new String[Engine.getTurnsCount()];

    public static String getGameRule() {
        return GAME_RULE;
    }

    public static String[] getQuestions() {
        return questions;
    }

    public static String[] getRightAnswers() {
        return rightAnswers;
    }

    private static void setGameData() {
        String[] progression = new String[progressionLength];

        for (var i = 0; i < Engine.getTurnsCount(); i += 1) {
            int startNumber = UtilsRandom.getRandomNumber(MIN_LIMIT, MAX_LIMIT);
            int step = UtilsRandom.getRandomNumber(MIN_LIMIT, MAX_LIMIT);
            int blankPosition = UtilsRandom.getRandomNumber(0, progressionLength - 1);

            for (int j = 0, num = startNumber; j < progressionLength; num += step, j += 1) {
                progression[j] = Integer.toString(num);
            }

            rightAnswers[i] = progression[blankPosition];
            progression[blankPosition] = "..";
            questions[i] = String.join(" ", progression);
        }
    }

    public static void start() {
        setGameData();
        Engine.startGame(GAME_RULE, questions, rightAnswers);
    }

}
