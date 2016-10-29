/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dezyre.hackerday.neo4j.movielens.api.dao;

import com.dezyre.hackerday.neo4j.movielens.entity.Movie;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.neo4j.template.Neo4jOperations;
import org.springframework.stereotype.Service;

/**
 *
 * @author michael.enudi
 */
@Service("serviceDAO")
public class ServiceDAOImpl implements ServiceDAO {

    @Autowired
    @Qualifier("neo4jTemplate")
    private Neo4jOperations neo4jTemplate;

    private final static String FIND_MOVIES_BY_MOVIE_ID = "";
    private final static String FIND_MOVIES_BY_USER_ID = "";

    public ServiceDAOImpl() {
    }

    @Override
    public List<Movie> getMoviesByMovieId(Long movieId) {
        Map<String, Object> parameters = new HashMap<>(1);
        parameters.put("movieId", 1);
        return neo4jTemplate.queryForObject(List.class, FIND_MOVIES_BY_MOVIE_ID, parameters);
    }

    @Override
    public List<Movie> getMoviesForUserId(Long userId) {
        Map<String, Object> parameters = new HashMap<>(1);
        parameters.put("userId", 1);
        return neo4jTemplate.queryForObject(List.class, FIND_MOVIES_BY_USER_ID, parameters);
    }
}