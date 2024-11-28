package lab5;

public class EBookFactory extends BookFactory {

	@Override
	Book createBook(String title) {
		// DONE Auto-generated method stub
	 Book ebook = new EBook(title);
	 return ebook;
	}

}
