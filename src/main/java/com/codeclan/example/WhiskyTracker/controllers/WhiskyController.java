package com.codeclan.example.WhiskyTracker.controllers;

import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository.WhiskyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/whiskies")
public class WhiskyController {

    @Autowired
    WhiskyRepository whiskyRepository;

    @GetMapping
    public List<Whisky> getAllWhiskies(){
        return whiskyRepository.findAll();
    }

    @GetMapping(value = "year/{year}")
    public List<Whisky> findWhiskiesByYear(@PathVariable int year){
        return whiskyRepository.findWhiskiesByYear(year);
    }

    @GetMapping(value = "/distillery/{distilleryId}/{age}")
    public List<Whisky> findWhiskiesByDistilleryIdAndAge(@PathVariable Long distilleryId, @PathVariable int age){
        return whiskyRepository.findWhiskiesByDistilleryIdAndAge(distilleryId, age);
    }

    @GetMapping(value = "/region/{region}")
    public List<Whisky> findWhiskiesFromRegion(@PathVariable String region){
        return whiskyRepository.findWhiskiesFromRegion(region);
    }

}
