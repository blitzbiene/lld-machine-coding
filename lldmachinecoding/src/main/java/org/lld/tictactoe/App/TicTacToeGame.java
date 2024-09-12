package org.lld.tictactoe.App;

import org.lld.tictactoe.entity.board.TicTacBoard;
import org.lld.tictactoe.entity.player.Player;
import org.lld.tictactoe.entity.playingpiece.PlayingPieceO;
import org.lld.tictactoe.entity.playingpiece.PlayingPieceX;
import org.lld.tictactoe.exeptions.IllegalMoveException;

import java.util.Scanner;

public class TicTacToeGame {

    Player player1;
    Player player2;
    TicTacBoard board;
    public TicTacToeGame(int boardSize) throws IllegalMoveException{
        initializeGame(boardSize);
        this.player1 = player1;
        this.player2 = player2;
    }

    public void startGame(){
        boolean isGamePlayable = true;
        Player currentPlayer = player1;
        while(isGamePlayable){
            System.out.println(currentPlayer.getName() + "'s turn. Please enter box row and column");
            Scanner scanner = new Scanner(System.in);
            String input =  scanner.nextLine();
            int row = Integer.parseInt(input.split(",")[0]);
            int col = Integer.parseInt(input.split(",")[1]);
            try{
                board.addPlayerToBox(currentPlayer, row, col);
                board.printBoard();
                if(board.doWeHaveWinner()){
                    System.out.println("Congratulations we have winner. " + currentPlayer.getName());
                    isGamePlayable = false;
                }
                else if(board.isBoardFull()){
                    System.out.println("BoardFull no winners ending game.");
                    isGamePlayable =false;
                }
                if(player1 == currentPlayer){
                    currentPlayer =player2;
                }else currentPlayer = player1;
            } catch (IllegalMoveException e){
                System.out.println("Illegal Move. Please try again");
            }


        }
        System.out.println("Game Ended");

    }

    private void initializeGame(int boardSize) throws IllegalMoveException{
        board = new TicTacBoard(boardSize);

        Scanner scanner = new Scanner(System.in);
        // Select Playing Piece for First Player
        System.out.println("P1 select your piece. Enter 1 for X and 2 for O.");
        switch (scanner.nextByte()){
            case 1: player1 = new Player(new PlayingPieceX(), "Player-1");
                    player2 = new Player(new PlayingPieceO(), "Player-2");
                    break;
            case 2: player2 = new Player(new PlayingPieceX(), "Player-2");
                    player1 = new Player(new PlayingPieceO(), "Player-1");
                    break;
            default: throw new IllegalMoveException();
        }
    }

}
