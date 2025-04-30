package com.example.demo.schedular;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.example.demo.cache.StudentCache;

@Component
@EnableScheduling
public class CacheSchedular {

	@Autowired
	StudentCache cache;

	@Scheduled(fixedDelay = 10000)
	public void execute() {
		cache.clear();
		cache.fetchAll();
	}

}
