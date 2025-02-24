 /**
 * @author Komal Ghodke
 * @version 1.0.0
 * @since 2025-02-21
 * @see <a href="https://github.com/komalghodke">GitHub Profile</a>
 */

# Orchestration API

A simple orchestration API to load user data from an external dataset into an in-memory H2 database and provide REST endpoints to fetch users based on various criteria.

## Features

- Loads users from `https://dummyjson.com/users` into H2 database.
- Provides RESTful endpoints for:
  - Free text search on first name, last name, or SSN.
  - Fetching a user by ID.
  - Fetching a user by email.
- API documentation using Swagger UI.

## Getting Started

### Prerequisites

- Java 17
- Maven

### Building and Running the Application

1. **Clone the repository:**

   ```bash
   git clone https://github.com/komalghodke/orchestration-api.git
   cd orchestration-api
   
 
## STEPS TO RUN:
1] Build the Project:-
```bash mvn clean install
2] Run the Application:-
```bash mvn spring-boot:run
3] Test the API Endpoints
You can use tools like Postman, curl, or your web browser to interact with your API.
Example Endpoints:
•	List All Users:	GET http://localhost:8080/users
•	Get User by ID:	GET http://localhost:8080/users/{id}
