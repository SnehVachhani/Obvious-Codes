import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class Student {

    private int id;
    private String firstName;
    private String lastName;
    private String contactNo;
    private String branch;
    private String address;
    private String dob;

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getName() {
        return firstName + " " + lastName;
    }

    public String getContactNo() {
        return contactNo;
    }

    public String getBranch() {
        return branch;
    }

    public String getAddress() {
        return address;
    }

    public String getDob() {
        return dob;
    }

    public boolean setId(int id) {
        this.id = id;
        return true;
    }

    public boolean setFirstName(String firstName) {
        if (!firstName.matches("[A-Za-z]+")) {
            System.out.println("Invalid First Name");
            return false;
        }
        this.firstName = firstName;
        return true;

    }

    public boolean setLastName(String lastName) {
        if (!lastName.matches("[A-Za-z]+")) {
            System.out.println("Invalid Last Name");
            return false;
        }
        this.lastName = lastName;
        return true;

    }

    public boolean setContactNo(String contactNo) {
        if (!contactNo.matches("[0-9]{10}")) {
            System.out.println("Invalid Contact No");
            return false;
        }
        this.contactNo = contactNo;
        return true;

    }

    public boolean setBranch(String branch) {
        if (!branch.matches("[A-Za-z ]+")) {
            System.out.println("Invalid Branch");
            return false;
        }
        this.branch = branch;
        return true;

    }

    public boolean setAddress(String address) {
        if (!address.matches("[A-Za-z0-9/,-/. ]+")) {
            System.out.println("Invalid Address");
            // throw new IllegalArgumentException("Invalid Address");
            return false;
        }
        this.address = address;
        return true;

    }

    public boolean setDob(String dob) {
        if (!dob.matches("^\\d{2}-\\d{2}-\\d{4}$")) {
            System.out.println("Invalid date");
            return false;
        }
        String[] splittedDOB = dob.split("-");
        if (Integer.valueOf(splittedDOB[0]) < 1 || Integer.valueOf(splittedDOB[0]) > 31) {
            System.out.println("Invalid date");
            return false;
        }
        if (Integer.valueOf(splittedDOB[1]) < 1 || Integer.valueOf(splittedDOB[1]) > 12) {
            System.out.println("Invalid date");
            return false;
        }
        if (Integer.valueOf(splittedDOB[2]) < 1900 || Integer.valueOf(splittedDOB[2]) > 2022) {
            System.out.println("Invalid date");
            return false;
        }
        this.dob = dob;
        return true;
    }

}

class StudentAdmininstrator {
    private List<Student> admin = new ArrayList<>();

    public void addStudent(int id, String firstName, String lastName, String contactNo, String branch, String address,
            String dob) {
        if (checkById(id) == null) {
            Student newStudent = new Student();
            if (newStudent.setId(id) && newStudent.setFirstName(firstName) &&
                    newStudent.setLastName(lastName) &&
                    newStudent.setContactNo(contactNo) &&
                    newStudent.setBranch(branch) &&
                    newStudent.setAddress(address) &&
                    newStudent.setDob(dob))
                admin.add(newStudent);
        }
        else
            System.out.println("Enter a unique Id. Id " + id + " already present.");
    }

    private Student checkById(int id) {
        for (Student student : admin)
            if (id == student.getId())
                return student;
        return null;
    }

    private Student checkByName(String fName, String lName) {
        for (Student student : admin)
            if (fName.toLowerCase().equals(student.getFirstName().toLowerCase())
                    && lName.toLowerCase().equals(student.getLastName().toLowerCase()))
                return student;
        return null;
    }

    private boolean checkByFName(int id, String newFName) {
        Student toUpdate = checkById(id);
        for (Student student : admin)
            if (newFName.toLowerCase().equals(student.getFirstName().toLowerCase())
                    && toUpdate.getLastName().toLowerCase().equals(student.getLastName().toLowerCase())) {
                System.out.println("the value you are trying to update is already present in the table");
                return true;
            }

        return false;
    }

    private boolean checkByLName(int id, String newLName) {
        Student toUpdate = checkById(id);
        for (Student student : admin)
            if (toUpdate.getFirstName().toLowerCase().equals(student.getFirstName().toLowerCase())
                    && newLName.toLowerCase().equals(student.getLastName().toLowerCase())) {
                System.out.println("the value you are trying to update is already present in the table");
                return true;
            }

        return false;
    }

    public boolean printAllNames() {
        if (admin.isEmpty()) {
            System.out.println("No students added yet...");
            return false;
        }
        for (Student student : admin)
            System.out.println(student.getName());
        return true;
    }

    public boolean printEveryThing() {
        if (admin.isEmpty()) {
            System.out.println("No students added yet...");
            return false;
        }
        for (Student student : admin)
            System.out.println("Id : " + student.getId() + " ,  " +
                    "Name : " + student.getName() + " ,  " +
                    "Contact Number : " + student.getContactNo() + " ,  " +
                    "Branch : " + student.getBranch() + " ,  " +
                    "Address : " + student.getAddress() + " ,  " +
                    "Date Of Birth : " + student.getDob());
        return true;
    }

    public boolean searchNameById(int id) {
        if (admin.isEmpty()) {
            System.out.println("No students added yet...");
            return false;
        }
        Student isStudent = checkById(id);
        if (isStudent == null) {
            System.out.println("Id not found");
            return false;
        }
        System.out.println(isStudent.getName());

        return true;
    }

    public boolean update(int id, int info, String newString) {
        if (admin.isEmpty()) {
            System.out.println("No students added yet...");
            return false;
        }
        if (checkById(id) == null) {
            System.out.println("Student not found");
            return false;
        }
        switch (info) {
            case 1:
                if (!checkByFName(id, newString))
                    checkById(id).setFirstName(newString);
                break;
            case 2:
                if (!checkByLName(id, newString))
                    checkById(id).setLastName(newString);
                break;
            case 3:
                checkById(id).setContactNo(newString);
                break;
            case 4:
                checkById(id).setBranch(newString);
                break;
            case 5:
                checkById(id).setAddress(newString);
                break;
            case 6:
                checkById(id).setDob(newString);
                break;
        }
        return true;
    }

    public boolean update(String fName, String lName, int info, String newString) {
        if (admin.isEmpty()) {
            System.out.println("No students added yet...");
            return false;
        }
        if (checkByName(fName, lName) == null) {
            System.out.println("Student not found");
            return false;
        }

        Student toUpdate = checkByName(fName, lName);
        switch (info) {
            case 0:
                if (checkById(Integer.valueOf(newString)) != null) {
                    System.out.println("Enter a unique Id");
                    return false;
                }
                toUpdate.setId(Integer.valueOf(newString));
                break;
            case 1:
                if (!checkByFName(toUpdate.getId(), newString))
                    toUpdate.setFirstName(newString);
                break;
            case 2:
                if (!checkByLName(toUpdate.getId(), newString))
                    toUpdate.setLastName(newString);
                break;
            case 3:
                toUpdate.setContactNo(newString);
                break;
            case 4:
                toUpdate.setBranch(newString);
                break;
            case 5:
                toUpdate.setAddress(newString);
                break;
            case 6:
                toUpdate.setDob(newString);
                break;
        }
        return true;
    }

    public boolean update(int id, String fName, String lName, String branch, String contactNo, String address,
            String dob) {
        if (admin.isEmpty()) {
            System.out.println("No students added yet...");
            return false;
        }
        if (checkById(id) == null) {
            System.out.println("Student not found");
            return false;
        }
        if (checkByFName(id, fName) || checkByFName(id, lName))
            return false;
        Student studentToUpdate = checkById(id);
        studentToUpdate.setFirstName(fName);
        studentToUpdate.setLastName(lName);
        studentToUpdate.setContactNo(contactNo);
        studentToUpdate.setAddress(address);
        studentToUpdate.setDob(dob);
        return true;
    }

    // public boolean fullNameChecker(String)
    public boolean listByBranch() {
        Map<String, List<Student>> map = new HashMap<>();
        for (Student student : admin) {
            if (!map.containsKey(student.getBranch()))
                map.put(student.getBranch(), new ArrayList<>());
            map.get(student.getBranch()).add(student);
        }
        for (String branch : map.keySet()) {
            System.out.println("---- Branch : " + branch + "----");
            for (Student s : map.get(branch))
                System.out.println("Name : " + s.getName());
        }
        return true;
    }

    public boolean deleteStudent(int id) {
        admin.remove(checkById(id));
        return true;
    }

}

public class Q6 {
    static Scanner sc = new Scanner(System.in);
    static StudentAdmininstrator admin = new StudentAdmininstrator();

    public static void main(String[] args) {

        // admin.addStudent(1, "Divyaraj", "Vachhani", "9409162241", "CP", "xyz9", "01-01-2022");
        // admin.addStudent(2, "Divyaraj", "Parmar", "1234567890", "CP", "xyz,morvi", "15-02-2002");
        // admin.addStudent(3, "ved", "k", "9409162241", "IT", "hetshi", "18-09-2001");
        boolean flag = true;
        while (flag) {
            menu();
            switch (sc.next()) {
                case "1":
                    addStudentMethod();
                    break;
                case "2":
                    System.out.println("Enter id to delete :");
                    admin.deleteStudent(sc.nextInt());
                    break;
                case "3":
                    updateMenu();
                    switch (sc.nextInt()) {
                        case 1:
                            updateUsingId();
                            break;

                        case 2:
                            updateUsingName();
                            break;
                        case 3:
                            updateAll();
                            break;
                    }
                    break;
                case "4":
                    admin.printAllNames();
                    break;
                case "5":
                    admin.printEveryThing();
                    break;
                case "6":
                    admin.listByBranch();
                    break;
                case "7":
                    flag = false;
                    System.out.println("404");
            }
        }
        sc.close();
    }

    private static void menu() {
        System.out.println("--------------------");
        System.out.println("1. Add students");
        System.out.println("2. Delete students");
        System.out.println("3. Modify students");
        System.out.println("4. View all students");
        System.out.println("5. View everything");
        System.out.println("6. View by branch");
        System.out.println("7. Exit");
        System.out.println("--------------------");
        System.out.println("please enter your choice :");
    }

    private static void addStudentMethod() {
        System.out.println("add student");
        System.out.print("Enter id :");
        int id = sc.nextInt();
        System.out.print("Enter First Name :");
        String fName = sc.next();
        System.out.print("Enter Last Name :");
        String lName = sc.next();
        System.out.print("Enter Contact No :");
        String cNo = sc.next();
        System.out.print("Enter Branch :");
        String branch = sc.next();
        System.out.print("Enter Address :");
        String address = sc.next();
        System.out.print("Enter Date Of Birth(dd-mm-yyyy) :");
        String dob = sc.next();
        admin.addStudent(id, fName, lName, cNo, branch, address, dob);
    }

    private static void updateMenu() {
        System.out.println("Enter 1. to update any value using id");
        System.out.println("Enter 2. to update any using first name and last name");
        System.out.println("Enter 3. to update all value using id");
    }

    private static void updateUsingId() {
        System.out.println("Enter id to update :");
        int tempId = sc.nextInt();
        System.out.println("Enter which field to update : ");
        System.out.println("Enter 1. to update First name");
        System.out.println("Enter 2. to update Last name");
        System.out.println("Enter 3. to update Contact number");
        System.out.println("Enter 4. to update Branch");
        System.out.println("Enter 5. to update address");
        System.out.println("Enter 6. to update Date of Birth");
        int info = sc.nextInt();
        System.out.println("Enter new value ");
        admin.update(tempId, info, sc.next());
    }

    private static void updateUsingName() {
        System.out.println("Enter First name to update :");
        String newFName = sc.next();
        System.out.println("Enter First name to update :");
        String newLName = sc.next();
        System.out.println("Enter which field to update : ");
        System.out.println("Enter 0. to update Id");
        System.out.println("Enter 1. to update First name");
        System.out.println("Enter 2. to update Last name");
        System.out.println("Enter 3. to update Contact number");
        System.out.println("Enter 4. to update Branch");
        System.out.println("Enter 5. to update address");
        System.out.println("Enter 6. to update Date of Birth");
        int newInfo = sc.nextInt();
        System.out.println("Enter new value ");
        admin.update(newFName, newLName, newInfo, sc.next());
    }

    private static void updateAll() {
        System.out.println("Enter id to update :");
        int tempIdd = sc.nextInt();
        System.out.println("Enter which field to update : ");
        System.out.println("Enter new First name");
        String newFname = sc.next();
        System.out.println("Enter new Last name");
        String newLname = sc.next();
        System.out.println("Enter new Contact number");
        String contactNo = sc.next();
        System.out.println("Enter new Branch");
        String newBranch = sc.next();
        System.out.println("Enter new address");
        String newAddress = sc.next();
        System.out.println("Enter new Date of Birth");
        String newDob = sc.next();
        admin.update(tempIdd, newFname, newLname, newBranch, contactNo, newAddress, newDob);
    }
}
