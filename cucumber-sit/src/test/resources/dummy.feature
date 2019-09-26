Feature: Dummy feature
  Scenario: Dummy test scenario
    When I pretend to do something
    Then Something start to happen

    Scenario: Verify json response
      When I call the mock endpoint
      Then the response code is 200
      And the response body should match with "hello_world.json" file