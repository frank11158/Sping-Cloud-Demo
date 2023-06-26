package com.example.university.service;

import com.example.university.entity.University;

import java.util.List;

public interface UniversityService {
    List<University> getUniversitiesByName(String name);
    List<University> getUniversitiesByCountry(String country);
}
