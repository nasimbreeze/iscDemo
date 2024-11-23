package com.isc.asg.iscdemo.repo;

import com.isc.asg.iscdemo.model.User;
import org.springframework.data.repository.Repository;

public interface UserRepository extends Repository<User, Long> {
}