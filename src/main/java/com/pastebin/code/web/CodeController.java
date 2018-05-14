package com.pastebin.code.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pastebin.account.model.User;
import com.pastebin.account.service.UserService;
import com.pastebin.code.model.Code;
import com.pastebin.code.service.CodeService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CodeController {
    private final CodeService codeService;
    private final UserService userService;

    @RequestMapping(value = { "/", "/welcome" }, method = RequestMethod.GET)
    public String welcome(Model model) {
	model.addAttribute("codeForm", new Code());
	return "welcome";
    }

    @RequestMapping(value = { "/", "/welcome" }, method = RequestMethod.POST)
    public String registration(@ModelAttribute("codeForm") Code codeForm, BindingResult bindingResult, Model model) {
	// userValidator.validate(userForm, bindingResult);

	if (bindingResult.hasErrors()) {
	    return "registration";
	}
	User user = userService.findByUsername(SecurityContextHolder.getContext()
								    .getAuthentication()
								    .getName());
	codeForm.setUser(user);
	codeService.save(codeForm);

	return "welcome";
    }

}
