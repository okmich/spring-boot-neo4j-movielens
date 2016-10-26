/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dezyre.hackerday.neo4j.movielens.entity.repo;

import com.dezyre.hackerday.neo4j.movielens.entity.User;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author michael.enudi
 */
@Repository
public interface UserRepo extends GraphRepository<User> {

}
