# project_spring_boot_restAPI


**To run a Spring Boot application, you can follow these steps:**

1. Ensure you have Java Development Kit (JDK) installed: Spring Boot requires Java to be installed on your machine. You can download the JDK from the Oracle website or use a package manager like Homebrew (for macOS) or Chocolatey (for Windows) to install it.

2. Set up your development environment: You can use any Java IDE of your choice, such as IntelliJ IDEA, Eclipse, or Visual Studio Code, to develop your Spring Boot application. Install the IDE and set up the necessary configurations.

3. Create a Spring Boot project: You can create a new Spring Boot project using Spring Initializr (https://start.spring.io/). Select the necessary dependencies, such as Web and JPA, based on your requirements. Generate the project and download the zip file.

4. Extract the project: Extract the downloaded zip file to a location on your machine.

5. Import the project into your IDE: Open your IDE and import the extracted project as a Maven or Gradle project, depending on the build tool you selected in Spring Initializr.

6. Build the project: Let your IDE download the necessary dependencies and build the project. It may take some time for the initial build.

7. Run the application: Once the project is built, you can run the Spring Boot application. In your IDE, locate the main class (usually annotated with @SpringBootApplication) and run it as a Java application.

8. Test the APIs: With the application running, you can now test the APIs using tools like Postman or cURL. Use the appropriate endpoints, such as /play and /next, to interact with the API and verify the responses.

Make sure to configure the necessary database connection properties, such as URL, username, and password, in the application.properties or application.yml file of your Spring Boot project, depending on your preferred configuration format.

These steps provide a general guideline to run a Spring Boot application. Adjustments may be needed based on your specific project setup and requirements.


**To hit the /fetch API endpoint using Postman, you can follow these steps:**

1. Open Postman: Launch the Postman application on your machine.

2. Create a new request: Click on the "New" button in Postman to create a new request.

To hit the /play and /next APIs using Postman, you can follow these steps:

Open Postman: Launch the Postman application on your machine.

Create a new request: Click on the "New" button in Postman to create a new request.

**Set the request method and URL:**

**For the /play API:**

1. Select the GET request method from the dropdown menu.

2. Set the URL to http://localhost:8080/questions/play.

**For the /next API:**
1. Select the POST request method from the dropdown menu.
2. Set the URL to ** http://localhost:8080/questions/next**.

sending a JSON payload.
 
Example:

JSON payload: 
{

"questionId":1020,

"answer":"Dennis the Menace"

}

3. Set the URL to  http://localhost:8080/questions/fetch.
  

4. Send the request: Click on the "Send" button to send the request to the specified API endpoint.

5. View the response: Postman will display the response received from the API. You can see the response body, headers, and status code in the Postman interface.

Make sure your Spring Boot application is running on localhost at port 8080 for these URLs to work. Adjust the URL and request method as per your specific API endpoints.

For the /next API, make sure to include the payload in the request body. The payload should be a JSON object with the question_id and answer fields.

Following these steps, you can hit the /play and /next APIs using Postman and view the responses returned by the APIs.










