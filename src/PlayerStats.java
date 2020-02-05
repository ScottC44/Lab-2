import java.io.*;
import java.util.Scanner;


public class PlayerStats {
    public static void main(String[] args){
        int n = 80;
        String names[] = new String[n];
        int scores[] = new int[n];

        String filename = "playerData2.txt";
        readPlayers(names, scores, filename);

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

}
