/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dezyre.hackerday.neo4j.movielens.api;

import com.dezyre.hackerday.neo4j.movielens.api.dao.ServiceDAO;
import com.dezyre.hackerday.neo4j.movielens.entity.Movie;
import com.dezyre.hackerday.neo4j.movielens.entity.Rating;
import com.dezyre.hackerday.neo4j.movielens.entity.Genre;
import com.dezyre.hackerday.neo4j.movielens.entity.repo.MovieRepo;
import com.dezyre.hackerday.neo4j.movielens.entity.repo.RatingRepo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.dezyre.hackerday.neo4j.movielens.entity.repo.GenreRepo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

/**
 *
 * @author michael.enudi
 */
@RestController
@RequestMapping("/service/movies")
public class MovieController {

    @Autowired
    private ServiceDAO serviceDAO;

    @Autowired
    private MovieRepo movieRepo;

    @Autowired
    private RatingRepo ratingRepo;

    @Autowired
    private GenreRepo genreRepo;

    public MovieController() {
    }

    @RequestMapping(method = RequestMethod.GET)
    public Page<Movie> getMovies(@RequestParam(name = "pageCount", required = false, defaultValue = "0") int pageCount,
            @RequestParam(name = "pageSize", required = false, defaultValue = "25") int pageSize) {
        Pageable pgbl = new PageRequest(pageCount, pageSize);
        return movieRepo.findAll(pgbl);
    }

    @RequestMapping(value = "/genres",method = RequestMethod.GET)
    public Page<Genre> getGenres(@RequestParam(name = "pageCount", required = false, defaultValue = "0") int pageCount,
            @RequestParam(name = "pageSize", required = false, defaultValue = "25") int pageSize) {
        Pageable pgbl = new PageRequest(pageCount, pageSize, new Sort(Sort.Direction.ASC, "name"));
        return genreRepo.findAll(pgbl);
    }

    @RequestMapping(value = "/{movieId}", method = RequestMethod.GET)
    public Movie getMovie(@PathVariable long movieId) {
        return movieRepo.findOne(movieId);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Movie createMovie(@RequestBody Movie movie) {
        return movieRepo.save(movie);
    }

    @RequestMapping(value = "/{movieId}", method = RequestMethod.PUT)
    public Movie updateMovie(@PathVariable long movieId, @RequestBody Movie movie) {
        return movieRepo.save(movie);
    }

    @RequestMapping(value = "/{movieId}/rate", method = RequestMethod.POST)
    public Rating rateMovie(@PathVariable long movieId, @RequestBody Rating rating) {
        return null;
    }

    @RequestMapping(value = "/{movieId}/alsowatched", method = RequestMethod.GET)
    public List<Movie> recommendOnMovie(@PathVariable long movieId) {
        return null;
    }
}
