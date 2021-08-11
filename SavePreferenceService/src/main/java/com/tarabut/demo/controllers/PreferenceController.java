package com.tarabut.demo.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tarabut.demo.annotations.Secured;
import com.tarabut.demo.dto.GenericResponse;
import com.tarabut.demo.entities.Preferences;
import com.tarabut.demo.exceptions.EntityNotFoundException;
import com.tarabut.demo.services.PreferenceService;
import com.tarabut.demo.util.GenericResponseUtils;

@RestController
@RequestMapping(path = "/api/preference")
public class PreferenceController {

	@Autowired
	private PreferenceService service;
	

	@Secured
	@PostMapping
	public ResponseEntity<GenericResponse> insertPreference(@RequestBody @Valid Preferences preferences)
			throws EntityNotFoundException {
		Preferences preferencesInserted=null;
		try {
			 preferencesInserted = service.insert(preferences);

       }catch (RuntimeException e) {
        	 return ResponseEntity.ok(GenericResponseUtils.buildGenericResponseError(e.getMessage()));
       }
		
		
		return ResponseEntity.ok(GenericResponseUtils.buildGenericResponseOK(preferencesInserted));
	}

	@Secured
	@PutMapping
	public ResponseEntity<GenericResponse> updatePreference(@RequestBody @Valid Preferences preferences)
			throws EntityNotFoundException {
		Preferences preferencepdated = service.save(preferences);
		return ResponseEntity.ok(GenericResponseUtils.buildGenericResponseOK(preferencepdated));
	}

}
