package com.suvam.springtokenpractice.repo;

import com.suvam.springtokenpractice.model.Officer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<Officer, Integer> {
    Officer findByUsername(String username);
}
