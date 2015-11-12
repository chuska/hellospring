package com.bit2015.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/board")
public class BoardController {
	@ResponseBody
	@RequestMapping("/view/{no}")
	public String view(@PathVariable("no") int no) {
		return "board view : " + no;
	}
}
