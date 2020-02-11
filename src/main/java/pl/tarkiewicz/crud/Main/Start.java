package pl.tarkiewicz.crud.Main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.tarkiewicz.crud.Author.Author;
import pl.tarkiewicz.crud.Author.AuthorRepo;
import pl.tarkiewicz.crud.Book.Book;
import pl.tarkiewicz.crud.Book.BookCategory;
import pl.tarkiewicz.crud.Book.BookRepo;

import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class Start {

    private BookRepo bookRepo;
    private AuthorRepo authorRepo;

    @Autowired
    public Start(BookRepo bookRepo, AuthorRepo authorRepo) {
        this.bookRepo = bookRepo;
        this.authorRepo = authorRepo;
    }

    @Autowired
    public void start() {
        Book book = new Book();
        book.setBookCategory(BookCategory.COMEDY);
        book.setTitle("Harry Potter i Czara ognia");
        book.setIsbn("123");

        Book book1 = new Book();
        book1.setBookCategory(BookCategory.HORROR);
        book1.setTitle("Harry Potter i Komnata tajemnic");
        book1.setIsbn("124");

        Book book2 = new Book();
        book2.setBookCategory(BookCategory.HORROR);
        book2.setTitle("Harry Potter Kamien filozoficzny");
        book2.setIsbn("125");

        Book book3 = new Book();
        book3.setBookCategory(BookCategory.THRILLER);
        book3.setTitle("Harry Potter i wiezien azkabanu");
        book3.setIsbn("126");

        Author author = new Author();
        author.setName("Maciek");
        author.setSurname("Tarkiewicz");

        author.setBookSet(Stream.of(book, book1, book2, book3).collect(Collectors.toSet()));

        bookRepo.save(book1);
        bookRepo.save(book2);
        bookRepo.save(book3);
        bookRepo.save(book);
        authorRepo.save(author);

    }


}