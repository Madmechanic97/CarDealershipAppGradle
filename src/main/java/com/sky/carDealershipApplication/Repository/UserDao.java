package com.sky.carDealershipApplication.Repository;

import com.sky.carDealershipApplication.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Integer> {
}
