/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dezyre.hackerday.neo4j.movielens.entity;

import java.io.Serializable;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;

/**
 *
 * @author michael.enudi
 */
@NodeEntity
public class User implements Serializable {

    @GraphId
    private Long Id;
    @Property
    private Long userId;
    @Property
    private String gender;
    @Property
    private Integer age;
    @Property
    private Integer occupation;
    @Property
    private String zipCode;
//    @Relationship(type = "GAVE", direction = Relationship.OUTGOING)
//    private List<Rating> ratings;

    public User() {
    }

    /**
     * @return the Id
     */
    public Long getId() {
        return Id;
    }

    /**
     * @param Id the Id to set
     */
    public void setId(Long Id) {
        this.Id = Id;
    }

    /**
     * @return the userId
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * @param userId the userId to set
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * @return the gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * @param gender the gender to set
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * @return the age
     */
    public Integer getAge() {
        return age;
    }

    /**
     * @param age the age to set
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    /**
     * @return the occupation
     */
    public Integer getOccupation() {
        return occupation;
    }

    /**
     * @param occupation the occupation to set
     */
    public void setOccupation(Integer occupation) {
        this.occupation = occupation;
    }

    /**
     * @return the zipCode
     */
    public String getZipCode() {
        return zipCode;
    }

    /**
     * @param zipCode the zipCode to set
     */
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

//    /**
//     * @return the ratings
//     */
//    public List<Rating> getRatings() {
//        return ratings;
//    }
    @Override
    public String toString() {
        return "User{" + "userId=" + getUserId() + ", gender=" + getGender() + ", age=" + getAge() + ", occupation=" + getOccupation() + ", zipCode=" + getZipCode() + '}';
    }

}
