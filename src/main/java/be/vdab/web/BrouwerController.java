package be.vdab.web;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import be.vdab.services.BrouwerService;

@Controller
@RequestMapping("/brouwers")
class BrouwerController {

	private static final String BROUWERS_VIEW = "brouwers/brouwers";
	private static final String BEGINNAAM_VIEW = "brouwers/beginnaam";
	private static final String TOEVOEGEN_VIEW = "brouwers/toevoegen";
	
	private static final String[] ALFABET = new String[] {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", 
			"M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
	
	private final BrouwerService brouwerService;
	
	@Autowired
	BrouwerController(BrouwerService brouwerService) {
		this.brouwerService = brouwerService;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	ModelAndView findAll() {
		return new ModelAndView(BROUWERS_VIEW, "brouwers", brouwerService.findAll());
	}
	
	@RequestMapping(path = "beginnaam", method = RequestMethod.GET)
	ModelAndView findByBeginnaam() {
		ModelAndView MAV = new ModelAndView(BEGINNAAM_VIEW);
		
		MAV.addObject("alfabet", Arrays.asList(ALFABET));
		
		return MAV;
	}
	
	@RequestMapping(path = "beginnaam/{eersteLetter}", method = RequestMethod.GET)
	ModelAndView findByBeginLetter(@PathVariable String eersteLetter) {
		ModelAndView MAV = new ModelAndView(BEGINNAAM_VIEW);
		
		MAV.addObject("alfabet", Arrays.asList(ALFABET));
		MAV.addObject("brouwers", brouwerService.findByEersteLetter(eersteLetter));
		
		return MAV;
	}
	
	@RequestMapping(path = "toevoegen", method = RequestMethod.GET)
	String toevoegen() {
		return TOEVOEGEN_VIEW;
	}
	
}
