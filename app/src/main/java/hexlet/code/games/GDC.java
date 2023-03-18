package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.UtilsRandom;

public class GDC {
    private static final String GAME_RULE = "Find the greatest common divisor of given numbers.";
    private static final int MAX_LIMIT = 100;
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
            int num1 = UtilsRandom.getRandomNumber(MAX_LIMIT);
            int num2 = UtilsRandom.getRandomNumber(MAX_LIMIT);
            var gdc = findGcd(num1, num2);

            questions[i] = Integer.toString(num1) + " " + Integer.toString(num2);
            rightAnswers[i] = Integer.toString(gdc);
        }
    }

    private static int findGcd(int a, int b) {
        int gcd = 1;

        for (int i = 1; i <= a && i <= b; ++i) {
            if (a % i == 0 && b % i == 0) {
                gcd = i;
            }
        }
        return gcd;
    }

    public static void start() {
        setGameData();
        Engine.startGame(GAME_RULE, questions, rightAnswers);
    }
}
