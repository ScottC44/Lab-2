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
        System.out.println("\nAverage high score of all players: " + calculateAverage(scores));
        sortByScore(names, scores);
        int topX = 10;
        topXPlayers(names, scores, topX);


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
    public static double calculateAverage(int scores[]) {
        int sum = 0;
        for (int i = 0; i < scores.length; i++) {
            sum += scores[i];
        }
        double avg = (double) sum / scores.length;
        return avg;
    }
    public static void sortByScore(String names[], int scores[]) {
        for (int i = 0; i < names.length; i++) {
            for (int j = i + 1; j < names.length; j++) {
                if (scores[i] < scores[j]) {
                    String temp = names[i];
                    names[i] = names[j];
                    names[j] = temp;
                    int t = scores[i];
                    scores[i] = scores[j];
                    scores[j] = t;
                }
            }
        }
    }
    public static void topXPlayers(String names[], int scores[], int topX) {
        System.out.println("\nTop " + topX + " Players: ");
        System.out.println("---------------------------");
        System.out.printf("%-15s %10s\n", "Player Name", "High Score");
        for (int i = 0; i < 10; i++) {
            System.out.println(String.format("%-15s %10d", names[i], scores[i]));
        }
    }
}





