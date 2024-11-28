package lab5;

public class PaperBookFactory extends BookFactory{
	public PaperBook createBook(String title) {
		return new PaperBook(title);
	}
}
