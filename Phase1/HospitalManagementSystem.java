package Phase1;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

// Hospital
public class HospitalManagementSystem {
    static ArrayList<Patient> patients = new ArrayList<>();
    static ArrayList<Doctor> doctors = new ArrayList<>();
    static ArrayList<Appointment> appointments = new ArrayList<>();
    static Scanner scn = new Scanner(System.in);

    static boolean isPatient(int ID) {
        for (Patient p : patients) {
            if (p.getId() == ID)
                return true;
        }
        return false;
    }

    static boolean isDoctor(int ID) {
        for (Doctor d : doctors) {
            if (d.getId() == ID)
                return true;
        }
        return false;
    }

    static void addPatient() {
        System.out.println("Enter the Name of Patient:");
        String patientName = scn.next();
        System.out.println("Enter the Gender of Patient:");
        String patientGender = scn.next();
        System.out.println("Enter the age of patient:");
        int patientAge = scn.nextInt();

        if (patientAge <= 0 || patientAge > 120) {
            System.out.println("Invalid age of patient");
            return;
        }

        Patient patient = new Patient(patientName, patientGender, patientAge);
        patients.add(patient);
    }

    static void addDoctor() {
        System.out.println("Enter the name of doctor:");
        String doctorName = scn.next();
        System.out.println("Enter the gender of doctor:");
        String doctorGender = scn.next();
        System.out.println("Enter the age of doctor:");
        int doctorAge = scn.nextInt();

        if (doctorAge <= 0 && doctorAge > 120) {
            System.out.println("Invalid age of doctor");
            return;
        }

        Doctor doctor = new Doctor(doctorName, doctorGender, doctorAge);
        doctors.add(doctor);
    }

    static void scheduleAppointment() {
        System.out.println("Enter the patient ID:");
        int patientID = scn.nextInt();

        if (isPatient(patientID) == false) {
            System.out.println("Patient ID not found");
            System.out.println("Appointment schedule unsuccessful");
            return;
        }

        System.out.println("Enter the doctor ID:");
        int doctorID = scn.nextInt();

        if (isDoctor(doctorID) == false) {
            System.out.println("Doctor ID not found");
            System.out.println("Appointment schedule unsuccessful!");
            return;
        }

        System.out.println("Enter the day of appointment:");
        int day = scn.nextInt();
        if (day <= 0 && day > 31) {
            System.out.println("Invalid date of appointment");
            return;
        }
        System.out.println("Enter the month of appointment:");
        int month = scn.nextInt();
        if (month <= 0 && month > 12) {
            System.out.println("Invalid date of appointment");
            return;
        }

        System.out.println("Enter the year of appointment:");
        int year = scn.nextInt();

        String date = day + "-" + month + "-" + year;
        Appointment appointment = new Appointment(patientID, doctorID, date);
        appointments.add(appointment);
        System.out.println("Your Appointment is booked!");
    }

    static void viewPatients() {
        if (patients.isEmpty()) {
            System.out.println("There is no patient");
            return;
        }

        System.out.println("-------*****-------");
        for (Patient patient : patients) {
            System.out.println("Patient: " + patient.getName());
            System.out.println("Gender:" + patient.getGender());
            System.out.println("Age: " + patient.getAge());
            System.out.println("Patient Id: " + patient.getId());
            System.out.println();
        }
        System.out.println("-------*****-------");
    }

    static void viewDoctors() {
        if (doctors.isEmpty()) {
            System.out.println("There is not doctor");
            return;
        }

        System.out.println("-------*****-------");
        for (Doctor doctor : doctors) {
            System.out.println("Doctor: " + doctor.getName());
            System.out.println("Gender: " + doctor.getGender());
            System.out.println("Age: " + doctor.getAge());
            System.out.println("Doctor ID: " + doctor.getId());
            System.out.println();
        }
        System.out.println("-------*****-------");
    }

    static void viewAppointments() {
        if (appointments.isEmpty()) {
            System.out.println("There is not appointments available");
            return;
        }
        System.out.println("-------*****-------");
        for (Appointment appointment : appointments) {
            System.out.println("Patient ID: " + appointment.getPatientId());
            System.out.println("Doctor ID: " + appointment.getDoctorId());
            System.out.println("Date: " + appointment.getDate());
            System.out.println();
        }
        System.out.println("-------*****-------");
    }

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("-------*****-------");
            System.out.println("1. Add Patient");
            System.out.println("2. Add Doctor");
            System.out.println("3. Schedule Appointment");
            System.out.println("4. View Patients");
            System.out.println("5. View Doctors");
            System.out.println("6. View Appointments");
            System.out.println("0. Exit");
            System.out.println("-------*****-------");
            System.out.println("Enter your choice:");
            choice = scn.nextInt();

            switch (choice) {
                case 1:
                    addPatient();
                    break;
                case 2:
                    addDoctor();
                    break;
                case 3:
                    scheduleAppointment();
                    break;
                case 4:
                    viewPatients();
                    break;
                case 5:
                    viewDoctors();
                    break;
                case 6:
                    viewAppointments();
                    break;
                case 0:
                    System.out.println("Exiting the system. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 0);
    }
}