package com.codingdojo.daikichiroutes.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/daikichi")
public class DaikichiController {

	@RequestMapping("")
	public String welcome() {
		return "Welcome!";
	}
	
    @RequestMapping(value="/today", method=RequestMethod.GET)
    public String today(){
      return "Today is moderate luck.";
    }
	@RequestMapping("/tomorrow")
	public String tomorrow() {
		return "Tomorrow is rain, bring an umbrella.";
	}

    @RequestMapping("/search")
    public String index(@RequestParam(value="q", required=false) String searchQuery) {
        return "You searched for: " + searchQuery;
    }

    @RequestMapping("/travel/{location}")
    public String travel(@PathVariable("location") String location){
    	return "Congratulations, you will soon be traveling to " + location + "!";
    }
    
    @RequestMapping("/lotto/{num}")
    public String lotto(@PathVariable("num") Integer num){
    	if (num%2 == 0) {
    		return "You will take a grand journey in the near future, but be weary of tempting offers.";
    	}
    	else {
    		return "You have enjoyed the fruits of your labor but now is a great time to spend time with family and friends.";
    	}
    }
}
