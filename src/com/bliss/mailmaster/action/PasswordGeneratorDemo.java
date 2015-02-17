package com.bliss.mailmaster.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bliss.mailmaster.utils.PasswordManager;

public class PasswordGeneratorDemo extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		if(req.getParameter("param_pass") == null)
			resp.getWriter().print("Randrom Password "+PasswordManager.generatePswd());
		else
			resp.getWriter().print("Randrom Password "+PasswordManager.getEncryptedPassword(req.getParameter("param_pass")));
	}
}
