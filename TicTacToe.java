import java.util.Scanner;

public class TicTacToe {

    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        
            System.out.println("\nLet's play tic tac toe");

            //Task 1: Create an array with three rows of '_' characters.
            char[][] board = {
              {'_','_','_'},
              {'_','_','_'},
              {'_','_','_'},
            };
            printBoard(board);
            //Task 2: Call the function printBoard();

              for(int i =0;i<9;i++){
                if(i%2==0){
                  System.out.println("X turn");
                  int[] spot=  ask(board);
                  board[spot[0]][spot[1]]='x';
                }else {
                  System.out.println("o turn");
                  int[] spot=  ask(board);
                  board[spot[0]][spot[1]]='o';
                }
                printBoard(board);
             
                if (checkWin(board) == 3) {
                  System.out.println("x wins");
                  System.exit(0);
                  // 1. print: X wins
                  // 2. break the loop
                } else if (checkWin(board) == -3) {
                  System.out.println("o wins");
                  System.exit(0);
                  // 1. print: O wins
                  // 2. break the loop
                 }else if (i==8) {System.out.println("its a tie");}
                }
             
              //printBoard(board);

              /**{  Task 3: Loop through turns.
                
                  if (X) turn {
                     Task 4: call askUser(). 
                     Task 5: populate the board using askUser's return value.
                  } else {
                      Task 4: call askUser(). 
                      Task 5: populate the board using askUser's return value. Then, print it.

                  }

                Task 6 - Call the function.
                   

              } 
              */

            scan.close();
        }


    /** Task 2 - Write a function that prints the board.
     * Function name - printBoard()
     * @param board (char[][])
     * 
     * Inside the function:
     *   1. print a new line.
     *   2. print the board.
     *      • separate each row by two lines. 
     *      • each row precedes a tab of space
     *      • each character in the grid has one space from the other character
     */        
    public static void printBoard(char[][] array){
      System.out.print("\n");
      
      for (int i = 0; i < array.length; i++) {
        System.out.print("\t");
        for (int j = 0; j < array[i].length; j++) {

          System.out.print(array[i][j]+" ");
          

          
        }
        System.out.println("\n");
      }
    }    
   /** Task 4 - Write a function that lets the user choose a spot
     * Function name – askUser
     * @param board (char[][] board)
     * @return spot (int[])
     * 
     * Inside the function
     *   1. Asks the user: - pick a row and column number: 
     *   2. Check if the spot is taken. If so, let the user choose again.
     *   3. Return the row and column in an int[] array.
     * 
     */
    public static int[] ask(char[][] board){
      System.out.print("pick a row and column number: ");
    
      
     
      int a =scan.nextInt();
      int b = scan.nextInt();
      while(true){
      if(board[a][b]=='x' || board[a][b]=='o'){
        
        System.out.print("try again : ");
        a =scan.nextInt();
        b =scan.nextInt();
      }else {break;}
     }
      int[] array= {a,b};
      return array;
    }
    /** Task 6 - Write a function that determines the winner
     * Function name - checkWin 
     * @para(m board (char[][])
     * @return count (int)
     * 
     * Inside the function:
     *   1. Make a count variable that starts at 0.
     *   2. Check every row for a straight X or straight O (Task 7).
     *   3. Check every column for a straight X or straight O (Task 8).
     *   4. Check the left diagonal for a straight X or straight O (Task 9).
     *   5. Check the right diagonal for a straight X or straight O (Task 10).
     */
    public static int checkWin(char[][] board){
      int rows =  checkRows(board);
      if(Math.abs(rows)==3){return rows;
      }
      int columns =  checkColumns(board);
      if(Math.abs(columns)==3){return columns;}
      int right = checkRight(board);
      if(Math.abs(right)==3){return right;}
      int left =  checkLeft(board);
      if(Math.abs(left)==3){return left;}
      else {return 2;} 
    }






    public static int checkRows(char[][] board) {
      int count = 0;
      for (int i = 0; i < board.length; i++) {
        for (int j = 0; j <board[i].length; j++) {
          if(board[i][j]=='x'){
            count ++;
          }else if (board[i][j]=='o'){count --;
            
          }
        
        }
        if(count == 3 || count == (-3)){
          return count ;
        }else{ count = 0;}
      }  
      return count;
  }
  
  
  public static int checkColumns(char[][] board) {
      int count = 0;
      for (int i = 0; i < board.length; i++) {
        for (int j = 0; j < 3; j++) {
          if(board[j][i]=='x'){
            count ++;
          }else if (board[j][i]=='o') {count --;
            
          }
         
        }  
        if(count == 3 || count == (-3)){
          return count ;
        }else{ count = 0;}
       
      }
      return count;
  }
  public static int checkLeft(char[][] board) {
    int count = 0;
    for (int i = 0; i < board.length; i++) {
      if(board[i][i]=='x'){
        count ++;
      }else if (board[i][i]=='o'){
        count --;
      }
    }
    if(count == 3 || count == (-3)){
      return count ;
    }else {return 0;}  
  }
public static int checkRight(char[][] board) {
    int count = 0;
    if(board[2][0]=='x'&& board[1][1]=='x'&&board[0][2]=='x'){
      count=3;
    }else if (board[2][0]=='o'&& board[1][1]=='o'&&board[0][2]=='o'){
      count=-3;
    }
    return count;
}

  
  }
  
        
       
    
  
//}
