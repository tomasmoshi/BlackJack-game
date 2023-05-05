import java.util.Scanner;
import java.util.EmptyStackException;
import java.io.*;
import java.util.*;

/**
 * Write a description of class BlackJackDemo here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class PhoneBookDemo {
    public static void main(String[] args) {


        String firstName, lastName, address;
        long Number;
        int choice = 99;
        int option, index;
        AddressBook ab = new AddressBook();
        String x = "";
        String name;
        Contact c = new Contact("", "", "", 0);
        String editOption;
        Scanner keyboard;


        while (choice != 6) {
            choice = menu();
            keyboard = new Scanner(System.in);
            switch (choice) {

                case 1:


                    System.out.println("Enter first name");
                    firstName = keyboard.nextLine();

                    System.out.println("Enter last name");
                    lastName = keyboard.nextLine();

                    System.out.println("Enter street Address");
                    address = keyboard.nextLine();

                    System.out.println("Enter Phone Number");
                    Number = keyboard.nextLong();

                    c = new Contact(firstName, lastName, address, Number);
                    ab.addContact(c);

                    System.out.println(c.toString());
                    writeContacts(ab);

                    break;

                case 2:

                    System.out.println("enter the first and last name of the contact "
                            + "so we can see if its in our phonebook");
                    name = keyboard.nextLine();

                    index = ab.findContact(name);
                    if (index != -1) {
                        //c = ab.getCurrent();
                        System.out.println("person found");
                        System.out.println(ab.getCurrent());

                    } else {
                        //System.out.printf("DEBUG: Searching for \"%s\"...",name);
                        System.out.println("person not found");
                    }

                    break;
                case 3:
                    keyboard = new Scanner(System.in);
                    System.out.println("enter the name to be found to be edited:");
                    name = keyboard.nextLine();
                    index = ab.findContact(name);

                    if (index != -1) {
                        System.out.println("person found");
                    } else {
                        System.out.println("person not found");
                    }

                    System.out.println("Enter 1, 2, 3, or 4 for the changes you'd like to make");
                    System.out.println("1.change first name \n" + " 2.Change last name \n"
                            + " 3.change address \n" + " 4.change phone number \n");
                    option = keyboard.nextInt();

                    if (option == 1) {
                        System.out.println("Enter new first name: ");
                        keyboard = new Scanner(System.in);
                        firstName = keyboard.nextLine();
                        c.setFirst(firstName);
                    } else if (option == 2) {
                        System.out.println("Enter new last name: ");
                        keyboard = new Scanner(System.in);
                        lastName = keyboard.nextLine();
                        c.setLast(lastName);
                    } else if (option == 3) {
                        System.out.println("Enter new address: ");
                        keyboard = new Scanner(System.in);
                        address = keyboard.nextLine();
                        c.setAddress(address);
                    } else if (option == 4) {
                        System.out.println("Enter new phone number: ");
                        keyboard = new Scanner(System.in);
                        Number = keyboard.nextLong();
                        c.setPhoneNumber(Number);
                    }
                    writeContacts(ab);

                    break;

                case 4:
                    System.out.println("Enter the name you'd wish to be deleted");
                    name = keyboard.nextLine();
                    index = ab.findContact(name);
                    if (index != -1) {
                        System.out.println("person found and is now deleted");
                        ab.deleteContact(c);
                    } else {
                        System.out.println("person not found");
                    }
                    writeContacts(ab);

                    break;

                case 5:
                    System.out.println(ab.getCurrent());
                    break;
                case 6:
                    System.out.print("Goodbye");
            }
        }
    }

    public static int menu() {
        int choice = 99;
        Scanner sc = new Scanner(System.in);
        System.out.println("\nWelcome to the Phonebook enter a operation you wish to perform.\n");
        System.out.println(" 1.Add Contact \n " +
                "2.Find Contact\n " +
                "3.Edit Contact\n " +
                "4.Delete Contact \n " +
                "5.Display Current Contact\n " +
                "6.Exit Program\n ");
        System.out.println("Enter Choice: ");
        try {
            choice = sc.nextInt();
            while (choice < 1 || choice > 6) {
                System.out.println("Please enter a valid menu choice: ");

                choice = sc.nextInt();
            }
        } catch (java.util.InputMismatchException e) {
            System.out.println("!!Non Integer entered!!");
            sc.nextLine();
            choice = 99;
        }
        System.out.println();
        return choice;
    }

    public static void writeContacts(AddressBook inAb) {

        String retVals = "";
        String info = "";
        for (Contact c : inAb.personContainer) {
            info = String.format("Name: %s %s\nAddress: %s\nPhone Number: %d\n\n",
                    c.firstName(), c.lastName(), c.Address(), c.phoneNumber());
            retVals += info;
        }

        try {

            FileWriter fw = new FileWriter("test.txt");
            BufferedWriter bw = new BufferedWriter(fw);

            bw.write(retVals);
            bw.close();
        } catch (Exception e) {
            System.out.printf("Exception caught: %s\n", e.toString());
        }
    }
}