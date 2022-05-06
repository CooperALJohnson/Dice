import java.util.Random;
import java.util.Scanner;

public class DiceRoller {
    private static String mathSymbol = null;
    private static int modifiers = 0;
    private static int rollCount = 0;
    private static boolean running = true;
    private static int diceInput;
    private static int rolledTotal;
    public static void main(String[] args) {
        while (running) {

            try {
                Scanner input = new Scanner(System.in);

                System.out.println("Enter: dX + modifier (* rollCount)");
                String answer = input.nextLine();
                String[] inputArgs = answer.split(" ");
                String dice = inputArgs[0];

                if (inputArgs.length >= 3) {
                    mathSymbol = inputArgs[1];
                    modifiers = Integer.parseInt(inputArgs[2]);
                } else {
                    mathSymbol = "+";
                    modifiers = 0;
                }

                if (inputArgs.length >= 4) {
                    rollCount = Integer.parseInt(inputArgs[4]);
                } else {
                    rollCount = 1;
                }

                switch (dice.toLowerCase()) {
                    case "d2", "2" -> diceInput = 2;
                    case "d4", "4" -> diceInput = 4;
                    case "d6", "6" -> diceInput = 6;
                    case "d8", "8" -> diceInput = 8;
                    case "d10", "10" -> diceInput = 10;
                    case "d12", "12" -> diceInput = 12;
                    case "d20", "20" -> diceInput = 20;
                    case "d100", "100" -> diceInput = 100;
                    case "stop" -> running = false;
                    default -> System.out.println("Damn Max, I don't know what that means!");
                }
                rolledTotal = 0;
                for(int i = 0; i < rollCount; i++){
                    roll(diceInput);
                }

                System.out.println("Final total: " + rolledTotal);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input");
            } catch (Exception e) {
                System.out.println("Dammit Max, something broke");
            }
        }
    }
    private static void roll(int diceType) {
        Random random = new Random();

        int randomRoll = random.nextInt(1, diceType + 1);
        int newRoll;
        if(mathSymbol.equals("+")) {
            newRoll = (randomRoll + modifiers);
        }
        else {
            newRoll = (randomRoll - modifiers);
        }
        rolledTotal += newRoll;
        System.out.println("Rolled: " + randomRoll + ", Total: " + newRoll);

    }
}