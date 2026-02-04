import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

public class WestminsterHealthCentreManager implements HealthCentreManager {

    private ArrayList<StaffMember> staffMemberList;
    private static final String DATA_FILE = "staffData.csv";
    private Scanner sc;

    public WestminsterHealthCentreManager() {
        staffMemberList = new ArrayList<>();
        sc = new Scanner(System.in);
        try {
            loadFromFile();
            System.out.println("Successfully Loaded");
        } catch (IOException e) {
            System.out.println("No data found!");
        }
    }

    public ArrayList<StaffMember> getStaffMemberList() {
        return staffMemberList;
    }

    public void runMenu() {
        boolean run = true;

        while (run) {
            System.out.println("\n");
            System.out.println("Westminster Health Centre Management System");
            System.out.println("=".repeat(50));
            System.out.println("1. Add New Staff Member");
            System.out.println("2. Remove Staff Member");
            System.out.println("3. View All Staff");
            System.out.println("4. Search Staff by ID");
            System.out.println("6. To load from a file");
            System.out.println("7. Save and Exit");
            System.out.print("\nEnter your choice: ");
        }
    }

    @Override
    public void addStaff() {
        try {
            System.out.println("\n=== Add New Staff Member ===");
            System.out.println("Select staff type: Doctor-1 , Receptionist-2");

            int selected = sc.nextInt();

            System.out.println("Enter ID: ");
            String ID = sc.nextLine().trim();

            System.out.println("Enter first name: ");
            String fName = sc.nextLine().trim();

            System.out.println("Enter Surname: ");
            String surName = sc.nextLine().trim();

            System.out.println("Enter DoB");
            String DoB = sc.nextLine().trim();

            System.out.print("Enter contact number: ");
            String contact = sc.nextLine().trim();

            if (selected == 1) {
                System.out.print("Enter licence number: ");
                String licence = sc.nextLine().trim();

                System.out.print("Enter specialisation: ");
                String specialisation = sc.nextLine().trim();

                System.out.print("Enter consultations per week: ");
                int consultations = Integer.parseInt(sc.nextLine().trim());

                Doctor doctor = new Doctor(ID, fName, surName, DoB, contact, licence, specialisation, consultations);

                staffMemberList.add(doctor);
                System.out.println("Doctor added Successfully");

            } else if (selected == 2) {
                System.out.print("Enter desk number: ");
                int deskNumber = Integer.parseInt(sc.nextLine().trim());

                System.out.print("Enter hours per week: ");
                int hours = Integer.parseInt(sc.nextLine().trim());
            }

            else {
                System.out.println("Invalid choice!");
            }

        } catch (NumberFormatException e) {
            System.err.println("Enter valid Number");
        }
    }

    @Override
    public void viewStaff() {
        if (staffMemberList.isEmpty()) {
            System.out.println("No member in the List");
            return;
        }

        System.out.println("Total staff members: " + staffMemberList.size());

        for (StaffMember s : staffMemberList) {
            System.out.println(s);
        }
    }

    public void searchStaffByID() {
        System.out.println("Enter staff ID: ");
        String id = sc.nextLine().trim();

        StaffMember found = null;

        for (StaffMember s : staffMemberList) {
            if (s.getUniqueID().equals(id)) {
                found = s;
            }
        }

        if (found == null) {
            System.out.println("No Staff member found in this ID: ");
        } else {
            System.out.println("Staff Member found with " + found.getUniqueID() + " ID");
            System.out.println(found);
        }
    }

    @Override
    public void removeStaff() {
        System.out.println("Enter ID to remove: ");
        String id = sc.nextLine().trim();

        StaffMember found = null;

        for (StaffMember s : staffMemberList) {
            if (s.getUniqueID().equals(id)) {
                found = s;
                break;
            }
        }

        if (found == null) {
            System.out.println("No staff member found!");
            return;
        }

        System.out.println("Staff member found!");
        System.out.println(found);
        System.out.println("Do you want to remove this member? (yes/no)");
        String confirm = sc.nextLine().trim().toLowerCase();

        if (confirm.equals("yes")) {
            staffMemberList.remove(found);
            System.out.println("Staff Member Successfully Removed ");
        } else {
            System.out.println("Remove canceled!");
        }

    }

    @Override
    public void loadFromFile() throws IOException {
        File file = new File(DATA_FILE);
        if (!file.exists()) {
            System.out.println("File not exist");
            return;
        }

        staffMemberList.clear();

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            reader.readLine();
            String line;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length < 8)
                    continue;

                String type = parts[0];

                if (type.equals("D")) {
                    Doctor doctor = new Doctor(
                            parts[1], // ID
                            parts[2], // fName
                            parts[3], // surname
                            parts[4], // Dob
                            parts[5], // contact
                            parts[6], // licence
                            parts[7], // specialisation
                            Integer.parseInt(parts[8]) // consultations
                    );
                    staffMemberList.add(doctor);
                } else if (type.equals("R")) {
                    Receptionist receptionist = new Receptionist(
                            parts[1], // ID
                            parts[2], // fName
                            parts[3], // surname
                            parts[4], // Dob
                            parts[5], // contact
                            Integer.parseInt(parts[6]), // deskNumber
                            Integer.parseInt(parts[7]) // hours
                    );
                    staffMemberList.add(receptionist);
                }
            }

        }
    }

    @Override
    public void saveToFile() throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(DATA_FILE))) {
            writer.write("memberType, ID, firstName, surName, DoB, Contact,  ,  ,  ,");
            writer.newLine();

            for (StaffMember s : staffMemberList) {
                if (s instanceof Doctor) {
                    Doctor d = (Doctor) s;
                    writer.write(String.format("D,%s,%s,%s,%s,%s,%s,%s,%d",
                            d.getUniqueID(), d.getName(), d.getSurName(),
                            d.getDob(), d.getContactNo(),
                            d.getLicenceNumber(), d.getSpecialisation(),
                            d.getConsultationsPerWeek()));
                } else if (s instanceof Receptionist) {
                    Receptionist r = (Receptionist) s;
                    writer.write(String.format("R,%s,%s,%s,%s,%s,%s,%d,",
                            r.getUniqueID(), r.getName(), r.getSurName(),
                            r.getDob(), r.getContactNo(),
                            r.getDeskNumber(), r.getHoursPerWeek()));
                }
                writer.newLine();

            }
        }
    }
}
