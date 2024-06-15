package book_junitTest.src.book_junitTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

// Book.java
public class Book {
    private List<IndiBook> bookList;

    public Book() {
        this.bookList = new ArrayList<>();
    }

    public class IndiBook {
        private int id;
        private String title;
        private String author;
        private int year;

        public IndiBook(int id, String title, String author, int year) {
            this.id = id;
            this.title = title;
            this.author = author;
            this.year = year;
        }

        public String getTitle() {
            return this.title;
        }

        public int getId() {
            return this.id;
        }

        public String getInfo() {
            return "IndiBook{" +
                    "id=" + this.id +
                    ", title='" + this.title + '\'' +
                    ", author='" + this.author + '\'' +
                    ", year=" + this.year +
                    '}';
        }
    }//test

    // Manage Book
    // Add Book
    public boolean addBook(int id, String title, String author, int year) {
        IndiBook newBook = new IndiBook(id, title, author, year);
        bookList.add(newBook);
        // sort when add book
        Collections.sort(bookList, new Comparator<IndiBook>() {
            @Override
            public int compare(IndiBook book1, IndiBook book2) {
                return Integer.compare(book1.getId(), book2.getId());
            }
        });
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

    // Search Book by book id 
    public String search_bs(int id) {
        int low = 0;
        int high = bookList.size() - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            IndiBook midBook = bookList.get(mid);
            int cmp = Integer.compare(midBook.getId(), id);

            if (cmp < 0) {
                low = mid + 1;
            } else if (cmp > 0) {
                high = mid - 1;
            } else {
                return midBook.getInfo();
            }
        }
        return "NO INFO";
    }
}
