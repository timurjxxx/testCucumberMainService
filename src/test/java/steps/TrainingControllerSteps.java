package steps;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.gypApp_main.controller.TrainingController;
import com.gypApp_main.model.Trainee;
import com.gypApp_main.model.Trainer;
import com.gypApp_main.model.Training;
import com.gypApp_main.model.TrainingSearchCriteria;
import com.gypApp_main.service.TrainingService;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

public class TrainingControllerSteps {

    @InjectMocks
    private TrainingController trainingController;

    @Mock
    private TrainingService trainingService;
    private ResponseEntity<Void> response;
    private ResponseEntity<String> trainingResponse;

    private Training training;
    private TrainingSearchCriteria criteria;

    private Trainer trainer;
    private Trainee trainee;

    public  TrainingControllerSteps() {
        MockitoAnnotations.openMocks(this);
    }
    @Given("a training request with trainer {string}, trainee {string}, and training type {string}")
    public void givenTrainingRequest(String trainerUsername, String traineeUsername, String trainingTypeName) {
        training.setTrainingName("name");
        training.setTrainingDate(LocalDate.now());
        training.setTrainingDuration(90);



    }

    @Given("a training with name {string}")
    public void givenTrainingWithName(String trainingName) {

        // Подготовьте тестовые данные, если это необходимо
    }

    @Given("a trainee with username {string} and search criteria")
    public void givenTraineeWithCriteria(String traineeUsername) {
        // Подготовьте тестовые данные, если это необходимо
    }

    @Given("a trainer with username {string} and search criteria")
    public void givenTrainerWithCriteria(String trainerUsername) {
        // Подготовьте тестовые данные, если это необходимо
    }

    @When("the create training request is sent to the API")
    public void whenCreateTrainingRequestSentToAPI() throws JsonProcessingException {
        when(trainingService.addTraining(any(Training.class), anyString(), anyString(), anyString())).thenReturn(new Training());
        response = trainingController.createTraining(training);    }

    @When("the delete training request is sent to the API")
    public void whenDeleteTrainingRequestSentToAPI() throws JsonProcessingException {
         trainingController.deleteTraining(anyString());
         response = ResponseEntity.ok().build();
    }

    @When("the get trainee trainings by criteria request is sent to the API")
    public void whenGetTraineeTrainingsByCriteriaRequestSentToAPI() {
        response = trainingController.getTraineeTrainingsByCriteria();
    }

    @When("the get trainer trainings by criteria request is sent to the API")
    public void whenGetTrainerTrainingsByCriteriaRequestSentToAPI() {
        response = trainingController.getTrainerTrainingsByCriteria(/* ваш запрос */);
    }

    @Then("the API should return a successful response indicating the training is created")
    public void thenApiShouldReturnSuccessfulResponseIndicatingTrainingCreated() {
        assertEquals(200, trainingResponse.getStatusCodeValue());

    }

    @Then("the API should return a successful response indicating the training is deleted")
    public void thenApiShouldReturnSuccessfulResponseIndicatingTrainingDeleted() {
        assertEquals(200, trainingResponse.getStatusCodeValue());

    }

    @Then("the API should return a successful response with the trainee's trainings based on the criteria")
    public void thenApiShouldReturnSuccessfulResponseWithTraineeTrainingsBasedOnCriteria() {
        // Проверьте успешный ответ от API
        // Проверьте возвращаемые данные, если это необходимо
        // Проверьте успешный ответ от API
        assertEquals(200, trainingResponse.getStatusCodeValue());


    }

    @Then("the API should return a successful response with the trainer's trainings based on the criteria")
    public void thenApiShouldReturnSuccessfulResponseWithTrainerTrainingsBasedOnCriteria() {
        assertEquals(200, trainingResponse.getStatusCodeValue());

    }

    @Given("an invalid request or criteria")
    public void anInvalidRequestOrCriteria() {

    }

    @Then("the API should return an appropriate error response")
    public void theAPIShouldReturnAnAppropriateErrorResponse() {
    }
}
