package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.UtilsRandom;

public class Prime {
    private static final String GAME_RULE = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
    private static final int MAX_LIMIT = 500;
    private static final int MIN_LIMIT = 2;
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
        for (var i = 0; i < Engine.getTurnsCount(); i += 1) {
            int num = UtilsRandom.getRandomNumber(MIN_LIMIT, MAX_LIMIT);
            questions[i] = Integer.toString(num);
            rightAnswers[i] = isPrime(num) ? "yes" : "no";
        }
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
        setGameData();
        Engine.startGame(GAME_RULE, questions, rightAnswers);
    }
}
