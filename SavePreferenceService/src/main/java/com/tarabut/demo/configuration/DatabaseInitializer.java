package com.tarabut.demo.configuration;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.annotation.PostConstruct;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tarabut.demo.entities.Preferences;
import com.tarabut.demo.repositories.PreferenceRepository;

@Component
public class DatabaseInitializer {

 
	@Autowired
	private PreferenceRepository preferenceRepository;

	@PostConstruct
	public void init() {
		if (preferenceRepository.findAll().isEmpty()) {
			preferenceRepository.insert(getInitialData());
 		}
	}

	public List<Preferences> getInitialData() {
		List<Preferences> list = new ArrayList<>(0);
		
		list.add(new Preferences("shijinkann@gmail","Shijin Koyambil","+971556108826","SMS"));
		list.add(new Preferences("shijinkann007@gmail","Shijin Koyambil","+971556108826","SMS"));

		return list;
	}


}
