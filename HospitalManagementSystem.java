import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;

public class HospitalManagementSystem {

    // Patient Class
    static class Patient {
        String patientID;
        String name;
        int age;
        String address;
        String contactNumber;

        public Patient(String patientID, String name, int age, String address, String contactNumber) {
            this.patientID = patientID;
            this.name = name;
            this.age = age;
            this.address = address;
            this.contactNumber = contactNumber;
        }

        public void displayPatientInfo() {
            System.out.println("Patient ID: " + patientID);
            System.out.println("Name: " + name);
            System.out.println("Age: " + age);
            System.out.println("Address: " + address);
            System.out.println("Contact Number: " + contactNumber);
        }
    }

    // Appointment Class
    static class Appointment {
        String appointmentID;
        String patientID;
        Date appointmentDate;
        String doctorName;

        public Appointment(String appointmentID, String patientID, Date appointmentDate, String doctorName) {
            this.appointmentID = appointmentID;
            this.patientID = patientID;
            this.appointmentDate = appointmentDate;
            this.doctorName = doctorName;
        }

        public void displayAppointmentInfo() {
            System.out.println("Appointment ID: " + appointmentID);
            System.out.println("Patient ID: " + patientID);
            System.out.println("Appointment Date: " + appointmentDate);
            System.out.println("Doctor: " + doctorName);
        }
    }

    // EHR (Electronic Health Records) Class
    static class EHR {
        String patientID;
        ArrayList<String> medicalHistory;

        public EHR(String patientID) {
            this.patientID = patientID;
            this.medicalHistory = new ArrayList<>();
        }

        public void addRecord(String record) {
            medicalHistory.add(record);
        }

        public void displayEHR() {
            System.out.println("EHR for Patient ID: " + patientID);
            for (String record : medicalHistory) {
                System.out.println(record);
            }
        }
    }

    // Billing Class
    static class Billing {
        String billingID;
        String patientID;
        double amountDue;

        public Billing(String billingID, String patientID, double amountDue) {
            this.billingID = billingID;
            this.patientID = patientID;
            this.amountDue = amountDue;
        }

        public void generateInvoice() {
            System.out.println("Invoice for Patient ID: " + patientID);
            System.out.println("Billing ID: " + billingID);
            System.out.println("Amount Due: $" + amountDue);
        }
    }

    // Inventory Class
    static class Inventory {
        HashMap<String, Integer> inventory;

        public Inventory() {
            inventory = new HashMap<>();
        }

        public void addItem(String itemName, int quantity) {
            inventory.put(itemName, inventory.getOrDefault(itemName, 0) + quantity);
        }

        public void displayInventory() {
            System.out.println("Inventory:");
            for (String itemName : inventory.keySet()) {
                System.out.println(itemName + ": " + inventory.get(itemName) + " units");
            }
        }
    }

    // Staff Class
    static class Staff {
        String staffID;
        String name;
        String role;

        public Staff(String staffID, String name, String role) {
            this.staffID = staffID;
            this.name = name;
            this.role = role;
        }

        public void displayStaffInfo() {
            System.out.println("Staff ID: " + staffID);
            System.out.println("Name: " + name);
            System.out.println("Role: " + role);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create example objects
        Patient patient = new Patient("P001", "John Doe", 30, "123 Main St", "555-1234");
        Appointment appointment = new Appointment("A001", "P001", new Date(), "Dr. Smith");
        EHR ehr = new EHR("P001");
        Billing billing = new Billing("B001", "P001", 250.75);
        Inventory inventory = new Inventory();
        Staff staff = new Staff("S001", "Jane Doe", "Nurse");

        // Add some records to the EHR
        ehr.addRecord("Blood test results: Normal");
        ehr.addRecord("X-ray results: Normal");

        // Add items to inventory
        inventory.addItem("Bandages", 50);
        inventory.addItem("Syringes", 100);

        // Display information
        patient.displayPatientInfo();
        appointment.displayAppointmentInfo();
        ehr.displayEHR();
        billing.generateInvoice();
        inventory.displayInventory();
        staff.displayStaffInfo();

        scanner.close();
    }
}

