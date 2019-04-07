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
 * 删除菜单Servlet
 */
@WebServlet("/delete")
public class FoodDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private FoodDaoImpl foodDao = new FoodDaoImpl();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FoodDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String deleteId = request.getParameter("id");
		int x = FoodDaoImpl.getDb().size();
		foodDao.deleteFoodById(deleteId);
		if(FoodDaoImpl.getDb().size()<x) {
			request.setAttribute("msg", "删除成功！");
			request.getRequestDispatcher("/deleteById.jsp").forward(request, response);			
		}else {
			request.setAttribute("msg", "没有该Id的美食，请重新输入要删除的美食！");
			request.getRequestDispatcher("/deleteById.jsp").forward(request, response);
		}

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		doGet(request, response);
	}

}
