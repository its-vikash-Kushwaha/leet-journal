package com.hardik.problemsservice.repository;

import com.hardik.problemsservice.model.Problem;
import org.springframework.data.repository.ListCrudRepository;

public interface ProblemRepository extends ListCrudRepository<Problem, Integer> {
}