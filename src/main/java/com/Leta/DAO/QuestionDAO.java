package com.Leta.DAO;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.Leta.Model.Question;
import com.Leta.Model.Wrapper;


public interface QuestionDAO extends JpaRepository<Question, Long> {

	List<Question> findByCategory(String category);
	
	@Query(value="SELECT * FROM quizapp.question where category=:category order by rand() limit :num",nativeQuery=true)
	List<Question> createQuiz(@Param("category") String category,@Param("num") Integer num);

	
	@Query(value="SELECT q.id as id FROM quizapp.question q where category=:category order by rand() limit :num",nativeQuery=true)
	List<Integer> createQuizIds(@Param("category") String category,@Param("num") Integer num);

	
	@Query(value="select q.id as id,q.question_title as question_title,q.option1 as option1,q.option2 as option2,q.option3 as option3,q.option4 as option4 from quizapp.question q where q.id=:id",nativeQuery=true)
	Wrapper getQuestionWrapperById(Integer id);
	
	
	@Query(value="select q.right_answer as right_answer from quizapp.question q where q.id=:id",nativeQuery=true)
	Optional<Object> getRightAnswerById(Integer id);
	
	
	
	
	
}
