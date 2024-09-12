package org.lld.tictactoe;

import org.lld.tictactoe.App.TicTacToeGame;
import org.lld.tictactoe.exeptions.IllegalMoveException;

public class Driver {


    public static void main(String[] args) throws IllegalMoveException {
        TicTacToeGame ticTacToeGame = new TicTacToeGame(3);
        ticTacToeGame.startGame();
    }


}
