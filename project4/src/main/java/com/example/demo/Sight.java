package com.example.demo;

import org.springframework.data.mongodb.core.mapping.Document;
@Document(collection = "sight")
public class Sight{

    private String sightName;
    private String zone;
    private String category;
    private String photoURL;
    private String des;
    private String address;
    
    public Sight(){

    }

    public Sight(String sightName, String zone, String category, String photoURL, String description, String address){
        this.sightName = sightName;
        this.zone = zone;
        this.category = category;
        this.photoURL = photoURL;
        this.des = description;
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

    public void setDes(String input){
        des = input;
    }

    public String getDes(){
        return des;
    }

    public void setAddress(String input){
        address = input;
    }

    public String getAddress(){
        return address;
    }

    public String toString(){
        return "\nSightName: " + sightName + "\nZone: " + zone + "\nCatagory: " + category 
                + "\nphotoURL: \n" + photoURL + "\nDescription: " + des + "\nAddress: " + address;
    }

}