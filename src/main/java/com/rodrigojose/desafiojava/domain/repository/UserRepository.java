package com.rodrigojose.desafiojava.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rodrigojose.desafiojava.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	


}
