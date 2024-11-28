package lab5;

public class AudioBookFactory extends BookFactory {

	@Override
	public AudioBook createBook(String title) {
		// TODO Auto-generated method stub
		return new AudioBook(title);
	}

}
