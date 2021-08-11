package com.tarabut.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tarabut.demo.entities.Preferences;
import com.tarabut.demo.exceptions.EntityNotFoundException;
import com.tarabut.demo.repositories.PreferenceRepository;



@Service
public class PreferenceService {

	@Autowired
	private PreferenceRepository repository;

	public List<Preferences> findByEmail(String email) throws EntityNotFoundException {
		return repository.findByEmail(email);
		 
	}
	
	public List<Preferences> findByMobileNumber(String mobileNumber) throws EntityNotFoundException {
		return repository.findByMobileNumber(mobileNumber);
		 
	}
	
	public List<Preferences> findAll() {
		return repository.findAll();
	}
	
}
