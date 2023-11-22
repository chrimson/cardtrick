import java.util.ArrayList;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    ArrayList<Integer> order = new ArrayList<Integer>();
    ArrayList<Integer> row = new ArrayList<Integer>();
    ArrayList<Card> deck = new ArrayList<Card>();
    Card[][][] round = new Card[3][9][3];

    for (int n = 0; n < 52; n++) {
      deck.add(new Card(n));
    }

    int k = 0;
    for (int r = 0; r < 9; r++) {
      for (int c = 0; c < 3; c++) {
        k = (int)(Math.random() * deck.size());
        round[0][r][c] = deck.remove(k);
        System.out.printf("%3d", round[0][r][c].value);
      }
      System.out.println();
    }
    int j = input.nextInt();

    for (int m = 1; m < 3; m++) {

      k = 0;
      for (int r = 0; r < 9; r++) {
        for (int c = 0; c < 3; c++) {
          round[m][r][c] = round[m - 1][k][j];
          k = (k + 1) % 9;
        }

        if ((r + 1) % 3 == 0) {
          j = (j + 1) % 3;
        }
      }

      for (int n = 0; n < 9; n++) {
        order.add(n);
      }
      for (int n = 0; n < 9; n++) {
        int p = (int)(Math.random() * order.size());
        row.add(order.remove(p));
      }

      for (int r = 0; r < 9; r++) {
        for (int c = 0; c < 3; c++) {
          System.out.printf("%3d", round[m][row.get(r)][c].value);
        }
        System.out.println();
      }

      j = input.nextInt();
    }    

    System.out.printf("%3d\n", round[2][0][j].value);
  }
}
