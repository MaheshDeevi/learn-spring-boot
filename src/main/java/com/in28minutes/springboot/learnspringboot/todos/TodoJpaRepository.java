package com.in28minutes.springboot.learnspringboot.todos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoJpaRepository extends JpaRepository<ToDo,Long> {

 List<ToDo> findByUsername(String username);

}
