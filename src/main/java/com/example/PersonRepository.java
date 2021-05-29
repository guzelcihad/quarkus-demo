package com.example;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author Cihad G&uuml;zel
 */
public interface PersonRepository extends JpaRepository<Person, Integer> {
}
