Feature: Training Controller Tests

  Scenario: Creating a Training
    Given a training request with trainer "trainerUsername", trainee "traineeUsername", and training type "trainingTypeName"
    When the create training request is sent to the API
    Then the API should return a successful response indicating the training is created

  Scenario: Deleting a Training
    Given a training with name "trainingName"
    When the delete training request is sent to the API
    Then the API should return a successful response indicating the training is deleted

  Scenario: Getting Trainee Trainings by Criteria
    Given a trainee with username "traineeUsername" and search criteria
    When the get trainee trainings by criteria request is sent to the API
    Then the API should return a successful response with the trainee's trainings based on the criteria

  Scenario: Getting Trainer Trainings by Criteria
    Given a trainer with username "trainerUsername" and search criteria
    When the get trainer trainings by criteria request is sent to the API
    Then the API should return a successful response with the trainer's trainings based on the criteria

  Scenario: Handling Bad Request
    Given an invalid request or criteria
    When the request is sent to the API
    Then the API should return an appropriate error response