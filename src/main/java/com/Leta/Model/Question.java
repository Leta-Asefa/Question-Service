package com.Leta.Model;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
@Data
@Component
@Entity
public class Question {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	String questionTitle;
	String option1;
	String option2;
	String option3;
	String option4;
	String rightAnswer;
	String category;
	String difficultyLevel;
	
	
}
