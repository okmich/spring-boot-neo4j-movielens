/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dezyre.hackerday.neo4j.movielens.api.dao;

import com.dezyre.hackerday.neo4j.movielens.entity.Movie;
import java.util.List;

/**
 *
 * @author michael.enudi
 */
public interface ServiceDAO {

    public List<Movie> getMoviesByMovieId(Long movieId);

    public List<Movie> getMoviesForUserId(Long userId);

}
