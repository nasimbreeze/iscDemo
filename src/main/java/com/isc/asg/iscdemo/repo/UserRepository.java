package com.isc.asg.iscdemo.repo;

import com.isc.asg.iscdemo.model.Card;
import com.isc.asg.iscdemo.model.User;
import org.springframework.data.repository.Repository;

import java.util.Optional;

public interface UserRepository extends Repository<User, Long> {
    Optional<User> findByCards(Card cards);
}