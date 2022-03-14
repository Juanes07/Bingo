package com.sofka.bingo.services;

import com.sofka.bingo.models.GameModel;
import com.sofka.bingo.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GameService {
    @Autowired
    GameRepository gameRepository;

    public List<GameModel> getAll(){
        return (List<GameModel>) gameRepository.findAll();
    }

    public List<GameModel> getByStatus(String status){
        return gameRepository.findByStatus(status);
    }

    public Optional<GameModel> getById(Integer id){
        return gameRepository.findById(id);
    }

    public GameModel save(GameModel game) {
        return gameRepository.save(game);
    }

    public void startGame(Integer id) {
        gameRepository.startGame(id);
    }

    public void endGame(Integer id) {
        gameRepository.endGame(id);
    }
}
