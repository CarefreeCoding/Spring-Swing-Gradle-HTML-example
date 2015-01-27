package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/view")
public class ViewController
{
	@RequestMapping(value = "/helloWorld")
	public String printHello(ModelMap model)
	{
		model.addAttribute("message", "Hello World Test!");

		return "HelloWorld";
	}
}
