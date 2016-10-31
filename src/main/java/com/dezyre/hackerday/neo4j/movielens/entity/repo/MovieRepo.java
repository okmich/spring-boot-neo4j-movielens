/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dezyre.hackerday.neo4j.movielens.entity.repo;

import com.dezyre.hackerday.neo4j.movielens.entity.Movie;
import java.util.List;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author michael.enudi
 */
@Repository
public interface MovieRepo extends GraphRepository<Movie> {

    Movie findByMovieId(long movieId);

    @Query("MATCH (x:Movie {movieId : {movieId}})<-[:TO]-(r)<-[:GIVE]-(u:User)\n"
            + "	WHERE r.rate > 4 \n"
            + "	WITH u as users\n"
            + "	MATCH (users)-[]-(r)-[:TO]-(m:Movie)\n"
            + "	WHERE r.rate > 4\n"
            + "	RETURN m")
    List<Movie> getMoviesByMovieId(@Param("movieId") Long movieId);
}
