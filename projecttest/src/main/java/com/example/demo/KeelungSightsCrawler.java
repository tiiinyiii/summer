package com.example.demo;

import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.jsoup.nodes.Element;


public class KeelungSightsCrawler{
    
    ArrayList<Sight> sights = new ArrayList<>();
    ArrayList<Sight> ans =  new ArrayList<>();
    int n = 0;
    public KeelungSightsCrawler(){

        try{
            String head = "https://www.travelking.com.tw";
            Document document = Jsoup.connect("https://www.travelking.com.tw/tourguide/taiwan/keelungcity/").get();
            Element p = document.getElementById("guide-point");
            Elements items = p.getElementsByTag("li");
            for(Element item : items){
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

        }catch(Exception e){
            System.out.println("QQ");
        }
    }

    public Sight[] getItems(String z){
        for(Sight sight : sights){
            if(sight.getZone().equals( z + "區")){
                ans.add(sight) ;
            }
        }
        return ans.toArray(new Sight[0]);
    }
}