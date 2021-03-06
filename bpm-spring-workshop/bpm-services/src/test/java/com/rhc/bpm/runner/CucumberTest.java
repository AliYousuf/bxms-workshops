package com.rhc.bpm.runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;

@RunWith(CucumberProfileRunner.class)
@CucumberOptions(features = "classpath:features", monochrome = true, glue = "com/redhat/steps/", strict = true, plugin = "json:target/cucumber.json")
public class CucumberTest {

}
