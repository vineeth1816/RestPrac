package com.cognizant;

import org.springframework.stereotype.Component;

@Component
public class TechnologyRepository {

	Technology[] techarr= {
		new Technology(1000,"java"),
		new Technology(2000,"javaScript"),
		new Technology(3000,"angular"),
		new Technology(4000,"react")
	};
	
	
	public Technology getTechnology(int id) {
		for(Technology e:techarr) {
			if(e.getId()==id) {
				return e;
			}
		}
		return null;
	}
}
