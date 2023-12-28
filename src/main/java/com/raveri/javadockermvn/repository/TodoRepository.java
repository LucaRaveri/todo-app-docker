package com.raveri.javadockermvn.repository;

import com.raveri.javadockermvn.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Long> {
}
