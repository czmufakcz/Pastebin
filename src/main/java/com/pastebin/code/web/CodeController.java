package com.pastebin.code.web;

import java.util.List;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.pastebin.account.model.User;
import com.pastebin.account.service.UserService;
import com.pastebin.code.model.Code;
import com.pastebin.code.service.CodeService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class CodeController {
    private final CodeService codeService;
    private final UserService userService;

    @RequestMapping(value = { "/", "/welcome" }, method = RequestMethod.GET)
    public String welcome(Model model) {

	User user = userService.findByUsername(SecurityContextHolder.getContext()
								    .getAuthentication()
								    .getName());
	List<Code> list = codeService.getCodes(user);
	model.addAttribute("codes", list);

	Code selectedCode = null;
	model.addAttribute("selectedCode", selectedCode);

	return "welcome";
    }

    @RequestMapping(value = "/createCode", method = RequestMethod.GET)
    public String showCreateCode(Model model) {
	model.addAttribute("codeForm", new Code());
	return "createCode";
    }

    @RequestMapping(value = "/createCode", method = RequestMethod.POST)
    public String createPost(@ModelAttribute("codeForm") Code codeForm, BindingResult bindingResult, Model model) {
	// userValidator.validate(userForm, bindingResult);

	if (bindingResult.hasErrors()) {
	    return "registration";
	}

	User user = userService.findByUsername(SecurityContextHolder.getContext()
								    .getAuthentication()
								    .getName());
	codeForm.setUser(user);
	codeService.save(codeForm);

	return "redirect:welcome";
    }

    @RequestMapping(value = "/removeCode", method = RequestMethod.POST)
    public String removeCode(@RequestParam("codeID") int codeID) {
	codeService.delete(codeID);
	return "redirect:/welcome";
    }

    @RequestMapping(value = "/updateCode", method = RequestMethod.POST)
    public String updateCode(@ModelAttribute("selectedCode") Code selectedCode, Model model) {

	Code code = codeService.findById(selectedCode.getId())
			       .get();

	code.setTitle(selectedCode.getTitle());
	code.setCode(selectedCode.getCode());

	codeService.save(code);
	model.addAttribute("selectedCode", code);
	return "redirect:/welcome";
    }

    @RequestMapping(value = "/welcome/{id}", method = RequestMethod.GET)
    public String selectCode(@PathVariable("id") int id, Model model) {
	User user = userService.findByUsername(SecurityContextHolder.getContext()
								    .getAuthentication()
								    .getName());
	List<Code> list = codeService.getCodes(user);
	model.addAttribute("codes", list);
	Code selectedCode = codeService.findById(id)
				       .get();
	model.addAttribute("selectedCode", selectedCode);
	return "/welcome";
    }

}
