package edu.mum.cs.cs425.demos.elibrarydemocrudweb.controller;

import edu.mum.cs.cs425.demos.elibrarydemocrudweb.model.Book;
import edu.mum.cs.cs425.demos.elibrarydemocrudweb.service.BookService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.collection.IsIterableWithSize.iterableWithSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = BookController.class)
public class BookControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BookService bookService;

    @Before
    public void setUp() {
        List<Book> books = Arrays.asList(new Book(1, "978-00001", "New Book Title", 1.05,
                "Apress", LocalDate.of(2011, 9, 13))
        ,
                new Book(2, "978-00002", "Second Book Title", 1.08,
                        "Apress Engine", LocalDate.of(2014, 9, 13) ));
        Mockito.when(bookService.getAllBooks()).thenReturn(books);
    }

    @Test
    public void testListBooks() throws Exception {
        mockMvc.perform(get("/elibrary/book/list"))
                .andExpect(status().isOk())
                .andExpect(view().name("book/list"))
                .andExpect(model().attributeExists("books"))
                .andExpect(model().attribute("books", iterableWithSize(2)));
    }



}
