package com.example.university.controller;

import com.example.university.entity.University;
import com.example.university.service.UniversityService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public class UniversityController {

    private final UniversityService universityService;

    public UniversityController(UniversityService universityService) {
        this.universityService = universityService;
    }

    @GetMapping(value="/university", params = "name")
    public List<University> getUniversitiesByName(@RequestParam String name) {
        return universityService.getUniversitiesByName(name);
    }

    @GetMapping(value="/university", params="country")
    public List<University> getUniversitiesByCountry(@RequestParam String country) {
        return universityService.getUniversitiesByCountry(country);
    }
}
