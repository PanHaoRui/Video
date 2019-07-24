package com.example.demo.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.UserModel;

/*LoginInterceptor.java是整个登录认证模块中的核心类之一，它实现了HandlerInterceptor类，由它来拦截并过滤到来的每一个请求；
它的三个方法能分别作用于每个请求的不同生命周期，你可以根据自己的需要来加入相应的处理逻辑
*/
public class LoginInterceptor implements HandlerInterceptor {

	/**
	 * 在请求被处理之前调用
	 * 
	 * @param request
	 * @param response
	 * @param handler
	 * @return
	 * @throws Exception
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// 检查每个到来的请求对应的session域中是否有登录标识
		UserModel userModel =(UserModel) request.getSession().getAttribute("userModel");
		if (null == userModel) {
			// 未登录，重定向到登录页
			response.sendRedirect("/");
			return false;
		}
		String userName = (String) userModel.getLoginName();
		System.out.println("当前用户已登录，登录的用户名为： " + userName);
		return true;
	}

	/**
	 * 在请求被处理后，视图渲染之前调用
	 * 
	 * @param request
	 * @param response
	 * @param handler
	 * @param modelAndView
	 * @throws Exception
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.print("请求被调用");
	}

	/**
	 * 在整个请求结束后调用
	 * 
	 * @param request
	 * @param response
	 * @param handler
	 * @param ex
	 * @throws Exception
	 */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.print("请求调用结束");
	}

}