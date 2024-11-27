package lab5.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import lab5.BorrowingService;

public class TestSingleton {

	@Test
	void TestSingletons() {
		BorrowingService service1 = BorrowingService.getInstance();
		BorrowingService service2 = BorrowingService.getInstance();
		assertEquals(service1, service2,"Two Singleton instances detected"); 
	}
}
