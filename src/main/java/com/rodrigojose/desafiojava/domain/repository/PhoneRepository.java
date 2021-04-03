package com.rodrigojose.desafiojava.domain.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rodrigojose.desafiojava.model.Phone;

@Repository
public interface PhoneRepository extends JpaRepository<Phone, Long> {

}
