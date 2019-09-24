package com.niroshan;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class DummyTest {

    @When("I pretend to do something")
    public void pretendToDoSomething() {
        System.out.println("I pretend to do something");;
    }

    @Then("Something start to happen")
    public void somethingHappen() {
        System.out.println("Something start to happen");
    }

}
