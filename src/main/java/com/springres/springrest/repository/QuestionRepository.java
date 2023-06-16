package com.springres.springrest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.springres.springrest.entities.Question;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {

    @Query(value = "SELECT * FROM questions ORDER BY RAND() LIMIT 1;", nativeQuery = true)
    Question getRandomQuestion();
    
}

