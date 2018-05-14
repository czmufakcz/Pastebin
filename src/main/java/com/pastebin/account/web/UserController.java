package com.pastebin.account.web;

import com.pastebin.account.model.User;
import com.pastebin.account.service.SecurityService;
import com.pastebin.account.service.UserService;
import com.pastebin.account.validator.UserValidator;

import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserController {
    private final UserService userService;
    private final SecurityService securityService;
    private final UserValidator userValidator;

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model) {
	model.addAttribute("userForm", new User());

	return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult, Model model) {
	userValidator.validate(userForm, bindingResult);

	if (bindingResult.hasErrors()) {
	    return "registration";
	}

	userService.save(userForm);

	securityService.autologin(userForm.getUsername(), userForm.getPasswordConfirm());

	return "redirect:/welcome";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, String error, String logout) {
	if (error != null)
	    model.addAttribute("error", "Your username and password is invalid.");

	if (logout != null)
	    model.addAttribute("message", "You have been logged out successfully.");

	return "login";
    }

    @RequestMapping(value = { "/", "/welcome" }, method = RequestMethod.GET)
    public String welcome(Model model) {
	return "welcome";
    }
}
