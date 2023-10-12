package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Feedback;
import com.example.demo.repository.FeedbackRepository;
@Service
public class FeedbackService {
	 @Autowired
	    private FeedbackRepository feedbackRepository;

	    public Feedback createFeedback(Feedback feedback) {
	        return feedbackRepository.save(feedback);
	    }

	    public List<Feedback> getAllFeedback() {
	        return feedbackRepository.findAll();
	    }

	    public Feedback getFeedbackById(int id) {
	        return feedbackRepository.findById(id).orElse(null);
	    }

	    public void deleteFeedback(int id) {
	        feedbackRepository.deleteById(id);
	    }
}