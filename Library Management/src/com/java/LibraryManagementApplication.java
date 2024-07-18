package com.java;

import java.util.*;

public class LibraryManagementApplication {

	public static void main(String[] args) {
		Implementation imp = new Implementation();
		Scanner s1 = new Scanner(System.in);

		while (true) {
			System.out.println("\nMenu:");
			System.out.println("1. Add New Book");
			System.out.println("2. View all Books");
			System.out.println("3. Show Author-wise Books");
			System.out.println("4. Search Books");
			System.out.println("5. Delete Book");
			System.out.println("6. Arrange Books by Price in Descending");
			System.out.println("7. Exit");
			System.out.print("Enter your choice: ");

			int choice = s1.nextInt();
			s1.nextLine();

			switch (choice) {

			case 1:
				System.out.println("Enter book details");

				System.out.print("ID: ");
				int id = s1.nextInt();
				s1.nextLine();

				System.out.print("Name: ");
				String name = s1.nextLine();

				System.out.print("Price: ");
				double price = s1.nextDouble();

				s1.nextLine();
				System.out.print("Author: ");
				String author = s1.nextLine();

				System.out.print("Publication: ");
				String publication = s1.nextLine();

				imp.addBook(new Data(id, name, price, author, publication));
				break;

			case 2:
				System.out.println("View all Books:");
				imp.viewAllBooks();
				break;

			case 3:
				System.out.print("Enter author name: ");
				String authorName = s1.nextLine();

				imp.showAuthorWiseBooks(authorName);
				break;

			case 4:
				System.out.print("Enter search keyword: ");
				String keyword = s1.nextLine();

				imp.searchBook(keyword);
				break;

			case 5:
				System.out.print("Enter book id, name, or publication to delete: ");
				String deleteKeyword = s1.nextLine();

				imp.deleteBook(deleteKeyword);
				break;

			case 6:
				System.out.println("Arrange Books by Price Descending:");
				imp.arrangeBooksByPriceDescending();
				break;

			case 7:
				System.out.println("Exiting...");
				System.exit(0);
			default:
				System.out.println("Invalid choice. Please enter a number between 1 and 7.");
			}
		}
	}
}