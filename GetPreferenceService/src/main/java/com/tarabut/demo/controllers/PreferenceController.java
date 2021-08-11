package com.tarabut.demo.controllers;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tarabut.demo.dto.GenericResponse;
import com.tarabut.demo.entities.Preferences;
import com.tarabut.demo.exceptions.EntityNotFoundException;
import com.tarabut.demo.services.PreferenceService;
import com.tarabut.demo.util.GenericResponseUtils;

@Validated
@RestController
@RequestMapping(path = "/api/preference")
public class PreferenceController {

	@Autowired
	private PreferenceService service;
	 
	@GetMapping(value = "/email/{email}")
 	public ResponseEntity<GenericResponse> getPreferenceByEmail(@PathVariable @NotBlank String email) throws EntityNotFoundException {	 
		List<Preferences> preferencesbyemail =  service.findByEmail(email);
		if (preferencesbyemail.isEmpty()) {
			throw new EntityNotFoundException("No preferences found for customer with email " + email);
		}		 
 		return ResponseEntity.ok(GenericResponseUtils.buildGenericResponseOK(preferencesbyemail));

	}
	@GetMapping(value = "/mobile/{mobileNumber}")
 	public ResponseEntity<GenericResponse> getPreferenceByMobilePhone(@PathVariable @NotBlank String mobileNumber) throws EntityNotFoundException {	 
		List<Preferences> preferencesbyemail =  service.findByMobileNumber(mobileNumber);
		if (preferencesbyemail.isEmpty()) {
			throw new EntityNotFoundException("No preferences found for customer with mobileNumber " + mobileNumber);
		}		 
 		return ResponseEntity.ok(GenericResponseUtils.buildGenericResponseOK(preferencesbyemail));

	}
	@GetMapping
	public ResponseEntity<GenericResponse> getAllPreferences() throws EntityNotFoundException {
		List<Preferences> allPreferences = service.findAll();
		if (allPreferences.isEmpty()) {
			throw new EntityNotFoundException("No preferences found.");
		}
		return ResponseEntity.ok(GenericResponseUtils.buildGenericResponseOK(allPreferences));
	}

}
