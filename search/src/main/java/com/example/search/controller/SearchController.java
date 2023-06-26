package com.example.search.controller;

import com.example.students.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.CompletableFuture;

@RestController
public class SearchController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/students/search")
    public ResponseEntity<?> getStudents(@RequestParam String universityName, @RequestParam String studentId) {
        CompletableFuture<String> studentInfoFuture = CompletableFuture.supplyAsync(() ->
            restTemplate.getForObject("http://localhost:9401/students/" + studentId, String.class)
        );

        CompletableFuture<String> UniversityInfoFuture = CompletableFuture.supplyAsync(() ->
                restTemplate.getForObject("http://localhost:9402/university/" + universityName, String.class)
        );

        CompletableFuture<String> result = studentInfoFuture.thenCombine(UniversityInfoFuture, (studentInfo, universityInfo) ->
                "Student Info: " + studentInfo + ", University: " + universityInfo
        );
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/weather/search")
    public ResponseEntity<?> getWeatherDetails() {
        //TODO
        return new ResponseEntity<>("this is search service", HttpStatus.OK);
    }
}
