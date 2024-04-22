package com.gypApp_main.controller;

import com.gypApp_main.model.Trainee;
import com.gypApp_main.model.Trainer;
import com.gypApp_main.model.User;
import com.gypApp_main.service.TraineeService;
import com.gypApp_main.service.TrainerService;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

public class TraineeControllerSteps {

    @InjectMocks
    private TraineeController traineeController;

    @Mock
    private TraineeService traineeService;

    @Mock
    private TrainerService trainerService;
    Trainee trainee = new Trainee();


    private ResponseEntity<String> response;
    private ResponseEntity<Void> responseVoid;

    public TraineeControllerSteps() {
        MockitoAnnotations.initMocks(this);
    }

    @Given("a trainee with username {string}")
    public void givenTraineeWithUsername(String username) {
        User user = new User();
        user.setFirstName("name");
        user.setIsActive(true);
        user.setLastName("lastnaem");
        trainee.setAddress("test");
        trainee.setDateOfBirth(LocalDate.now());
        trainee.setUser(user);

        // Здесь вы можете подготовить тестовые данные для запроса, если это необходимо
        when(traineeService.selectTraineeByUserName(username)).thenReturn(trainee);

    }

    @Given("a list of trainer usernames")
    public void givenListOfTrainerUsernames(List<String> trainerUsernames) {
        Set<Trainer> trainers = new HashSet<>();
        for (String trainerUsername : trainerUsernames) {
            Trainer trainer = new Trainer();
            when(trainerService.selectTrainerByUserName(trainerUsername)).thenReturn(trainer);
            trainers.add(trainer);
        }
    }

    @When("the get trainee profile request is sent to the API")
    public void whenGetTraineeProfileRequestSentToAPI() {
        // Отправка запроса на контроллер поездника
        response = traineeController.getTraineeProfile("username");
    }

    @When("the update trainee profile request is sent to the API")
    public void whenUpdateTraineeProfileRequestSentToAPI() {
        // Отправка запроса на контроллер поездника
        response = traineeController.updateTraineeProfile("username", trainee);
    }

    @When("the delete trainee profile request is sent to the API")
    public void whenDeleteTraineeProfileRequestSentToAPI() {
        // Отправка запроса на контроллер поездника
        responseVoid = traineeController.deleteTraineeProfile("name");
    }

    @When("the update trainee trainers list request is sent to the API")
    public void whenUpdateTraineeTrainersListRequestSentToAPI() {
        // Отправка запроса на контроллер поездника
        response = traineeController.updateTraineeTrainersList("username ", new HashMap<>());
    }

    @When("the activate/deactivate trainee request is sent to the API")
    public void whenActivateDeactivateTraineeRequestSentToAPI() {
        // Отправка запроса на контроллер поездника
        responseVoid = traineeController.activateDeactivateTrainee("username");
    }

    @Then("the API should return a successful response with the trainee profile")
    public void thenApiShouldReturnSuccessfulResponseWithTraineeProfile() {
        assertEquals(HttpStatus.OK, response.getStatusCode());
        // Проверка возвращаемых данных, если необходимо
        // Пример: Проверка, что ответ содержит профиль ученика
        assertTrue(response.getBody().contains("traineeProfile"));
    }

    @Then("the API should return a successful response with the updated trainee profile")
    public void thenApiShouldReturnSuccessfulResponseWithUpdatedTraineeProfile() {
        // Проверка успешного ответа от API
        // Проверка возвращаемых данных, если необходимо
    }

    @Then("the API should return a successful response and delete the trainee profile")
    public void thenApiShouldReturnSuccessfulResponseAndDeleteTraineeProfile() {
        // Проверка успешного ответа от API
        // Проверка удаления профиля поездника
    }

    @Then("the API should return a successful response with the updated trainee's trainers list")
    public void thenApiShouldReturnSuccessfulResponseWithUpdatedTraineesTrainersList() {
        // Проверка успешного ответа от API
        // Проверка возвращаемых данных, если необходимо
    }

    @Then("the API should return a successful response and activate or deactivate the trainee")
    public void thenApiShouldReturnSuccessfulResponseAndActivateDeactivateTrainee() {
        // Проверка успешного ответа от API
        // Проверка активации или деактивации поездника
    }

    @When("the activate/deactivate trainee request is sent to the API")
    public void theActivateDeactivateTraineeRequestIsSentToTheAPI() {
    }


    @Given("an invalid trainee profile request")
    public void anInvalidTraineeProfileRequest() {

    }

    @When("the request is sent to the API")
    public void theRequestIsSentToTheAPI() {

    }


}
