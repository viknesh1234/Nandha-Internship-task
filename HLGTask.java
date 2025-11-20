import java.util.Random;
import java.util.Scanner;

public class HLGTask{

    static void display(int[][] grid, Integer mark) {
        int n = grid.length;

        System.out.print("   ");
        for (int i = 0; i < n; i++) {
            System.out.printf("%02d ", i);
        }
        System.out.println();

        System.out.print("   ");
        for (int i = 0; i < n; i++) {
            System.out.print("---");
        }
        System.out.println();

        for (int i = 0; i < n; i++) {
            System.out.printf("%02d| ", i);
            for (int j = 0; j < n; j++) {
                if (mark != null && grid[i][j] == mark) {
                    System.out.printf("[%d] ", grid[i][j]);
                } else {
                    System.out.printf("%2d  ", grid[i][j]);
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random random = new Random();

        int n;

        while (true) {
            try {
                System.out.print("Enter array size (for NxN array): ");
                n = Integer.parseInt(input.nextLine());
                if (n > 0) break;
            } catch (Exception e) {
            }
            System.out.println("Invalid size. Try again.");
        }

        int[][] grid = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = 2 * (random.nextInt(10) + 1);
            }
        }

        System.out.println("\nGenerated 2D array:");
        display(grid, null);

        int highlight;

        while (true) {
            try {
                System.out.print("\nEnter a number to highlight (even number 2–20): ");
                highlight = Integer.parseInt(input.nextLine());
                if (highlight >= 2 && highlight <= 20 && highlight % 2 == 0) break;
            } catch (Exception e) {
            }
            System.out.println("Invalid entry. Try again.");
        }

        int count = 0;
        for (int[] row : grid) {
            for (int value : row) {
                if (value == highlight) count++;
            }
        }

        System.out.println("\nArray with " + highlight + " highlighted:");
        display(grid, highlight);

        System.out.println("\nNumber " + highlight + " appeared " + count + " time(s)");
    }
}
