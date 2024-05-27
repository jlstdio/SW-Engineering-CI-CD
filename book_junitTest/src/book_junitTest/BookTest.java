package book_junitTest;
// Test
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BookTest {

	private Book bookLibrary;
	
	@BeforeEach
	void setUp() throws Exception {
		bookLibrary = new Book();
	}


	@Test
    public void testAddBook() {
        boolean result = bookLibrary.addBook("1", "Effective Java", "Joshua Bloch", 2008);
        assertTrue(result);
        System.out.println("test add book passed");
    }

    @Test
    public void testSearchBook() {
        bookLibrary.addBook("1", "Effective Java", "Joshua Bloch", 2008);
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

    @Test
    public void testRemoveBook() {
        bookLibrary.addBook("1", "Effective Java", "Joshua Bloch", 2008);
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

}
