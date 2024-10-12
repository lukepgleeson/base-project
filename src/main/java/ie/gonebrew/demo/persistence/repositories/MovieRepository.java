package ie.gonebrew.demo.persistence.repositories;

import org.springframework.data.neo4j.repository.Neo4jRepository;

import ie.gonebrew.demo.persistence.entities.MovieEntity;

public interface MovieRepository extends Neo4jRepository<MovieEntity, String> {
}