
package com.fedex.test.shipping.cucumberRunners;


import cucumber.api.CucumberOptions;


@CucumberOptions(strict = true,
		features = {"src/test/resources/features"},
		monochrome = true,
		tags ={"@Desktop"},
		plugin = {"html:target/site/cucumber-pretty","json:target/cucumber.json"},
		glue ={"com.fedex.test.shipping.cucumberSteps"})
public class Parallel01IT extends AbstractTestNGCucumberParallelTests{
}