# 🚀 Spring Boot CRUD API with Exception Handling

This project is a **Spring Boot REST API** that supports **CRUD operations** (Create, Read, Update, Delete) for managing users, using **MySQL** as the database. It includes **custom exception handling** for better error responses.

## 📌 Features
✅ Create a user (`POST /users`)  
✅ Get all users (`GET /users`)  
✅ Update a user (`PUT /users/{id}`)  
✅ Delete a user (`DELETE /users/{id}`)  
✅ Custom exception handling for **404 Not Found**

## ⚙️ Technologies Used
- Java + Spring Boot
- Spring Data JPA
- MySQL
- Exception Handling with `@RestControllerAdvice`

## 🛠 Exception Handling
The app uses **custom exceptions** to handle cases like missing users. Example error response:

```json  
{
    "timestamp": "2025-03-20T00:40:00.123Z",  
    "status": 404,  
    "error": "Not Found",  
    "message": "User with id {wrongId} not found",  
    "path": "/users/{wrongId}"  
}  
```  

## 🏃 Running the Project
1. Clone the repo:
   ```sh  
   git clone https://github.com/HarishVijendiran1997/SpringBoot-RestApi.git  
   ```  
2. Configure `application.properties` with your MySQL credentials.
3. Run the application using:
   ```sh  
   mvn spring-boot:run  
   ```  

---  
