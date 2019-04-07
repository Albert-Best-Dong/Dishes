package com.practice.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.practice.dao.impl.FoodDaoImpl;
import com.practice.domain.Food;

/**
 * Servlet implementation class FoodServlet
 */
@WebServlet("/foodselect")
public class FoodQueryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public FoodQueryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String foodName = request.getParameter("foodName");
		FoodDaoImpl foodDao = new FoodDaoImpl();
		
		Food f = foodDao.getFoodByName(foodName);
		request.setAttribute("food", f);
		if(f == null) {
			request.setAttribute("msg", "还没有这道美味");
			request.getRequestDispatcher("/selectFoodByName.jsp").forward(request, response);
		}else {
			request.getRequestDispatcher("/showFoodList.jsp").forward(request, response);
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		doGet(request, response);
	}

}
