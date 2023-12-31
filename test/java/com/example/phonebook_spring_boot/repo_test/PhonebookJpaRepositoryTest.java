package com.example.phonebook_spring_boot.repo_test;

import com.example.phonebook_spring_boot.data.models.Phonebook;
import com.example.phonebook_spring_boot.data.repositories. PhonebookJpaRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigInteger;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PhonebookJpaRepositoryTest {
	
	Phonebook phonebook;
	@Autowired
	PhonebookJpaRepository jpaRepository;
	Phonebook savedPhonebook;
	
	@BeforeEach
	void setUp() {
		jpaRepository.deleteAll();
		phonebook = new Phonebook();
		phonebook.setName("Abdulmalik");
		savedPhonebook = jpaRepository.save(phonebook);
	}
	
	@AfterEach void tearDown() {
	}
	
	@Test void savePhonebookTest(){
		jpaRepository.deleteAll();
		assertEquals(BigInteger.ONE.intValue(), jpaRepository.count());
		assertNotNull(savedPhonebook);
		assertNotNull(savedPhonebook.getName());
	}
	
	@Test void savePhonebook_FindSavedPhonebookByIdTest(){
		Optional<Phonebook> foundPhonebook = jpaRepository.findById(phonebook.getId());
		assertThat(foundPhonebook).isPresent();
		assertEquals(foundPhonebook.get(), savedPhonebook);
	}
}