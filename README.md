# Smart Hospital Queue Management System

## Overview
The **Smart Hospital Queue Management System** is a **CLI-based Java application** designed to efficiently manage patient registrations and doctor assignments based on ailment severity. This system ensures that critical patients receive priority treatment while optimizing doctor availability.

## Features
- **Patient Registration**: Stores patient details (Name, Age, Gender, Ailment, Severity Level).
- **Doctor Management**: Keeps track of doctor details and availability.
- **Priority-based Queue System**: Critical patients are prioritized.
- **Automatic Doctor Assignment**: Matches available doctors with patients.
- **Queue Display**: Shows real-time waiting list.
- **Discharge System**: Frees up doctors for new patients.

## Technologies Used
- **Java** (Core Java, Collections, PriorityQueue)
- **Data Structures** (PriorityQueue for managing patient urgency)
- **CLI** (Command Line Interface for easy interaction)

## How to Run
1. **Install Java**: Ensure you have Java (JDK 8+) installed.
2. **Clone the Repository**:
   ```sh
   git clone https://github.com/piyushdubey490/Smart-Hospital-Queue-Management-System-.git
   cd Smart-Hospital-Queue-Management-System-
   ```
3. **Compile the Code**:
   ```sh
   javac SmartHospitalQueue.java
   ```
4. **Run the Application**:
   ```sh
   java SmartHospitalQueue
   ```

## Usage Guide
1. **Register a Patient** by entering their details and severity.
2. **Assign a Doctor** to the next available patient.
3. **View the Waiting Queue** to check pending patients.
4. **Discharge a Patient** to free up doctor availability.
5. **Exit** the system when done.

## Future Enhancements
- **Database Integration** to persist patient records.
- **GUI Version** using Java Swing or JavaFX.
- **Automated Doctor Scheduling** based on specialization.

## License
This project is open-source and available under the **MIT License**.

## Contributors
- **Piyush Dubey** - Developer

Feel free to contribute by raising issues or submitting pull requests!

[Edit this file on GitHub](https://github.com/piyushdubey490/Smart-Hospital-Queue-Management-System-/edit/main/README.md)

