
package Hangman;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class HangmanReal {
  
    private static final String[] Words = loadWords();

    private static final int Mistakes = 6;
  
    private static final String[] Drawings = {
            " +---+\n |   |\n     |\n     |\n     |\n=======",
            " +---+\n |   |\n O   |\n     |\n     |\n=======",
            " +---+\n |   |\n O   |\n |   |\n     |\n=======",
            " +---+\n |   |\n O   |\n/|   |\n     |\n=======",
            " +---+\n |   |\n O   |\n/|\\  |\n     |\n=======",
            " +---+\n |   |\n O   |\n/|\\  |\n/    |\n=======",
            " +---+\n |   |\n O   |\n/|\\  |\n/ \\  |\n======="
    };

   
        private static File findWordFile() {
            
      String homeDir = System.getProperty("user.home");
		
		
		String[] candidatePaths = {
			
			"words.txt",
			new File(homeDir, "Downloads/words.txt").getPath(),
			
			
			
		
		};



        for (String path : candidatePaths) {
            File candidate = new File(path);
            if (candidate.exists() && candidate.isFile()) {
                return candidate;
            }
        }

        return new File("words.txt");
    }

 
    private static String[] loadWords() {
       
        ArrayList<String> words = new ArrayList<>();
        File wordFile = findWordFile();

        try {
           
            Scanner file = new Scanner(wordFile);
            while (file.hasNextLine()) {
             
                String word = file.nextLine().trim().toLowerCase();
                if (!word.isEmpty()) {
                    words.add(word);
                }
            }
            file.close(); 
        } catch (FileNotFoundException e) {
           
            System.out.println("Error File");
        }

        
        return words.toArray(new String[0]);
    }

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean playAgain = true;

        System.out.println("Welcome to Hangman!");
        while (playAgain) {
            playRound(scanner, random);
            System.out.print("Play again? (y/n): ");
        
            playAgain = scanner.nextLine().trim().equalsIgnoreCase("y");
        }

        System.out.println("Thanks for playing!");
        scanner.close();
    }

    private static void playRound(Scanner scanner, Random random) {
        if (Words.length == 0) {
            System.out.println("No words available to play.");
            return;
        }

        
        String word = Words[random.nextInt(Words.length)];
        
        String guessedWord = "";
        for (int i = 0; i < word.length(); i++) {
            char character = word.charAt(i);
            guessedWord += character == '-' ? '-' : '_';
        }

        String guessedLetters = "";
        int mistakes = 0;

        
        while (mistakes < Mistakes && !word.equals(guessedWord)) {
            printGameState(guessedWord, mistakes);
            System.out.print("Guess a letter: ");
            String input = scanner.nextLine().trim().toLowerCase();


            if (input.length() != 1 || input.charAt(0) < 'a' || input.charAt(0) > 'z') {
                System.out.println("Please enter one letter (a-z).");
                continue;
            }

            char guess = input.charAt(0);
        
            if (guessedLetters.contains(input)) {
                System.out.println("You already guessed that letter.");
                continue;
            }
            guessedLetters += guess;

            boolean found = false;
            String newGuessedWord = "";
            // Visit each character position and reveal every match.
            for (int i = 0; i < word.length(); i++) {
                if (word.charAt(i) == guess) {
                    newGuessedWord += guess;
                    found = true;
                } else {
                    newGuessedWord += guessedWord.charAt(i);
                }
            }
            guessedWord = newGuessedWord;

            if (!found) {
                mistakes++;
                System.out.println("That letter isn't in the word.");
            }
        }

        printGameState(guessedWord, mistakes);
        if (mistakes == Mistakes) {
            System.out.println("You lost! The word was: " + word);
        } else {
            System.out.println("You won! The word was: " + word);
        }
    }

    // Print the current drawing, word progress, and mistakes remaining.
    private static void printGameState(String guessedWord, int mistakes) {
        System.out.println();
        System.out.println(Drawings[mistakes]);
        System.out.println("Word: " + guessedWord);
        System.out.println("Mistakes remaining: " + (Mistakes - mistakes));
    }
}
