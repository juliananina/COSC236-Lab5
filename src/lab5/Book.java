package lab5;

<<<<<<< Updated upstream
<<<<<<<< Updated upstream:src/lab5/Book.java
public class Book {
========
public class PaperBook implements Book {
>>>>>>>> Stashed changes:src/lab5/PaperBook.java
	
	private String title;
	private boolean isAvailable;
	
	public Book(String title) {
		this.title = title;
		this.isAvailable = true;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String toString() {
		return "Book: " + title;
	}
	public void setIsAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
	public boolean getIsAvailable() {
		return isAvailable;
	}
=======
public interface Book {
	public String getTitle();
	public void setIsAvailable(boolean isAvailable);
	public boolean getIsAvailable();
	public String toString();
>>>>>>> Stashed changes
}