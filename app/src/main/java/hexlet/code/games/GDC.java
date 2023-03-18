package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.UtilsRandom;

public class GDC {
    static String gameRule = "Find the greatest common divisor of given numbers.";
    static String[] questions = new String[Engine.turnsCount];
    static String[] rightAnswers = new String[Engine.turnsCount];


    private static void setGameData() {
        for (var i = 0; i < Engine.turnsCount; i += 1) {
            var num1 = UtilsRandom.getRandomNumber(100);
            var num2 = UtilsRandom.getRandomNumber(100);
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
        Engine.startGame(gameRule, questions, rightAnswers);
    }
}