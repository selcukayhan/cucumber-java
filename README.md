# cucumber-java-example
Technical Interview Tasks #1 is login.feature
Technical Interview Tasks #2 is crawler.feature

A small example on how to use cucumber &amp; selenium in java with Page Object Model as Maven Project.

## Usage
You can run the tests by either executing mvn test or running the specified feature file. 

## Before Test
Before running crawler.feature please generate dropbox access token,
Before running login.feature please create an amazon account,
Please update following credentials in Config file :

    DEFAULT_EMAIL = "yourAmazonAccountsEmail";
    DEFAULT_PASSWORD = "yourAmazonAccountsPassword";
    DROPBOX_ACCESS_TOKEN = "yourDropboxAccessToken"; 