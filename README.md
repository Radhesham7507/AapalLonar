# AapalLonar

AapalLonar is a project built with **Spring Boot** for the backend. This guide provides step-by-step instructions on setting up the project, running it locally, and deploying it on **AWS**.

## Table of Contents
- [Prerequisites](#prerequisites)
- [Project Setup](#project-setup)
- [Run the Project Locally](#run-the-project-locally)
- [API Endpoints](#api-endpoints)
- [Database Configuration](#database-configuration)
- [Deploying on AWS](#deploying-on-aws)
- [Contributing](#contributing)
- [License](#license)

---

## Prerequisites
Before setting up the project, ensure you have the following installed:

- **Java 17** or later
- **Spring Boot**
- **Maven** (for dependency management)
- **PostgreSQL/MySQL** (whichever is used in the project)
- **Git**
- **AWS Account** (for deployment)

---

## Project Setup

1. **Clone the repository:**
   ```sh
   git clone https://github.com/Radhesham7507/AapalLonar.git
   cd AapalLonar
   ```

2. **Configure application properties:**
   Open `src/main/resources/application.properties` or `application.yml` and update database credentials accordingly.

3. **Install dependencies:**
   ```sh
   mvn clean install
   ```

---

## Run the Project Locally

1. **Start the database**
   Ensure PostgreSQL/MySQL is running and the database is created.

2. **Run the Spring Boot application:**
   ```sh
   mvn spring-boot:run
   ```

3. **Access the API:**
   The application should now be running on `http://localhost:8080`

---

## API Endpoints
Refer to the API documentation or `swagger-ui` for available endpoints.

- Swagger UI (if enabled): `http://localhost:8080/swagger-ui.html`

---

## Database Configuration
Modify `application.properties` or `application.yml` with the correct database details:
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/your_database
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
```

---

## Deploying on AWS

### 1. Create an AWS EC2 Instance
- Go to AWS Console → EC2 → Launch Instance
- Choose an OS (Amazon Linux, Ubuntu, etc.)
- Select instance type (t2.micro for free tier)
- Configure security group (allow **port 8080** for HTTP access)
- Launch instance and connect via SSH

### 2. Install Java and Git on EC2
```sh
sudo yum update -y
sudo yum install java-17-openjdk -y
sudo yum install git -y
```

### 3. Clone the Project on EC2
```sh
git clone https://github.com/Radhesham7507/AapalLonar.git
cd AapalLonar
```

### 4. Build the Project
```sh
mvn clean package
```

### 5. Run the Application
```sh
java -jar target/*.jar
```

### 6. Configure AWS RDS (If using managed DB)
- Create an RDS instance with PostgreSQL/MySQL
- Update `application.properties` with the RDS connection details

### 7. Set Up Reverse Proxy (Optional, for domain mapping)
Using **NGINX**:
```sh
sudo yum install nginx -y
sudo systemctl start nginx
sudo systemctl enable nginx
```
Update the NGINX config to proxy requests to `localhost:8080`.

---

## Contributing
Feel free to contribute by creating issues or submitting pull requests.

---



