# Automated Tests for the Squeezer android application

## General info
* Test 1. Сheck that the menu MyApp contains the applications corresponding to the list

## Technologies
Project is created with:
* Java 1.8
* Apache Maven 3.8.6 
* TestNG 7.8.0
* Appium 7.6.0
* Selenide 6.15.0
* Allure 2.22.1  

## Squeezer in Play Store

https://play.google.com/store/apps/details?id=uk.org.ngo.squeezer
  
## Launch
to run the default test go to project dir and run:
```
mvn clean test
```

to view the Allure report:
```
allure serve $(pwd)/target/allure-results
```

