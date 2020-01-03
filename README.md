# cucumber-java-example
A small example on how to use cucumber &amp; selenium in java with Page Object Model as Maven Project.

## Usage
You can run the tests by either executing mvn test or running the specified feature file. 

If you run the tests with env variable runEnv="docker" , tests will be sent to the selenium grid via remote web driver. 

## Before Test
This tests for amazon.com,
Please update credentials in Config file ( Credentials and DROPBOX_ACCESS_TOKEN )