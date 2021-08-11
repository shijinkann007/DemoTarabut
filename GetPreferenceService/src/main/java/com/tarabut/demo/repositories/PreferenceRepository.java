package com.tarabut.demo.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.tarabut.demo.entities.Preferences;
//@RepositoryRestResourceList 
@Repository
public interface PreferenceRepository extends MongoRepository<Preferences, String> {

	public List<Preferences> findByEmail(String email);
	
	public List<Preferences> findByMobileNumber(String mobileNumber);


}
