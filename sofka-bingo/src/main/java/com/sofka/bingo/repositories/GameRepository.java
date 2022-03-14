package com.sofka.bingo.repositories;

import com.sofka.bingo.models.GameModel;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface GameRepository extends CrudRepository<GameModel, Integer> {
    List<GameModel> findByStatus(String status);

    Optional<GameModel> findById(Integer id);

    @Transactional
    @Modifying
    @Query(value = "UPDATE game SET status='ACTIVE' WHERE id = :id", nativeQuery = true)
    void startGame(@Param("id") Integer id);

    @Transactional
    @Modifying
    @Query(value = "UPDATE game SET status='INACTIVE' WHERE id = :id", nativeQuery = true)
    void endGame(@Param("id") Integer id);
}
