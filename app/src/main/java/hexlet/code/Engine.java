package hexlet.code;

import java.util.Scanner;

public class Engine {
    public static final int TURNS_COUNT = 3;

    public static void startGame(String gameRule, String[][] gameData) {
        String[] questions = gameData[0];
        String[] rightAnswers = gameData[1];
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Brain Games!");
        System.out.println("May I have your name? ");
        String playerName = scanner.next();
        System.out.println("Hello, " + playerName + "!");
        System.out.println(gameRule);

        for (var i = 0; i < TURNS_COUNT; i += 1) {
            var question = questions[i];
            var rightAnswer = rightAnswers[i];

            System.out.println("Question: " + question);
            System.out.print("Your answer: ");
            var playerAnswer = scanner.next();

            if (playerAnswer.equals(rightAnswer)) {
                System.out.println("Correct!");
            } else {
                System.out.println(playerAnswer + " is wrong answer ;(. Correct answer was " + rightAnswer + ".");
                System.out.println("Let's try again, " + playerName + "!");
                return;
            }
        }
        System.out.println("Congratulations, " + playerName + "!");

        scanner.close();
    }
}
