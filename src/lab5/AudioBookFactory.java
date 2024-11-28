package lab5;

public class AudioBookFactory extends BookFactory {

	@Override
	Book createBook(String title) {
		// TODO Auto-generated method stub
		return new AudioBook(title);
	}

}
