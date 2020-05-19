/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Play;

/**
 *
 * @author Mauricio Andres Flores Perez
 */
public class Game {
    
    // Board values can be:
    //  O: Player O 
    //  _: Blank
    //  X: Player X
    private char[][] board;
    
    public Game() 
    {
        board = new char[][]{
        {'_', '_', '_'},
        {'_', '_', '_'},
        {'_', '_', '_'}
        };
    }
    
    // Copy constructor
    public Game(Game game) {
        this.board = game.getBoard();
    }

    /**
     * Function getBoard
     * @return Returns the board
     */
    public char[][] getBoard() 
    {
        return board;
    }
    
    /**
     * Function move
     * @param x Indicates x coordinate
     * @param y Indicates y coordinate
     * @param player Indicates x if player x moves, O if player O moves 
     */
    public void move(int x, int y, char player) 
    {
        board[x][y] = player;
    }
    
    /**
     * Returns if a player wins
     * @param player Indicates wich player is moving
     * @return 1 if player X has won, 0 if no one has won, -1 if O has won
     */
    public int evaluation() 
    {
        // Checking horizontal and vertical winning for X and O
        for (int i = 0; i < 3; ++i) 
        {
            // Checking rows for X and O
            if (board[i][0] == board[i][1] && board[i][1] == board[i][2]) 
            {
                if (board[i][0] == 'X')
                    return 1;
                else if (board[i][0] == 'O')
                    return -1;
            }
            
            // Checking cols for X and O
            if (board[0][i] == board[1][i] && board[1][i] == board[2][i])
            {
                if (board[0][i] == 'X')
                    return 1;
                else if (board[0][i] == 'O')
                    return -1;
            }
        }
       
        // Checking diagonals
        if (board[0][0] == board[1][1] && board[1][1] == board[2][2])
        {
            if (board[0][0] == 'X')
                return 1;
            else if (board[0][0] == 'O')
                return -1;
        }
        
        // Checking diagonals
        if (board[0][2] == board[1][1] && board[1][1] == board[2][0])
        {
            if (board[0][2] == 'X')
                return 1;
            else if (board[0][2] == 'O')
                return -1;
        }
        
        return 0;
    }
    
    /**
     * Returns whether the game is over or not because of board is complete
     * @return Return true if the game is over, false otherwise
     */
    public boolean isOver() 
    {
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                if (board[i][j] == '_') 
                    return false;
            }
        }
        
        return true;
    }
    
    /**
     * Returns whether a square is empty or not
     * @param x Position in x
     * @param y Position in y
     * @return Returns 1 if the square is empty, false otherwise
     */
    public boolean isEmpty(int x, int y) 
    {
        if (board[x][y] == '_')
            return true;
        else 
            return false;
    }
}
