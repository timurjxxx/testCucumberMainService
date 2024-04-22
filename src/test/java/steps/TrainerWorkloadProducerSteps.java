package steps;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gypApp_main.activemq.TrainerWorkloadProducer;
import com.gypApp_main.dto.TrainerWorkloadRequest;
import com.gypApp_main.model.Trainer;
import com.gypApp_main.model.Training;
import com.gypApp_main.model.TrainingType;
import com.gypApp_main.model.User;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.jms.core.MessagePostProcessor;

import java.time.LocalDate;

import static org.mockito.Mockito.*;

public class TrainerWorkloadProducerSteps {

    @InjectMocks
    private TrainerWorkloadProducer producer;

    @Mock
    private ObjectMapper objectMapper;

    @Mock
    private JmsTemplate jmsTemplate;

    private Training training = new Training();
    private String action ;
    private String jsonRequest;
    private Trainer trainer = new Trainer();

    private TrainerWorkloadRequest request ;
    public  TrainerWorkloadProducerSteps() {
        MockitoAnnotations.openMocks(this);
    }


    @Given("a training and an action type")
    public void givenTrainingAndActionType() {
        TrainingType trainingType = new TrainingType();
        training.setTrainingTypes(trainingType);
        trainingType.setTrainingTypeName("SAs");
        training.setTrainingName("name");
        training.setTrainingDate(LocalDate.now());
        User user = new User();
        user.setFirstName("name");
        user.setIsActive(true);
        user.setLastName("lastnaem");
        trainingType.setTrainingTypeName("Run");
        trainer.setSpecialization(trainingType);
        trainer.setUser(user);
        training.setTrainer(trainer);


    }

    @When("the update workload request is sent to the ActiveMQ queue")
    public void whenUpdateWorkloadRequestSentToQueue() throws JsonProcessingException {
        producer.updateWorkLoad(training, action);
    }

    @Then("the request should be successfully sent")
    public void thenRequestSuccessfullySent() {
        verify(jmsTemplate).convertAndSend(anyString(), anyString());
    }

    @When("the request is created")
    public void whenRequestCreated() {
        request = producer.createRequest(training, action);
    }

    @Then("the request should contain the correct details")
    public void thenRequestContainsCorrectDetails() {
    }

    @When("the request is created or sent to the ActiveMQ queue")
    public void theRequestIsCreatedOrSentToTheActiveMQQueue() {
        
    }

    @Given("an invalid training or action type")
    public void anInvalidTrainingOrActionType() {
        
    }


    @Then("the system should handle the error appropriately")
    public void theSystemShouldHandleTheErrorAppropriately() {
    }
}
