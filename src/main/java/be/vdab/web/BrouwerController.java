package be.vdab.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/brouwers")
class BrouwerController {

	private static final String BROUWERS_VIEW = "brouwers/brouwers";
	private static final String BEGINNAAM_VIEW = "brouwers/beginnaam";
	private static final String TOEVOEGEN_VIEW = "brouwers/toevoegen";
	
	@RequestMapping(method = RequestMethod.GET)
	String findAll() {
		return BROUWERS_VIEW;
	}
	
	@RequestMapping(path = "beginnaam", method = RequestMethod.GET)
	String findByBeginnaam() {
		return BEGINNAAM_VIEW;
	}
	
	@RequestMapping(path = "toevoegen", method = RequestMethod.GET)
	String toevoegen() {
		return TOEVOEGEN_VIEW;
	}
	
}
