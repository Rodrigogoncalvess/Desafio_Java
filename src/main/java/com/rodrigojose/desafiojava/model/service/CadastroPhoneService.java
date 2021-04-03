package com.rodrigojose.desafiojava.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rodrigojose.desafiojava.domain.repository.PhoneRepository;
import com.rodrigojose.desafiojava.model.Phone;

@Service
public class CadastroPhoneService {

	@Autowired
	private PhoneRepository phoneRepository;
	
	public Phone salvar(Phone phone) {
		return phoneRepository.save(phone);
		
	}
	
	public void excluir (Long phoneId) {
		phoneRepository.deleteById(phoneId);
		
	}
}
