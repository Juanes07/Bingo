package com.sofka.bingo.repositories;

import com.sofka.bingo.models.GameHasUserModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GameHasUserRepository  extends CrudRepository<GameHasUserModel, Integer> {
    List<GameHasUserModel> findByGameId(Integer gameId);
}
