package com.sofka.bingo.services;

import com.sofka.bingo.models.CartoonModel;
import com.sofka.bingo.repositories.CartoonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartoonService {
    @Autowired
    CartoonRepository cartoonRepository;

    public List<CartoonModel> getByGameIdAndUser(Integer gameId, String userId){
        return cartoonRepository.findByGameIdAndUserId(gameId, userId);
    }

    public CartoonModel save(CartoonModel cartoon) {
        return cartoonRepository.save(cartoon);
    }
}
