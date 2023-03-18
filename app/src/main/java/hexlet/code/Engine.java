package hexlet.code;

import java.util.Scanner;

public class Engine {
    public static int turnsCount = 3;
    private static String playerName;

    public static void startGame(String gameRule, String[] questions, String[] rightAnswers) {
        Scanner scanner = new Scanner(System.in);
        greet(scanner);

        System.out.println(gameRule);

        for (var i = 0; i < turnsCount; i += 1) {
            var question = questions[i];
            var rightAnswer = rightAnswers[i];

            System.out.println("Question: " + question);
            System.out.print("Your answer: ");
            var playerAnswer = scanner.next();

            if (playerAnswer.equals(rightAnswer)) {
                System.out.println("Correct!");
            } else {
                System.out.println(playerAnswer + " is wrong answer ;(. Correct answer was " + rightAnswer + ".");
                System.out.println("Let's try again, " + playerName);
                return;
            }
        }
        System.out.println("Congratulations, " + playerName + "!");

        scanner.close();
    }

    private static void greet(Scanner scanner) {
        System.out.println("Welcome to the Brain Games!");
        System.out.println("May I have your name? ");
        playerName = scanner.next();
        System.out.println("Hello, " + playerName + "!");
    }

}