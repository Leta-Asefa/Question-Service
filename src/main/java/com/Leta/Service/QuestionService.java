package com.Leta.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.Leta.DAO.QuestionDAO;
import com.Leta.Model.Question;
import com.Leta.Model.QuestionWrapper;
import com.Leta.Model.Response;
import com.Leta.Model.Wrapper;

@Service
public class QuestionService {
	
	@Autowired
	QuestionDAO dao;

	public   ResponseEntity<List<Question> >getAllQuestions() {
		try {
			
			return new ResponseEntity<>(dao.findAll(),HttpStatus.OK);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);

	}

	public List<Question> getQuestionsByCategory(String category) {
		
		return dao.findByCategory(category);
	}

	public ResponseEntity<String> add(Question question) {
		dao.save(question);
		return new ResponseEntity<>("added successfully  !",HttpStatus.CREATED);
		
	}

	public ResponseEntity<String> delete(Long id) {
		dao.deleteById(id);
		return new ResponseEntity<>("Deleted successfully ! ",HttpStatus.OK);
	}
	
	public ResponseEntity<List<Integer>> generateQuestions(String category,Integer num){
		
		List<Integer> quiz=dao.createQuizIds(category, num);
		return new ResponseEntity<>(quiz,HttpStatus.BAD_REQUEST);

	}

	public ResponseEntity<List<QuestionWrapper>> getQuestions(List<Integer> questionsid){
		List<QuestionWrapper> wrapper=new ArrayList<>();
		
		
		for(int i=0;i<questionsid.size();i++) {
			Wrapper obj=dao.getQuestionWrapperById(questionsid.get(i));
			System.out.println(obj.getQuestion_title());
			wrapper.add(	
					new QuestionWrapper( 
										obj.getId(),
										obj.getQuestion_title(),
										obj.getOption1(),
										obj.getOption2(),
										obj.getOption3(),
										obj.getOption4()	))	;	
			}
		
		return new ResponseEntity<>(wrapper,HttpStatus.OK);
		
	}

	public ResponseEntity<Integer> getResponse(List<Response> responses) {
		int score=0;
		for (Response response : responses) {
			
			String rightAnswer=(String) dao.getRightAnswerById(response.getId()).get();
			
			if(response.getAnswer().equals(rightAnswer))
				score++;
		}
		return new ResponseEntity<>(score,HttpStatus.OK);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
