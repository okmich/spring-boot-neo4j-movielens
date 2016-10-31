/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dezyre.hackerday.neo4j.movielens.entity.repo;

import com.dezyre.hackerday.neo4j.movielens.entity.Movie;
import com.dezyre.hackerday.neo4j.movielens.entity.User;
import java.util.List;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author michael.enudi
 */
@Repository
public interface UserRepo extends GraphRepository<User> {

    User findByUserId(long userId);

    @Query("MATCH (u:User {userId : {0}})-[:GIVE]->(r)-[:TO]->(m:Movie)<-[:TO]-(r2)-[]-(others:User)-[:GIVE]->(r3)-[:TO]->(m2:Movie)\n"
            + "WHERE r.rate >= 4 AND r2.rate >=4 AND r3.rate >= 4 AND u.gender = others.gender and u.age=others.age \n"
            + "WITH m2 AS movie, count(r3)  AS ratings\n"
            + "RETURN movie\n"
            + "ORDER BY ratings DESC\n"
            + "LIMIT 10")
    List<Movie> recommendByUserRatingHistory(long userId);

}