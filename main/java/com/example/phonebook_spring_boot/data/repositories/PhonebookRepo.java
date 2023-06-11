package com.example.phonebook_spring_boot.data.repositories;

import com.example.phonebook_spring_boot.data.models.Phonebook;
import com.example.phonebook_spring_boot.exceptions.DatabaseConnectionFailedException;
import com.example.phonebook_spring_boot.exceptions.PhonebookDoesNotExistException;
import com.example.phonebook_spring_boot.exceptions.TableCreationFailedException;

import java.util.Optional;

public interface PhonebookRepo {
	Optional<Phonebook> save(Phonebook phonebook) throws DatabaseConnectionFailedException, TableCreationFailedException, PhonebookDoesNotExistException;
	Optional<Phonebook> findPhonebookById(int id) throws DatabaseConnectionFailedException, PhonebookDoesNotExistException;
	Optional<Phonebook> findPhonebookByName(String phonebookName) throws DatabaseConnectionFailedException, PhonebookDoesNotExistException;
	void deletePhonebookById(int id) throws DatabaseConnectionFailedException, PhonebookDoesNotExistException;
	void deleteAll() throws DatabaseConnectionFailedException;
	void deleteDatabase() throws DatabaseConnectionFailedException;
}