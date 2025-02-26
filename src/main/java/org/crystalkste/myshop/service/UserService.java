package org.crystalkste.myshop.service;

import jakarta.transaction.Transactional;
import org.crystalkste.myshop.entity.User;
import org.crystalkste.myshop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Transactional
    public void transForMoney(Long fromUserId, Long toUserId, Double amount) {
        User fromUser = userRepository.findById(fromUserId).orElseThrow(()->new RuntimeException("User not found"));
        User toUser = userRepository.findById(toUserId).orElseThrow(()->new RuntimeException("User not found"));
        if(fromUser.getBalance()<amount){
            throw new RuntimeException("Not enough money");
        }
        fromUser.setBalance(fromUser.getBalance()-amount);
        userRepository.save(fromUser);
        toUser.setBalance(toUser.getBalance()+amount);
        userRepository.save(toUser);
        }
}
