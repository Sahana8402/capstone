package com.capstone.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capstone.model.Feedback;
import com.capstone.repository.FeedbackRepository;

@Service
public class FeedbackService {
	
	@Autowired
	private FeedbackRepository repository;
	
	public Feedback addFeedback(Feedback newFeedback) {
		return repository.save(newFeedback);
	}
	
	public Optional<Feedback> getUserId(long user_id) {
		return repository.findById(user_id);
	}
	
	public Optional<Feedback> getBusId(long bus_id) {
		return repository.findById(bus_id);
	}
	
	public List<Feedback> getAll() {
		return repository.findAll();
	}
	
	

}
