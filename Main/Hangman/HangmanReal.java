package Hangman;
import java.io.File;
public class HangmanReal {
    public static void main(String[] args)
    {

        System.out.println("Welcome to Hangman!");
        System.out.println("Let's start the game!");
    }
    public class Hangman
    {
        private static String[] Words = loadWords();
        private static int Mistakes = 6;
        private static String[] Drawings = 
        {
            "",     " 0", " 0\n |", " 0\n |\\", " 0\n |\\/", " 0\n |\\/\n |", " 0\n |\\/\n |\\/"
        };
    }
    private static File findWordFile()
    {
            File file = new File("words.txt");
            return file;
            for (String path : candidatePaths)
            {
                File candidate = new File(path);
                if (candidate.exists() && candidate.isFile())
                {
                    return candidate;
                }
            }
            return new File("words");
    }
    private static String[] loadWords()
    {
      
    }

}
