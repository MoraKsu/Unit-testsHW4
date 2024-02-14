package seminars.fourth.book;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class BookServiceTest {

    @Test
    public void testFindBookById() {
        BookRepository bookRepository = mock(BookRepository.class);
        BookService bookService = new BookService(bookRepository);

        Book expectedBook = new Book("1", "Book1", "Author1");

        when(bookRepository.findById("1")).thenReturn(expectedBook);

        Book actualBook = bookService.findBookById("1");

        verify(bookRepository).findById("1");

        assertEquals(expectedBook, actualBook);
    }

    @Test
    public void testFindAllBooks() {
        BookRepository bookRepository = mock(BookRepository.class);
        BookService bookService = new BookService(bookRepository);

        List<Book> expectedBooks = new ArrayList<>();
        expectedBooks.add(new Book("1", "Book1", "Author1"));
        expectedBooks.add(new Book("2", "Book2", "Author2"));

        when(bookRepository.findAll()).thenReturn(expectedBooks);

        List<Book> actualBooks = bookService.findAllBooks();

        verify(bookRepository).findAll();

        assertEquals(expectedBooks, actualBooks);
    }
}
