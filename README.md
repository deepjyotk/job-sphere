# Getting Started

#### Clone the Repository
```bash
git clone https://github.com/your-repo/job-sphere.git
cd ./job-sphere-api-gateway
```

#### Running the Application with Docker

1. Build and run the containers:
   ```bash
   docker-compose up --build
   ```

2. Access the application via `localhost:80`. Your application will be up and running.


# Job Sphere Application

### Overview

**Job Sphere** is a microservices-based job recommendation system built using Java Spring Web Flux for reactive programming, MongoDB for data storage, and Docker for containerization. The application uses Nginx as an API gateway to expose the services and facilitate communication between containers. Job Sphere manages job listings and candidate data, and provides job recommendations based on candidate profiles.

### Features

- **Reactive Services**: Utilizes Spring Web Flux to build asynchronous, non-blocking services.
- **Microservices Architecture**: Separate services for job and candidate management, with internal service-to-service communication.
- **API Gateway**: Nginx acts as the gateway to expose services to external clients.
- **MongoDB**: Used for storing job listings and candidate data in separate collections.
- **Containerized Environment**: All services are containerized using Docker to provide a consistent and isolated environment.

### Architecture

The system consists of the following components:

1. **API Gateway (Nginx)**:
   - Acts as the entry point for job seekers.
   - Routes HTTP requests to the appropriate service.
   - Exposes endpoints such as:
     - `/job/all` - Retrieve all job listings.
     - `/job/{id}` - Retrieve a specific job by ID.
     - `/candidate/all` - Retrieve all candidates.
     - `/candidate/{id}` - Retrieve a specific candidate by ID.

2. **Job Sphere Service**:
   - Manages job-related operations.
   - Contains multiple containers to handle job requests.
   - Interacts with MongoDB to fetch job data.

3. **Job Seeker Service**:
   - Manages candidate-related operations.
   - Contains multiple containers to handle candidate requests.
   - Provides a recommendation service via the `/get-recommended-jobs` endpoint.
   - Interacts with MongoDB to fetch candidate data.

4. **MongoDB**:
   - Stores job and candidate data in two separate collections:
     - `job-db`: Stores job information.
     - `candidate-db`: Stores candidate profiles.

5. **Service Communication**:
   - Internal communication between services (Job Sphere Service ↔ Job Seeker Service) happens container-to-container.
   - Each service is isolated and communicates via HTTP-based RESTful APIs exposed by the services.

### Prerequisites

- **Java 17** or above
- **Docker** and **Docker Compose**
- **MongoDB** (if not using Docker)

### Getting Started

#### Clone the Repository
```bash
git clone https://github.com/your-repo/job-sphere.git
cd job-sphere
```

#### Running the Application with Docker

1. Build and run the containers:
   ```bash
   docker-compose up --build
   ```

2. Once the containers are up, access the API Gateway via the Nginx exposed port (default: `8080`).

#### Running the Application Locally (without Docker)

1. Start MongoDB locally or use a remote instance.
2. Update the `application.properties` with the MongoDB connection string.
3. Run the services individually:
   ```bash
   mvn spring-boot:run
   ```
   Repeat this for both the **Job Sphere Service** and **Job Seeker Service**.

4. Use Nginx or another API Gateway to route traffic to the services, or access services directly on their respective ports.

### API Endpoints

#### Job Sphere Service
- `GET /job/all` - Fetch all job listings.
- `GET /job/{id}` - Fetch a specific job by ID.

#### Job Seeker Service
- `GET /candidate/all` - Fetch all candidates.
- `GET /candidate/{id}` - Fetch a specific candidate by ID.
- `GET /get-recommended-jobs` - Get job recommendations based on candidate profile.

### Technologies Used

- **Java Spring Web Flux**: For reactive, asynchronous microservices.
- **MongoDB**: NoSQL database for storing job and candidate data.
- **Docker**: Containerization of all services and MongoDB for consistent environments.
- **Nginx**: API Gateway to expose services and manage routing.
