package com.example.demo.controller;

import javax.servlet.http.HttpServletRequest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.demo.dao.UserDao;
import com.example.demo.model.UserModel;


@Controller
public class IndexController {
	// 创建UserService的实例

	@Autowired
	UserDao userDao;
	
	@RequestMapping(value = "/")
	public String to_login() {
		// 接受请求并转发login.html页面
		return "login";
	}
	
	@RequestMapping(value = "do_register")
	public String to_register(HttpServletRequest request,Model model) {
		// 接受请求并转发login.html页面
		model.addAttribute("alert",request.getSession().getAttribute("alert"));
		return "register";
	}
	
	

	@RequestMapping("quit")
	public String loginOut(HttpServletRequest request) {
		request.getSession().invalidate();
		return "redirect:/";
	}

	//登陆
	@RequestMapping(value = "login")
	public String do_login(HttpServletRequest request) {
		// 登录请求判断	
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		UserModel userModel=userDao.getUserByLoginName(username);
		if(userModel==null){return "redirect:/";}
		else if (password.equals(userModel.getPassWord())) 
					{
						// 密码匹配，表示登录成功
						//request.getSession().setAttribute("loginName", userModel.getLoginName());
						request.getSession().setAttribute("userModel", userModel);
						
					return "redirect:/index";
					}
		else {
			return "redirect:/";
		}
	}
	
	//注册
	@RequestMapping(value="register")
	public String do_register(HttpServletRequest request){
		UserModel userModel=new UserModel();
		UserModel getUserModel=new UserModel();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String repassword = request.getParameter("repassword");
		if(!password.equals(repassword)){
			
			
			request.getSession().setAttribute("alert","两次输入密码不一致，请重新输入");
			return "redirect:/do_register";
			}
		else {
			userModel.setLoginName(username);
			userModel.setPassWord(password);
//			
			//查询结果先看下是不是null，防止空指针异常
			if(userDao.getUserByLoginName(username)==null){
				
				userDao.insertUser(userModel);
				//request.getSession().setAttribute("loginName", userModel.getLoginName());
				request.getSession().setAttribute("userModel", userModel);
				//重定向请求index
				return "redirect:/index";
				
				}
			else{
				request.getSession().setAttribute("alert","该账户已存在，请重新输入");
				return "redirect:/do_register";
		}
	}
	
	}
}
