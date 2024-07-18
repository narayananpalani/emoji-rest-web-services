# Emoji for Social Payments-Spring Boot 3 Application
This is a sample application built to showcase emoji usage for the payments that are posted in social media

Related Newsletter:
https://www.linkedin.com/pulse/social-payment-innovations-narayanan-palani-alc0e/?trackingId=lcC%2FPR34T9euPiAXmxX8GA%3D%3D
Credits "Spring Boot 3 Fundamentals" by Jesper de Jong at [Pluralsight](https://www.pluralsight.com/).

## Building REST Web Services

In this module, we've created REST web services to get information about events, organizers, venues and products and to register attendees for events.

Steps:

- Create records that represent the data model for the emoji usage in payments application.
- Create repository classes (data access objects) to manage the data in the application.
- Create Spring Web MVC REST controller classes to define web services.
- Create a controller advice class to handle exceptions thrown from the controller classes.
- Use Bean Validation to validate request data.

## Running the application and testing the web services

The minimum version of Java that is required by Spring Framework 6 and Spring Boot 3 is Java 17. Make sure you have JDK 17 or newer installed.

You can build an run the application from your IDE or from the command line using the Spring Boot Maven plugin:

On Windows:

    mvnw.cmd spring-boot:run

On macOS or Linux:

    ./mvnw spring-boot:run

Then you can use an HTTP client tool to call the web services. Examples using `curl`:

Get information about the senders of emojis:

    curl http://localhost:8080/senders

Get the emojis for a specific sender (in this example sender 101; note that quotes are necessary because the shell might interpret the question mark
in the URL):

    curl "http://localhost:8080/events?senderId=101"

Get the details of a specific emoji (in this example emoji 501):

    curl http://localhost:8080/emojis/501

Get the payment products that has usages of emoji:

    curl "http://localhost:8080/paymentproducts?emojiId=501"

Post a transaction:

    curl http://localhost:8080/sendmoney -H "Content-Type: application/json" -d '{"paymentId": 801, "senderName": "Jesper de Jong"}'
