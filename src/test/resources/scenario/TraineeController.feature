Feature: Trainee Controller Tests

  Scenario: Getting Trainee Profile
    Given a trainee with username "traineeUsername"
    When the get trainee profile request is sent to the API
    Then the API should return a successful response with the trainee profile

  Scenario: Updating Trainee Profile
    Given a trainee with username "traineeUsername"
    When the update trainee profile request is sent to the API
    Then the API should return a successful response with the updated trainee profile

  Scenario: Deleting Trainee Profile
    Given a trainee with username "traineeUsername"
    When the delete trainee profile request is sent to the API
    Then the API should return a successful response and delete the trainee profile

  Scenario: Updating Trainee's Trainers List
    Given a trainee with username "traineeUsername"
    And a list of trainer usernames
    When the update trainee trainers list request is sent to the API
    Then the API should return a successful response with the updated trainee's trainers list

  Scenario: Activating or Deactivating Trainee
    Given a trainee with username "traineeUsername"
    When the activate/deactivate trainee request is sent to the API
    Then the API should return a successful response and activate or deactivate the trainee
