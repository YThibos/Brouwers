package be.vdab.web;

import java.util.Arrays;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import be.vdab.entities.Brouwer;
import be.vdab.services.BrouwerService;
import be.vdab.valueobjects.ZoekenOpNaam;

@Controller
@RequestMapping("/brouwers")
class BrouwerController {

	private static final String BROUWERS_VIEW = "brouwers/brouwers";
	private static final String BEGINNAAM_VIEW = "brouwers/beginnaam";
	private static final String TOEVOEGEN_VIEW = "brouwers/toevoegen";
	private static final String ZOEKEN_OP_NAAM_VIEW = "brouwers/zoekenopnaam";

	private final static String REDIRECT_NA_TOEVOEGEN = "redirect:/";

	private static final String[] ALFABET = new String[] { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L",
			"M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z" };

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

	// ----------- TOEVOEGEN ------------------
	@RequestMapping(path = "toevoegen", method = RequestMethod.GET)
	ModelAndView toevoegen() {
		return new ModelAndView(TOEVOEGEN_VIEW).addObject(new Brouwer());
	}

	@RequestMapping(method = RequestMethod.POST)
	String toevoegen(@Valid Brouwer brouwer, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return TOEVOEGEN_VIEW;
		}
		brouwerService.create(brouwer);
		return REDIRECT_NA_TOEVOEGEN;
	}

	@InitBinder("brouwer")
	void initBinderPostcodeReeks(WebDataBinder binder) {
		binder.initDirectFieldAccess();
	}

	@RequestMapping(path = "zoekenopnaam", method = RequestMethod.GET)
	ModelAndView zoekenOpNaam() {
		return new ModelAndView(ZOEKEN_OP_NAAM_VIEW).addObject(new ZoekenOpNaam());
	}

	@RequestMapping(method = RequestMethod.GET, params = "zoekstring")
	ModelAndView findByNaam(@Valid ZoekenOpNaam zoekenOpNaam, BindingResult bindResult) {
		ModelAndView mav = new ModelAndView(ZOEKEN_OP_NAAM_VIEW);
		if (!bindResult.hasErrors()) {
			mav.addObject("brouwers", brouwerService.findByEersteLetter(zoekenOpNaam.getZoekstring()));
		}
		return mav;
	}
}
