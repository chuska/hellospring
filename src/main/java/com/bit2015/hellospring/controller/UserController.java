package com.bit2015.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.bit2015.hellospring.vo.MemberVo;

@Controller
@RequestMapping("/user")
public class UserController {
	@RequestMapping(value = "/joinform", method = RequestMethod.GET)
	public String joinform() {
		return "/WEB-INF/views/joinform.jsp";
	}

	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public ModelAndView join(@ModelAttribute MemberVo vo) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("vo", vo);
		//mav.addObject(vo); // vo 클래스 이름 단 앞에는 소문자로 대치 memberVo
		mav.setViewName("/WEB-INF/views/join.jsp");
		return mav;
	}

	/*
	 * @RequestMapping(value = "/join", method = RequestMethod.POST) public
	 * String join(@ModelAttribute MemberVo vo, Model model) {
	 * model.addAttribute("vo", vo); return "/WEB-INF/views/join.jsp"; }
	 */

	@ResponseBody
	@RequestMapping("/login")
	public String login(@RequestParam("email") String email,
			@RequestParam("pass") String password) {
		return "user login + " + email + ":" + password;
	}

	@ResponseBody
	@RequestMapping("/view")
	public String view(
			@RequestParam(value = "n", required = true, defaultValue = "-1") int no) {
		return "user view + " + no;
	}
}
