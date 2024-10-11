Infy Project
This project is built using Spring Boot and PostgreSQL. Below are the steps to set up the project on your local machine.

Requirements
Java 8 or above
PostgreSQL
pgAdmin
Apache NetBeans (or any Java IDE)
Setup Instructions
1. Clone the Repository
Clone this repository to your local machine using the following command:

git clone https://github.com/yourusername/infy-project.git
2. PostgreSQL Setup
Download and install PostgreSQL and pgAdmin.
Open pgAdmin and create a new database. You can name it app or choose your preferred database name.
3. Update application.properties
Navigate to the src/main/resources/application.properties file and update the following properties with your PostgreSQL details:

spring.datasource.url=jdbc:postgresql://localhost:5432/app
spring.datasource.username=your_db_username
spring.datasource.password=your_db_password
spring.jpa.hibernate.ddl-auto=update

Replace your_db_username, your_db_password, and app with your actual database credentials.

4. Run the Application
To run the application, use your preferred IDE or build tool:
This will start the server on http://localhost:8080.

Additional Notes
Ensure that the PostgreSQL server is running, and you've connected to the correct database.
The project uses pgAdmin for database management. You can monitor your database activity and query data using this tool.
