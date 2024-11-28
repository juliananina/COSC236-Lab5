package lab5.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import lab5.PaperBookFactory;
import lab5.AudioBook;
import lab5.AudioBookFactory;
import lab5.Book;
import lab5.EBook;
import lab5.EBookFactory;
import lab5.PaperBook;

public class TestBookFactory {
	@Test
	public void createCorrect() {
		PaperBookFactory paperbookFactory = new PaperBookFactory();
		AudioBookFactory audiobookFactory = new AudioBookFactory();
		EBookFactory ebookFactory = new EBookFactory();
		
		Book p = paperbookFactory.createBook("title1");
		Book a = audiobookFactory.createBook("title1");
		Book e = ebookFactory.createBook("title1");
		
		assertTrue(p instanceof PaperBook);
		assertTrue(a instanceof AudioBook);
		assertTrue(e instanceof EBook);
	}

	@Test
	public void createIncorrect() {
		PaperBookFactory paperbookFactory = new PaperBookFactory();
		AudioBookFactory audiobookFactory = new AudioBookFactory();
		EBookFactory ebookFactory = new EBookFactory();
		
		Book p = paperbookFactory.createBook("title1");
		Book a = audiobookFactory.createBook("title1");
		Book e = ebookFactory.createBook("title1");
		
		assertFalse(p instanceof AudioBook);
		assertFalse(a instanceof EBook);
		assertFalse(e instanceof PaperBook);
	}
}
