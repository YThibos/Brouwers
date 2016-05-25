package be.vdab.web;

import java.time.LocalTime;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class IndexController {

	private static final String VIEW = "index";
	
	public static final String GROET_KEY = "groet";
	
	@RequestMapping(method = RequestMethod.GET)
	ModelAndView index() {
		
		ModelAndView mav = new ModelAndView(VIEW);
		
		int hourOfDay = LocalTime.now().getHour();
		
		if (hourOfDay >= 0 && hourOfDay < 6) {
			mav.addObject(GROET_KEY, "goedeNacht");
		}
		else if (hourOfDay >= 6 && hourOfDay < 12) {
			mav.addObject(GROET_KEY, "goedeMorgen");
		}
		else if (hourOfDay >= 12 && hourOfDay < 18) {
			mav.addObject(GROET_KEY, "goedeMiddag");
		}
		else {
			mav.addObject(GROET_KEY, "goedeAvond");
		}
		
		return mav;
	}
}
	
