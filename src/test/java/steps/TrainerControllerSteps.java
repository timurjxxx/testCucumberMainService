package steps;


import com.gypApp_main.controller.TrainerController;
import com.gypApp_main.exception.UserNotFoundException;
import com.gypApp_main.model.Trainer;
import com.gypApp_main.model.TrainingType;
import com.gypApp_main.model.User;
import com.gypApp_main.service.TrainerService;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class TrainerControllerSteps {


    @Mock
    private TrainerService trainerService;

    @InjectMocks
    private TrainerController controller;

    private String username;
    private Trainer trainer;
    private List<Trainer> trainers;
    private String invalidUsername;

    private ResponseEntity<String> responseEntity;

    public TrainerControllerSteps() {
        MockitoAnnotations.openMocks(this);
    }

    @Given("a trainer username")
    public void aTrainerUsername() {
        username = "example_username";
        trainer = new Trainer();
        TrainingType trainingType = new TrainingType();
        trainingType.setTrainingTypeName("test");
        trainer.setSpecialization(trainingType);
        User user = new User();
        user.setUserName(username);
        trainer.setUser(user);
    }

    @When("the get trainer profile request is sent")
    public void theGetTrainerProfileRequestIsSent() {
        when(trainerService.selectTrainerByUserName(username)).thenReturn(trainer);
        responseEntity = controller.getTrainerProfile(username);
    }

    @Then("the trainer profile should be returned")
    public void theTrainerProfileShouldBeReturned() {
        Assertions.assertNotNull(responseEntity);
        Assertions.assertEquals(200, responseEntity.getStatusCodeValue());
    }
    ///////////////////// 2 scenario
    @Given("a trainer username and updated trainer details")
    public void aTrainerUsernameAndUpdatedTrainerDetails() {
        username = "test";
        trainer = new Trainer();
        TrainingType trainingType = new TrainingType();
        trainingType.setTrainingTypeName("test");
        trainer.setSpecialization(trainingType);
        User user = new User();
        user.setUserName(username);
        trainer.setUser(user);
    }

    @When("the update trainer profile request is sent")
    public void theUpdateTrainerProfileRequestIsSent() {
        when(trainerService.updateTrainer(Mockito.eq(username), any(Trainer.class))).thenReturn(trainer);
        responseEntity = controller.updateTrainerProfile(username, trainer);
    }

    @Then("the trainer profile should be updated")
    public void theTrainerProfileShouldBeUpdated() {
        Assertions.assertNotNull(responseEntity);
        Assertions.assertEquals(200, responseEntity.getStatusCodeValue());
    }

    @Given("a username")
    public void aUsername() {
        username = "existing_username";
    }

    @When("the get not assigned active trainers request is sent")
    public void theGetNotAssignedActiveTrainersRequestIsSent() {
        List<Trainer> trainers = new ArrayList<>();
        Trainer trainer = new Trainer();
        TrainingType trainingType = new TrainingType();
        trainingType.setTrainingTypeName("test");
        User user = new User();
        user.setUserName("existing_username");
        user.setFirstName("name");
        trainer.setUser(user);
        trainer.setSpecialization(trainingType);
        trainers.add(trainer);
        when(trainerService.getNotAssignedActiveTrainers(Mockito.eq(username)))
                .thenReturn(trainers);
        responseEntity = controller.getNotAssignedActiveTrainers(username);
    }

    @Then("the list of not assigned active trainers should be returned")
    public void theListOfNotAssignedActiveTrainersShouldBeReturned() {
        Assertions.assertNotNull(responseEntity);
        Assertions.assertEquals(200, responseEntity.getStatusCodeValue());
        String responseBody = responseEntity.getBody();
        Assertions.assertNotNull(responseBody);
    }
//////////////////////////////////////
    @Given("an invalid username")
    public void anInvalidUsername() {
        invalidUsername = "non_existing_username";
    }

    @When("the get trainer profile request with invalid username is sent")
    public void theGetTrainerProfileRequestWithInvalidUsernameIsSent() {
        when(trainerService.selectTrainerByUserName(invalidUsername)).thenThrow(UserNotFoundException.class);
        responseEntity = controller.getTrainerProfile(invalidUsername);
    }

    @Then("the API should return a not found response")
    public void theAPIShouldReturnANotFoundResponse() {
        Assertions.assertNotNull(responseEntity);
        Assertions.assertEquals(404, responseEntity.getStatusCodeValue());
    }
}
