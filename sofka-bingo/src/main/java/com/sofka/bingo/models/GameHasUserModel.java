package com.sofka.bingo.models;

import javax.persistence.*;

@Entity
@Table(name = "game_has_user")
public class GameHasUserModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;

    @Column(name = "user_id")
    private String userId;

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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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
