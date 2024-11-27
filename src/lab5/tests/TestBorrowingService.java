package lab5.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import lab5.Member;
import lab5.PaperBook;
import lab5.AudioBook;
import lab5.Book;
import lab5.Library;
import lab5.LibrarianController;
import lab5.BorrowingService;
import lab5.EBook;

public class TestBorrowingService {
	BorrowingService borrow;
	Member member1;
	Member member2;
	
	Book paperbook = new PaperBook("Dune");
	Book audiobook = new AudioBook("1984");
	Book ebook = new EBook("Charlotte's Web");

	@BeforeEach
	void setUp() throws Exception {
		borrow = new BorrowingService();
		member1 = new Member("Alice"); // flush borrowedBook array 
		member2 = new Member("Bob");   // flush borrowedBook array 
		paperbook.setIsAvailable(true);
		audiobook.setIsAvailable(false);
		ebook.setIsAvailable(true);
	}

	@Test
	public void testValidBorrow() {
		assertTrue(borrow.borrowBook(member1, paperbook).getIsSuccess());
	}

	@Test
	public void testBorrowUnavailable() {
		assertFalse(borrow.borrowBook(member1, audiobook).getIsSuccess());
	}

	@Test
	public void testBorrowAlreadyBorrowed() {
		borrow.borrowBook(member1, paperbook);
		assertFalse(borrow.borrowBook(member2, paperbook).getIsSuccess());
	}
	
	@Test
	public void testBorrowNullBook() {
		assertFalse(borrow.borrowBook(member1, null).getIsSuccess());
	}

	@Test
	public void testBorrowNullMember() {
		assertFalse(borrow.borrowBook(null, paperbook).getIsSuccess());
	}

	@Test
	public void testValidReturn() {
		borrow.borrowBook(member1, ebook);
		assertTrue(borrow.returnBook(member1, ebook).getIsSuccess());
	}

	@Test
	public void testReturnAlreadyReturned() {
		borrow.borrowBook(member1, ebook);
		borrow.returnBook(member1, ebook);
		assertFalse(borrow.returnBook(member1, ebook).getIsSuccess());
	}

	@Test
	public void testReturnUnborrowedBook() {
		assertFalse(borrow.returnBook(member1, ebook).getIsSuccess());
	}

	@Test
	public void testReturnNullBook() {
		assertFalse(borrow.returnBook(member1, null).getIsSuccess());
	}

	@Test
	public void testReturnNullMember() {
		assertFalse(borrow.returnBook(null, paperbook).getIsSuccess());
	}

}
