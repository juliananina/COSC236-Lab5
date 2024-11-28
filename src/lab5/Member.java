package lab5;

import java.util.ArrayList;
import java.util.Iterator;

public class Member {

	private String name;
	private ArrayList<Book> borrowedBooks; // Book class dependency
	private BorrowingServiceAPI borrowingService;

	public Member(String name, BorrowingServiceAPI borrowingService) {
		this.name = name;
		this.borrowedBooks = new ArrayList<>();
		this.borrowingService = borrowingService;
	}
	public BorrowingServiceAPI getBorrowingService() {
		return borrowingService;
	}
	public String getName() {
		return name;
	}
	public ArrayList<Book> getBorrowedBooks() { 
		return borrowedBooks;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String toString() {
		return "Member: " + name;
	}
	public void borrowBook(Book book) {
		BorrowingBookResult bbr = borrowingService.borrowBook(this, book);
		System.out.println("Success: " + bbr.getIsSuccess() + ": " + bbr.getBorrowingMessage()); 

	}
	public void returnBook(Book book) {
		BorrowingBookResult bbr = borrowingService.returnBook(this, book); 
		System.out.println("Success: " + bbr.getIsSuccess() + ": " + bbr.getBorrowingMessage());
	}
	public void listBorrowedBooks() {
		for (Book book : borrowedBooks)
			System.out.println(book); // book.toString()
	}
	public int borrowedBooksCount() {
		return borrowedBooks.size();
	}
	public void returnAllBooks() {
		Iterator<Book> bookIterator = borrowedBooks.iterator();
		while(bookIterator.hasNext()) {
			Book book = bookIterator.next();
			book.setIsAvailable(true);
		}
		borrowedBooks.clear(); // clear array of borrowed books
	}
}