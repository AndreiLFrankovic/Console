//* Andrei Frakovic     */
//* Rock, Paper, Scissors     */
//*                      */
import java.util.ArrayList;
import java.util.Scanner;
public class RockPaperScissors {
    
   
    public static class PlayerData
     {
        String name;
        int score;
        int wins;
        int losses;
        int ties;
        int compscore;
        int simplayer;
    public PlayerData (String name)
    {
        this.name = name;
        this.score = 0;
        this.wins = 0;
        this.losses = 0;
        this.ties = 0;
        this.compscore = 0;
        this.simplayer = 0;
    }
}
    static ArrayList<PlayerData> Variables = new ArrayList<PlayerData>();
    static PlayerData player1;
    static PlayerData player2;
    public static void main(String[] args) {
      Scanner input = new Scanner(System.in);
      System.out.println("Enter Player 1 name: ");
        String name1 = input.nextLine();
      
      player1 = new PlayerData(name1);

      System.out.println("Enter Player 2 name: ");
        String name2 = input.nextLine();
        player2 = new PlayerData(name2);


        Menu();
     }
    
    public static void Menu( )
    {
         
   
        
        System.out.println("Welcome to Rock Paper Scissors!");
        DrawRockBasic();
        DrawPaperBasic();
        DrawScissorsBasic();
        System.out.println("Press 1 to play 1 round of simulation mode");
        System.out.println("Press 2 to play multiple rounds of simulation mode ");
        System.out.println("Press 3 to play 1v1 Computer mode");
        System.out.println("Press 4 to play multiple rounds of 1v1 against Computer");
        System.out.println("Press 5 to play 1v1");
        System.out.println("Press 6 to play multiple rounds of 1v1");
        System.out.println("Press 7 to reset scores");
        System.out.println("Press 8 for help");
        System.out.println("Press 9 for stats");


        Scanner checking = new Scanner(System.in);
        
        int choice = checking.nextInt();
        if (choice == 1) 
        {
            PlayGame();
        } 
        else if (choice == 2) 
        {
            System.out.println("How many rounds would you like to play?");
            int rounds = checking.nextInt();
            for (int i = 0; i < rounds; i++) 
            {
                PlayGame();
            }
        } 
        else if (choice == 7) 
        {
            System.out.println("Reset Scores");
            System.out.println("Are you sure you want to reset the scores? (yes/no)");
            if (checking.next().equalsIgnoreCase("yes")) 
            {
                System.out.println("Scores have been reset.");
                Menu();
                    player1.score = 0;
                    player2.score = 0;
                    player1.ties = 0;
                    player1.compscore = 0;
                    player1.simplayer = 0;


            } 
            else if (checking.next().equalsIgnoreCase("no")) 
            {
                System.out.println("Scores have not been reset.");
                Menu();
            } 
            else 
            {
                System.out.println("Invalid input. Scores have not been reset.");
                Menu();
            }
      
            
        }
        else if (choice == 3)
        {
            PlayGameRPSC();

        }
        else if (choice == 4)
        {
            System.out.println("How many rounds would you like to play?");
            int rounds = checking.nextInt();
            for (int i = 0; i < rounds; i++) 
            {
                PlayGameRPSC();
            }
        }
        else if (choice == 6)
        {
            System.out.println("How many rounds would you like to play?");
            int rounds = checking.nextInt();
            for (int i = 0; i < rounds; i++) 
            {
                PlayGame1v1();
            }
        }
        else if (choice == 5)
        {
            PlayGame1v1();
        }
        else if (choice == 8)
        {
            
            System.out.println("Help Menu");
            System.out.println("In this game, you can play Rock Paper Scissors against the computer or simulate games or play against another player.");
            System.out.println("You can choose to play a single round or multiple rounds.");
            System.out.println("The scores will be displayed after each round.");
            System.out.println("You can reset the scores at any time by selecting the reset option.");
            System.out.println("To play, simply type rock, paper, or scissors when asked. It is not case sensitive.");
            System.out.println("Have fun!");
            System.out.println("Return to menu? (yes/no)");
            String returnToMenu = checking.next();
            if (returnToMenu.equalsIgnoreCase("yes"))
            {
                Menu();
            }
            else if (returnToMenu.equalsIgnoreCase("no"))
            {
                System.out.println("");
                checking.close();
              
                Menu();
            }
            else
            {
                
                
                    System.out.println("Invalid input.");
                    Menu();
                
                
            
            
        }
    }
        else if (choice == 9)
        {
            System.out.println("Stats Menu");
            System.out.println("Player Wins: " + player1.score);
            System.out.println("Computer Wins: " +  player1.compscore);
            System.out.println("Ties: " + player1.ties);
            System.out.println("Player 2 Wins: " + player2.score);
            System.out.println("Simulation Player Wins: " + player1.simplayer);


            System.out.println("Return to menu? (Yes/No?)");
            String returnToMenu = checking.next();
            if (returnToMenu.equalsIgnoreCase("yes"))
            {
                Menu();
            }
            else if (returnToMenu.equalsIgnoreCase("no"))
            {
                System.out.println("");
                checking.close();
                Menu();
            }
            else
            {
                System.out.println("Invalid input.");
                System.out.println("Return to menu? (Yes/No?)");
            }
        }
        else 
        {
            System.out.println("Invalid choice. Please try again.");
            checking.close();
            Menu();
        }
       

    }   
    public static void PlayGameRPSC()
    {
        
        int randomcompNumber = (int) (Math.random() * 3)+1;
        Scanner checking = new Scanner(System.in);
        System.out.println(" Rock, Paper, or Scissors? ");
        String word = checking.next();
        if (word.equalsIgnoreCase("rock")) 
        
        
            {
            DrawRockBasic();
            DrawVSBasic();
            if (randomcompNumber == 1) 
            {
                System.out.println("  Computer   ");
                DrawRockBasic();
                System.out.println("Computer chose Rock. It's a tie!");
                player1.ties++;
                System.out.println("Ties: " + player1.ties);
                System.out.println("Computer Wins: " + player1.compscore);
                System.out.println("Player Wins: " + player1.score);

            }
            else if (randomcompNumber == 2) 
            {
                System.out.println("  Computer   ");
                DrawPaperBasic();

                System.out.println("Computer chose Paper. Computer wins!");
                player1.compscore++;
                System.out.println("Computer Wins: " + player1.compscore);
                System.out.println("Player Wins: " + player1.score);
                System.out.println("Ties: " + player1.ties);
            } 
            else if (randomcompNumber == 3) 
            {
                System.out.println("  Computer   ");
                DrawScissorsBasic();
                System.out.println("Computer chose Scissors. Player wins!");
                
                System.out.println("Player Wins: " + player1.score);
                System.out.println("Computer Wins: " + player1.compscore);
                System.out.println("Ties: " + player1.ties);
            }
        } 
        else if (word.equalsIgnoreCase("paper")) 
        {
            DrawPaperBasic();
            DrawVSBasic();
            if (randomcompNumber == 1) 
            {

                System.out.println("  Computer   ");
                DrawRockBasic();
                System.out.println("Computer chose Rock. Player wins!");
                player1.score++;
                System.out.println("Player Wins: " + player1.score);
                System.out.println("Computer Wins: " + player1.compscore);
                System.out.println("Ties: " + player1.ties);
            } 
            else if (randomcompNumber == 2) 
            {

                System.out.println("  Computer   ");
                DrawPaperBasic();
                System.out.println("Computer chose Paper. It's a tie!");
                player1.ties++;
                System.out.println("Ties: " + player1.ties);
                System.out.println("Computer Wins: " + player1.compscore);
                System.out.println("Player Wins: " + player1.score);
            } 
            else if (randomcompNumber == 3) 
            {
                DrawScissorsBasic();    
                System.out.println("  Computer   ");
                System.out.println("Computer chose Scissors. Computer wins!");
                player1.compscore++;
                System.out.println("Computer Wins: " + player1.compscore);
                System.out.println("Player Wins: " + player1.score);
                System.out.println("Ties: " + player1.ties);
            }
        } 
        else if (word.equalsIgnoreCase("scissors")) 
        {
            DrawScissorsBasic();
            DrawVSBasic();
            if (randomcompNumber == 1) 
            {

                System.out.println("  Computer   ");
                DrawRockBasic();
                System.out.println("Computer chose Rock. Computer wins!");
                player1.compscore++;
                System.out.println("Computer Wins: " + player1.score);
                System.out.println("Player Wins: " + player1.compscore);
                System.out.println("Ties: " + player1.ties);
            } 
            else if (randomcompNumber == 2) 
            {
                System.out.println("  Computer   ");
                DrawPaperBasic();
                System.out.println("Computer chose Paper. Player wins!");
                player1.score++;
                System.out.println("Player Wins: " + player1.score);
                System.out.println("Computer Wins: " + player1.compscore);
                System.out.println("Ties: " + player1.ties);

            } 
            else if (randomcompNumber == 3) 
            {
                System.out.println("  Computer   ");
                DrawScissorsBasic();
                System.out.println("Computer chose Scissors. It's a tie!");
                player1.ties++;
                System.out.println("Ties: " + player1.ties);
                System.out.println("Computer Wins: " + player1.compscore);
                System.out.println("Player Wins: " + player1.score);
            }
        } 
        else 
        {
            System.out.println("Invalid input. Please try again.");
            
            PlayGameRPSC();
            checking.close();
  
        }

    }
    public static void PlayGame1v1()
    {
        Scanner checking = new Scanner(System.in);
        System.out.println(" Rock, Paper, or Scissors? ");
        String P1word = checking.next();
        DrawBarrier();
        System.out.println(" Rock, Paper, or Scissors? ");
        String P2word = checking.next(); 
        
        if (P1word.equalsIgnoreCase("rock") && P2word.equalsIgnoreCase("rock")) 
        {
            System.out.println("Player 1 chose Rock");
            DrawRockBasic();
            DrawVSBasic();
            System.out.println("Player 2 chose Rock");
            DrawRockBasic();
            System.out.println("It's a tie!");
            player1.ties++;
            System.out.println("Ties: " + player1.ties);
            System.out.println("Computer Wins: " + player1.compscore);
            System.out.println("Player Wins: " + player1.score);
            System.out.println("Player 2 Wins: " + player2.score);
        }
        else if (P1word.equalsIgnoreCase("rock") && P2word.equalsIgnoreCase("paper")) 
        {
            System.out.println("Player 1 chose Rock");
            DrawRockBasic();
            DrawVSBasic();
            System.out.println("Player 2 chose Paper");
            DrawPaperBasic();
            System.out.println("Player 2 wins: ");

            player2.score++;
            System.out.println("Ties: " + player1.ties);
            System.out.println("Computer Wins: " + player1.compscore);
            System.out.println("Player Wins: " + player1.score);
            System.out.println("Player 2 Wins: " + player2.score);

        }
        else if (P1word.equalsIgnoreCase("rock") && P2word.equalsIgnoreCase("scissors")) 
        {
            System.out.println("Player 1 chose Rock");
            DrawRockBasic();
            DrawVSBasic();
            System.out.println("Player 2 chose Scissors");
            DrawScissorsBasic();
            System.out.println("Player 1 wins!");
            player1.score++;
            System.out.println("Ties: " + player1.ties);
            System.out.println("Computer Wins: " + player1.compscore);
            System.out.println("Player Wins: " + player1.score);
           System.out.println("Player 2 Wins: " + player2.score);
        }
        else if (P1word.equalsIgnoreCase("paper") && P2word.equalsIgnoreCase("rock")) 
        {
            System.out.println("Player 1 chose Paper");
            DrawPaperBasic();
            DrawVSBasic();
            System.out.println("Player 2 chose Rock");
            DrawRockBasic();
            System.out.println("Player 1 wins!");
            player1.score++;
            System.out.println("Ties: " + player1.ties);
            System.out.println("Computer Wins: " + player1.compscore);
            System.out.println("Player Wins: " + player1.score);
        }
        else if (P1word.equalsIgnoreCase("paper") && P2word.equalsIgnoreCase("paper")) 
        {
            System.out.println("Player 1 chose Paper");
            DrawPaperBasic();
            DrawVSBasic();
            System.out.println("Player 2 chose Paper");
            DrawPaperBasic();
            System.out.println("It's a tie!");
            player1.score++;
            System.out.println("Ties: " + player1.score);
            System.out.println("Computer Wins: " + player1.compscore);
            System.out.println("Player Wins: " + player1.score);
             System.out.println("Player 2 Wins: " + player2.score);
           

        }
        else if (P1word.equalsIgnoreCase("paper") && P2word.equalsIgnoreCase("scissors")) 
        {
            System.out.println("Player 1 chose Paper");
            DrawPaperBasic();
            DrawVSBasic();
            System.out.println("Player 2 chose Scissors");
            DrawScissorsBasic();
            System.out.println("Player 2 wins!");
            player2.score++;
            System.out.println("Ties: " + player1.ties);
            System.out.println("Computer Wins: " + player1.compscore);
            System.out.println("Player Wins: " + player1.score);
             System.out.println("Player 2 Wins: " + player2.score);
        }
        else if (P1word.equalsIgnoreCase("scissors") && P2word.equalsIgnoreCase("rock")) 
        {
            System.out.println("Player 1 chose Scissors");
            DrawScissorsBasic();
            DrawVSBasic();
            System.out.println("Player 2 chose Rock");
            DrawRockBasic();
            System.out.println("Player 2 wins!");
            player2.score++;
            System.out.println("Ties: " + player1.ties);
            System.out.println("Computer Wins: " + player1.compscore);
            System.out.println("Player Wins: " + player1.score);
             System.out.println("Player 2 Wins: " + player2.score);
        }
        else if (P1word.equalsIgnoreCase("scissors") && P2word.equalsIgnoreCase("paper")) 
        {
            System.out.println("Player 1 chose Scissors");
            DrawScissorsBasic();
            DrawVSBasic();
            System.out.println("Player 2 chose Paper");
            DrawPaperBasic();
            System.out.println("Player 1 wins!");
            player1.score++;
            System.out.println("Ties: " + player1.ties);
            System.out.println("Computer Wins: " + player1.compscore);
            System.out.println("Player Wins: " + player1.score);
             System.out.println("Player 2 Wins: " + player2.score);
        }
        else if (P1word.equalsIgnoreCase("scissors") && P2word.equalsIgnoreCase("scissors")) 
        {
            System.out.println("Player 1 chose Scissors");
            DrawScissorsBasic();
            DrawVSBasic();
            System.out.println("Player 2 chose Scissors");
            DrawScissorsBasic();
            System.out.println("It's a tie!");
            player1.ties++;
            System.out.println("Ties: " + player1.ties);
            System.out.println("Computer Wins: " + player1.compscore);
            System.out.println("Player Wins: " + player1.score);
             System.out.println("Player 2 Wins: " + player2.score);
        }
        else 
        {
            System.out.println("Invalid input/s. Match is restarting. Please try again.");
            PlayGame1v1();
            checking.close();
        }

        



    }


    
    public static void PlayGame()
    {   
     
        
        int randomplayerNumber = (int) (Math.random() * 3)+1;
        int randomcomputerNumber = (int) (Math.random() * 3)+1;
        if (randomcomputerNumber == 1) 
        {
            System.out.println("  Computer   ");
            DrawRockBasic();
            DrawVSBasic();
        } 
        else if (randomcomputerNumber == 2) 
        {
            System.out.println("  Computer   ");
            DrawPaperBasic();
            DrawVSBasic();
        } 
        else if (randomcomputerNumber == 3) 
        {
            System.out.println("  Computer   ");
            DrawScissorsBasic();
            DrawVSBasic();
        }
        if (randomplayerNumber == 1) 
        {
            DrawRockBasic();
           
            if (randomcomputerNumber ==1 && randomplayerNumber == 1) 
                {
                    System.out.println("Tie!");
                    player1.ties++;
                    System.out.println("Ties: " + player1.ties);
                    System.out.println("Computer Wins: " + player1.compscore);
                    System.out.println("Player Wins: " + player1.score);
                }
            if (randomcomputerNumber == 2 && randomplayerNumber == 1) 

                {

                    System.out.println("Computer Wins!");
                    player1.compscore++;
                    System.out.println("Computer Wins: " + player1.compscore);
                    System.out.println("Player Wins: " + player1.score);
                    System.out.println("Ties: " + player1.ties);
               
                }


            if (randomcomputerNumber == 3 && randomplayerNumber == 1) 

                {

                    System.out.println("Player Wins!");
                    player1.score++;
                    System.out.println("Player Wins: " + player1.score);
                    System.out.println("Computer Wins: " + player1.compscore);
                    System.out.println("Ties: " + player1.ties);

                }
        } 

        else if (randomplayerNumber == 2) 
        {
            DrawPaperBasic();
           
            if (randomcomputerNumber ==2 && randomplayerNumber == 2) 

                {

                    System.out.println("Tie!");
                    player1.ties++;
                    System.out.println("Ties: " + player1.ties);
                    System.out.println("Computer Wins: " + player1.compscore);
                    System.out.println("Player Wins: " + player1.score);

               
                }

            if (randomcomputerNumber == 3 && randomplayerNumber == 2) 

                {

                    System.out.println("Computer Wins!");
                    addComputerPoint();
                    System.out.println("Computer Wins: " + scoreComputer);
                    System.out.println("Player Wins: " + scorePlayer);
                    System.out.println("Ties: " + scoreTie);


                }

            if (randomcomputerNumber == 1 && randomplayerNumber == 2) 

                {

                    System.out.println("Player Wins!");
                    addPlayerPoint();
                    System.out.println("Player Wins: " + scorePlayer);
                    System.out.println("Computer Wins: " + scoreComputer);
                    System.out.println("Ties: " + scoreTie);

                }
        } 

        else if (randomplayerNumber == 3) 
        {
            DrawScissorsBasic();
           
            if (randomcomputerNumber ==3 && randomplayerNumber == 3) 

                {

                    System.out.println("Tie!");
                    addTiePoint();
                    System.out.println("Ties: " + scoreTie);
                    System.out.println("Computer Wins: " + scoreComputer);
                    System.out.println("Player Wins: " + scorePlayer);
             
                }

            if (randomcomputerNumber == 1 && randomplayerNumber == 3) 

                {

                    System.out.println("Computer Wins!");
                    addComputerPoint();
                    System.out.println("Computer Wins: " + scoreComputer);
                    System.out.println("Player Wins: " + scorePlayer);
                    System.out.println("Ties: " + scoreTie);

                }

            if (randomcomputerNumber == 2 && randomplayerNumber == 3) 

                {
                    System.out.println("Player Wins!");
                    addPlayerPoint();
                    System.out.println("Player Wins: " + scorePlayer);
                    System.out.println("Computer Wins: " + scoreComputer);
                    System.out.println("Ties: " + scoreTie);

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
