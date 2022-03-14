package com.sofka.bingo.controllers;

import com.sofka.bingo.models.BallotGameModel;
import com.sofka.bingo.models.CartoonModel;
import com.sofka.bingo.models.GameHasUserModel;
import com.sofka.bingo.models.GameModel;
import com.sofka.bingo.services.BallotGameService;
import com.sofka.bingo.services.CartoonService;
import com.sofka.bingo.services.GameHasUserService;
import com.sofka.bingo.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/game")
public class
GameController {
    @Autowired
    GameService gameService;

    @Autowired
    GameHasUserService gameHasUserService;

    @Autowired
    BallotGameService ballotGameService;

    @Autowired
    CartoonService cartoonService;

    @GetMapping("/all")
    public List<GameModel> getAllGames(){
        return gameService.getAll();
    }

    @GetMapping("/status")
    public List<GameModel> getGamesByStatus(@RequestParam(name = "status") String status){
        return gameService.getByStatus(status);
    }

    @PostMapping("/save")
    public GameModel saveGame(@RequestBody GameModel game) {
        return gameService.save(game);
    }

    @PutMapping("/start_game/{id}")
    public Optional <GameModel> startGame(@PathVariable("id") Integer gameId) {
        gameService.startGame(gameId);
        return gameService.getById(gameId);
    }

    @PutMapping("/end_game/{id}")
    public Optional <GameModel> endGame(@PathVariable("id") Integer gameId) {
        gameService.endGame(gameId);
        return gameService.getById(gameId);
    }

    @GetMapping("/{id}/user")
    public List<GameHasUserModel> getUsersByGameId(@PathVariable("id") Integer gameId){
        return gameHasUserService.getByGameId(gameId);
    }

    @PostMapping("/user/save")
    public GameHasUserModel saveUser(@RequestBody GameHasUserModel user) {
        return gameHasUserService.save(user);
    }

    @PostMapping("/ballot_used/save")
    public BallotGameModel saveBallotUsed(@RequestBody BallotGameModel ballot) {
        return ballotGameService.save(ballot);
    }

    @GetMapping("/{id}/ballot")
    public List<BallotGameModel> getBallotByGameId(@PathVariable("id") Integer gameId) {
        return ballotGameService.getByGameId(gameId);
    }

    @PostMapping("/cartoon/save")
    public CartoonModel saveCartoon(@RequestBody CartoonModel cartoon) {
        return cartoonService.save(cartoon);
    }

    @GetMapping("/{id}/cartoon/user/{userId}")
    public List<CartoonModel> getCartoonByGameIdAndUser(@PathVariable("id") Integer gameId, @PathVariable("userId") String userId) {
        return cartoonService.getByGameIdAndUser(gameId, userId);
    }
}
