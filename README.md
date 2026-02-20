# Simple HTTP API - Java

## Overview

This project implements a simple HTTP API using Spring Boot.

Endpoint example:

GET /hello-world?name=alice

## Behaviour

- If the first letter of `name` is A–M/a-m (case insensitive):
    - Returns 200 OK
    - { "message": "Hello <Name>" }

- If the first letter of `name` is N–Z:
    - Returns 400 Bad Request
    - { "error": "Invalid Input" }

- If name is:
    - missing
    - null
    - empty
    - whitespace
    - starts with non-English letter
    - starts with non-alphabetic character

  → Returns 400 Bad Request with { "error": "Invalid Input" }

## Tech Stack

- Java 17
- Spring Boot 3.x
- Maven
- JUnit 5

## How to Run Project

```bash
./mvnw spring-boot:run
```

## How to Run Project
http://localhost:8080/hello-world?name=alice


## How to Run Tests
```bash
./mvnw test
```
