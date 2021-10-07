package com.codingdojo.daikichiroutes.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@RequestMapping("/omikuji")
public class OmikujiController {
	
	@GetMapping("")
	public String index() {
		
		return "omikujihome.jsp";
	}
	
	
	@PostMapping("/process")
	public String processResponse(@RequestParam(value="numYears", required=false)Integer numYears, @RequestParam(value="city")String city, @RequestParam(value="person")String person, @RequestParam(value="activity")String activity, @RequestParam(value="livingthing")String livingthing, @RequestParam(value="compliment")String compliment, HttpSession session, RedirectAttributes redirectAttributes) {
		if (numYears == null) {
			redirectAttributes.addFlashAttribute("error","Please enter in information");
			return "redirect:/omikuji";
		}
		else {		
			session.setAttribute("numYears", numYears);
			session.setAttribute("city", city);
			session.setAttribute("person", person);
			session.setAttribute("activity", activity);
			session.setAttribute("livingthing", livingthing);
			session.setAttribute("compliment", compliment);
		
			return "redirect:/omikuji/show";
		}
	}
	
	@GetMapping("/show")
	public String showOmikuji(HttpSession session, Model model) {


		model.addAttribute("numYears", session.getAttribute("numYears"));
		model.addAttribute("city", session.getAttribute("city"));
		model.addAttribute("person", session.getAttribute("person"));
		model.addAttribute("activity", session.getAttribute("activity"));
		model.addAttribute("livingthing", session.getAttribute("livingthing"));
		model.addAttribute("compliment", session.getAttribute("compliment"));

		return "showomikuji.jsp";
	}
	
	
}
