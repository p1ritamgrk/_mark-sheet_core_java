
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author pritam shrestha
 * @version v1.0
 * @date 2024-12-27
 **/


class MarkSheetManager {
    private static ArrayList<MarkSheet> MarkSheets = new ArrayList<>();
    public MarkSheetManager() {
    }

    
    public static void main(String[] args) {
        MarkSheetManager manager = new MarkSheetManager();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n");
            System.out.println("*****************************************************************");
            System.out.println("1. Add MarkSheet");
            System.out.println("2. View MarkSheets");
            System.out.println("3. Delete MarkSheet");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    MarkSheet MarkSheet = grabStudentDetails(scanner);
                    manager.addMarkSheet(MarkSheet);
                    break;
                case 2:
                    System.out.println("*****************************************************************");
                    System.out.println("Enter roll number to view MarkSheet: ");
                    int rollToView = scanner.nextInt();
                    manager.viewMarkSheet(rollToView);
                    break;

                case 3:
                    System.out.println("*****************************************************************");
                    System.out.println("Enter roll number of the student to delete: ");
                    int rollNumber = scanner.nextInt();
                    manager.deleteMarkSheet(rollNumber);
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);

        scanner.close();
    }

    private static MarkSheet grabStudentDetails(Scanner scanner) {
        MarkSheet MarkSheet = new MarkSheet();
        System.out.println("*****************************************************************");
        scanner.nextLine();
        System.out.print("Enter your name: ");
        MarkSheet.setName(scanner.nextLine().trim().toUpperCase());
        MarkSheet.setRollNumber(grabIntegerRelatedInfo(scanner, "Roll Number"));
        MarkSheet.setMathMark(grabIntegerRelatedInfo(scanner, "Marks obtained in Maths"));
        MarkSheet.setScienceMark(grabIntegerRelatedInfo(scanner, "Marks obtained in Science"));
        MarkSheet.setSocialMark(grabIntegerRelatedInfo(scanner, "Marks obtained in Social"));
        MarkSheet.setNepaliMark(grabIntegerRelatedInfo(scanner, "Marks obtained in Nepali"));
        MarkSheet.setEnglishMark(grabIntegerRelatedInfo(scanner, "Marks obtained in English"));

        return MarkSheet;
    }

    private static int grabIntegerRelatedInfo(Scanner input, String type) {
        int enteredMark;
        while (true) {
            System.out.print("Please enter " + type + ": ");
            while (!input.hasNextInt()) {
                System.out.println("Character not allowed, please enter an integer number only.");
                input.next();
                System.out.print("Please enter " + type + ": ");
            }
            enteredMark = input.nextInt();

            if (enteredMark < 0 || (enteredMark > 100 && !type.equals("Roll Number"))) {
                System.out.println(type + " cannot be less than 0 and greater than 100");
            } else {
                break;
            }
        }
        return enteredMark;
    }

    public void addMarkSheet(MarkSheet MarkSheet) {
        MarkSheets.add(MarkSheet);
        System.out.println("Successfully add MarkSheet");
    }

    public void viewMarkSheet(int rollNumber) {
        MarkSheet foundMarkSheet = null;
        for (MarkSheet MarkSheet : MarkSheets) {
            if (MarkSheet.getRollNumber() == rollNumber) {
                foundMarkSheet = MarkSheet;
                break;
            }
        }

        if (foundMarkSheet != null) {
            displayMarkSheet(foundMarkSheet);
        } else {
            System.out.println("MarkSheet with roll number " + rollNumber + " not found.");
        }
    }



    public void deleteMarkSheet(int rollNumber) {
        MarkSheet MarkSheetToRemove = null;
        for (MarkSheet MarkSheet : MarkSheets) {
            if (MarkSheet.getRollNumber() == rollNumber) {
                MarkSheetToRemove = MarkSheet;
                break;
            }
        }

        if (MarkSheetToRemove != null) {
            MarkSheets.remove(MarkSheetToRemove);
            System.out.println("MarkSheet removed successfully!");
        } else {
            System.out.println("MarkSheet with roll number " + rollNumber + " not found.");
        }
    }

    private static void displayMarkSheet(MarkSheet MarkSheet) {
        System.out.println("\t\t\tAcademia International College");
        System.out.println("\t\t\t\tGwarko, Lalitpur");
        System.out.println("\t\t\t\t\t9800000000\n");
        System.out.println("Class : X");
        System.out.println("Name : " + MarkSheet.getName());
        System.out.println("Roll No : " + MarkSheet.getRollNumber());
        String division = "";
        String status = "";
        double percentage = 0;
        if (MarkSheet.isAllSubjectPass()) {
            percentage = MarkSheet.getPercentage();
            status = "PASS";
            if (percentage > 40 && percentage < 60) {
                division = "PASS";
            } else if (percentage > 60 && percentage < 80) {
                division = "FIRST DIVISION";
            } else if (percentage > 80 && percentage <= 100) {
                division = "DISTINCTION";
            }
        }
        System.out.print("---------------------------------------------------|\n");
        System.out.printf("%s\t\t | %s\t\t | %s\t\t | %s\n", "Subject", "FM", "PM", "OM|");
        System.out.print("---------------------------------------------------|\n");
        System.out.printf("%s\t\t | %s\t\t | %s\t\t | %s\n", "Science", "100", "32", MarkSheet.getScienceMark());
        System.out.print("---------------------------------------------------|\n");
        System.out.printf("%s\t\t | %s\t\t | %s\t\t | %s\n", "Maths", "100", "32", MarkSheet.getMathMark());
        System.out.print("---------------------------------------------------|\n");
        System.out.printf("%s\t\t | %s\t\t | %s\t\t | %s\n", "Social", "100", "32", MarkSheet.getSocialMark());
        System.out.print("---------------------------------------------------|\n");
        System.out.printf("%s\t\t | %s\t\t | %s\t\t | %s\n", "Nepali", "100", "32", MarkSheet.getNepaliMark());
        System.out.print("---------------------------------------------------|\n");
        System.out.printf("%s\t\t | %s\t\t | %s\t\t | %s\n", "English", "100", "32", MarkSheet.getEnglishMark());
        System.out.print("---------------------------------------------------|\n");
        System.out.println("Result : " + (status.isEmpty() ? "FAIL" : status));
        System.out.println("Division : " + (division.isEmpty() ? "-" : division));
        System.out.println("Percentage : " + (percentage == 0 ? "-" : percentage));
    }
}