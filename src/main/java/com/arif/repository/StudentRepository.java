package com.arif.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.arif.model.Student;

public interface StudentRepository extends MongoRepository<Student, Integer> {

	@Query("{currClass : ?0}")
	List<Student> findByCurrClass(String currClass);
}
