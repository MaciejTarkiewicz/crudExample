package pl.tarkiewicz.crud.Author;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface AuthorRepo extends JpaRepository<Author, Long> {


    @Query(value = "SELECT AUTHOR.NAME as name,  BOOK .BOOK_CATEGORY as bookCategory, COUNT(BOOK .BOOK_CATEGORY) as CountBookCategory\n" +
            "FROM AUTHOR JOIN BOOK ON AUTHOR.ID = BOOK.AUTHOR_ID\n" +
            "GROUP BY BOOK.BOOK_CATEGORY", nativeQuery = true)
    List<AuthorDto> getBookCategory();
}
