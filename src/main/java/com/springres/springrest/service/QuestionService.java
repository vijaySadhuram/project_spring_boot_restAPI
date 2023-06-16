package com.springres.springrest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.springres.springrest.entities.Question;
import com.springres.springrest.repository.QuestionRepository;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Service
public class QuestionService {
    @Autowired
    private QuestionRepository questionRepository;

    public void fetchAndStoreQuestions() {
        try {
            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<QuestionResponse[]> response = restTemplate.getForEntity("https://jservice.io/api/random?count=5", QuestionResponse[].class);

            if (response.getStatusCode() == HttpStatus.OK) {
                QuestionResponse[] questionResponses = response.getBody();
                if (questionResponses != null) {
                    for (QuestionResponse questionResponse : questionResponses) {
                        Question question = new Question(questionResponse.getAnswer(), questionResponse.getQuestion());
                        questionRepository.save(question);
                    }
                }
            } else {
                System.out.println("Failed to fetch questions. API returned status code: " + response.getStatusCode());
            }
        } catch (RestClientException e) {
            System.out.println("Failed to fetch questions from the API: " + e.getMessage());
        }
    }

    private static class QuestionResponse {
        private String answer;
        private String question;

        public String getAnswer() {
            return answer;
        }

        public void setAnswer(String answer) {
            this.answer = answer;
        }

        public String getQuestion() {
            return question;
        }

        public void setQuestion(String question) {
            this.question = question;
        }
    }
}


