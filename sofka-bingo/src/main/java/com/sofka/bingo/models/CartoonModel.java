package com.sofka.bingo.models;

import javax.persistence.*;

@Entity
@Table(name = "cartoon")
public class CartoonModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "game_id")
    private Integer gameId;

    @Column(name = "b")
    private String b;

    @Column(name = "i")
    private String i;

    @Column(name = "n")
    private String n;

    @Column(name = "g")
    private String g;

    @Column(name = "o")
    private String o;

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

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }

    public String getI() {
        return i;
    }

    public void setI(String i) {
        this.i = i;
    }

    public String getN() {
        return n;
    }

    public void setN(String n) {
        this.n = n;
    }

    public String getG() {
        return g;
    }

    public void setG(String g) {
        this.g = g;
    }

    public String getO() {
        return o;
    }

    public void setO(String o) {
        this.o = o;
    }

    public GameModel getGame() {
        return game;
    }

    public void setGame(GameModel game) {
        this.game = game;
    }
}
