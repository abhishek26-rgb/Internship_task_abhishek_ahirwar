package InternshipTask.Internship;

import java.util.ArrayList;
import java.util.Scanner;

public class TodolistApp {
    private String title;
    private String status;

    
    public TodolistApp() {
        super();
    }

   
    public TodolistApp(String title) {
        this.title = title;
        this.status = "New";
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Task [Title: " + title + ", Status: " + status + "]";
    }

    
    public static void main(String[] args) {
        ArrayList<TodolistApp> tasks = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            // Display menu
            System.out.println("\nTodo List Menu:");
            System.out.println("1. Add Task");
            System.out.println("2. Edit Existing Task");
            System.out.println("3. Remove Task");
            System.out.println("4. List All Tasks");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1: 
                    System.out.print("Enter Task Title: ");
                    String title = sc.nextLine();
                    tasks.add(new TodolistApp(title));
                    System.out.println("Task added successfully!");
                    break;

                case 2:
                    if (tasks.isEmpty()) {
                        System.out.println("No tasks available to edit.");
                        break;
                    }
                    System.out.print("Enter the task number to edit (1 to " + tasks.size() + "): ");
                    int editIndex = sc.nextInt() - 1;
                    sc.nextLine();
                    
                    if (editIndex >= 0 && editIndex < tasks.size()) {
                        System.out.print("Enter new title: ");
                        String newTitle = sc.nextLine();
                        System.out.print("Enter new status (New, In Progress, Completed, Cancelled): ");
                        String newStatus = sc.nextLine();
                        tasks.get(editIndex).setTitle(newTitle);
                        tasks.get(editIndex).setStatus(newStatus);
                        System.out.println("Task updated successfully!");
                    } else {
                        System.out.println("Invalid task number.");
                    }
                    break;

                case 3:
                    if (tasks.isEmpty()) {
                        System.out.println("No tasks available to remove.");
                        break;
                    }
                    System.out.print("Enter the task number to remove (1 to " + tasks.size() + "): ");
                    int removeIndex = sc.nextInt() - 1;
                    if (removeIndex >= 0 && removeIndex < tasks.size()) {
                        tasks.remove(removeIndex);
                        System.out.println("Task removed successfully!");
                    } else {
                        System.out.println("Invalid task number.");
                    }
                    break;

                case 4: 
                    if (tasks.isEmpty()) {
                        System.out.println("No tasks available.");
                    } else {
                        System.out.println("\nTodo List:");
                        for (int i = 0; i < tasks.size(); i++) {
                            System.out.println((i + 1) + ". " + tasks.get(i));
                        }
                    }
                    break;

                case 5: 
                    System.out.println("Exiting Todo List App. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 5);

        sc.close();
    }
}
