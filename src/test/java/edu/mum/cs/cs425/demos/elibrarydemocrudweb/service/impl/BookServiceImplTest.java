package edu.mum.cs.cs425.demos.elibrarydemocrudweb.service.impl;

import edu.mum.cs.cs425.demos.elibrarydemocrudweb.AbstractELibraryComponentTest;
import edu.mum.cs.cs425.demos.elibrarydemocrudweb.model.Book;
import edu.mum.cs.cs425.demos.elibrarydemocrudweb.service.BookService;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

@Transactional // Enables any database operations to rollback after each testing
public class BookServiceImplTest extends AbstractELibraryComponentTest {

    @Autowired
    private  BookService bookService;

    @Before
    public  void setUp() {
        logger.info("BookServiceImplTest started");
    }

    @After
    public void tearDown() {
        logger.info("BookServiceImplTest completed");
    }

    @Test
    public void testGetAllBooks() {
       List<Book> books = (List<Book>)bookService.getAllBooks();
        Assert.assertNotNull("Failure: expected books not to be null", books);
        Assert.assertEquals("Failure: expected size should be 3", 3, books.size());
        logger.info("Book list data: " + Arrays.toString(books.toArray()));
    }



//    @Autowired
//    private BookService bookService;
//
//    @Before
//    public void setUp() {
//        logger.info("BookServiceImplTest started");
//    }
//
//    @After
//    public void tearDown() {
//        logger.info("BookServiceImplTest completed");
//    }
//
//    @Test
//    public void testGetAllBooks() {
//        List<Book> books = (List<Book>)bookService.getAllBooks();
//        Assert.assertNotNull("Failure: expected books to be not null", books);
//        Assert.assertEquals("Failure: expected size", 6, books.size());
//        logger.info("Books list data: " + Arrays.toString(books.toArray()));
//    }
//
//    @Test
//    public void testGetBookById() {
//        Integer bookId = new Integer(1);
//        Book book = bookService.getBookById(bookId);
//        Assert.assertNotNull("Failure: expected book to be not null", book);
//        Assert.assertEquals("Failure: expected bookId to match", bookId, book.getBookId());
//        logger.info("Book data: " + book);
//    }
//
//    @Test
//    public void testGetBookByIdForInvalidId() {
//        Integer bookId = Integer.MAX_VALUE;
//        Book book = bookService.getBookById(bookId);
//        Assert.assertNull("Failure: expected null", book);
//        logger.info("Book data: " + book);
//    }
//
//    @Test
//    public void testSaveBook() {
//        Book newBook = new Book("978-0000000002", "New Book Title",
//                1.05, "Apress",
//                LocalDate.of(2011,9,13));
//        Book savedBook = bookService.saveBook(newBook);
//        Assert.assertNotNull("Failure: expected not null", savedBook);
//        Assert.assertNotNull("Failure: expected bookId to be not null", savedBook.getBookId());
//        Assert.assertEquals("Failure: expected book title match", "New Book Title", savedBook.getTitle());
//        List<Book> books = (List<Book>)bookService.getAllBooks();
//        Assert.assertEquals("Failure: expected size", 7, books.size());
//        logger.info("Books list data: " + Arrays.toString(books.toArray()));
//    }
//
//    @Test
//    public void testDeleteBookById() {
//		// TODO You try this
//    }
//
//    /* Execute unit-tests via maven on cmdline: mvn clean package */
//    /* Execute package only without unit-tests via maven on cmdline:
//    /* mvn clean package -DskipTests */
}
