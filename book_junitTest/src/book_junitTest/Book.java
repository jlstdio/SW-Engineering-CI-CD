
package book_junitTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

// Book.java
public class Book {
    private List <IndiBook> bookList;

    public Book() {
        this.bookList = new ArrayList<>();
    }

    private class IndiBook {
        private String id;
        private String title;
        private String author;
        private int year;

        public IndiBook(String id, String title, String author, int year) {
            this.id = id;
            this.title = title;
            this.author = author;
            this.year = year;
        }
       
        public String getTitle() {
        	return this.title;
        }

        public String getInfo() {
        	return "IndiBook{" +
                    "id='" + this.id + '\'' +
                    ", title='" + this.title + '\'' +
                    ", author='" + this.author + '\'' +
                    ", year=" + this.year +
                    '}';
        }

    }
    
    // Manage Book
    // Add Book
    public boolean addBook(String id, String title, String author, int year) {
        IndiBook newBook = new IndiBook(id, title, author, year);
        bookList.add(newBook);
        Collections.sort(bookList, Comparator.comparing(IndiBook::getId)); // Sort by Id When add a book
        return true;
    }
    // Search Book
    public String searchBook(String title) {
        for (IndiBook book : bookList) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book.getInfo();
            }
        }
        return "NO INFO";
    }
    // Remove Book
    public boolean removeBook(String title) {
        for (IndiBook book : bookList) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                bookList.remove(book);
                return true;
            }
        }
        return false;
    }
    // Search Book by book's code (binary search)
    public String search_bs(String id) {
    	int low = 0; int mid = 0;
    	int high = bookList.size() - 1;
    	while(low<=high) {
    		int mid = (low+high) / 2;
    		IndiBook midbook = bookList.get(mid);
    		int cmp = midBook.getId().compareTo(id);
    		
    		if(cmp < 0) {
    			low = mid + 1;
    		}
    		else if (cmp > 0) {
    			high = mid - 1;
    		}
    		else {
    			return midBook.getInfo();
    		}
    	}
    	return "NO INFO";
    }
}
