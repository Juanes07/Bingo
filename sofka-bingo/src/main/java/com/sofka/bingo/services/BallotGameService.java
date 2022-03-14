package com.sofka.bingo.services;

import com.sofka.bingo.models.BallotGameModel;
import com.sofka.bingo.repositories.BallotGameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BallotGameService {
    @Autowired
    BallotGameRepository ballotGameRepository;

    public List<BallotGameModel> getAll(){
        return (List<BallotGameModel>) ballotGameRepository.findAll();
    }

    public List<BallotGameModel> getByGameId(Integer gameId){
        return ballotGameRepository.findByGameId(gameId);
    }

    public BallotGameModel save(BallotGameModel ballot) {
        return ballotGameRepository.save(ballot);
    }
}
