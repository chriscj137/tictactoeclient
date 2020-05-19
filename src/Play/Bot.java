/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Play;


/**
 * Class that behaves as a player
 * @author Mauricio Andres Flores Perez
 */
public class Bot {
    
    private char player;
    private char opponent;
    
    public Bot(char player) {
        this.player = player;
        opponent = (player == 'X') ? 'O' : 'X';
    }
    
    public char getPlayer() 
    {
        return player;
    }
    
    public Move findBestMove(Game auxGame) 
    {    
        int bestVal; 
        if (player == 'X')
            bestVal = -1000; 
        else 
            bestVal = 1000;
        
        Move bestMove = new Move();  

        // Traverse all cells, evaluate minimax function  
        // for all empty cells. And return the cell  
        // with optimal value. 
        for (int i = 0; i < 3; ++i) 
        { 
            for (int j = 0; j < 3; ++j) 
            { 
                // Check if cell is empty 
                if (auxGame.getBoard()[i][j] == '_') 
                { 
                    // Make the move 
                    auxGame.move(i, j, player);

                    // compute evaluation function for this move.
                    int moveVal = minimax(auxGame, opponent);

                    // Undo the move 
                    auxGame.move(i, j, '_');

                    // If the value of the current move is 
                    // more than the best value, then update 
                    // best/ 
                    if (player == 'X') 
                    {
                        if (moveVal > bestVal) 
                        { 
                            bestMove.setRow(i);
                            bestMove.setCol(j); 
                            bestVal = moveVal; 
                        }
                    } else 
                    {
                        if (moveVal < bestVal) 
                        { 
                            bestMove.setRow(i);
                            bestMove.setCol(j); 
                            bestVal = moveVal; 
                        }
                    }
                } 
            } 
        } 
        
        return bestMove; 
    }
    
    public int minimax(Game game, char player) 
    { 
        int score = game.evaluation(); 

        // If Maximizer has won the game  
        // return his/her evaluated score 
        if (score == 1) 
            return score; 

        // If Minimizer has won the game  
        // return his/her evaluated score 
        if (score == -1) 
            return score; 

        // If there are no more moves and  
        // no winner then it is a tie 
        if (game.isOver()) 
            return 0; 

        // If this playerX's move
        if (player == 'X') 
        { 
            int best = -1000; 

            // Traverse all cells 
            for (int i = 0; i < 3; ++i) 
            { 
                for (int j = 0; j < 3; ++j) 
                { 
                    // Check if cell is empty 
                    if (game.getBoard()[i][j] == '_') 
                    { 
                        // Make the move 
                        game.move(i, j, 'X');

                        // Call minimax recursively and choose 
                        // the maximum value 
                        best = Math.max(best, minimax(game, 'O')); 

                        // Undo the move 
                        game.move(i, j, '_'); 
                    } 
                } 
            } 
            return best; 
        } 

        // If this minimizer's move 
        else
        { 
            int best = 1000; 

            // Traverse all cells 
            for (int i = 0; i < 3; ++i) 
            { 
                for (int j = 0; j < 3; ++j) 
                { 
                    // Check if cell is empty 
                    if (game.getBoard()[i][j] == '_') 
                    { 
                        // Make the move 
                        game.move(i, j, 'O');

                        // Call minimax recursively and choose 
                        // the minimum value 
                        best = Math.min(best, minimax(game, 'X')); 

                        // Undo the move 
                        game.move(i, j, '_'); 
                    } 
                } 
            } 
            return best; 
        } 
    } 
    
}
