package manage;

import person.Student;
import data.Data;
import java.io.IOException;
import java.util.Scanner;

public class ManageSys {
    private static Scanner sc;

    public static void main(String[] args) throws IOException {
        Data data = new Data();
        System.out.println("Welcome! Welcome!");
        System.out.println("Student management system is at your service!");
        System.out.println("Enter the command 1--Add, 2--Set, 3-search, 4--Delete, 5--view, 6--Clear, 7--Exit");
        System.out.println("\r\n");
        sc = new Scanner(System.in);
        while (true) {
            System.out.println("waisting cmd......");
            String cmd = sc.nextLine();
            switch (cmd) {
                case "1":
                    addStu(data);
                    break;
                case "2":
                    updateStu(data);
                    break;
                case "3":
                    System.out.println("Please enter the student's ID to search:");
                    String sid2 = sc.nextLine();
                    System.out.println(data.getBySid(sid2));
                    break;
                case "4":
                    System.out.println("Please enter the student's ID to delete:");
                    String sid3 = sc.nextLine();
                    data.remove(sid3);
                    break;
                case "5":
                    data.list();
                    break;
                case "6":
                    data.clear();
                    break;
                case "7":
                    System.out.println("Thanks for your coming!");
                    break;
                default:
                    System.out.println("Illegal cmd, please enter an integer, example: 1\r\n");
            }
        }
    }

    private static void addStu(Data data) throws IOException {
        System.out.println("Please enter informationstudent to add:");
        System.out.print("student ID:");
        String sid1 = sc.nextLine();
        System.out.print("name:");
        String name = sc.nextLine();
        System.out.print("age:");
        String age = sc.nextLine();
        System.out.print("address:");
        String addr = sc.nextLine();
        Student student = new Student(sid1, name, Integer.parseInt(age), addr);
        data.add(student);
    }

    private static void updateStu(Data data) throws IOException {
        System.out.println("Please enter informationstudent to update:");
        System.out.print("student ID:");
        String sid1 = sc.nextLine();
        System.out.print("new name:");
        String name = sc.nextLine();
        System.out.print("new age:");
        String age = sc.nextLine();
        System.out.print("new address:");
        String addr = sc.nextLine();
        data.set(sid1, name, Integer.parseInt(age), addr);
    }
}
