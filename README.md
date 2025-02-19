# IRCTC Train Booking Service (Console Application)

## Project Description

This is a simple console-based Java application that simulates a train booking service, similar to IRCTC.  It allows users to:

*   **Sign up and Login:** Create user accounts and log in to the system.
*   **Search Trains:** Find trains based on source and destination stations.
*   **View Train Details:** See train ID, stations, and arrival/departure times.
*   **Book Seats:** Select and book available seats on a chosen train.
*   **Cancel Bookings:** Cancel existing ticket bookings using ticket IDs.
*   **Fetch Bookings:** View a list of all tickets booked by a logged-in user.

This project is intended as a learning exercise and demonstration of basic Java application development, file-based data persistence, and console user interface design.

## Features

*   **User Authentication:**  Signup and Login functionality with password hashing for security.
*   **Train Search:**  Search for trains based on source and destination stations.
*   **Seat Booking:** Interactive seat selection and booking process.
*   **Booking Management:** View and cancel existing bookings.
*   **Data Persistence:** User and train data is stored locally in JSON files.
*   **Simple Console Interface:**  Menu-driven command-line interface for user interaction.

## Technologies Used

*   **Java:** Programming language for the application logic.
*   **Gradle:** Build automation tool to manage project dependencies and build process.
*   **Jackson ObjectMapper:** Library for JSON serialization and deserialization (used for data persistence).

## Setup and Running Instructions

**Prerequisites:**

*   **Java Development Kit (JDK):**  You need to have Java JDK (version 17 or higher is recommended) installed on your system. You can download it from [Oracle Java Downloads](https://www.oracle.com/java/technologies/downloads/) or use an OpenJDK distribution.
*   **Gradle:** Gradle build tool is required. If you don't have it installed, follow the instructions on the [Gradle website](https://gradle.org/install/). However, IntelliJ IDEA usually bundles Gradle, so you might not need to install it separately if you are using IntelliJ IDEA.

**Steps to Run:**

1.  **Clone the Repository:** Clone this GitHub repository to your local machine using Git:
    ```bash
    git clone <repository_url>
    ```
    Replace `<repository_url>` with the actual URL of your GitHub repository.

2.  **Open the Project in IntelliJ IDEA:**
    *   Launch IntelliJ IDEA.
    *   Select **File > Open** and navigate to the directory where you cloned the repository. Select the root project directory and click "Open".
    *   IntelliJ IDEA should automatically detect the Gradle build files and configure the project.

3.  **Build the Project:**
    *   In IntelliJ IDEA, open the Gradle tool window (usually on the right side, labeled "Gradle").
    *   In the Gradle window, navigate to your project's tasks (e.g., `your_project_name > Tasks > build > build`).
    *   Double-click on the `build` task to build the project.  Alternatively, you can use the Gradle command line:
        ```bash
        ./gradlew build
        ```
        (or `gradlew.bat build` on Windows) from the project's root directory in your terminal.

4.  **Run the Application:**
    *   In IntelliJ IDEA, you can run the `App.java` class directly.
        *   Open `App.java` in the editor.
        *   Right-click in the editor and select **"Run 'App.main()'"**.
    *   Alternatively, you can run it from the Gradle command line:
        ```bash
        ./gradlew run
        ```
        (or `gradlew.bat run` on Windows) from the project's root directory in your terminal.

5.  **Interact with the Application:**
    *   Once the application starts, you will see a menu in the console.
    *   Follow the on-screen prompts to interact with the train booking service. Choose options from the menu (1-7) to perform actions like signup, login, search for trains, book seats, etc.

## Data Storage

The application uses JSON files for local data storage.

*   **`users.json`:** Stores user account information (usernames, hashed passwords, booking history). It is expected to be located in the `src/main/resources/localDb/` directory (or potentially `src/main/resources/`). **Note:** Ensure this file exists in the correct location for the application to run properly.

**Important:** This project uses local file-based storage for simplicity. In a real-world application, you would typically use a database system for more robust and scalable data management.

## Known Issues and Limitations (Work in Progress)

*   **Basic Error Handling:** Error handling is basic and needs to be improved for production use.
*   **Limited Functionality:** This is a simplified simulation. Many features of a real train booking system are not implemented (e.g., payment processing, real-time train status, more complex search options).
*   **Data Validation:** Input validation is basic. More robust validation is needed.
*   **Concurrency:** This console application is single-user and does not handle concurrent access or multiple users simultaneously.
*   **File Path Issues:** Currently, the application is being debugged to resolve issues related to file paths and loading data files correctly, especially when running from different environments (IDE vs. packaged application). Ensure `users.json` is in the `src/main/resources/localDb/` (or `src/main/resources/`) directory.

## Future Enhancements (Potential)

*   Implement a more user-friendly interface (e.g., a web or graphical user interface).
*   Integrate with a real-time train data API.
*   Implement payment processing functionality.
*   Use a database system (like MySQL, PostgreSQL, or MongoDB) for data persistence instead of JSON files.
*   Add more features like seat selection preferences, user profiles, admin functionalities, etc.
*   Improve error handling, logging, and input validation.
