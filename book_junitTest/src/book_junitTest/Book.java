package book_junitTest;

import java.util.ArrayList;
import java.util.List;
//juyeon/first commit
// Book.java
public class Book {
    private List<IndiBook> bookList;

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

    public boolean addBook(String id, String title, String author, int year) {
        IndiBook newBook = new IndiBook(id, title, author, year);
        bookList.add(newBook);
        
        return true;
    }

    public String searchBook(String title) {
        for (IndiBook book : bookList) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book.getInfo();
            }
        }
        return "NO INFO";
    }

    public boolean removeBook(String title) {
        for (IndiBook book : bookList) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                bookList.remove(book);
                return true;
            }
        }
        return false;
    }

}
