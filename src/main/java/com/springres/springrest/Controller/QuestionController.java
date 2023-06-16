package com.springres.springrest.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.springres.springrest.entities.Question;
import com.springres.springrest.repository.QuestionRepository;
import com.springres.springrest.service.QuestionService;

@RestController
@RequestMapping("/questions")
public class QuestionController {

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private QuestionService questionService;
    
    
 
    @GetMapping("/play")
    public ResponseEntity<?> getQuestionForPlay() {
        Question question = questionRepository.getRandomQuestion();
        if (question != null) {
            QuestionResponse questionResponse = new QuestionResponse(question.getId(), question.getQuestion());
            return ResponseEntity.ok(questionResponse);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

   
    
    @PostMapping("/next")
    public ResponseEntity<NextQuestionResponse> getNextQuestion(@RequestBody AnswerRequest answerRequest) {
        Long questionId = answerRequest.getQuestionId();
        String answer = answerRequest.getAnswer();

        Question previousQuestion = questionRepository.findById(questionId).orElse(null);
        if (previousQuestion == null) {
            return ResponseEntity.notFound().build();
        }

        String correctAnswer = previousQuestion.getAnswer();
        Question nextQuestion = questionRepository.getRandomQuestion();

        NextQuestionResponse nextQuestionResponse = new NextQuestionResponse(correctAnswer, nextQuestion.getId(), nextQuestion.getQuestion());
        return ResponseEntity.ok(nextQuestionResponse);
    }
    
    @GetMapping("/fetch")
    public ResponseEntity<?> fetchAndStoreQuestions() {
        questionService.fetchAndStoreQuestions();
        return ResponseEntity.ok("Questions fetched and stored successfully.");
    }

    private static class QuestionResponse {
        private Long questionId;
        private String question;
        
        public QuestionResponse() {
        }

        public QuestionResponse(Long questionId, String question) {
            this.questionId = questionId;
            this.question = question;
        }

        public Long getQuestionId() {
            return questionId;
        }
//
        public void setQuestionId(Long questionId) {
            this.questionId = questionId;
        }

        public String getQuestion() {
            return question;
        }

        public void setQuestion(String question) {
            this.question = question;
        }

    }

    private static class AnswerRequest {
        private Long questionId;
        private String answer;

        
        public AnswerRequest() {
        }

        public Long getQuestionId() {
            return questionId;
        }

        public void setQuestionId(Long questionId) {
            this.questionId = questionId;
        }

        public String getAnswer() {
            return answer;
        }
//
        public void setAnswer(String answer) {
            this.answer = answer;
        }
//        Getters and setters
    }

    private static class NextQuestionResponse {
        private String correctAnswer;
        private Long questionId;
        private String question;

        public NextQuestionResponse(String correctAnswer, Long questionId, String question) {
            this.correctAnswer = correctAnswer;
            this.questionId = questionId;
            this.question = question;
        }
        public String getCorrectAnswer() {
            return correctAnswer;
        }

        public void setCorrectAnswer(String correctAnswer) {
            this.correctAnswer = correctAnswer;
        }

        public Long getQuestionId() {
            return questionId;
        }
//
        public void setQuestionId(Long questionId) {
            this.questionId = questionId;
        }
//
        public String getQuestion() {
            return question;
        }
//
        public void setQuestion(String question) {
            this.question = question;
        }
     
  }
}
