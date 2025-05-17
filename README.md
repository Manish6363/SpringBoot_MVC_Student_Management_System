# SpringBoot-MVC-Student-Management-System

## Technology Used [ Java + Spring-Boot + Spring-MVC + Spring-JPA + Hibernate + MySQL]
### 1. Backend Technologies
      
**Spring Boot**: Framework for building the standalone, production-ready Spring-based MVC web application.
      
**Spring MVC**: Handles HTTP requests and responses following the Model-View-Controller architecture.

**Java**: Primary programming language used for backend development and business logic.

**Hibernate (JPA)**: Object-Relational Mapping (ORM) tool for managing database entities and interactions.

**Servlet API**: Manages HTTP requests and sessions at the server-side.

### 2. Frontend Technologies
**JavaServer Pages (JSP)**: Used to create dynamic web pages and render views for user interactions.

**HTML & CSS**: For structuring and styling the frontend user interface.

### 3. Database Technologies
**MySQL**: Relational database management system used to store student data and other persistent information.

**JDBC**: Java Database Connectivity API (used under the hood via Hibernate) for database communication.


Description (Module-wise Statement-wise)
1. Configuration Module
The application is configured using the application.properties file.

It defines the database connection URL, username, and password to connect with MySQL.

Hibernate is configured to automatically update the database schema based on entity changes.

The view resolver is set to locate JSP files inside /WEB-INF/views/ with .jsp suffix.

Multipart file upload size is limited to 2MB to handle student profile image uploads securely.

2. Entity Module (Student Entity)
The Student class represents the student entity in the system.

It contains fields for student details such as ID, name, registration number, email, phone number, password, and profile image.

The class is annotated with JPA annotations to map it to the corresponding database table.

The profile image is stored as a byte array to support image upload and retrieval.

3. Repository Module
The StudentRepository interface extends JpaRepository to provide CRUD operations on student data.

It includes custom methods to find students by registration number and password for authentication purposes.

The repository abstracts the database interaction layer, enabling easy querying and modification of student records.

4. CRUD Helper Module (StudentCrud)
The StudentCrud class provides explicit database operations such as saving, updating, and fetching student records.

It acts as a DAO-style helper class encapsulating complex data access logic.

This class helps separate the data persistence logic from the controller and service layers.

5. Service Module
The StudentService class acts as an intermediary between the controller and repository layers.

It handles business logic such as validation, processing of student data, and managing image upload functionality.

This module ensures a clean separation of concerns and promotes modularity in the application.

6. Controller Module
The StudentController class manages HTTP requests and user interactions.

It contains endpoints for student registration, login, profile update, dashboard display, image retrieval, and logout.

Session management is used to maintain logged-in user state securely.

It handles form data including multipart image uploads and passes them to the service layer.

On successful login, it fetches the student’s details and the list of all other students to display on the dashboard.

7. View Module (JSP Pages)
JSP pages provide the user interface for different application functions.

index.jsp serves as the landing page offering navigation to registration and login.

registerPage.jsp allows users to input student details and upload a profile picture.

loginPage.jsp provides a login form and displays error messages on failure.

updatePage.jsp presents the logged-in user with their current details for editing and image replacement.

login_dashboard.jsp displays the logged-in student's information alongside a list of other registered students with their profile pictures, and provides options for updating profile or logging out.

8. Additional Features
Profile images are stored and retrieved as binary data, allowing students to have personal photos displayed in the application.

Error messages and validations are shown in the views for better user experience.

The application follows MVC architecture, promoting maintainability and scalability.

All sensitive data like passwords are handled carefully to ensure security during authentication.

