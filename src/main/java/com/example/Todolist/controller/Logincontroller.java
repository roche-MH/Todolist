"ackage com.example.Todolist.controller;



import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;



@Controller

public class Todolistcontroller {



	@GetMapping("/")

	public String Dolist(Model model) {

		return null;

	}

}


