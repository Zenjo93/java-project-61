package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.UtilsRandom;

public class GDC {
    private static final String GAME_RULE = "Find the greatest common divisor of given numbers.";
    private static final int MAX_LIMIT = 100;

    private static String[][] getGameData() {
        String[] questions = new String[Engine.TURNS_COUNT];
        String[] rightAnswers = new String[Engine.TURNS_COUNT];

        for (var i = 0; i < Engine.TURNS_COUNT; i += 1) {
            int num1 = UtilsRandom.getRandomNumber(MAX_LIMIT);
            int num2 = UtilsRandom.getRandomNumber(MAX_LIMIT);
            var gdc = findGcd(num1, num2);

            questions[i] = num1 + " " + num2;
            rightAnswers[i] = Integer.toString(gdc);
        }
        return new String[][]{questions, rightAnswers};
    }

    private static int findGcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return findGcd(b, a % b);
    }

    public static void start() {
        String[][] gameData = getGameData();
        Engine.startGame(GAME_RULE, gameData);
    }
}
