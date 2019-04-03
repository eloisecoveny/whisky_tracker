package com.codeclan.example.WhiskyTracker;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.DistilleryRepository.DistilleryRepository;
import com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository.WhiskyRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WhiskyTrackerApplicationTests {

	@Autowired
	WhiskyRepository whiskyRepository;

	@Autowired
	DistilleryRepository distilleryRepository;

	@Test
	public void contextLoads() {
	}

	@Test
	public void canGetAllWhiskiesFromAParticularYear(){
		List<Whisky> found = whiskyRepository.findWhiskiesByYear(1991);
		assertEquals(1, found.size());
	}

	@Test
	public void canGetAllDistilleriesFromAParticularRegion(){
		List<Distillery> found = distilleryRepository.findDistilleriesByRegion("Highland");
		assertEquals(1, found.size());
	}

	@Test
	public void canGetAllWhiskiesFromAParticularDistilleryOfASpecificAge(){
		List<Whisky> found = whiskyRepository.findWhiskiesByDistilleryIdAndAge(2L, 12);
		assertEquals(1, found.size());
	}

	@Test
	public void canGetAllWhiskiesFromAParticularRegion(){
		List<Whisky> found = whiskyRepository.findWhiskiesFromRegion("Highland");
		assertEquals(2, found.size());
	}

	@Test
	public void canGetDistilleriesThatHaveWhiskiesThatAreOver12YearsOld(){
		List<Distillery> found = distilleryRepository.findDistilleriesWithWhiskiesOverAge(12);
		assertEquals(2, found.size());
	}
}
