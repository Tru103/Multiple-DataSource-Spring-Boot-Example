package org.demo.multiple_datasources_example.controller;

import org.demo.multiple_datasources_example.repository.ExampleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 
 * @author Tuomas Törmä
 *
 */
@Controller
public class ExampleController {
	
	@Autowired
	private ExampleRepository repo;
	
	@RequestMapping("/primary")
	public @ResponseBody String returnPrimary(){
		return repo.getExampleTextFromPrimary();
	}
	
	@RequestMapping("/secondary")
	public @ResponseBody String returnSecondary(){
		return repo.getExampleTextFromSecondary();
	}

}