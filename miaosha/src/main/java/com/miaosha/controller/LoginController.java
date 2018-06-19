package com.miaosha.controller;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.miaosha.common.Result;
import com.miaosha.service.MiaoshaUserService;
import com.miaosha.vo.LoginVo;

@Controller
@RequestMapping("login")
public class LoginController {
	
	private static final Logger LOG = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	private MiaoshaUserService miaoshaUserService;
	
	@RequestMapping("toLogin")
	public String toLogin() {
		return "login";
	}
	
	@PostMapping("do_login")
	@ResponseBody
	public Result<Boolean> doLogin(@Valid LoginVo loginVo, HttpServletResponse response) {
		LOG.info(loginVo.toString());
		return miaoshaUserService.login(loginVo, response);
	}
	
}
