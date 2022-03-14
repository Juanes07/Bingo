package com.sofka.bingo.services;

import com.sofka.bingo.models.GameHasUserModel;
import com.sofka.bingo.repositories.GameHasUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameHasUserService {
    @Autowired
    GameHasUserRepository gameHasUserRepository;

    public List<GameHasUserModel> getAll(){
        return (List<GameHasUserModel>) gameHasUserRepository.findAll();
    }

    public List<GameHasUserModel> getByGameId(Integer gameId){
        return gameHasUserRepository.findByGameId(gameId);
    }

    public GameHasUserModel save(GameHasUserModel user) {
        return gameHasUserRepository.save(user);
    }
}
