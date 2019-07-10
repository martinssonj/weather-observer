# weather-observer

How to start the weather-observer application
---

1. Run `mvn clean install` to build your application
1. Start application with `java -jar target/weather-observer-1.0-SNAPSHOT.jar server config.yml`
1. To check that your application is running enter url `http://localhost:8080`

API
---
To add a city for a user, use PST time for the period

- PUT to `http://localhost:8080/weather?userId=user@email.com&city=Los Angeles&countryCode=US&periodStart=2019-07-09T16:14:20&periodEnd=2019-07-09T18:57:00`

Response 201 Created means, users city added. 
404 if city not found

- GET to `http://localhost:8080/weather?userId=user@email.com`



