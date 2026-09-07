import java.util.Scanner;
public class RockPaperScissors {
    static int scorePlayer = 0;
    static int scoreComputer = 0
    ;
    static int scoreTie = 0;
    public static void addPlayerPoint() 
    {
        scorePlayer++;
    }
    public static void addComputerPoint() 
    {
        scoreComputer++;
    }
    public static void addTiePoint()
    {
        scoreTie++;
    }


     public static void main(String[] args) {
       Menu();
       
     }
    
    public static void Menu( )
    {
         
   
        
        System.out.println("Welcome to Rock Paper Scissors!");
        System.out.println("Press 1 to play 1 round of simulation mode");
        System.out.println("Press 2 to play multiple rounds of simulation mode ");
        System.out.println("Press 3 to reset scores");
        System.out.println("Press 4 to play 1v1 Computer mode");
        System.out.println("Press 5 to play multiple rounds of 1v1 against Computer");
        System.out.println("Press 6 to play multiple rounds of 1v1");
        System.out.println("Press 7 to play 1v1");


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
        else if (choice == 3) 
        {
            System.out.println("Reset Scores");
            scorePlayer = 0;
            scoreComputer = 0;
            scoreTie = 0;
            Menu();
        }
        else if (choice == 4)
        {
            PlayGameRPSC();

        }
        else if (choice == 5)
        {
            PlayGameRPSC();

        }
        else if (choice == 6)
        {
            PlayGame1v1();
        }
        else if (choice == 7)
        {
            PlayGame1v1();
        }
        else 
        {
            System.out.println("Invalid choice. Please try again.");
            Menu();
        }
       

    }   
    public static void PlayGameRPSC()
    {
        System.out.println(" Rock, Paper, or Scissors? ");

        int randomcompNumber = (int) (Math.random() * 3)+1;
        if (randomcompNumber == 1) 
        {
            System.out.println("  Computer   ");
            DrawRockBasic();
            DrawVSBasic();
        } 
        else if (randomcompNumber == 2) 
        {
            System.out.println("  Computer   ");
            DrawPaperBasic();
            DrawVSBasic();
        } 
        else if (randomcompNumber == 3) 
        {
            System.out.println("  Computer   ");
            DrawScissorsBasic();
            DrawVSBasic();
        }
    

    }
    public static void PlayGame1v1()
    {
        
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
                    addTiePoint();
                    System.out.println("Ties: " + scoreTie);
                    System.out.println("Computer Wins: " + scoreComputer);
                    System.out.println("Player Wins: " + scorePlayer);
                }
            if (randomcomputerNumber == 2 && randomplayerNumber == 1) 
                {
                    System.out.println("Computer Wins!");
                    addComputerPoint();
                    System.out.println("Computer Wins: " + scoreComputer);
                    System.out.println("Player Wins: " + scorePlayer);
                    System.out.println("Ties: " + scoreTie);
                }
            if (randomcomputerNumber == 3 && randomplayerNumber == 1) 
                {
                    System.out.println("Player Wins!");
                    addPlayerPoint();
                    System.out.println("Player Wins: " + scorePlayer);
                    System.out.println("Computer Wins: " + scoreComputer);
                    System.out.println("Ties: " + scoreTie);


                }
        } 
        else if (randomplayerNumber == 2) 
        {
            DrawPaperBasic();
           
            if (randomcomputerNumber ==2 && randomplayerNumber == 2) 
                {
                    System.out.println("Tie!");
                    addTiePoint();
                    System.out.println("Ties: " + scoreTie);
                    System.out.println("Computer Wins: " + scoreComputer);
                    System.out.println("Player Wins: " + scorePlayer);



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
        System.out.println("    ___");
        System.out.println("   |_|_\\");
        System.out.println("  /_|_|_|");
        System.out.println(" /___|__|");
        
        
    }     
    public static void DrawScissorsBasic() 
    {
        System.out.println(" \\  /");
        System.out.println("  \\/");
        System.out.println("  /\\");
        System.out.println(" 0  0");

    }

    public static void DrawPaperBasic() 
    {
        System.out.println(" _______ ");
        System.out.println("|      \\|");
        System.out.println("|       |");
        System.out.println("|_______|");
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

}
