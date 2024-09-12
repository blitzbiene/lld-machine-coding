package org.lld.tictactoe.entity.board;

import org.lld.tictactoe.entity.player.Player;
import org.lld.tictactoe.exeptions.IllegalMoveException;

public class TicTacBoard {

    Player[][] board;
    int boardSize;

    public TicTacBoard(int size){
        this.board = new Player[size][size];
        this.boardSize = size;
    }

    public void addPlayerToBox(Player player, int row, int col) throws IllegalMoveException{
        if(row> board.length || col> board.length || row<0 || col<0 || board[row][col]!=null)
            throw new IllegalMoveException();
        board[row][col] = player;
    }

    public void printBoard(){
        for(int i=0;i<boardSize;i++){
            for(int j=0;j<boardSize;j++){
                if(board[i][j] != null)System.out.print(board[i][j].getPlayingPiece().getSymbol());
                if(j==boardSize-1) System.out.print("");
                else if(board[i][j]!=null)System.out.print("  | ");
                else System.out.print("   | ");
            }
            System.out.println();
        }
    }

    public boolean doWeHaveWinner(){

        for(int i=0;i<boardSize;i++){
            boolean areRowWon = true;
           for (int j=1;j<boardSize;j++){
               if(board[i][j] != board[i][j-1] || board[i][j]==null)areRowWon=false;
           }
           if(areRowWon)return true;
        }

        for(int i=0;i<boardSize;i++){
            boolean areColumnsWon = true;
            for(int j=1;j<boardSize;j++){
                if(board[j][i] == null || board[j][i]!=board[j-1][i])areColumnsWon=false;
            }
            if(areColumnsWon)return true;
        }

        boolean areDiagonal1Won = true;
        boolean areDiagonal2Won = true;

        for(int i=1;i<boardSize;i++){
            if(board[i][i] != board[i-1][i-1] || board[i][i]==null)areDiagonal1Won=false;
            if(board[i][boardSize-i-1] != board[i-1][boardSize-i] || board[i][boardSize-1-i]==null)areDiagonal2Won=false;
        }

        if(areDiagonal1Won)return true;
        if(areDiagonal2Won)return true;

        return false;
    }

    public boolean isBoardFull(){
        for(int i=0;i<boardSize;i++){
            for(int j=0;j<boardSize;j++){
                if(board[i][j] == null)return false;
            }
        }
        return true;
    }
}
