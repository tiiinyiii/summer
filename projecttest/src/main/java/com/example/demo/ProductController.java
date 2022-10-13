package com.example.demo;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.stream.Collectors;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class ProductController {
    ArrayList<Sight> sights = new ArrayList<>();
    @PostConstruct
    private void initDB() {
        try {
            String head = "https://www.travelking.com.tw";
            Document document = Jsoup.connect("https://www.travelking.com.tw/tourguide/taiwan/keelungcity/").get();
            Element p = document.getElementById("guide-point");
            Elements items = p.getElementsByTag("li");
            for (Element item : items) {
                String href = item.getElementsByTag("a").attr("href");

                Document sight = Jsoup.connect(head + href).get();
                Element c = sight.getElementById("content");
                c.select("[class=author]").remove();
                c.select("[class=othermsg2]").remove();

                String zone = c.getElementsByClass("bc_last").text();
                String name = c.getElementsByClass("h1").text();
                String category = c.getElementsByClass("point_type").get(0).getElementsByTag("strong").get(0).text();

                Element a = c.getElementById("point_area");
                String url = null;
                url = a.getElementsByTag("meta").get(2).attr("content");

                String description = c.getElementsByClass("text").first().text();
                String address = c.getElementsByClass("address").get(0).getElementsByTag("p").get(0).text();

                Sight s = new Sight(name, zone, category, url, description, address);
                sights.add(s);
            }

        } catch (Exception e) {
            System.out.println("QQ");
        }
    }

    @GetMapping("/SightAPI")
    public ResponseEntity<ArrayList<Sight>> getSight (
            @RequestParam(value = "zone", defaultValue = "") String zone){
        ArrayList<Sight> products = (ArrayList<Sight>) sights.stream()
                .filter(p -> p.getZone().toUpperCase().contains(zone))
                .collect(Collectors.toList());

        return ResponseEntity.ok().body(products);

    }
}



