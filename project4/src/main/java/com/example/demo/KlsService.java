package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KlsService {
    @Autowired
    private KlsRepository rep;

    public List<Sight> getSight(String zone){
        return rep.findByZone(zone);
    }

    public List<Sight> getAllSight(){
        return rep.findAll();
    }

    public Sight createSight(Sight s){
        Sight sight = new Sight();
        sight.setSightName(s.getSightName());
        sight.setZone(s.getZone());
        sight.setCategory(s.getCategory());
        sight.setPhotoURL(s.getPhotoURL());
        sight.setDes(s.getDes());
        sight.setAddress(s.getAddress());
        return rep.save(sight);
    }
}
