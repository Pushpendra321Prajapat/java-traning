import java.lang.Math;
import java.util.Scanner;

public class Hangman {

    public static String[] words = { "ant", "baboon", "badger", "bat", "bear", "beaver", "camel", "cat", "clam",
            "cobra", "cougar", "coyote", "crow", "deer", "dog", "donkey", "duck", "eagle", "ferret", "fox", "frog",
            "goat", "goose", "hawk", "lion", "lizard", "llama", "mole", "monkey", "moose", "mouse", "mule", "newt",
            "otter", "owl", "panda", "parrot", "pigeon", "python", "rabbit", "ram", "rat", "raven", "rhino", "salmon",
            "seal", "shark", "sheep", "skunk", "sloth", "snake", "spider", "stork", "swan", "tiger", "toad", "trout",
            "turkey", "turtle", "weasel", "whale", "wolf", "wombat", "zebra" };

    public static String[] gallows = { "+---+\n" + "|   |\n" + "    |\n" + "    |\n" + // if the user didn't miss any
                                                                                       // guesses.
            "    |\n" + "    |\n" + "=========\n",

            "+---+\n" + "|   |\n" + "O   |\n" + // if the user missed one guess.
                    "    |\n" + "    |\n" + "    |\n" + "=========\n",

            "+---+\n" + "|   |\n" + "O   |\n" + // if the user missed two guesses.
                    "|   |\n" + "    |\n" + "    |\n" + "=========\n",

            " +---+\n" + " |   |\n" + " O   |\n" + // if the user missed three guesses.
                    "/|   |\n" + "     |\n" + "     |\n" + " =========\n",

            " +---+\n" + " |   |\n" + " O   |\n" + "/|\\  |\n" + // if the user missed four guesses.
                    "     |\n" + "     |\n" + " =========\n",

            " +---+\n" + " |   |\n" + " O   |\n" + "/|\\  |\n" + // if the user missed five guesses.
                    "/    |\n" + "     |\n" + " =========\n",

            " +---+\n" + " |   |\n" + " O   |\n" + "/|\\  |\n" + // if the user missed six guesses.
                    "/ \\  |\n" + "     |\n" + " =========\n" };

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String randWord = randomWord();
        char[] ch = randWord.toCharArray();

        char[] placeholder = new char[ch.length];

        for (int i = 0; i < ch.length; i++) {
            placeholder[i] = '_';
        }

        char[] missedGuesses = new char[6];
        int miss = 0;

        while (miss < 6) {
            System.out.println(gallows[miss]);

            System.out.print("word:      ");
            printPlaceholders(placeholder);

            System.out.print("Misses:    ");
            printMissedGuesses(missedGuesses);

            System.out.print("Guess:     ");
            char guessChar = sc.next().charAt(0);

            boolean check = checkGuess(ch, guessChar);

            if (check == true) {
                updatePlaceholders(ch, placeholder, guessChar);
            } else {
                missedGuesses[miss] = guessChar;
                miss++;
            }

            if (win(ch, placeholder) == true) {
                System.out.println(gallows[miss]);
                System.out.print("\n word:   ");
                printPlaceholders(placeholder);

                System.out.println("GOOD WORK !  \n\n");
                break;

            }

            if (miss == 6) {
                System.out.print(gallows[6]);
                System.out.println("\nRIP!");
                System.out.println("\nThe word was: '" + randWord + "'");
                System.out.print("\n\n");

                sc.close();
            }

        }

    }

    public static String randomWord() {
        int len = words.length;

        int index = (int) (Math.random() * len);
        String rand = words[index];
        return rand;
    }

    public static boolean checkGuess(char[] ch, char guessChar) {
        for (int i = 0; i < ch.length; i++) {
            if (ch[i] == guessChar) {
                return true;
            }
        }
        return false;
    }

    public static void updatePlaceholders(char[] ch, char[] placeholder, char guessChar) {
        for (int i = 0; i < ch.length; i++) {
            if (ch[i] == guessChar) {
                placeholder[i] = guessChar;
            }
        }

    }

    public static void printPlaceholders(char[] placeholder) {
        for (int i = 0; i < placeholder.length; i++) {
            System.out.print(placeholder[i] + " ");
        }
        System.out.println("\n \n");

    }

    public static void printMissedGuesses(char[] missedGuesses) {
        for (int i = 0; i < missedGuesses.length; i++) {
            System.out.print(missedGuesses[i]);
        }
        System.out.println("\n \n");
    }

    public static boolean win(char[] ch, char[] placeholder) {
        for (int i = 0; i < ch.length; i++) {
            if (ch[i] != placeholder[i]) {
                return false;
            }
        }
        return true;
    }
}
