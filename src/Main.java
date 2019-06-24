import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        System.out.println("Time to get to...where were you going, again?");
        String place = read.nextLine();
        System.out.println("Ah, yes, " + place + "! Hop in your car and drive!");
        int dest = 5;
        String[] visibility = {"clear", "wooded", "residential"};
        String[] distance = {"straight", "winding"};
        int[] danger = {50, 20, 80};
        int[] time = {120, 150};
        Random rand = new Random();
        int totalTime = 0;

        while (dest > 0) {
            int road1Type1 = rand.nextInt(3);
            int road1Type2 = rand.nextInt(2);

            int road2Type1 = rand.nextInt(3);
            int road2Type2 = rand.nextInt(2);

            String direction = "";
            while (!direction.equals("left") && !direction.equals("right")) {
                System.out.println("Would you like to take the 'left' road: "
                        + visibility[road1Type1] + " " + distance[road1Type2]
                        + "\nOr the 'right' road: "
                        + visibility[road2Type1] + " " + distance[road2Type2]);
                direction = read.nextLine().toLowerCase().trim();
            }

            String speed = "";
            while (!speed.equals("yes") && !speed.equals("no")) {
                System.out.println("Try your luck by speeding? Type 'yes' or 'no'.");
                speed = read.nextLine().toLowerCase().trim();
            }

            boolean speeding = false;
            if (speed.equals("yes")) {
                speeding = true;
            }

            int attention = rand.nextInt(100) + 1;
            int roadDanger = road1Type1;
            int roadTime = road1Type2;
            if (direction.equals("right")) {
                roadDanger = road2Type1;
                roadTime = road2Type2;
            }
            if (speeding) {
                if (attention > 100 - danger[roadDanger]) {
                    System.out.println("You got caught speeding!\nYou lost plenty of time and got a $100 ticket!");
                    totalTime += ((time[roadTime] / 1.5) + 240);
                } else {
                    System.out.println("You made great time!");
                    totalTime += (time[roadTime] / 1.5);
                }
            } else {
                System.out.println("You take the speed limit.");
                totalTime += time[roadTime];
            }

            dest--;
        }

        System.out.println("You made it to " + place + "!\nYour time is: " + (totalTime / 60)
                + " minutes, " + (totalTime % 60) + " seconds.");
    }
}
