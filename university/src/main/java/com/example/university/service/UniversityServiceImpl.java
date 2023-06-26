package com.example.university.service;

import com.example.university.entity.University;
import com.example.university.entity.UniversityResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class UniversityServiceImpl implements UniversityService {

    @Autowired
    private final RestTemplate restTemplate;

    public UniversityServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public List<University> getUniversitiesByName(String name) {
        String url = "https://universities.hipolabs.com/search?name=" + name;
        UniversityResponse response = restTemplate.getForObject(url, UniversityResponse.class);
        return response.getUniversities();
    }

    @Override
    public List<University> getUniversitiesByCountry(String country) {
        String url = "https://universities.hipolabs.com/search?country=" + country;
        UniversityResponse response = restTemplate.getForObject(url, UniversityResponse.class);
        return response.getUniversities();
    }
}
