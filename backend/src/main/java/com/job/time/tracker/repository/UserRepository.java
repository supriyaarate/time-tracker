package com.job.time.tracker.repository;


import com.job.time.tracker.entity.JUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<JUser, Integer>{

	Optional<JUser> findByUsername(String username);
	Optional<JUser> findById(int id);
	
	Optional<JUser> findByEmail(String email);
}
