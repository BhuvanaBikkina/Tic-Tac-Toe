import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("====================================");
        System.out.println("        TIC TAC TOE (2 Players)      ");
        System.out.println("====================================");
        System.out.println("How to play:");
        System.out.println("1) This is a 3x3 board.");
        System.out.println("2) Player 1 = X, Player 2 = O");
        System.out.println("3) Enter your move as row col");
        System.out.println("   Example: 0 1 means row 0, col 1");
        System.out.println("4) Row and col are from 0 to 2");
        System.out.println("====================================\n");
        // taking player names
        System.out.print("Enter Player 1 name (X): ");
        String n1 = sc.nextLine();
        System.out.print("Enter Player 2 name (O): ");
        String n2 = sc.nextLine();
        boolean again = true;
        while (again) {
            char[][] b = new char[3][3];
            // fill board with '-'
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    b[i][j] = '-';
                }
            }
            char p = 'X';
            int moves = 0;
            while (true) {
                // display board after each move
                System.out.println("\nBoard:");
                System.out.println("  0 1 2");
                for (int i = 0; i < 3; i++) {
                    System.out.print(i + " ");
                    for (int j = 0; j < 3; j++) {
                        System.out.print(b[i][j] + " ");
                    }
                    System.out.println();
                }
                System.out.println();
                // show player name during turn
                if (p == 'X') {
                    System.out.println(n1 + " (X) enter row and col:");
                } else {
                    System.out.println(n2 + " (O) enter row and col:");
                }
                int x = sc.nextInt();
                int y = sc.nextInt();
                // validate input bounds
                if (x < 0 || x > 2 || y < 0 || y > 2) {
                    System.out.println("Invalid input! Enter row and col between 0 and 2.");
                    continue;
                }
                // check empty cell
                if (b[x][y] != '-') {
                    System.out.println("Cell already filled! Choose another one.");
                    continue;
                }
                // place move
                b[x][y] = p;
                moves++;
                // check winner
                boolean win = false;
                for (int i = 0; i < 3; i++) {
                    if (b[i][0] == p && b[i][1] == p && b[i][2] == p)
                        win = true;
                }
                for (int j = 0; j < 3; j++) {
                    if (b[0][j] == p && b[1][j] == p && b[2][j] == p)
                        win = true;
                }
                if (b[0][0] == p && b[1][1] == p && b[2][2] == p)
                    win = true;
                if (b[0][2] == p && b[1][1] == p && b[2][0] == p)
                    win = true;
                // if win
                if (win) {
                    System.out.println("\nFinal Board:");
                    System.out.println("  0 1 2");
                    for (int i = 0; i < 3; i++) {
                        System.out.print(i + " ");
                        for (int j = 0; j < 3; j++) {
                            System.out.print(b[i][j] + " ");
                        }
                        System.out.println();
                    }
                    // announce winner name
                    if (p == 'X') {
                        System.out.println("\n" + n1 + " wins!");
                    } else {
                        System.out.println("\n" + n2 + " wins!");
                    }
                    break;
                }
                // draw condition
                if (moves == 9) {
                    System.out.println("\nMatch Draw!");
                    break;
                }
                // alternate turns
                if (p == 'X')
                    p = 'O';
                else
                    p = 'X';
            }
            // ask to play again
            System.out.print("\nDo you want to play again? (y/n): ");
            String ans = sc.next();
            if (ans.equalsIgnoreCase("y")) {
                again = true;
            } else {
                again = false;
            }
        }
        System.out.println("\nThanks for playing!");
    }
}
