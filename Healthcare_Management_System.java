import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Custom exception for handling invalid patient data
class InvalidPatientDataException extends Exception {
    public InvalidPatientDataException(String message) {
        super(message);
    }
}

// Abstract class for a patient record
abstract class PatientRecord {
    private int patientID;
    private String name;
    private String gender;
    private String contactNo;

    public PatientRecord(int patientID, String name, String gender, String contactNo) {
        this.patientID = patientID;
        this.name = name;
        this.gender = gender;
        this.contactNo = contactNo;
    }

    public int getPatientID() {
        return patientID;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public String getContactNo() {
        return contactNo;
    }

    @Override
    public String toString() {
        return "Patient ID: " + patientID + "\nName: " + name + "\nGender: " + gender + "\nContact No: " + contactNo;
    }
}

// Concrete class for detailed patient record
class DetailedPatientRecord extends PatientRecord {
    private String healthProblem;
    private int daysOfSuffering;
    private String suggestedMedicine;
    private double totalBill;
    private String insuranceInfo;
    private List<String> doctorNames;

    public DetailedPatientRecord(
            int patientID, String name, String gender, String contactNo,
            String healthProblem, int daysOfSuffering, String suggestedMedicine,
            double totalBill, String insuranceInfo
    ) {
        super(patientID, name, gender, contactNo);
        this.healthProblem = healthProblem;
        this.daysOfSuffering = daysOfSuffering;
        this.suggestedMedicine = suggestedMedicine;
        this.totalBill = totalBill;
        this.insuranceInfo = insuranceInfo;
        doctorNames = new ArrayList<>();
        doctorNames.add("Dr. Smith");
        doctorNames.add("Dr. Johnson");
    }

    public String getHealthProblem() {
        return healthProblem;
    }

    public int getDaysOfSuffering() {
        return daysOfSuffering;
    }

    public String getSuggestedMedicine() {
        return suggestedMedicine;
    }

    public double getTotalBill() {
        return totalBill;
    }

    public String getInsuranceInfo() {
        return insuranceInfo;
    }

    public List<String> getDoctorNames() {
        return doctorNames;
    }

    @Override
    public String toString() {
        return super.toString() + "\nHealth Problem: " + healthProblem + "\nDays of Suffering: " + daysOfSuffering +
                "\nDoctor Names: " + doctorNames + "\nSuggested Medicine: " + suggestedMedicine +
                "\nTotal Bill: " + totalBill + "\nInsurance: " + insuranceInfo;
    }
}

public class HealthcareManagementApp {
    public static void main(String[] args) {
        List<PatientRecord> patientRecords = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Healthcare Management System");
            System.out.println("1. Add Patient Record");
            System.out.println("2. List Patient Records");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    try {
                        System.out.print("Enter Patient ID: ");
                        int patientID = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Enter Patient Name: ");
                        String name = scanner.nextLine();
                        System.out.print("Enter Gender: ");
                        String gender = scanner.nextLine();
                        System.out.print("Enter Contact No: ");
                        String contactNo = scanner.nextLine();
                        System.out.print("Enter Health Problem: ");
                        String healthProblem = scanner.nextLine();
                        System.out.print("Enter Days of Suffering: ");
                        int daysOfSuffering = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Enter Total Bill: ");
                        double totalBill = scanner.nextDouble();
                        scanner.nextLine();
                        System.out.print("Enter Insurance Info: ");
                        String insuranceInfo = scanner.nextLine();

                        PatientRecord patientRecord = new DetailedPatientRecord(
                                patientID, name, gender, contactNo, healthProblem,
                                daysOfSuffering, "Paracetamol", totalBill, insuranceInfo
                        );
                        patientRecords.add(patientRecord);
                        System.out.println("Patient Record added successfully.");
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 2:
                    System.out.println("List of Patient Records:");
                    for (PatientRecord record : patientRecords) {
                        System.out.println(record);
                        System.out.println("-----------");
                    }
                    break;

                case 3:
                    System.out.println("Exiting the system.");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}