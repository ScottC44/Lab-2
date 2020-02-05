import java.io.*;
import java.util.Scanner;


public class PlayerStats {
    public static void main(String[] args){
        int n = 80;
        String names[] = new String[n];
        int scores[] = new int[n];

        String filename = "playerData2.txt";
        readPlayers(names, scores, filename);
        printPlayers(names, scores);


    }

    public static void readPlayers(String names[], int scores[], String fileName) {
        try {
            Scanner fileIn = new Scanner(new File(fileName));
            int i = 0;
            while (fileIn.hasNext()) {
                names[i] = fileIn.next();
                scores[i] = fileIn.nextInt();
                i++;
            }
            fileIn.close();
        } catch (FileNotFoundException e) {
            System.out.println("Unable to open " + fileName);
        }
    }
    public static void printPlayers(String names[], int scores[]) {
        System.out.printf("%-15s %10s\n", "Player Name", "High Score");
        for (int i = 0; i < names.length; i++) {
            System.out.println(String.format("%-15s %10d", names[i], scores[i]));
        }
    }

}
