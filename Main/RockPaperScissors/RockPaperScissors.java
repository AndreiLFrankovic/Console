package RockPaperScissors;
//Andrei Frankovic 

//Rock, Paper, Scissors 

//Project Oveview

//This program is a Rock, Paper, Scissors game. It has
// simmulation runds, rounds where a person plays against the
// compter, and rounds where two peple play against each other. The mnu
//has all of these opions for one rond or mltiple rounds, resetting scores,
//help, and vieing score. Text-art draings of rock, aper, and scissrs are printed.

// How it Wrks
// The menu lets you choose a simulation, play against the computer, play with
// another person, reset scres, get help, or view scores.
//
// In each round, rock beats scissors, scissors beats paper, and paper beats
// rock. Mathes tie. Simulatins chooe moves autom the other
// modes ask players to choose. Scores update after each round.
//
// PlayerData stores player scores and statisics while the program runs. The
// drawing methods print the game artwork.
// How te scanner works Scanner rads
//  static lets evertyhing use this Scanner
// final makes it so it can be changed. 
// the list stores al of the data and it tracks the variabes andit will ten store the data and set the numers to 0.
import java.util.ArrayList;
import java.util.Scanner;

public class RockPaperScissors {

    private static final Scanner checking = new Scanner(System.in);

    public static void TiesWin() {
        System.out.println("Tie!");
        player1.ties++;
        System.out.println("Ties: " + player1.ties);
        System.out.println("Computer Wins: " + player1.compscore);
        System.out.println("Player Wins: " + player1.score);

    }

    public static void ComputerWin() {
        System.out.println("Computer Wins!");
        player1.compscore++;
        System.out.println("Computer Wins: " + player1.compscore);
        System.out.println("Player Wins: " + player1.score);
        System.out.println("Ties: " + player1.ties);
    }

    public static void PlayerWin() {
        System.out.println("Player Wins!");
        player1.score++;
        System.out.println("Ties: " + player1.ties);
        System.out.println("Computer Wins: " + player1.compscore);
        System.out.println("Player Wins: " + player1.score);
        System.out.println("Player 2 Wins: " + player2.score);

    }

    public static void Player2Win() {
        System.out.println("Player 2 Wins!");
        player2.score++;
        System.out.println("Ties: " + player1.ties);
        System.out.println("Computer Wins: " + player1.compscore);
        System.out.println("Player Wins: " + player1.score);
        System.out.println("Player 2 Wins: " + player2.score);
    }

    public static class PlayerData {

        String soemthing;
        int score;

        int wins;

        int losses;

        int ties;

        int compscore;

        int simplayer;

        public PlayerData(String soemthing) {

            this.soemthing = soemthing;

            this.score = 0;
            this.wins = 0;
            this.losses = 0;
            this.ties = 0;

            this.compscore = 0;
            this.simplayer = 0;
        }
    }

    static ArrayList<PlayerData> Variables = new ArrayList<PlayerData>();
    static PlayerData player1 = new PlayerData("Player 1");
    static PlayerData player2 = new PlayerData("Player 2");

    public static void main(String[] args) {

        DrawRockBasic();
        DrawScissorsBasic();
        DrawPaperBasic();
        Menu();
    }

    public static void Menu() {
        while (true) {

            System.out.println("Welcome to Rock Paper Scissors!");
            System.out.println("Press 1 to play 1 round of simulation mode");
            System.out.println("Press 2 to play multiple rounds of simulation mode ");
            System.out.println("Press 3 to play 1v1 Computer mode");
            System.out.println("Press 4 to play multiple rounds of 1v1 against Computer");
            System.out.println("Press 5 to play 1v1");
            System.out.println("Press 6 to play multiple rounds of 1v1");
            System.out.println("Press 7 to reset scores");
            System.out.println("Press 8 for help");
            System.out.println("Press 9 for stats");
            System.out.println("Press 10 to exit");

            int choice;
            try {
                choice = Integer.parseInt(checking.next());
            } catch (NumberFormatException bad) {
                System.out.println("Invalid input. Please enter a number between 1 and 10.");
                continue;
            }
            if (choice < 1 || choice > 10) {
                System.out.println("Invalid input. Please enter a number between 1 and 10.");
                continue;
            }

            if (choice == 1) {
                PlayGame();

            } else if (choice == 2) {
                int rounds = readPositiveRoundCount();
                for (int i = 0; i < rounds; i++) {
                    PlayGame();
                }

            } else if (choice == 3) {
                PlayGameRPSC();

            } else if (choice == 4) {
                int rounds = readPositiveRoundCount();
                for (int i = 0; i < rounds; i++) {
                    PlayGameRPSC();
                }

            } else if (choice == 5) {
                PlayGame1v1();
                if (!ReturnToMenuPrompt()) {
                    return;
                }

            } else if (choice == 6) {
                int rounds = readPositiveRoundCount();
                for (int i = 0; i < rounds; i++) {
                    PlayGame1v1();
                }
                if (!ReturnToMenuPrompt()) {
                    return;
                }

            } else if (choice == 7) {
                System.out.println("Reset Scores");
                System.out.println("Are you sure you want to reset the scores? (yes/no)");
                String resetChoice = checking.next();
                if (resetChoice.equalsIgnoreCase("yes")) {
                    Reset();
                    System.out.println("Scores have been reset.");

                } else if (resetChoice.equalsIgnoreCase("no")) {
                    System.out.println("Scores have not been reset.");

                } else {
                    System.out.println("Invalid input. Scores have not been reset.");

                }

            } else if (choice == 8) {

                System.out.println("Help Menu");
                System.out.println(
                        "In this game, you can play Rock Paper Scissors against the computer or simulate games or play against another player.");
                System.out.println("You can choose to play a single round or multiple rounds.");
                System.out.println("The scores will be displayed after each round.");
                System.out.println("You can reset the scores at any time by selecting the reset option.");
                System.out
                        .println("To play, simply type rock, paper, or scissors when asked. It is not case sensitive.");
                System.out.println("Have fun!");
                System.out.println("Return to menu? (yes/no)");
                String returnToMenu = checking.next();
                if (returnToMenu.equalsIgnoreCase("yes")) {

                } else if (returnToMenu.equalsIgnoreCase("no")) {
                    System.out.println("");
                } else {

                    System.out.println("Invalid input.");

                }

            } else if (choice == 9) {
                System.out.println("Stats Menu");
                System.out.println("Player Wins: " + player1.score);
                System.out.println("Computer Wins: " + player1.compscore);
                System.out.println("Ties: " + player1.ties);
                System.out.println("Player 2 Wins: " + player2.score);
                System.out.println("Simulation Player Wins: " + player1.simplayer);

                System.out.println("Return to menu? (Yes/No?)");
                String returnToMenu = checking.next();
                if (returnToMenu.equalsIgnoreCase("yes")) {

                } else if (returnToMenu.equalsIgnoreCase("no")) {
                    System.out.println("");
                } else {
                    System.out.println("Invalid input.");
                    System.out.println("Return to menu? (Yes/No?)");
                }

            } else if (choice == 10) {
                System.out.println("Ended Program");
                return;
            }
        }

    }

    public static void Reset() {
        player1.score = 0;
        player1.wins = 0;
        player1.losses = 0;
        player1.ties = 0;
        player1.compscore = 0;
        player1.simplayer = 0;

        player2.score = 0;
        player2.wins = 0;
        player2.losses = 0;
        player2.ties = 0;
        player2.compscore = 0;
        player2.simplayer = 0;
    }

    public static int readPositiveRoundCount() {
        while (true) {
            System.out.println("How many rounds would you like to play?");
            try {
                int rounds = Integer.parseInt(checking.next());
                if (rounds >= 1) {
                    return rounds;
                }
                System.out.println("Invalid input. Please enter a whole number greater than 0.");
            } catch (NumberFormatException bad) {
                System.out.println("Invalid input. Please enter a whole number greater than 0.");
            }
        }
    }

    private static boolean ReturnToMenuPrompt() {
        while (true) {
            System.out.println("Return to menu? (yes/no)");
            String answer = checking.next();
            if (answer.equalsIgnoreCase("yes")) {
                return true;
            }
            if (answer.equalsIgnoreCase("no")) {
                return false;
            }
            System.out.println("Invalid input. Please enter yes or no.");
        }
    }

    public static void PlayGameRPSC() {
        int randomcompNumber = (int) (Math.random() * 3) + 1;
        System.out.println("Rock, Paper, or Scissors?");
        String word = checking.next();

        while (!word.equalsIgnoreCase("rock")
                && !word.equalsIgnoreCase("paper")
                && !word.equalsIgnoreCase("scissors")) {
            System.out.println("Invalid input. Please enter rock, paper, or scissors.");
            word = checking.next();
        }

        if (word.equalsIgnoreCase("rock")) {
            DrawRockBasic();
        } else if (word.equalsIgnoreCase("paper")) {
            DrawPaperBasic();
        } else {
            DrawScissorsBasic();
        }

        DrawVSBasic();
        System.out.println("Computer");
        if (randomcompNumber == 1) {
            DrawRockBasic();
            System.out.println("Computer chose Rock.");
        } else if (randomcompNumber == 2) {
            DrawPaperBasic();
            System.out.println("Computer chose Paper.");
        } else {
            DrawScissorsBasic();
            System.out.println("Computer chose Scissors.");
        }

        int playerNumber = word.equalsIgnoreCase("rock") ? 1
                : word.equalsIgnoreCase("paper") ? 2 : 3;
        if (playerNumber == randomcompNumber) {
            System.out.println("It's a tie!");
            player1.ties++;
        } else if ((playerNumber == 1 && randomcompNumber == 3)
                || (playerNumber == 2 && randomcompNumber == 1)
                || (playerNumber == 3 && randomcompNumber == 2)) {
            System.out.println("Player wins!");
            player1.score++;
        } else {
            System.out.println("Computer wins!");
            player1.compscore++;
        }

        System.out.println("Player Wins: " + player1.score);
        System.out.println("Computer Wins: " + player1.compscore);
        System.out.println("Ties: " + player1.ties);
    }

    public static void PlayGame1v1() {
        System.out.println(" Rock, Paper, or Scissors? ");
        String P1word = checking.next();
        while (!P1word.equalsIgnoreCase("rock")
                && !P1word.equalsIgnoreCase("paper")
                && !P1word.equalsIgnoreCase("scissors")) {
            System.out.println("Invalid input. Please enter rock, paper, or scissors.");
            P1word = checking.next();
        }
        DrawBarrier();
        System.out.println(" Rock, Paper, or Scissors? ");
        String P2word = checking.next();
        while (!P2word.equalsIgnoreCase("rock")
                && !P2word.equalsIgnoreCase("paper")
                && !P2word.equalsIgnoreCase("scissors")) {
            System.out.println("Invalid input. Please enter rock, paper, or scissors.");
            P2word = checking.next();
        }

        if (P1word.equalsIgnoreCase("rock") && P2word.equalsIgnoreCase("rock")) {
            System.out.println("Player 1 chose Rock");
            DrawRockBasic();
            DrawVSBasic();
            System.out.println("Player 2 chose Rock");
            DrawRockBasic();
            TiesWin();
        } else if (P1word.equalsIgnoreCase("rock") && P2word.equalsIgnoreCase("paper")) {
            System.out.println("Player 1 chose Rock");
            DrawRockBasic();
            DrawVSBasic();
            System.out.println("Player 2 chose Paper");
            DrawPaperBasic();

            Player2Win();

        } else if (P1word.equalsIgnoreCase("rock") && P2word.equalsIgnoreCase("scissors")) {
            System.out.println("Player 1 chose Rock");
            DrawRockBasic();
            DrawVSBasic();
            System.out.println("Player 2 chose Scissors");
            DrawScissorsBasic();

            PlayerWin();
        } else if (P1word.equalsIgnoreCase("paper") && P2word.equalsIgnoreCase("rock")) {
            System.out.println("Player 1 chose Paper");
            DrawPaperBasic();
            DrawVSBasic();
            System.out.println("Player 2 chose Rock");
            DrawRockBasic();

            PlayerWin();
        } else if (P1word.equalsIgnoreCase("paper") && P2word.equalsIgnoreCase("paper")) {
            System.out.println("Player 1 chose Paper");
            DrawPaperBasic();
            DrawVSBasic();
            System.out.println("Player 2 chose Paper");
            DrawPaperBasic();

            TiesWin();

        } else if (P1word.equalsIgnoreCase("paper") && P2word.equalsIgnoreCase("scissors")) {
            System.out.println("Player 1 chose Paper");
            DrawPaperBasic();
            DrawVSBasic();
            System.out.println("Player 2 chose Scissors");
            DrawScissorsBasic();

            Player2Win();
        } else if (P1word.equalsIgnoreCase("scissors") && P2word.equalsIgnoreCase("rock")) {
            System.out.println("Player 1 chose Scissors");
            DrawScissorsBasic();
            DrawVSBasic();
            System.out.println("Player 2 chose Rock");
            DrawRockBasic();

            Player2Win();
        } else if (P1word.equalsIgnoreCase("scissors") && P2word.equalsIgnoreCase("paper")) {
            System.out.println("Player 1 chose Scissors");
            DrawScissorsBasic();
            DrawVSBasic();
            System.out.println("Player 2 chose Paper");
            DrawPaperBasic();

            PlayerWin();
        } else if (P1word.equalsIgnoreCase("scissors") && P2word.equalsIgnoreCase("scissors")) {
            System.out.println("Player 1 chose Scissors");
            DrawScissorsBasic();
            DrawVSBasic();
            System.out.println("Player 2 chose Scissors");
            DrawScissorsBasic();

            TiesWin();
        } else {

        }

    }

    public static void PlayGame() {

        int randomplayerNumber = (int) (Math.random() * 3) + 1;
        int randomcomputerNumber = (int) (Math.random() * 3) + 1;
        if (randomcomputerNumber == 1) {
            System.out.println("  Computer   ");
            DrawRockBasic();
            DrawVSBasic();
        } else if (randomcomputerNumber == 2) {
            System.out.println("  Computer   ");
            DrawPaperBasic();
            DrawVSBasic();
        } else if (randomcomputerNumber == 3) {
            System.out.println("  Computer   ");
            DrawScissorsBasic();
            DrawVSBasic();
        }
        if (randomplayerNumber == 1) {
            DrawRockBasic();

            if (randomcomputerNumber == 1 && randomplayerNumber == 1) {
                TiesWin();

            }
            if (randomcomputerNumber == 2 && randomplayerNumber == 1)

            {

                ComputerWin();
            }

            if (randomcomputerNumber == 3 && randomplayerNumber == 1)

            {

                PlayerWin();
            }
        }

        else if (randomplayerNumber == 2) {
            DrawPaperBasic();

            if (randomcomputerNumber == 2 && randomplayerNumber == 2)

            {

                TiesWin();

            }

            if (randomcomputerNumber == 3 && randomplayerNumber == 2)

            {

                ComputerWin();

            }

            if (randomcomputerNumber == 1 && randomplayerNumber == 2)

            {

                PlayerWin();
            }
        }

        else if (randomplayerNumber == 3) {
            DrawScissorsBasic();

            if (randomcomputerNumber == 3 && randomplayerNumber == 3)

            {

                TiesWin();
            }

            if (randomcomputerNumber == 1 && randomplayerNumber == 3)

            {

                ComputerWin();
            }

            if (randomcomputerNumber == 2 && randomplayerNumber == 3)

            {
                PlayerWin();
            }

        }

    }

    public static void DrawRockBasic()

    {

        System.out.println("          ");
        System.out.println("    ___");
        System.out.println("   |_|_\\");
        System.out.println("  /_|_|_|");
        System.out.println(" /___|__|");
        System.out.println("          ");

    }

    public static void DrawScissorsBasic()

    {

        System.out.println("          ");
        System.out.println(" \\  /");
        System.out.println("  \\/");
        System.out.println("  /\\");
        System.out.println(" 0  0");
        System.out.println("          ");

    }

    public static void DrawPaperBasic()

    {

        System.out.println("          ");
        System.out.println(" _______ ");
        System.out.println("|      \\|");
        System.out.println("|       |");
        System.out.println("|_______|");
        System.out.println("          ");
    }

    public static void DrawVSBasic()

    {

        System.out.println("          ");
        System.out.println("        _");
        System.out.println(" \\  /  |_  ");
        System.out.println("  \\/    _|");
        System.out.println("          ");
        System.out.println("          ");
    }

    public static void DrawBarrier()

    {

        System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
        System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
        System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
        System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
        System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
        System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
        System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||Easter|Egg||||||||||||||");
        System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
        System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
        System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
        System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
        System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
        System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
        System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
        System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
        System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
        System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
        System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
        System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
        System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
        System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
        System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
        System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
        System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
        System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
        System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
        System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
        System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
        System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
        System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
        System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
        System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
        System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
        System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
        System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
        System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
        System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
        System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
        System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
        System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
        System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
        System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
        System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
        System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
        System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
        System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
        System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
        System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");

    }

}
