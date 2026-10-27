import java.util.Scanner;

public class MenuProject {
    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String BLUE = "\u001B[34m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String PURPLE = "\u001B[35m";
    public static final String ORANGE = "\u001B[38;5;208m";


    public static void main(String[] args) {
        PlayGame();
    }

    public static void PlayGame() {
        Scanner checking = new Scanner(System.in);

        while (true) {
            System.out.println(BLUE + "1. Copy(C)" + RESET + GREEN + "\n2. Cut(T)" + RESET + YELLOW + "\n3. Paste(V)" + RESET + RED + "\n4. Exit\n" + RESET+ PURPLE);
            System.out.print("Please enter your choice: ");
            String choice = checking.nextLine().trim().toUpperCase();

            switch (choice) {
                case "1":
                case "C":
                    System.out.println(BLUE + "\nYou have selected Copy\n" + RESET);
                    break;
                case "2":
                case "T":
                    System.out.println(GREEN + "\nYou have selected Cut\n" + RESET);
                    break;
                case "3":
                case "V":
                    System.out.println(YELLOW + "You have selected Paste\n" + RESET);
                    break;
                case "4":
                case "X":
                    System.out.println(RED + "\nYou have selected Exit\n" + RESET);
                    return;
                default:
                    System.out.println(ORANGE + "\nInvalid choice\n" + RESET);
            }
        }
    }
}
