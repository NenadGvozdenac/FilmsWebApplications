# Spring Boot Web Application with Login, Registration, MySQL Database, and External API Integration

## Introduction

In this project, we will create a Spring Boot web application that allows users to register, log in, and maintain a list of films they have watched. The application will use a MySQL database to store user information, the list of films they watched, and an external API to fetch the latest films. We will leverage the Hibernate framework for data persistence and manipulation.

## Prerequisites

Before starting the development process, ensure you have the following installed on your machine:

- Java Development Kit (JDK) 8 or above
- Spring Boot
- MySQL Server
- Integrated Development Environment (IDE) of your choice (e.g., IntelliJ, Eclipse)

## Setup

1. **Create a Spring Boot Project:**
    - Use your IDE to create a new Spring Boot project. You can also use Spring Initializr (https://start.spring.io/) to generate a project with the necessary dependencies.

2. **Set Up MySQL Database:**
    - Install MySQL Server on your machine if you haven't already.
    - Create a new database for the application, e.g., "film_tracker_db."

3. **Add Dependencies:**
    - Add the required dependencies to your `pom.xml` file:
        - `spring-boot-starter-web` for web-related functionalities.
        - `spring-boot-starter-data-jpa` for working with JPA and Hibernate.
        - `mysql-connector-java` for MySQL database communication.
        - `spring-boot-starter-security` for handling user authentication and authorization.
        - `spring-boot-starter-webclient` for making HTTP requests to the external API.
        - `jjwt-api`, `jjwt-impl, `jjwt-jackson` for creating JWT tokens.
        - `unirest-java` for making HTTP requests.

4. **Configure Application Properties:**
    - Open the `application.properties` (or `application.yml`) file and configure the database connection properties, such as URL, username, and password.
    - Add properties related to the external API, such as the base URL and API key.

## Data Model

We will create two main tables: `users` and `films` to handle user information and the films they have watched, respectively.

1. **`users` Table:**
    - `id` (Primary Key)
    - `username`
    - `email`
    - `phoneNumber`
    - `password` (hashed :: encrypted)

2. **`films` Table:**
    - `id` (Primary Key)
    - `title`
    - `genre`
    - `release_date`

3. **`watched_films` Table:**
    - `id` (Primary Key)
    - `username`
    - `film_id`
    - `film_name`

## User Registration and Login

1. **Registration Page:**
    - Create a registration form where users can provide their details, such as username, password, name, and email.
    - Upon submission, validate the input, and if valid, store the user's information in the `users` table.

2. **Login Page:**
    - Create a login form where users can enter their username and password.
    - Validate the input and authenticate the user against the data stored in the `users` table.

## Films Management

1. **Fetch Films from External API:**
    - Create a scheduled task that fetches the latest films from the external API once a week.
    - Parse the response and store the film information in the `films` table.
    - `/api/films/fetch` or `/api/films/fetch/{number}`

2. **Add Films to Watched List:**
    - Create a page where authenticated users can add films they have watched to their list.
    - Users can search and select films from the films stored in the database (including those fetched from the external API).
    - Upon selection, store the film information in the `films` table, associating it with the respective user.
    - `/api/film/{id}/watched` - endpoint for adding the film to the watched list. Requires a valid JWT token.

3. **List Watched Films:**
    - Create a page where authenticated users can view the films they have watched.
    - Fetch and display the films associated with the logged-in user from the `films` table.
    - `/api/user/get_watched` - endpoint for listing all watched films. Requires a valid JWT token.

## Security

1. **Password Encryption:**
    - Ensure that user passwords are securely hashed or encrypted before storing them in the database.

2. **Authentication and Authorization:**
    - Implement Spring Security to handle user authentication and authorization.
    - Restrict access to certain pages and functionalities based on user roles.

## Conclusion

By following the steps outlined above, you can create a Spring Boot web application that allows users to register, log in, and manage a list of films they have watched. The application leverages Hibernate for data persistence, communicates with a MySQL database, and integrates with an external API to fetch the latest films. Remember to implement security measures to protect user data and thoroughly test the application for robustness and correctness.
