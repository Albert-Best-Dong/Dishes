package com.practice.servlet;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import com.practice.dao.FoodDao;
import com.practice.dao.impl.FoodDaoImpl;
import com.practice.domain.Food;

public class InitServlet extends HttpServlet{
	@Override
	public void init() throws ServletException {
		List<Food> list = FoodDaoImpl.getDb();
		this.getServletContext().setAttribute("list", list);
	}
}
