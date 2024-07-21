package app.controller;

import app.domain.Book;
import app.domain.MockBookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    MockBookService mockBookService = new MockBookService();
    @GetMapping("/helloBook")
    public Book helloBook() {
        return new Book(1L, "9788324631766", "Thinking in Java",
                "Bruce Eckel", "Helion", "programming");
    }
    @GetMapping()
    public List<Book> getAllBooks() {
        return mockBookService.returnBooks();
    }

    @PostMapping("/{id}/{isbn}/{title}/{author}/{publisher}/{type}")
    public String addBook(@PathVariable  long id,
                        @PathVariable  String isbn,
                        @PathVariable  String title,
                        @PathVariable  String author,
                        @PathVariable  String publisher,
                        @PathVariable  String type) {
        mockBookService.addBook(id, isbn, title, author, publisher, type);
        return "Book added  " + mockBookService.bookOnId(id).toString();
    }
    @GetMapping("/{id}")
    public String getBook(@PathVariable long id) {
        return mockBookService.bookOnId(id);
    }
    @PutMapping("/{id}/{isbn}/{title}/{author}/{publisher}/{type}")
    public String changeBookOnId(@PathVariable  long id,
                          @PathVariable  String isbn,
                          @PathVariable  String title,
                          @PathVariable  String author,
                          @PathVariable  String publisher,
                          @PathVariable  String type) {
        mockBookService.addBook(id, isbn, title, author, publisher, type);
        return "Book canged  " + mockBookService.bookOnId(id).toString();
    }

    @DeleteMapping("/{id}")
    public String deleteBood(@PathVariable int id)
    {

        mockBookService.deleteBookOnId(id);
        return "Book about id   " + id + " has been deleted";
    }


}