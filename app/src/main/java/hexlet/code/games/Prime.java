package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.UtilsRandom;

public class Prime {
    static String gameRule = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
    static String[] questions = new String[Engine.turnsCount];
    static String[] rightAnswers = new String[Engine.turnsCount];


    private static void setGameData() {
        for (var i = 0; i < Engine.turnsCount; i += 1) {
            int num = UtilsRandom.getRandomNumber(2, 500);
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
        Engine.startGame(gameRule, questions, rightAnswers);
    }
}
