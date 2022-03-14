package com.sofka.bingo.repositories;

import com.sofka.bingo.models.BallotGameModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BallotGameRepository extends CrudRepository<BallotGameModel, Integer> {
    List<BallotGameModel> findByGameId(Integer gameId);
}
