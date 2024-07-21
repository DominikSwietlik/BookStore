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
        if(!mockBookService.bookOnIdChecker(id)) {
            mockBookService.addBook(id, isbn, title, author, publisher, type);
            return "Book added  " + mockBookService.bookOnId(id).toString();
        }
        return "On this id already is book" + mockBookService.bookOnId(id);

    }
    @GetMapping("/{id}")
    public String getBook(@PathVariable long id) {
        if(mockBookService.bookOnIdChecker(id))
        {
        return mockBookService.bookOnId(id);
        }
        return "Book about id " + id + " hasn't existe";
    }
    @PutMapping("/{id}/{isbn}/{title}/{author}/{publisher}/{type}")
    public String changeBookOnId(@PathVariable  long id,
                          @PathVariable  String isbn,
                          @PathVariable  String title,
                          @PathVariable  String author,
                          @PathVariable  String publisher,
                          @PathVariable  String type) {
        if(mockBookService.bookOnIdChecker(id)) {
            mockBookService.addBook(id, isbn, title, author, publisher, type);
            return "Book changed  " + mockBookService.bookOnId(id).toString();
        }
        return "Book about id " + id + " hasn't existe";

    }

    @DeleteMapping("/{id}")
    public String deleteBood(@PathVariable int id)
    {
        if(mockBookService.bookOnIdChecker(id))
        {
            mockBookService.deleteBookOnId(id);
            return "Book about id   " + id + " has been deleted";
        }
            return "Book about id " + id + " hasn't existed";
    }


}