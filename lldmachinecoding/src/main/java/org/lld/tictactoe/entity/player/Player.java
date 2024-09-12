package org.lld.tictactoe.entity.player;

import org.lld.tictactoe.entity.playingpiece.PlayingPiece;

public class Player {

    PlayingPiece playingPiece;
    String name;

    public Player(PlayingPiece playingPiece, String name){
        this.playingPiece = playingPiece;
        this.name = name;
    }

    public PlayingPiece getPlayingPiece() {
        return playingPiece;
    }

    public String getName() {
        return name;
    }
}
