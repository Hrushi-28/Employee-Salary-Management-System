package com.java;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class Implementation {

	private Stack<Data> books = new Stack<>();

	public void addBook(Data data) {
//    	System.out.println("Data:"+data);
		books.push(data);
		System.out.println("Book added!!!");
	}

	public void viewAllBooks() {
		Stack<Data> reversedStack = new Stack<>();
		reversedStack.addAll(books);

		while (!reversedStack.isEmpty()) {
			Data book = reversedStack.pop();
			System.out.println("Id: " + book.getId() + "\t Author: " + book.getAuthor() + "\t Name: " + book.getName()
					+ "\t Publication: " + book.getPublication() + "\t Price: " + book.getPrice());
		}
	}

	public void showAuthorWiseBooks(String author) {
		List<Data> authorBooks = getAuthorBooks(author);
		if (authorBooks != null) {
			for (Data book : authorBooks) {
				System.out.println("Id: " + book.getId() + "\t Author: " + book.getAuthor() + "\t Name: "
						+ book.getName() + "\t Publication: " + book.getPublication() + "\t Price: " + book.getPrice());
			}
		} else {
			System.out.println("No books found for author: " + author);
		}
	}

	private List<Data> getAuthorBooks(String author) {
		List<Data> authorBooks = new ArrayList<>();
		for (Data book : books) {
			if (book.getAuthor().equalsIgnoreCase(author)) {
				authorBooks.add(book);
			}
		}
		return authorBooks.isEmpty() ? null : authorBooks;
	}

	public void searchBook(String keyword) {
		List<Data> result = new ArrayList<>();
		for (Data book : books) {
			if (isEqualIgnoreCase(book.getAuthor(), keyword) || isEqualIgnoreCase(book.getName(), keyword)
					|| isEqualIgnoreCase(book.getPublication(), keyword)
					|| isEqualIgnoreCase(String.valueOf(book.getPrice()), keyword)) {
				result.add(book);
			}
		}
		if (!result.isEmpty()) {
			System.out.println("Book found!!!");
			for (Data book : result) {
				System.out.println("Id: " + book.getId() + "\t Author: " + book.getAuthor() + "\t Name: "
						+ book.getName() + "\t Publication: " + book.getPublication() + "\t Price: " + book.getPrice());
			}
		} else {
			System.out.println("No books found matching the search criteria: " + keyword);
		}
	}

	private boolean isEqualIgnoreCase(String str1, String str2) {
		return str1.equalsIgnoreCase(str2);
	}

	public void deleteBook(String keyword) {
		Iterator<Data> iterator = books.iterator();
		while (iterator.hasNext()) {
			Data book = iterator.next();
			if (String.valueOf(book.getId()).equalsIgnoreCase(keyword) || book.getName().equalsIgnoreCase(keyword)
					|| book.getPublication().equalsIgnoreCase(keyword)) {
				iterator.remove();
			}
		}
		System.out.println("Deletion success!!!");
	}

	public void arrangeBooksByPriceDescending() {
		List<Data> sortedBooks = new ArrayList<>(books);
		sortedBooks.sort(Comparator.comparingDouble(Data::getPrice).reversed());
		for (Data book : sortedBooks) {
			System.out.println(book);
		}
	}

}
