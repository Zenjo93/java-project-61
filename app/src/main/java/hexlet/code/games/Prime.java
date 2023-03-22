package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.UtilsRandom;

public class Prime {
    private static final String GAME_RULE = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
    private static final int MAX_LIMIT = 500;
    private static final int MIN_LIMIT = 2;

    private static String[][] getGameData() {
        String[] questions = new String[Engine.TURNS_COUNT];
        String[] rightAnswers = new String[Engine.TURNS_COUNT];

        for (var i = 0; i < Engine.TURNS_COUNT; i += 1) {
            int num = UtilsRandom.getRandomNumber(MIN_LIMIT, MAX_LIMIT);
            questions[i] = Integer.toString(num);
            rightAnswers[i] = isPrime(num) ? "yes" : "no";
        }

        return new String[][]{questions, rightAnswers};
    }

    private static boolean isPrime(int num) {
        for (int i = 2, sqrtNum = (int) Math.sqrt(num); i <= sqrtNum; i += 1) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void start() {
        String[][] gameData = getGameData();
        Engine.startGame(GAME_RULE, gameData);
    }
}
