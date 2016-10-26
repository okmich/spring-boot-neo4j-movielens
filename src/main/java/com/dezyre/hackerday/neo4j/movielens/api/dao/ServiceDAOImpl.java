/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dezyre.hackerday.neo4j.movielens.api.dao;

import com.dezyre.hackerday.neo4j.movielens.entity.Movie;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author michael.enudi
 */
@Service("serviceDAO")
public class ServiceDAOImpl implements ServiceDAO {

//    @Autowired
//    private Neo4jTemplate neo4jTemplate;

    public ServiceDAOImpl() {
    }

    @Override
    public List<Movie> getMoviesByMovieId(Long movieId) {
        return null;
    }

    @Override
    public List<Movie> getMoviesForUserId(Long userId) {
        return null;
    }

}
