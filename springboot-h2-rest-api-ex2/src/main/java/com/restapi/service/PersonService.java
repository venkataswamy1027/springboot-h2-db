package com.restapi.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restapi.model.Person;
import com.restapi.repository.PersonRepository;

@Service
public class PersonService {
	private static final Logger LOGGER = LoggerFactory.getLogger(PersonService.class);
	@Autowired
	private PersonRepository personRepository;

	public List<Person> list() {
		LOGGER.info("list method executed");
		return (List<Person>) personRepository.findAll();
	}

	public Person getPersonById(int personId) {
		LOGGER.info("getPersonById method executed");
		return personRepository.findById(personId).get();
	}

	public Person createPerson(Person person) {
		LOGGER.info("createPerson method executed");
		return personRepository.save(person);
	}

	public Person update(Person person, int personId) {
		LOGGER.info("update method executed");
		person.setId(personId);
		return personRepository.save(person);
	}

	public void delete(int personId) {
		LOGGER.info("update method executed");
		personRepository.deleteById(personId);
	}
}
