import java.util.Random;

public class TortoiseAndHare {
    public static void main(String[] args) {
        int tortoisePosition = 1;
        int harePosition = 1;
        int finishLine = 70;
        Random rand = new Random();

        System.out.println("BANG!!!!");
        System.out.println("AND THEY'RE OFF!!!!");

        while (tortoisePosition < finishLine && harePosition < finishLine) {
            int tortoiseMove = rand.nextInt(10) + 1;
            int hareMove = rand.nextInt(10) + 1;

            // Tortoise move
            if (tortoiseMove >= 1 && tortoiseMove <= 5) {
                tortoisePosition += 3;
            } else if (tortoiseMove >= 6 && tortoiseMove <= 7) {
                tortoisePosition -= 6;
            } else {
                tortoisePosition += 1;
            }

            // Hare move
            if (hareMove >= 1 && hareMove <= 2) {
                harePosition += 0;
            } else if (hareMove >= 3 && hareMove <= 4) {
                harePosition += 9;
            } else if (hareMove == 5) {
                harePosition -= 12;
            } else if (hareMove >= 6 && hareMove <= 8) {
                harePosition += 1;
            } else {
                harePosition -= 2;
            }

            if (tortoisePosition < 1) {
                tortoisePosition = 1;
            }
            if (harePosition < 1) {
                harePosition = 1;
            }

            // Display race progress
            for (int i = 1; i <= finishLine; i++) {
                if (i == tortoisePosition && i == harePosition) {
                    System.out.print("OUCH!!!");
                } else if (i == tortoisePosition) {
                    System.out.print("T");
                } else if (i == harePosition) {
                    System.out.print("H");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();

            // Check for winner
            if (tortoisePosition >= finishLine && harePosition >= finishLine) {
                System.out.println("It's a tie.");
            } else if (tortoisePosition >= finishLine) {
                System.out.println("TORTOISE WINS!!! YAY!!!");
            } else if (harePosition >= finishLine) {
                System.out.println("Hare wins. Yuch.");
            }

            try {
                Thread.sleep(1000); // Pause for 1 second
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        }
    }
}