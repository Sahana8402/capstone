package com.capstone.controller;

import java.util.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
//import java.util.logging.Logger;
//import java.util.logging.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capstone.model.Feedback;
import com.capstone.service.FeedbackService;

@RestController
@RequestMapping("/bustrack/feedback")
public class FeedbackController {
	
	@Autowired
	FeedbackService service;
	//ArrayList<Feedback>feedlist=new ArrayList<>();
	
	@GetMapping(value="/user/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Feedback> getUserId(@PathVariable long user_id){
		Optional<Feedback>optional=service.getUserId(user_id);
		return ResponseEntity.status(HttpStatus.OK).body(optional.get());
		//return null;
	}
	
	@GetMapping(value="/bus/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Feedback> getBusId(@PathVariable long bus_id){
		Optional<Feedback>optional=service.getBusId(bus_id);
		return ResponseEntity.status(HttpStatus.OK).body(optional.get());
		//return null;
	}
	
	@GetMapping(value="/allfeed",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Feedback>> displayfeed(){
		return ResponseEntity.ok(service.getAll());
		//return null;
	}
	
	@PostMapping(value="/addfeed",consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)

	public ResponseEntity<Feedback> addFeedback(@RequestBody Feedback feedback){
		
		Feedback savedFeedback=service.addFeedback(feedback);
		return ResponseEntity.status(HttpStatusCode.valueOf(200)).body(savedFeedback);
	}

}
