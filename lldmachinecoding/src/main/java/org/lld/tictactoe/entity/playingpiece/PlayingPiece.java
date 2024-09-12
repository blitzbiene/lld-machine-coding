package org.lld.tictactoe.entity.playingpiece;

public abstract class PlayingPiece {
    private char symbol;

    PlayingPiece(Character symbol){
        this.symbol = symbol;
    }

    public char getSymbol(){
        return symbol;
    }
}
