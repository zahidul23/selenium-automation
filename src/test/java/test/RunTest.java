package test;


import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features/",
	glue = "stepdefinitions",
	tags = {"@test"})
public class RunTest {

}
