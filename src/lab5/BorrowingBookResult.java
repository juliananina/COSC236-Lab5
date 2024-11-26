package lab5;

public class BorrowingBookResult {
	private boolean isSuccess;
	private String borrowingMessage;

	public BorrowingBookResult(boolean b, String s) {
		this.isSuccess = b;
		this.borrowingMessage = s;
	}
	public boolean getIsSuccess() {
		return isSuccess;
	}
	public String getBorrowingMessage() {
		return borrowingMessage;
	}
	public void setIsSuccess(boolean b) {
		this.isSuccess = b;
	}
	public void setBorrowingMessage(String s) {
		this.borrowingMessage = s;
	}
}