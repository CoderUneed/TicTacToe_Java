package pro2;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {

        printBoard();
        System.out.println("The row and column number are shown as above.");
        System.out.println("Please enter the coordinates where you want to place your turn!! (Rowno., ColNo.)");
        System.out.println("The person starting will have 'X' and the other one 'O'");
        System.out.println("Good Luck!!!!");


        boolean flag = true;
        boolean bring = true;
        int a=0, b=0;
        //boolean flag1;
        char[][] arr = new char[3][3];
        int k = 0;
        while(bring) {
            System.out.print("Enter coordinates : ");
            Scanner sc = new Scanner(System.in);
            while (flag) {
                if(!sc.hasNextInt()) {
                    System.out.println("You should enter numbers!");
                    System.out.println("Enter coordinates :");
                    sc.nextLine();
                } else {
                    flag = false;
                }
            }

            a = sc.nextInt() - 1;
            b = sc.nextInt() - 1;

            flag = true;
            while(flag) {
                if (a > 2 || a < 0 || b < 0 || b > 2) {
                    System.out.println("Coordinates should be from 1 to 3!");
                    System.out.println("Enter coordinates : ");
                    a = sc.nextInt() - 1;
                    b = sc.nextInt() - 1;
                } else if (arr[a][b] == 'X' || arr[a][b] == 'O') {
                    System.out.println("This cell is occupied! Choose another one!");
                    System.out.println("Enter coordinates : ");
                    a = sc.nextInt();
                    b = sc.nextInt();
                    a--;
                    b--;
                } else  {
                    flag = false;
                }
            }
            if (k % 2 == 0) {
                arr[a][b] = 'X';
            } else if (k % 2 == 1) {
                arr[a][b] = 'O';
            }
            k++;
            printCurrent(arr);
            boolean xWon = isSymbolWon(arr, 'X');
            boolean oWon = isSymbolWon(arr, 'O');
            boolean draw = checkDraw(arr);
            if (xWon) {
                System.out.print("X wins!!");
                bring = false;
            } else if (oWon) {
                System.out.println("O wins!!");
                bring = false;
                break;
            } else if (draw) {
                System.out.print("Draw");
                bring = false;
                break;
            }
        }
    }

    private static void printCurrent(char[][] arr) {
        System.out.println("---------");
        for(int i = 0; i < 3; i++) {
            System.out.print("| ");
            for(int j = 0; j < 3; j++) {
                if(arr[i][j] == 'O' || arr[i][j] == 'X') {
                    System.out.print(arr[i][j] + " ");
                } else {
                    System.out.print("_ ");
                }
            }
            System.out.print("|\n");
        }
        System.out.println("---------");
    }


    private static boolean isSymbolWon (char[][] arr, char symbol) {
        return arr[0][0] == symbol && arr[0][1] == symbol && arr[0][2] == symbol
                || arr[1][0] == symbol && arr[1][1] == symbol && arr[1][2] == symbol
                || arr[2][0] == symbol && arr[2][1] == symbol && arr[2][2] == symbol
                || arr[0][0] == symbol && arr[1][0] == symbol && arr[2][0] == symbol
                || arr[0][1] == symbol && arr[1][1] == symbol && arr[2][1] == symbol
                || arr[0][2] == symbol && arr[1][2] == symbol && arr[2][2] == symbol
                || arr[0][0] == symbol && arr[1][1] == symbol && arr[2][2] == symbol
                || arr[0][2] == symbol && arr[1][1] == symbol && arr[2][0] == symbol;
    }

    private static boolean checkDraw (char[][] arr) {
        int nOfX = 0;
        int nOfO = 0;
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                if(arr[i][j] == 'X') {
                    nOfX++;
                } else if(arr[i][j] == 'O') {
                    nOfO++;
                }
            }
        }
        if (nOfX + nOfO == 9) {
            return true;
        } else if (nOfX + nOfO != 9) {
            return false;
        } else {
            return false;
        }
    }

    private static void printBoard() {
        System.out.println("""
                     Columns
                      1 2 3 
                    ---------
             R    1 | _ _ _ |
             O    2 | _ _ _ |
             W    3 | _ _ _ |
             S      ---------  
                         """);
    }
}
