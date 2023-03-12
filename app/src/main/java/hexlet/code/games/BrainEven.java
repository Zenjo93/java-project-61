package hexlet.code.games;

import java.util.Random;
import java.util.Scanner;

public class BrainEven {
    String playerName;
    static String gameRule = "Answer 'yes' if the number is even, otherwise answer 'no'.";
    static int turnsCount = 3;
    static int rightAnswerCounter = 0;
    Scanner scanner;

    public void launchGame() {
        scanner = new Scanner(System.in);
        greet();
        runGameProcess();
    }

    private void greet() {

        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        this.playerName = scanner.next();
        System.out.println("Hello, " + this.playerName + "!");
    }

    private void runGameProcess() {
        Random random = new Random();
        System.out.println(gameRule);

        for (var i = 0; i < turnsCount; i += 1) {
            int questionNumber = random.nextInt(100);
            var rightAnswer = isEven(questionNumber) ? "yes" : "no";

            System.out.println("Question: " + questionNumber);
            System.out.print("Your answer: ");
            var playerAnswer = scanner.next();

            if (playerAnswer.equals(rightAnswer)) {
                System.out.println("Correct!");
                rightAnswerCounter += 1;
            } else {
                System.out.println(playerAnswer + " is wrong answer ;(. Correct answer was " + rightAnswer + ".");
                System.out.println("Let's try again, " + this.playerName);
                return;
            }
        }
        System.out.println("Congratulations, " + this.playerName + "!");

    }

    private boolean isEven(int num) {
        return num % 2 == 0;
    }


}