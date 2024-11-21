package lab5;

public class BorrowingService implements BorrowingServiceAPI {

	@Override
	public boolean borrowBook(Member member, Book book) {
	    if (member == null || book == null) {
	        System.out.println("Member or book does not exist");
	        return false;
	    }

	    if (!book.getIsAvailable()) {
	        System.out.println("Book is not available to be borrowed: " + book.getTitle());
	        return false;
	    }

	    member.getBorrowedBooks().add(book);
	    book.setIsAvailable(false);
	    System.out.println("Borrowing book: " + book);
	    return true;
	}


	@Override
	public boolean returnBook(Member member, Book book) {
		if (member == null || book == null) {
	        System.out.println("Member or book does not exist");
	        return false;
	    }

	    member.getBorrowedBooks().remove(book);
	    book.setIsAvailable(true);
	    System.out.println("Returned: " + book);
	    return true;
		
		
	}
}
	