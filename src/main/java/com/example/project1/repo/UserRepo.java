package com.example.project1.repo;

import com.example.project1.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepo extends JpaRepository<User,Integer> {


    @Query(value = "SELECT * FROM user WHERE user_id=?1", nativeQuery = true)
    public User getUserByUserId(String userId);

    @Query(value = "SELECT * FROM user WHERE user_id=?1 AND user_address=?2", nativeQuery = true)
    public User getUserByUserIdAndAddress(String userId, String address);
}
