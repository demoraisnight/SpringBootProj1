# School Management API System

[![License](https://img.shields.io/badge/License-MIT-blue.svg)](https://opensource.org/licenses/MIT)

The School Management System is a comprehensive web application developed in Spring Boot to efficiently manage various aspects of a school. It provides functionalities for student and teacher management, course administration, grade management, and more.

## Table of Contents

- [Features](#features)
- [Conceptual Model](#conceptual-model)
- [Installation](#installation)
- [Usage](#usage)
- [Technologies Used](#technologies-used)
- [Contributing](#contributing)
- [License](#license)

## Features

- User authentication and role-based access control (Admin, Instructor, Student)
- Student management: Add, view, update, and delete student records with comprehensive details
- Teacher management: Maintain teacher profiles with qualifications and contact information
- Course management: Create, assign teachers, and manage course schedules
- Grade management: Record and calculate student grades for assessments and exams
- Communication: Internal notification system for administrators, teachers, and students

## Conceptual Model

![Conceptual Model](conceptualmodel.png)

## Installation

1. Clone the repository:

   ```bash
   git clone https://github.com/demoraisnight/SpringBootProj1.git

2. Set up the database:
   1. Using H2(Some queries doesn't work)
      - Change [application.properties](/src/main/resources/application.properties)
        
          `spring.profiles.active=test`
   2. Using PostgreSQL
      - Change [application.properties](/src/main/resources/application.properties)
            
          `spring.profiles.active=dev`
      - Run POSTGRES container
          ```bash
          sudo docker run -p 5432:5432 --name meu-container-pg12 -e POSTGRES_PASSWORD=1234567 -e POSTGRES_DB=minha_base postgres:12-alpine
      - Download and Install [pgAdmin4](https://www.pgadmin.org/download/pgadmin-4-apt/)
      - Run [ddl.sql](ddl.sql) on your database
3. Run the project:
    1. Run via Command Line
    ```bash
      mvn package
      java -jar target/school-0.0.1-SNAPSHOT.jar
    ```
    2. Running using and IDE
    - [SchoolApplication](/src/main/java/com/vinicius/school/SchoolApplication.java)
## Usage
- Register as an admin user with full access rights.
- Use the admin account to create teacher and student accounts.
- Assign teachers to courses.
- Manage students grades.
- Explore other features based on your specific requirements.

## Some Endpoints
| Endpoint                           | Method | Description                |
|------------------------------------|--------|----------------------------|
| `/users`                           | GET    | Retrieve all users         |                                                                                             |
| `/users/{id}`                      | GET    | Retrieve user by ID        |                                                                                            |  
| `/users`                           | POST   | Create a new user          | 
| `/users/{id}`                      | PUT    | Update user by ID          | 
| `/users/{id}`                      | DELETE | Delete user by ID          |                                                                                        |
| `/courses`                         | GET    | Retrieve all courses       |                                                                                             |
| `/courses/{id}`                    | GET    | Retrieve course by ID      |                                                                                        |  
| `/courses`                         | POST   | Create a new course        | 
| `/courses/{id}`                    | PUT    | Update course by ID        |
| `/courses/{id}`                    | DELETE | Delete course by ID        |   
| `/enrollments`                     | GET    | Retrieve all enrollments   |                                                                                             |
| `/enrollments/{userId}/{courseId}` | GET    | Retrieve enrollments by ID |                                                                                        |  
| `/enrollments/{userId}/{courseId}` | POST   | Create a new enrollment    | 
| `/enrollments/{userId}/{courseId}` | PUT    | Update enrollment by ID    |
| `/enrollments/{userId}/{courseId}` | DELETE | Delete enrollment by ID    |

## Authentication
Some endpoints may require authentication. Include an Authorization header in your request with a valid access token.
`Authorization: Bearer <access_token>`
- You can get your access token at oauth/token using these app credentials
    #### App crendentials
        - client_id:myclientid
        - client_secret:myclientsecret
    #### User crendentials
        - client_id:alex@gmail.com
        - client_secret:123456
        - grant_type:password

## Technologies Used
- Spring Boot
- Spring Security
- Spring Data JPA
- Spring Validations
- Docker
- PostgreSQL
- ModelMapper

## To implement
- Forum(Topics, replies, likes)
- Roles assigning endpoint
- Event Listener
- API Documentation(Swagger/Openapi)
- Sending tasks/challenges
- Sending files
- More queries
- Email Confirmation
- Front-End(Angular/React)
- AWS/Google Cloud
- ...

## Contributing
Contributions are welcome! If you find any issues or have suggestions for improvements, please feel free to open an issue or create a pull request. Make sure to follow the existing coding style and commit message conventions.

## License
This project is licensed under the MIT License. See the LICENSE file for details.