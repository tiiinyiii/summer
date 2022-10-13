package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
@Service
public class KlsController {

    @Autowired
    private  KlsService serve;

    @GetMapping("/SightAPI/{Zone}")
    public ResponseEntity<List<Sight>> getSight (@PathVariable("Zone") String zone){
        List<Sight> item = serve.getSight(zone);
        return ResponseEntity.ok(item);
    }

    @GetMapping("/SightAPI")
    public List<Sight> getSights(){
        return serve.getAllSight();
    }

    @PostMapping("/add")
    public Sight saveSight (@RequestBody Sight s){
        return serve.createSight(s);
    }
}



