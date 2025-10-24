package com.rishi.review.controller;

import com.rishi.review.entity.Review;
import com.rishi.review.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reviewapi")
@CrossOrigin(origins = "*")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @GetMapping("/")
    public String home() {
        return "Movie Review API is Running!";
    }

    @PostMapping("/add")
    public ResponseEntity<Review> addReview(@RequestBody Review review) {
        return new ResponseEntity<>(reviewService.addReview(review), HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Review>> getAllReviews() {
        return new ResponseEntity<>(reviewService.getAllReviews(), HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> getReviewById(@PathVariable int id) {
        Review review = reviewService.getReviewById(id);
        if (review != null) {
            return new ResponseEntity<>(review, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Review with ID " + id + " not found.", HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateReview(@RequestBody Review review) {
        Review existing = reviewService.getReviewById(review.getId());
        if (existing != null) {
            return new ResponseEntity<>(reviewService.updateReview(review), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Cannot update. Review with ID " + review.getId() + " not found.", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteReview(@PathVariable int id) {
        Review existing = reviewService.getReviewById(id);
        if (existing != null) {
            reviewService.deleteReviewById(id);
            return new ResponseEntity<>("Review with ID " + id + " deleted successfully.", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Cannot delete. Review with ID " + id + " not found.", HttpStatus.NOT_FOUND);
        }
    }
}
