package be.vdab.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
	String findByBeginnaam() {
		return BEGINNAAM_VIEW;
	}
	
	@RequestMapping(path = "toevoegen", method = RequestMethod.GET)
	String toevoegen() {
		return TOEVOEGEN_VIEW;
	}
	
}
