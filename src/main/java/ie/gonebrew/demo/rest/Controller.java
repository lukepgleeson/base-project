package ie.gonebrew.demo.rest;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import ie.gonebrew.demo.service.MovieService;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class Controller {

    private MovieService movieService;

    @GetMapping("/root")
    public String getRoot() {
        return "Hello World!";
    }

    @GetMapping("/movies")
    public ResponseEntity<List<String>> getMovies() {
        return ResponseEntity.ok(movieService.getAllMovies());
    }

    @GetMapping("/movies/createdummy")
    public ResponseEntity<List<String>> createDummyMovies() {
        movieService.createDummyMovies();
        return ResponseEntity.ok(movieService.getAllMovies());
    }

}
