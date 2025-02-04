package InternshipTask.Internship;

import java.util.ArrayList;
import java.util.Scanner;

public class News {
    private String title;
    private String details;
    private String imagepath;

   
    public News() {
        super();
    }

    public News(String title, String details, String imagepath) {
        super();
        this.title = title;
        this.details = details;
        this.imagepath = imagepath;
    }

    public String getTitle() {
        return title;
    }

    public String getDetails() {
        return details;
    }

    public String getImagepath() {
        return imagepath;
    }

    @Override
    public String toString() {
        return "News [Title=" + title + ", Details=" + details + ", Image Path=" + imagepath + "]";
    }


    public static class NewsfeedApp {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            ArrayList<News> newsfeed = new ArrayList<>();
            int choice;

            do {
                System.out.println("\nNews Feed Menu:");
                System.out.println("1. Add News Details");
                System.out.println("2. List News");
                System.out.println("3. Exit");
                System.out.print("Enter your choice: ");
                choice = sc.nextInt();
                 sc.nextLine(); 

                switch (choice) {
                    case 1:
                        System.out.print("Enter News Title: ");
                        String title = sc.nextLine();

                        System.out.print("Enter News Details: ");
                        String details = sc.nextLine();

                        System.out.print("Enter News Image Path: ");
                        String imagepath = sc.nextLine();

                        newsfeed.add(new News(title, details, imagepath));
                        System.out.println("News added successfully!");
                        break;

                    case 2:
                        if (newsfeed.isEmpty()) {
                            System.out.println("No news available.");
                        } else {
                            System.out.println("\nNews Feed:");
                            for (int i = 0; i < newsfeed.size(); i++) {
                                System.out.println((i + 1) + ". " + newsfeed.get(i));
                            }
                        }
                        break;

                    case 3:
                        System.out.println("Exiting News Feed App. Goodbye!");
                        break;

                    default:
                        System.out.println("Invalid choice! Please try again.");
                        break;
                }
            } while (choice != 3);

            sc.close();
        }
    }
}
