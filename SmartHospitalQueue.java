import java.util.*;

class Patient implements Comparable<Patient> {
    private String name;
    private int age;
    private String gender;
    private String ailment;
    private int severity; // 1 (Mild), 2 (Moderate), 3 (Critical)

    public Patient(String name, int age, String gender, String ailment, int severity) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.ailment = ailment;
        this.severity = severity;
    }

    public int getSeverity() {
        return severity;
    }

    @Override
    public int compareTo(Patient other) {
        return Integer.compare(other.severity, this.severity);
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Age: " + age + ", Gender: " + gender + ", Ailment: " + ailment + ", Severity: " + severity;
    }
}

class Doctor {
    private String name;
    private String specialization;
    private boolean available;

    public Doctor(String name, String specialization) {
        this.name = name;
        this.specialization = specialization;
        this.available = true;
    }

    public boolean isAvailable() {
        return available;
    }

    public void assignPatient() {
        available = false;
    }

    public void freeDoctor() {
        available = true;
    }

    @Override
    public String toString() {
        return "Dr. " + name + " (Specialization: " + specialization + ", Available: " + available + ")";
    }
}

public class SmartHospitalQueue {
    private static PriorityQueue<Patient> patientQueue = new PriorityQueue<>();
    private static List<Doctor> doctors = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        doctors.add(new Doctor("Amit Verma", "Cardiologist"));
        doctors.add(new Doctor("Neha Sharma", "General Physician"));
        doctors.add(new Doctor("Raj Malhotra", "Neurologist"));

        boolean exit = false;
        while (!exit) {
            System.out.println("\nSmart Hospital Queue Management System");
            System.out.println("1. Register Patient");
            System.out.println("2. Assign Patient to Doctor");
            System.out.println("3. Display Waiting Queue");
            System.out.println("4. Discharge Patient");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    registerPatient();
                    break;
                case 2:
                    assignDoctor();
                    break;
                case 3:
                    displayQueue();
                    break;
                case 4:
                    dischargePatient();
                    break;
                case 5:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
        scanner.close();
    }

    private static void registerPatient() {
        System.out.print("Enter patient name: ");
        String name = scanner.nextLine();
        System.out.print("Enter patient age: ");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter patient gender: ");
        String gender = scanner.nextLine();
        System.out.print("Enter ailment: ");
        String ailment = scanner.nextLine();
        System.out.print("Enter severity (1-Mild, 2-Moderate, 3-Critical): ");
        int severity = scanner.nextInt();
        scanner.nextLine();

        Patient patient = new Patient(name, age, gender, ailment, severity);
        patientQueue.offer(patient);
        System.out.println("Patient registered successfully!");
    }

    private static void assignDoctor() {
        if (patientQueue.isEmpty()) {
            System.out.println("No patients in queue.");
            return;
        }

        for (Doctor doctor : doctors) {
            if (doctor.isAvailable()) {
                Patient patient = patientQueue.poll();
                doctor.assignPatient();
                System.out.println("Patient " + patient + " assigned to " + doctor);
                return;
            }
        }
        System.out.println("No available doctors. Please wait.");
    }

    private static void displayQueue() {
        if (patientQueue.isEmpty()) {
            System.out.println("No patients in queue.");
        } else {
            System.out.println("Waiting Queue: ");
            for (Patient patient : patientQueue) {
                System.out.println(patient);
            }
        }
    }

    private static void dischargePatient() {
        System.out.print("Enter doctor name to free up: ");
        String doctorName = scanner.nextLine();

        for (Doctor doctor : doctors) {
            if (doctor.toString().contains(doctorName) && !doctor.isAvailable()) {
                doctor.freeDoctor();
                System.out.println(doctorName + " is now available.");
                return;
            }
        }
        System.out.println("Doctor not found or already available.");
    }
}
