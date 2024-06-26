package book_junitTest.src.book_junitTest;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BookTest {

	private Book bookLibrary;
	
	@BeforeEach
	void setUp() throws Exception {
		bookLibrary = new Book();
	}

	// Test addBook()
	@Test
    public void testAddBook() {
        boolean result = bookLibrary.addBook(1, "Effective Java", "Joshua Bloch", 2008);
        assertTrue(result);
        System.out.println("test add book passed");
    }
	
	// Test searchBook()
    @Test
    public void testSearchBook() {
        bookLibrary.addBook(1, "Effective Java", "Joshua Bloch", 2008);
        String result = bookLibrary.searchBook("Effective Java");
        assertTrue(result.contains("Effective Java"));
        
        System.out.println("test search book passed");
    }
    @Test
    public void testSearchBookNotFound() {
        String result = bookLibrary.searchBook("Nonexistent Book");
        assertEquals("NO INFO", result);
        
        System.out.println("testSearchBookNotFound passed");
    }
    
    // Test removeBook()
    @Test
    public void testRemoveBook() {
        bookLibrary.addBook(1, "Effective Java", "Joshua Bloch", 2008);
        boolean result = bookLibrary.removeBook("Effective Java");
        assertTrue(result);
        
        System.out.println("testRemoveBook passed");
    }
    @Test
    public void testRemoveBookNotFound() {
    	boolean result = bookLibrary.removeBook("Nonexistent Book");
    	assertFalse(result);
        
        System.out.println("testRemoveBookNotFound passed");
    }
    
    // Test search_bs()
    @Test
    public void testSearchBookById() {
        bookLibrary.addBook(1, "Effective Java", "Murakami Haruki", 2011);
        bookLibrary.addBook(2, "Effective Python", "Don Mills", 2002);
        bookLibrary.addBook(3, "Effective C++", "Camil aloha", 2004);
        bookLibrary.addBook(4, "Effective Go", "Joshua Bloch", 2024);
        
        String result = bookLibrary.search_bs(3);
        assertTrue(result.contains("Effective C++"));
        
        System.out.println("testSearchBookById passed");
    }

    @Test
    public void testSearchBookByIdNotFound() {
        String result = bookLibrary.search_bs(5);
        assertEquals("NO INFO", result);
        
        System.out.println("testSearchBookByIdNotFound passed");
    }

    // Test searchBook()
    @Test
    public void testSearchBook() {
    	double  beforeTime = System.currentTimeMillis(); 
    	
        bookLibrary.addBook(1, "Effective Java", "Murakami Haruki", 2011);
        bookLibrary.addBook(2, "Effective Python", "Don Mills", 2002);
        bookLibrary.addBook(3, "Effective C++", "Camil aloha", 2004);
        bookLibrary.addBook(4, "Effective Go", "Joshua Bloch", 2024);
        
        String result = bookLibrary.searchBook("Effective Java");
        assertTrue(result.contains("Effective Java"));
        
        
        double  afterTime = System.currentTimeMillis(); // 코드 실행 후 시간

        double  secDiffTime = (afterTime - beforeTime)/1000000000; // 코드 실행 전후 시간 차이 계산

        System.out.println("시간차이(s) : " + secDiffTime);
        System.out.println("test search book performance passed");
    }
    
    // Test search_bs()
    @Test
    public void testSearchBookById() {
    	double beforeTime = System.currentTimeMillis(); 
    	
        bookLibrary.addBook(1, "Effective Java", "Murakami Haruki", 2011);
        bookLibrary.addBook(2, "Effective Python", "Don Mills", 2002);
        bookLibrary.addBook(3, "Effective C++", "Camil aloha", 2004);
        bookLibrary.addBook(4, "Effective Go", "Joshua Bloch", 2024);
        
        String result = bookLibrary.search_bs(3);
        assertTrue(result.contains("Effective C++"));
        
        double afterTime = System.currentTimeMillis(); // 코드 실행 후 시간

        double secDiffTime = (afterTime - beforeTime)/1000000000; // 코드 실행 전후 시간 차이 계산

        System.out.println("시간차이(s) : " + secDiffTime);
        System.out.println("test search book with BS performance passed");
    }

}
//jenkins test dk
