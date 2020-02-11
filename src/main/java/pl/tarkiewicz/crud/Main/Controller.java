package pl.tarkiewicz.crud.Main;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.tarkiewicz.crud.Author.AuthorDto;
import pl.tarkiewicz.crud.Author.AuthorRepo;

import java.util.List;

@RestController
public class Controller {
    private AuthorRepo authorRepo;

    @Autowired
    public Controller(AuthorRepo authorRepo) {
        this.authorRepo = authorRepo;
    }

    @GetMapping("/")
    public List<AuthorDto> get() {
        return authorRepo.getBookCategory();
    }

}
