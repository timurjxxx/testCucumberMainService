Feature: Trainer Controller Tests

  Scenario: Getting Trainer Profile
    Given a trainer with username "trainerUsername"
    When the get trainer profile request is sent to the API
    Then the API should return a successful response with the trainer profile

  Scenario: Updating Trainer Profile
    Given a trainer with username "trainerUsername"
    When the update trainer profile request is sent to the API
    Then the API should return a successful response with the updated trainer profile

  Scenario: Getting Not Assigned Active Trainers
    Given a user with username "username"
    When the get not assigned active trainers request is sent to the API
    Then the API should return a successful response with the list of not assigned active trainers

  Scenario: Activating or Deactivating Trainer
    Given a trainer with username "trainerUsername"
    When the activate/deactivate trainer request is sent to the API
    Then the API should return a successful response and activate or deactivate the trainer

  Scenario: Handling Bad Request
    Given an invalid trainer profile request
    When the request is sent to the API
    Then the API should return a bad request response