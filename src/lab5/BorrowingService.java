package lab5;

public class BorrowingService implements BorrowingServiceAPI {
	private BorrowingService() {}
	
	private static class BorrowingServiceHelper {
		private static final BorrowingService INSTANCE = new BorrowingService();
	}
	
	public static BorrowingService getInstance() {
		return BorrowingServiceHelper.INSTANCE;
	}

	public BorrowingBookResult borrowBook(Member member, Book book) {
		if (member == null || book == null) {
			return new BorrowingBookResult(false, "Member or book do not exist");
		}

		if(member.getBorrowedBooks().contains(book)) {
			return new BorrowingBookResult(false, member.getName() + " already has this book");
		}
		if (!book.getIsAvailable()) {
			return new BorrowingBookResult(false, book.getTitle() + " is not available to be borrowed");
		}
		if(member.getBorrowedBooks().size() >= 3) {
			return new BorrowingBookResult(false, member.getName() + " already has 3 books. Cannot borrow anymore");
		}
		//success
		member.getBorrowedBooks().add(book);
		book.setIsAvailable(false);
		return new BorrowingBookResult(true, book.getTitle() + " borrowed successfully");
	}


	public BorrowingBookResult returnBook(Member member, Book book) {
		if (member == null || book == null) {
			return new BorrowingBookResult(false, "Member or book do not exist");
		}
		if(!member.getBorrowedBooks().contains(book)) {
			return new BorrowingBookResult(false, member.getName() + " does not have this book");
		}

		member.getBorrowedBooks().remove(book);
		book.setIsAvailable(true);
		return new BorrowingBookResult(true, book.getTitle() + " returned successfully");


	}
}