package app.domain;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class MockBookService {
    List<Book> books = new ArrayList<Book>();
    long recordId = 1;

    public List<Book> returnBooks(){

        return new ArrayList<>(books);
    }

    public String bookOnId(long id){
        return books.get((int) id).toString();
    }

    void changeBookOnId(int id,  String isbn,
    String title,
    String author,
    String publisher,
    String type){
        books.get(id).setIsbn(isbn);
        books.get(id).setTitle(title);
        books.get(id).setAuthor(author);
        books.get(id).setPublisher(publisher);
        books.get(id).setType(type);
    }
    public void deleteBookOnId(int id){
        books.remove(id);
    }

    public void addBook(long id, String isbn,
                        String title,
                        String author,
                        String publisher,
                        String type){
        Book book = new Book();
        book.setId(id);
        book.setIsbn(isbn);
        book.setTitle(title);
        book.setAuthor(author);
        book.setPublisher(publisher);
        book.setType(type);
        books.add(book);

    }
}
