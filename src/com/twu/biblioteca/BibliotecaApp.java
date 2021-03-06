package com.twu.biblioteca;

import java.util.Scanner;

public class BibliotecaApp {

    static BangalorePublicLibrary bangalorePublicLibrary;

    public static void main(String[] args) {

        bangalorePublicLibrary = new BangalorePublicLibrary();

        Book book1 = new Book("Harry Potter and the Philosopher's Stone","J. K. Rowling", 2001);
        book1.setCheckout(true);
        Book book2 = new Book("Harry Potter and the Chamber of Secrets","J. K. Rowling", 2002);
        book2.setCheckout(false);
        Book book3 = new Book("Harry Potter and the Prisoner of Azkaban","J. K. Rowling", 2004);
        book3.setCheckout(true);

        bangalorePublicLibrary.setBooks(book1);
        bangalorePublicLibrary.setBooks(book2);
        bangalorePublicLibrary.setBooks(book3);

        WelcomeMessage();
        displayMainMenu();

    }

    private static void WelcomeMessage() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bangalore Public Library");
        System.out.println("Please, what your name? ");

        String customerName = scanner.nextLine();
        Client client = new Client(customerName);

        System.out.println("Welcome, " + client.getName());
    }

    private static void displayMainMenu() {
        Scanner input = new Scanner(System.in);

        String op;
        do {
            System.out.println("\n\n\n\t Bangalore Public Library Menu");
            System.out.println("--------------------------------------");
            System.out.println("1 - List Book");
            System.out.println("2 - Checkout Book");
            System.out.println("3 - Return Book");
            System.out.println("0 - Quit");
            System.out.print("\nSelect a Menu Option: ");
            op = input.next();
            getInput(op);
        }
        while(!op.equals("0"));
    }

    private static void getInput(String input) {
        switch(input) {
            case "1":
                bangalorePublicLibrary.listBooks();
                break;
            case "2":
                bangalorePublicLibrary.checkout();
                break;
            case "3":
                bangalorePublicLibrary.returnBook();
                break;
            case "0":
                System.out.print("Thank you, and come back soon!");
                break;
            default:
                System.out.print("Select a valid option!");
                break;
        }
    }
}
