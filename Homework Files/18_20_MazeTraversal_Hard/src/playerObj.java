/***
 * Class playerObj controls the movement and printing of movement through the maze.
 */
public class playerObj {
    /***
     * Char[][] playerMoves is a 2D array containing a players moves through the maze.
     */
    private char[][] playerMoves;

    /***
     * Constructor playerObj sets the players state to the initial maze.
     * @param maze is the generated maze to traverse.
     */
    public playerObj(char[][] maze)
    {
        playerMoves = maze;
    }

    /***
     * Method playerMovement will recursively check each direction, and if the player is able to move in any of them, to move.
     * If the player cannot move anywhere, it calls the recursive function for backtracking.
     * @param i players position on the X axis.
     * @param j players position on the Y axis.
     */
    public void playerMovement(int i, int j)
    {
        System.out.println("-------------------------");
        ///Printing the last move
        for (int k = 0; k < 12; k++) {
            for (int l = 0; l < 12; l++) {
                System.out.print(playerMoves[k][l] + " ");
            }
            System.out.println();
        }
        //Moving the player one space left
        if ((j > 0) && (playerMoves[i][j-1] == ('.')))
        {
            playerMoves[i][j] = 'X';
            playerMovement(i, j-1);
        }
        //Moving the player one space right
        else if ((j < 11) && (playerMoves[i][j+1] == ('.')))
        {
            playerMoves[i][j] = 'X';
            playerMovement(i, j+1);
        }
        //Moving the player one space up
        else if ((i > 0) && (playerMoves[i-1][j] == ('.')))
        {
            playerMoves[i][j] = 'X';
            playerMovement(i-1, j);
        }
        //Moving the player one space down
        else if ((i < 11) && (playerMoves[i+1][j] == ('.')))
        {
            playerMoves[i][j] = 'X';
            playerMovement(i+1, j);
        }
        else if (i == 0 || j == 0 || i == 11 || j == 11)
        {
            playerMoves[i][j] = 'X';
        }
        else
        {
            playerMoves[i][j] = 'O';
            playerBackTrack(i,j);
        }

    }

    /***
     * Method playerMovement will recursively check each direction, and if the player is not able to move in any of them,
     * to start backtracking and placing 0s to show that the player should not go this way again.
     * @param i players position on the X axis.
     * @param j players position on the Y axis.
     */
    public void playerBackTrack(int i, int j)
    {
        //Moving the player back
        if ((j < 11) && playerMoves[i][j+1] == 'X')
        {
            playerMoves[i][j] = 'O';
            playerMovement(i,j+1);
        }
        //Moving the player one space left
        else if ((j > 0) && (playerMoves[i][j-1] == ('X')))
        {
            playerMoves[i][j] = 'O';
            playerMovement(i, j-1);
        }
        //Moving the player one space up
        else if ((i > 0) && (playerMoves[i-1][j] == ('X')))
        {
            playerMoves[i][j] = 'O';
            playerMovement(i-1, j);
        }
        //Moving the player one space down
        else if ((i < 11) && (playerMoves[i+1][j] == ('X')))
        {
            playerMoves[i][j] = 'O';
            playerMovement(i+1, j);
        }

    }

    /***
     * method printAll prints player movement and the final solution through the maze.
     */
    public void printAll()
    {
        System.out.println("-------------------------");
        System.out.println("Final Solution:");
        for (int k = 0; k < 12; k++) {
            for (int l = 0; l < 12; l++) {
                System.out.print(playerMoves[k][l] + " ");
            }
            System.out.println();
        }
    }

}
