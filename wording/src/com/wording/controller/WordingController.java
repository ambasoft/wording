package com.wording.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wording.service.WordingGenerator;

@Controller
public class WordingController {

	@Autowired
	private WordingGenerator wordingGenerator;

	@RequestMapping(value="/{number}",method=RequestMethod.GET)
	public @ResponseBody String sampleResponse(@PathVariable String number){
		
		return wordingGenerator.getWordingsForNumber(number);
	}
	
}
