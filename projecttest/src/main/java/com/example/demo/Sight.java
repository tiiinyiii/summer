package com.example.demo;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class Sight{

    private String sightName;
    private String zone;
    private String category;
    private String photoURL;
    private String description;
    private String address;
    
    public Sight(){

    }

    public Sight(String sightName, String zone, String category, String photoURL, String description, String address){
        this.sightName = sightName;
        this.zone = zone;
        this.category = category;
        this.photoURL = photoURL;
        this.description = description;
        this.address = address;
    }

    public void setSightName(String input){
        sightName = input;
    }

    public String getSightName(){
        return sightName;
    }
    public void setZone(String input){
        zone = input;
    }
    public String getZone(){
        return zone;
    }
    public void setCategory(String input){
        category = input;
    }

    public String getCategory(){
        return category;
    }

    public void setPhotoURL(String input){
        photoURL = input;
    }

    public String getPhotoURL(){
        return photoURL;
    }

    public void setes(String input){
        description = input;
    }

    public String getDes(){
        return description;
    }

    public void setAddress(String input){
        address = input;
    }

    public String getAddress(){
        return address;
    }

    public String toString(){
        return "\nSightName: " + sightName + "\nZone: " + zone + "\nCatagory: " + category 
                + "\nphotoURL: \n" + photoURL + "\nDescription: " + description + "\nAddress: " + address;
    }

}