package com.rodrigojose.desafiojava.model.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rodrigojose.desafiojava.domain.repository.PhoneRepository;
import com.rodrigojose.desafiojava.domain.repository.UserRepository;
import com.rodrigojose.desafiojava.model.Phone;
import com.rodrigojose.desafiojava.model.User;

@Service
public class CadastroUserService {

	
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PhoneRepository phoneRepository;
	

	
	
	public User salvar(User user) {
		return userRepository.save(user);
		
	}
	
	public void excluir (Long userId) {
		userRepository.deleteById(userId);
		
	}
	
	public Phone incluir(Phone phone) {
		Date data = new Date();
		return phoneRepository.save(phone);
	}
	

}
