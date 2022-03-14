package com.sofka.bingo.models;

import javax.persistence.*;

@Entity
@Table(name = "ballot_game")
public class BallotGameModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;

    @Column(name = "ballot")
    private Integer ballot;

    @Column(name = "game_id")
    private Integer gameId;

    @ManyToOne
    @JoinColumn(name = "game_id", insertable = false, updatable = false)
    private GameModel game;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBallot() {
        return ballot;
    }

    public void setBallot(Integer ballot) {
        this.ballot = ballot;
    }

    public Integer getGameId() {
        return gameId;
    }

    public void setGameId(Integer gameId) {
        this.gameId = gameId;
    }

    public GameModel getGame() {
        return game;
    }

    public void setGame(GameModel game) {
        this.game = game;
    }
}
