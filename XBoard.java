import static javax.swing.JOptionPane.showMessageDialog;

public class XBoard {

   private XOButton[] board;
   private Boolean playerX;
   private Boolean winner;


    public XBoard(){
        playerX = true;
        winner = false;

    }

    public void setBoard(XOButton[] buttons){
        board = buttons;
    }

    public Boolean getPlayer(){
        return playerX;
    }

    public void updatePlayer(){
        playerX = ! playerX;
    }

    public void clearBoard(){
        for(XOButton button : board){
            button.reset();
        }
    }

    public void evaluateBoard(){

        String currentPlayer = board[0].getPlayer();
        if(!currentPlayer.equals("#")){
            if(currentPlayer.equals(board[1].getPlayer()) && currentPlayer.equals(board[2].getPlayer()) ||
                    currentPlayer.equals(board[3].getPlayer()) && currentPlayer.equals(board[6].getPlayer())){
                winner = true;
            }
        }

        currentPlayer = board[8].getPlayer();
        if(!currentPlayer.equals("#")){
            if(currentPlayer.equals(board[7].getPlayer()) && currentPlayer.equals(board[6].getPlayer()) ||
                    currentPlayer.equals(board[5].getPlayer()) && currentPlayer.equals(board[2].getPlayer())){
                winner = true;
            }
        }

        currentPlayer = board[4].getPlayer();
        if(!currentPlayer.equals("#")){
            if(currentPlayer.equals(board[3].getPlayer()) && currentPlayer.equals(board[5].getPlayer()) ||
                    currentPlayer.equals(board[1].getPlayer()) && currentPlayer.equals(board[7].getPlayer()) ||
                    currentPlayer.equals(board[0].getPlayer()) && currentPlayer.equals(board[8].getPlayer()) ||
                    currentPlayer.equals(board[2].getPlayer()) && currentPlayer.equals(board[6].getPlayer())){
                winner = true;
            }
        }

        if(winner){
            String winningPlayer;
            if(playerX){
                winningPlayer = "X";
            } else {
                winningPlayer = "O";
            }
            showMessageDialog(null, winningPlayer + " is the winner!");
            winner = false;
            clearBoard();
        }

        Boolean draw  = true;
        for(XOButton button : board){
            if(button.getPlayer() == "#"){
                draw = false;
            }
        }

        if(draw){
            showMessageDialog(null, " It's a draw.");
            clearBoard();
        }


    }

}
