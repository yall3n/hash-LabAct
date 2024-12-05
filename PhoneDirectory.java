import java.util.Hashtable;
import java.util.Scanner;

public class PhoneDirectory{
    public static void main(String[] args){
        Hashtable<String, String> phoneDirectory = new Hashtable<>();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n=== Phone Directory ===");
            System.out.println("1. Add Entry");
            System.out.println("2. Retrieve Phone Number");
            System.out.println("3. Delete Entry");
            System.out.println("4. View All Entries");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter phone number: ");
                    String phoneNumber = scanner.nextLine();

                    phoneDirectory.put(name, phoneNumber);
                    System.out.println("Entry added successfully!");
                    break;

                case 2:
                    System.out.print("Enter name to retrieve phone number: ");
                    String retrieveName = scanner.nextLine();

                    if (phoneDirectory.containsKey(retrieveName)) {
                        System.out.println("Phone Number: " + phoneDirectory.get(retrieveName));
                    } else {
                        System.out.println("Name not found in the directory.");
                    }
                    break;

                case 3:
                    System.out.print("Enter name to delete: ");
                    String deleteName = scanner.nextLine();

                    if (phoneDirectory.containsKey(deleteName)) {
                        phoneDirectory.remove(deleteName);
                        System.out.println("Entry deleted successfully!");
                    } else {
                        System.out.println("Name not found in the directory.");
                    }
                    break;

                case 4:
                    if (phoneDirectory.isEmpty()) {
                        System.out.println("The directory is empty.");
                    } else {
                        System.out.println("All Entries:");
                        phoneDirectory.forEach((key, value) -> {
                            System.out.println("Name: " + key + ", Phone Number: " + value);
                        });
                    }
                    break;

                case 5:
                    System.out.println("Exiting Phone Directory. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);

        scanner.close();
    }
}