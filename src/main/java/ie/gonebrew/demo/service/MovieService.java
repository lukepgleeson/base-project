package ie.gonebrew.demo.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ie.gonebrew.demo.persistence.entities.MovieEntity;
import ie.gonebrew.demo.persistence.repositories.MovieRepository;
import lombok.AllArgsConstructor;
import lombok.NonNull;

@Service
@AllArgsConstructor
public class MovieService {
    private MovieRepository movieRepository;

    public List<String> getAllMovies() {
        List<MovieEntity> moviesEntities = movieRepository.findAll();
        System.out.println("HERE  " + moviesEntities.stream().map(m -> m.getTitle()).toList().toString());
        return moviesEntities.stream().map(m -> m.getTitle()).toList();
    }

    public void createMovie(@NonNull MovieEntity movieEntity) {
        movieRepository.save(movieEntity);
    }

    @SuppressWarnings("null")
    public void createDummyMovies() {
        System.out.println("SAVING");
        movieRepository.saveAll(
                Arrays.asList(
                        new MovieEntity("Dune", "Sand Movie"),
                        new MovieEntity("Avengers", "Comic Book Movie"),
                        new MovieEntity("Prisoners", "Thriller"),
                        new MovieEntity("Borat", "Comedy Movie"),
                        new MovieEntity("Star Wars", "Space Movie")));
    }
}
