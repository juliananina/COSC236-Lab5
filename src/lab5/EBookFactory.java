package lab5;

public class EBookFactory extends BookFactory {

	@Override
	public EBook createBook(String title) {
		// DONE Auto-generated method stub
	 EBook ebook = new EBook(title);
	 return ebook;
	}

}
