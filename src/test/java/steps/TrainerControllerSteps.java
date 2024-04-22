//package steps;
//
//
//import com.gypApp_main.controller.TrainerController;
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//
//import static org.junit.Assert.assertEquals;
//
//public class TrainerControllerSteps {
//
//    private TrainerController trainerController;
//
//    private ResponseEntity<String> response;
//
//    @Given("a trainer with username {string}")
//    public void givenTrainerWithUsername(String username) {
//        // Подготовьте тестовые данные, если это необходимо
//    }
//
//    @Given("a user with username {string}")
//    public void givenUserWithUsername(String username) {
//        // Подготовьте тестовые данные, если это необходимо
//    }
//
//    @When("the get trainer profile request is sent to the API")
//    public void whenGetTrainerProfileRequestSentToAPI() {
//        response = trainerController.getTrainerProfile(/* ваш запрос */);
//    }
//
//    @When("the update trainer profile request is sent to the API")
//    public void whenUpdateTrainerProfileRequestSentToAPI() {
//        response = trainerController.updateTrainerProfile(/* ваш запрос */);
//    }
//
//    @When("the get not assigned active trainers request is sent to the API")
//    public void whenGetNotAssignedActiveTrainersRequestSentToAPI() {
//        response = trainerController.getNotAssignedActiveTrainers(/* ваш запрос */);
//    }
//
//    @When("the activate/deactivate trainer request is sent to the API")
//    public void whenActivateDeactivateTrainerRequestSentToAPI() {
//        response = trainerController.activateDeactivateTrainer(/* ваш запрос */);
//    }
//
//    @Then("the API should return a successful response with the trainer profile")
//    public void thenApiShouldReturnSuccessfulResponseWithTrainerProfile() {
//        // Проверьте успешный ответ от API
//        // Проверьте возвращаемые данные, если это необходимо
//    }
//
//    @Then("the API should return a successful response with the updated trainer profile")
//    public void thenApiShouldReturnSuccessfulResponseWithUpdatedTrainerProfile() {
//        // Проверьте успешный ответ от API
//        // Проверьте возвращаемые данные, если это необходимо
//    }
//
//    @Then("the API should return a successful response with the list of not assigned active trainers")
//    public void thenApiShouldReturnSuccessfulResponseWithListOfNotAssignedActiveTrainers() {
//        // Проверьте успешный ответ от API
//        // Проверьте возвращаемые данные, если это необходимо
//    }
//
//    @Then("the API should return a successful response and activate or deactivate the trainer")
//    public void thenApiShouldReturnSuccessfulResponseAndActivateDeactivateTrainer() {
//        // Проверьте успешный ответ от API
//        // Проверьте активацию или деактивацию тренера
//    }
//
//    @When("the activate\\/deactivate trainer request is sent to the API")
//    public void theActivateDeactivateTrainerRequestIsSentToTheAPI() {
//
//    }
//}
