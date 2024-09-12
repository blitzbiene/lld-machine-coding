package org.lld.tictactoe.exeptions;

public class IllegalMoveException extends Exception{

    public IllegalMoveException(){
        super("Illegal Move.");
    }
}
