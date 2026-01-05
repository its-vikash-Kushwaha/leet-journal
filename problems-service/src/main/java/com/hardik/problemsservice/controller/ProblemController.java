package com.hardik.problemsservice.controller;

import com.hardik.problemsservice.model.Problem;
import com.hardik.problemsservice.service.ProblemService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProblemController {

    private final ProblemService problemService;

    public ProblemController(ProblemService problemService) {
        this.problemService = problemService;
    }

    @GetMapping("/hello")
    String hello() {
        return "Leet";
    }

    @GetMapping("/all")
    List<Problem> findAll() {
        return problemService.findAll();
    }
}
