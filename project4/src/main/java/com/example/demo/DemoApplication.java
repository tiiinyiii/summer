package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {

		ConfigurableApplicationContext applicationContext = SpringApplication.run(DemoApplication.class,args);
		applicationContext.start();
	}

	@Component
	public class ContextStartedListener implements ApplicationListener<ContextStartedEvent>{

		@Autowired
 		private KlsRepository rep;

		@Override
		public void onApplicationEvent(ContextStartedEvent event){
			ArrayList<Sight> sights;
			KeelungSightsCrawler crawler = new KeelungSightsCrawler();
			sights = crawler.getAll();
			for (Sight s : sights) {
				rep.save(s);
			}
		}
	}
}
