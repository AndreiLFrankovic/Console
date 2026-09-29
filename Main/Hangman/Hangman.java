package Hangman;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;  

public class Hangman 
   

{
    private static List<String> words = new ArrayList<>();

    public static List<String> loadWords(String filePath) {
        List<String> words = new ArrayList<>();
    
        
    
    try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) 
            {
                line = line.trim();
                if (!line.isEmpty())
                {
                    words.add(line.toLowerCase());
                }
            }
      } catch (IOException e) {
            System.err.println("Error readinf file: " + e.getMessage()); 
      }
      return words;
    }

    public static String chooseRandomWord(List<String> words)
    {
        Random rand = new Random();
        return words.get(rand.nextInt(words.size()));
    }

    public static void playGame(List<String> words)
    {
        String secretWord = chooseRandomWord(words);
        Set<Character> guessedLetters = new HashSet<>();
        int attemptsLeft = 6;

        Scanner scanner = new Scanner(System.in);

        

        while (attemptsLeft > 0) {
           
            StringBuilder display = new StringBuilder();
            boolean allRevealed = true;

            for (char c : secretWord.toCharArray()) {
                if (guessedLetters.contains(c)) {
                    display.append(c).append(" ");
                } else {
                    display.append("_ ");
                    allRevealed = false;
                }
            }
            System.out.println(display);
            break;
        }
        scanner.close();
    }

      public static class PlayerData
     {
        String soemthing;
        int Hangscore;
        int wins;
        int losses;
        
    public PlayerData (String soemthing)
    {
        this.soemthing = soemthing;
        
        this.wins = 0;
        this.losses = 0;
  
    }
    static ArrayList<PlayerData> Variables = new ArrayList<PlayerData>();
    static PlayerData player1 = new PlayerData("player1");
    static PlayerData player2;
    public static void main(String[] args )
   {
     String filePath = "C:/Users/frankovica/Downloads/words.txt";
        words = loadWords(filePath);

        if (words.isEmpty()) {
            System.out.println("Loading Words");
            return;
        }

        Menu();    
   }
   public static void Menu()
   {
        
        System.out.println("Welcome to Hangman!");

        System.out.println(" _______________________ ");
        System.out.println("           ||           |  ");
        System.out.println("           ||           | ");
        System.out.println("          _||_          |   ");
        System.out.println("         |.  .|         |    ");
        System.out.println("         |____|         | ");
        System.out.println("        ___||___        |      ");
        System.out.println("      /|        |\\      |   ");
        System.out.println("     //|        |\\\\     |   ");
        System.out.println("    // |        | \\\\    |      ");
        System.out.println("   ##  |________|  ##   |      ");
        System.out.println("        | |  | |        |   ");
        System.out.println("        | |  | |        |   ");
        System.out.println("       _| |  | |_       |      ");
        System.out.println("      /___|  |___\\      |      ");
        System.out.println("                        |   ");
        System.out.println("                        |   ");
        System.out.println("                        |      ");
        System.out.println("                        |      ");

        System.out.println("Type 0 To Play Full Game");
        System.out.println("Type 1 To Play Easy Difficulty ");
        
        System.out.println("Type 2 To Play Hard Difficulty ");
        System.out.println("Type 3 To Play Insane Difficulty ");

        System.out.println("Type 4 For Help");
        System.out.println("Type 5 To Reset Scores");
        System.out.println("Type 6 For Stats");
        Scanner checking = new Scanner(System.in);
        int choice = checking.nextInt();
        if (choice == 0)
        {
            FullGame();
        }
        if (choice == 1)
        {
            EasyMode();
        }
      
        else if (choice == 2)
        {
            HardMode();
        }
        else if (choice == 3)
        {
            InsaneMode();
        }
        else if (choice == 4)
        {
            Help();
        }
       
        else 
        {
            System.out.println("Invalid Input, Returning to Menu.");
            Menu();
        }

   }

    public static void FullGame()
    {
        String secretWord = chooseRandomWord(words);
        Set<Character> guessedLetters = new HashSet<>();
        int attemptsLeft = 7;
        Scanner scanner = new Scanner(System.in);

        while (attemptsLeft > 0)
        {
            StringBuilder display = new StringBuilder();
            boolean allRevealed = true;
            for (char c : secretWord.toCharArray()) {
                if (guessedLetters.contains(c)) {
                    display.append(c).append(' ');
                } else {
                    display.append("_ ");
                    allRevealed = false;
                }
            }
            
            System.out.println("Word: " + display);
            System.out.println("Attempts left: " + attemptsLeft);
            System.out.print("Guess a letter: ");

            String input = scanner.nextLine().toLowerCase();

            if (input.length() != 1 || !Character.isLetter(input.charAt(0))) {
              
                System.out.println("Please enter a single letter.");
                continue;
            }
              char guess = input.charAt(0);

            if (guessedLetters.contains(guess)) {
                System.out.println("You already guessed that letter.");
                continue;
            }

            guessedLetters.add(guess);

            if (secretWord.indexOf(guess) >= 0) {
                System.out.println("Correct!");
                  if (attemptsLeft == 7)
                {
                    DrawHangmanV1();
                }
                 if (attemptsLeft == 6)
                {
                    DrawHangmanV2();
                }
                 if (attemptsLeft == 5)
                {
                    DrawHangmanV3();
                }
                 if (attemptsLeft == 4)
                {
                    DrawHangmanV4();
                }
                 if (attemptsLeft == 3)
                {
                    DrawHangmanV5();
                }
                 if (attemptsLeft == 2)
                {
                    DrawHangmanV6();
                }
                 if (attemptsLeft == 1)
                {
                    DrawHangmanV7();
                }
                 if (attemptsLeft == 0)
                {
                    DrawHangmanV8();
                }
                
            } else {
                attemptsLeft--;
                if (attemptsLeft == 7)
                {
                    DrawHangmanV1();
                }
                 if (attemptsLeft == 6)
                {
                    DrawHangmanV2();
                }
                 if (attemptsLeft == 5)
                {
                    DrawHangmanV3();
                }
                 if (attemptsLeft == 4)
                {
                    DrawHangmanV4();
                }
                 if (attemptsLeft == 3)
                {
                    DrawHangmanV5();
                }
                 if (attemptsLeft == 2)
                {
                    DrawHangmanV6();
                }
                 if (attemptsLeft == 1)
                {
                    DrawHangmanV7();
                }
                if (attemptsLeft == 0)
                {
                    DrawHangmanV8();
                }
                
                System.out.println("Wrong!");
                
            }

            if (allRevealed) {
                System.out.println("You win! The word was: " + secretWord);
                return;
            }
        }

        System.out.println("You lost! The word was: " + secretWord);
    }
}
      public static void EasyMode()
   {
    String secretWord = chooseRandomWord(words);
        Set<Character> guessedLetters = new HashSet<>();
        int attemptsLeft = 14;
        Scanner scanner = new Scanner(System.in);

        while (attemptsLeft > 0)
        {
            StringBuilder display = new StringBuilder();
            boolean allRevealed = true;
            for (char c : secretWord.toCharArray()) {
                if (guessedLetters.contains(c)) {
                    display.append(c).append(' ');
                } else {
                    display.append("_ ");
                    allRevealed = false;
                }
            }
            System.out.println("Word: " + display);
            System.out.println("Attempts left: " + attemptsLeft);
            System.out.print("Guess a letter: ");

            String input = scanner.nextLine().toLowerCase();

            if (input.length() != 1 || !Character.isLetter(input.charAt(0))) {
              
                System.out.println("Please enter a single letter.");
                continue;
            }
              char guess = input.charAt(0);

            if (guessedLetters.contains(guess)) {
                System.out.println("You already guessed that letter.");
                continue;
            }

            guessedLetters.add(guess);

            if (secretWord.indexOf(guess) >= 0) {
                System.out.println("Correct!");
                  if (attemptsLeft == 14)
                {
                    DrawHangmanV1();
                }
                 if (attemptsLeft == 12)
                {
                    DrawHangmanV2();
                }
                 if (attemptsLeft == 10)
                {
                    DrawHangmanV3();
                }
                 if (attemptsLeft == 8)
                {
                    DrawHangmanV4();
                }
                 if (attemptsLeft == 6)
                {
                    DrawHangmanV5();
                }
                 if (attemptsLeft == 4)
                {
                    DrawHangmanV6();
                }
                 if (attemptsLeft == 2)
                {
                    DrawHangmanV7();
                }
                 if (attemptsLeft == 0)
                {
                    DrawHangmanV8();
                }
                
            } else {
                attemptsLeft--;
                if (attemptsLeft == 14)
                {
                    DrawHangmanV1();
                }
                 if (attemptsLeft == 12)
                {
                    DrawHangmanV2();
                }
                 if (attemptsLeft == 10)
                {
                    DrawHangmanV3();
                }
                 if (attemptsLeft == 8)
                {
                    DrawHangmanV4();
                }
                 if (attemptsLeft == 6)
                {
                    DrawHangmanV5();
                }
                 if (attemptsLeft == 4)
                {
                    DrawHangmanV6();
                }
                 if (attemptsLeft == 2)
                {
                    DrawHangmanV7();
                }
                if (attemptsLeft == 0)
                {
                    DrawHangmanV8();
                }
                System.out.println("Wrong!");
                
            }

            if (allRevealed) {
                System.out.println("You win! The word was: " + secretWord);
                return;
            }
        }

        System.out.println("You lost! The word was: " + secretWord);
    }

  
    public static void HardMode()
   {
        String secretWord = chooseRandomWord(words);
        Set<Character> guessedLetters = new HashSet<>();
        int attemptsLeft = 6;
        Scanner scanner = new Scanner(System.in);

        while (attemptsLeft > 0)
        {
            StringBuilder display = new StringBuilder();
            boolean allRevealed = true;
            for (char c : secretWord.toCharArray()) {
                if (guessedLetters.contains(c)) {
                    display.append(c).append(' ');
                } else {
                    display.append("_ ");
                    allRevealed = false;
                }
            }
            System.out.println("Word: " + display);
            System.out.println("Attempts left: " + attemptsLeft);
            System.out.print("Guess a letter: ");

            String input = scanner.nextLine().toLowerCase();

            if (input.length() != 1 || !Character.isLetter(input.charAt(0))) {
              
                System.out.println("Please enter a single letter.");
                continue;
            }
              char guess = input.charAt(0);

            if (guessedLetters.contains(guess)) {
                System.out.println("You already guessed that letter.");
                continue;
            }

            guessedLetters.add(guess);

            if (secretWord.indexOf(guess) >= 0) {
                System.out.println("Correct!");
               
                 if (attemptsLeft == 6)
                {
                    DrawHangmanV2();
                }
                 if (attemptsLeft == 5)
                {
                    DrawHangmanV3();
                }
                 if (attemptsLeft == 4)
                {
                    DrawHangmanV4();
                }
                 if (attemptsLeft == 3)
                {
                    DrawHangmanV5();
                }
                 if (attemptsLeft == 2)
                {
                    DrawHangmanV6();
                }
                 if (attemptsLeft == 1)
                {
                    DrawHangmanV7();
                }
                 if (attemptsLeft == 0)
                {
                    DrawHangmanV8();
                }
                
            } else {
                attemptsLeft--;
               
                 if (attemptsLeft == 6)
                {
                    DrawHangmanV2();
                }
                 if (attemptsLeft == 5)
                {
                    DrawHangmanV3();
                }
                 if (attemptsLeft == 4)
                {
                    DrawHangmanV4();
                }
                 if (attemptsLeft == 3)
                {
                    DrawHangmanV5();
                }
                 if (attemptsLeft == 2)
                {
                    DrawHangmanV6();
                }
                 if (attemptsLeft == 1)
                {
                    DrawHangmanV7();
                }
                if (attemptsLeft == 0)
                {
                    DrawHangmanV8();
                }
                System.out.println("Wrong!");
                
            }

            if (allRevealed) {
                System.out.println("You win! The word was: " + secretWord);
                return;
            }
        }

        System.out.println("You lost! The word was: " + secretWord);
    }

   
    public static void InsaneMode()
   {
    String secretWord = chooseRandomWord(words);
        Set<Character> guessedLetters = new HashSet<>();
        int attemptsLeft = 3;
        Scanner scanner = new Scanner(System.in);

        while (attemptsLeft > 0)
        {
            StringBuilder display = new StringBuilder();
            boolean allRevealed = true;
            for (char c : secretWord.toCharArray()) {
                if (guessedLetters.contains(c)) {
                    display.append(c).append(' ');
                } else {
                    display.append("_ ");
                    allRevealed = false;
                }
            }
            System.out.println("Word: " + display);
            System.out.println("Attempts left: " + attemptsLeft);
            System.out.print("Guess a letter: ");

            String input = scanner.nextLine().toLowerCase();

            if (input.length() != 1 || !Character.isLetter(input.charAt(0))) {
              
                System.out.println("Please enter a single letter.");
                continue;
            }
              char guess = input.charAt(0);

            if (guessedLetters.contains(guess)) {
                System.out.println("You already guessed that letter.");
                continue;
            }

            guessedLetters.add(guess);

            if (secretWord.indexOf(guess) >= 0) {
                System.out.println("Correct!");
               
              
                 if (attemptsLeft == 3)
                {
                    DrawHangmanV5();
                }
                 if (attemptsLeft == 2)
                {
                    DrawHangmanV6();
                }
                 if (attemptsLeft == 1)
                {
                    DrawHangmanV7();
                }
                 if (attemptsLeft == 0)
                {
                    DrawHangmanV8();
                }
                
            } else {
                attemptsLeft--;
               
                
                 if (attemptsLeft == 3)
                {
                    DrawHangmanV5();
                }
                 if (attemptsLeft == 2)
                {
                    DrawHangmanV6();
                }
                 if (attemptsLeft == 1)
                {
                    DrawHangmanV7();
                }
                if (attemptsLeft == 0)
                {
                    DrawHangmanV8();
                }
                System.out.println("Wrong!");
                
            }

            if (allRevealed) {
                System.out.println("You win! The word was: " + secretWord);
                return;
            }
        }

        System.out.println("You lost! The word was: " + secretWord);
    }
        
    
   
  
   public static void Help()
   {
    System.out.println("Here is how to play Hangman");
    System.out.println("You will have 7 guesses in the full unmodifed version of the game");
    System.out.println("In the full version you will lose the game if you guess 7 times. Try to guess the full word with as little mistakes as possible");
    System.out.println("There are also 3 different difficulties; Easy, Hard, and Insane. Each mode eother increases or reduces your number of guesses to make the game significantly harder.");
    System.out.println("To play simply type ansd enter the humber of the gamemod that you wish to play, then simply type a letter and enter it to see if you were correct.");
   }
  
   public static void DrawHangmanV8()
   {
        System.out.println(" _______________________ ");
        System.out.println("           ||           |  ");
        System.out.println("           ||           | ");
        System.out.println("          _||_          |   ");
        System.out.println("         |.  .|         |    ");
        System.out.println("         |____|         | ");
        System.out.println("        ___||___        |      ");
        System.out.println("      /|        |\\      |   ");
        System.out.println("     //|        |\\\\     |   ");
        System.out.println("    // |        | \\\\    |      ");
        System.out.println("   ##  |________|  ##   |      ");
        System.out.println("        | |  | |        |   ");
        System.out.println("        | |  | |        |   ");
        System.out.println("       _| |  | |_       |      ");
        System.out.println("      /___|  |___\\      |      ");
        System.out.println("                        |   ");
        System.out.println("                        |   ");
        System.out.println("                        |      ");
        System.out.println("                        |      ");
   }
   public static void DrawHangmanV7()
    {
        System.out.println(" _______________________  ");
        System.out.println("                        |  ");
        System.out.println("                        | ");
        System.out.println("          ____          |   ");
        System.out.println("         |.  .|         |    ");
        System.out.println("         |____|         | ");
        System.out.println("        ___||___        |      ");
        System.out.println("      /|        |\\      |   ");
        System.out.println("     //|        |\\\\     |   ");
        System.out.println("    // |        | \\\\    |      ");
        System.out.println("   ##  |________|  ##   |      ");
        System.out.println("        | |  | |        |   ");
        System.out.println("        | |  | |        |   ");
        System.out.println("       _| |  | |_       |      ");
        System.out.println("      /___|  |___\\      |      ");
        System.out.println("                        |   ");
        System.out.println("                        |   ");
        System.out.println("                        |      ");
        System.out.println("                        |      ");

 
        
        
        
        
    }
    public static void DrawHangmanV6()
    {
        System.out.println(" _______________________  ");
        System.out.println("                        |  ");
        System.out.println("                        | ");
        System.out.println("          ____          |   ");
        System.out.println("         |.  .|         |    ");
        System.out.println("         |____|         | ");
        System.out.println("        ___||___        |      ");
        System.out.println("      /|        |\\      |   ");
        System.out.println("     //|        |\\\\     |   ");
        System.out.println("    // |        | \\\\    |      ");
        System.out.println("   ##  |________|  ##   |      ");
        System.out.println("        | |             |   ");
        System.out.println("        | |             |   ");
        System.out.println("       _| |             |      ");
        System.out.println("      /___|             |      ");
        System.out.println("                        |   ");
        System.out.println("                        |   ");
        System.out.println("                        |      ");
        System.out.println("                        |      ");

     
    }
    public static void DrawHangmanV5()
    {
        System.out.println(" _______________________  ");
        System.out.println("                        |  ");
        System.out.println("                        | ");
        System.out.println("          ____          |   ");
        System.out.println("         |.  .|         |    ");
        System.out.println("         |____|         | ");
        System.out.println("        ___||___        |      ");
        System.out.println("      /|        |\\      |   ");
        System.out.println("     //|        |\\\\     |   ");
        System.out.println("    // |        | \\\\    |      ");
        System.out.println("   ##  |________|  ##   |      ");
        System.out.println("                        |   ");
        System.out.println("                        |   ");
        System.out.println("                        |      ");
        System.out.println("                        |      ");
        System.out.println("                        |   ");
        System.out.println("                        |   ");
        System.out.println("                        |      ");
        System.out.println("                        |      ");


      
   
    }
    public static void DrawHangmanV4()
    {
        System.out.println(" _______________________  ");
        System.out.println("                        |  ");
        System.out.println("                        | ");
        System.out.println("          ____          |   ");
        System.out.println("         |.  .|         |    ");
        System.out.println("         |____|         | ");
        System.out.println("        ___||___        |      ");
        System.out.println("      /|        |       |   ");
        System.out.println("     //|        |       |   ");
        System.out.println("    // |        |       |      ");
        System.out.println("   ##  |________|       |      ");
        System.out.println("                        |   ");
        System.out.println("                        |   ");
        System.out.println("                        |      ");
        System.out.println("                        |      ");
        System.out.println("                        |   ");
        System.out.println("                        |   ");
        System.out.println("                        |      ");
        System.out.println("                        |      ");

  
    }
    public static void DrawHangmanV3()
    {
        System.out.println(" _______________________  ");
        System.out.println("                        |  ");
        System.out.println("                        | ");
        System.out.println("          ____          |   ");
        System.out.println("         |.  .|         |    ");
        System.out.println("         |____|         | ");
        System.out.println("        ___||___        |      ");
        System.out.println("       |        |       |   ");
        System.out.println("       |        |       |   ");
        System.out.println("       |        |       |      ");
        System.out.println("       |________|       |      ");
        System.out.println("                        |   ");
        System.out.println("                        |   ");
        System.out.println("                        |      ");
        System.out.println("                        |      ");
        System.out.println("                        |   ");
        System.out.println("                        |   ");
        System.out.println("                        |      ");
        System.out.println("                        |      ");

  
    }
    public static void DrawHangmanV2()
    {
        System.out.println(" _______________________  ");
        System.out.println("                        |  ");
        System.out.println("                        | ");
        System.out.println("          ____          |   ");
        System.out.println("         |.  .|         |    ");
        System.out.println("         |____|         | ");
        System.out.println("                        |      ");
        System.out.println("                        |   ");
        System.out.println("                        |   ");
        System.out.println("                        |      ");
        System.out.println("                        |      ");
        System.out.println("                        |   ");
        System.out.println("                        |   ");
        System.out.println("                        |      ");
        System.out.println("                        |      ");
        System.out.println("                        |   ");
        System.out.println("                        |   ");
        System.out.println("                        |      ");
        System.out.println("                        |      ");

    }
    public static void DrawHangmanV1()//Pole
    {
        
        System.out.println(" _______________________  ");
        System.out.println("                        |  ");
        System.out.println("                        | ");
        System.out.println("                        |   ");
        System.out.println("                        |    ");
        System.out.println("                        | ");
        System.out.println("                        |      ");
        System.out.println("                        |   ");
        System.out.println("                        |   ");
        System.out.println("                        |      ");
        System.out.println("                        |      ");
        System.out.println("                        |   ");
        System.out.println("                        |   ");
        System.out.println("                        |      ");
        System.out.println("                        |      ");
        System.out.println("                        |   ");
        System.out.println("                        |   ");
        System.out.println("                        |      ");
        System.out.println("                        |      ");
    
    }
    public static void PrivacyScreen()
    {
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
           System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
         System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
        System.out.println("#######################################################################################################################################################");
   
    }
}

