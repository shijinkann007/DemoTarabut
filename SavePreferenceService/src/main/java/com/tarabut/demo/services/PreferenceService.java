package com.tarabut.demo.services;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tarabut.demo.entities.Preferences;
import com.tarabut.demo.exceptions.EntityNotFoundException;
import com.tarabut.demo.repositories.PreferenceRepository;



@Service
public class PreferenceService {

	@Autowired
	private PreferenceRepository repository;

	public Preferences insert(@Valid Preferences preferences) throws EntityNotFoundException {
 		return repository.insert(preferences);
	}

	public Preferences save(@Valid Preferences preferences) throws EntityNotFoundException {
 		return repository.save(preferences);
	}
}
