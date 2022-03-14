package com.sofka.bingo.repositories;

import com.sofka.bingo.models.CartoonModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartoonRepository extends CrudRepository<CartoonModel, Integer> {
    List<CartoonModel> findByGameIdAndUserId(Integer gameId, String userId);
}
