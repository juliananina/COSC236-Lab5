package lab5;

public class BorrowingService implements BorrowingServiceAPI {

	@Override
	public boolean borrowBook(Member member, Book book) {
	    if (member == null || book == null) {
	        System.out.println("Member or book does not exist");
	        return false;
	    }
	   
	    if(member.getBorrowedBooks().contains(book)) {
			 System.out.println("Member already has this book");
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
		 if(!member.getBorrowedBooks().contains(book)) {
			 System.out.println("Member does not have this book");
			 return false;
		 }

	    member.getBorrowedBooks().remove(book);
	    book.setIsAvailable(true);
	    System.out.println("Returning book: " + book);
	    return true;
		
		
	}
}
