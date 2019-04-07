package com.practice.servlet;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.practice.dao.impl.FoodDaoImpl;
import com.practice.domain.Food;
import com.practice.utils.UploadUtils;

/**
 * Servlet implementation class FoodAlterServlet
 */
@WebServlet("/update")
public class FoodUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private FoodDaoImpl foodDao = new FoodDaoImpl();

	public FoodUpdateServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String updateId = null;
		if (FoodDaoImpl.getDb() != null) {
			try {
				Map<String, String> map = new HashMap<String, String>();
				DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();

				ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);

				List<FileItem> list = servletFileUpload.parseRequest(request);

				// 4.遍历集合，获得每个FileItem，判断是表单项还是文件上传项
				String url = null;
				for (FileItem fileItem : list) {
					// 判断是表单项还是文件上传项
					if (fileItem.isFormField()) {
						// 普通表单项:
						// 接收表单项参数的值:
						String name = fileItem.getFieldName(); // 获得表单项的name属性的值
						String value = fileItem.getString("UTF-8");// 获得表单项的值
						System.out.println(name + "    " + value);

						// 将数据存入到map集合中:
						map.put(name, value);

					} else {
						// 文件上传项:
						// 文件上传功能：
						// 获得文件上传的名称：
						String fileName = fileItem.getName();
						if (fileName != null && !"".equals(fileName)) {
							// 通过工具类获得唯一文件名:
							String uuidFileName = UploadUtils.getUUIDFileName(fileName);
							// 获得文件上传的数据：
							InputStream is = fileItem.getInputStream();
							// 获得文件上传的路径:
							String path = this.getServletContext().getRealPath("/upload");
							// 将输入流对接到输出流就可以了:
							url = path + "\\" + uuidFileName;
							OutputStream os = new FileOutputStream(url);
							int len = 0;
							byte[] b = new byte[1024];
							while ((len = is.read(b)) != -1) {
								os.write(b, 0, len);
							}
							is.close();
							os.close();
						}

					}
				}
				System.out.println(map);
				FoodDaoImpl.getDb();
				// 获得ServletContext对象:
//				List<Food> foodList = (List<Food>) this.getServletContext().getAttribute("list");
				// 校验用户名:
				for (Food ff : FoodDaoImpl.getDb()) {
					if (ff.getFoodName().equals(map.get("foodName"))) {
						request.setAttribute("msg", "菜名已经存在！");
						request.getRequestDispatcher("/addFood.jsp").forward(request, response);
						return;
					}
				}

				updateId = map.get("id");
				//修改菜品信息
				for (Food f : FoodDaoImpl.getDb()) {
					if (f.getId().equals(updateId)) {
						FoodDaoImpl.getDb().remove(f);
						// 封装数据到Food当中:
						Food food = new Food();
						food.setFoodName(map.get("foodName"));
						food.setTaste(map.get("taste"));
						food.setId(map.get("id"));
						food.setPrice(map.get("price"));
						food.setFoodImage(url);

						// 将注册用户的信息存入到List集合中:
						foodDao.updateFood(food);
//						FoodDaoImpl.getDb().add(food);
//						foodList.add(food);
						List<Food> fdb = FoodDaoImpl.getDb();
						for (Food foo : fdb) {
							System.out.println(foo);
						}
						this.getServletContext().setAttribute("list", FoodDaoImpl.getDb());
						// 注册成功，跳转到登录页面:
						request.getSession().setAttribute("foodName", food.getFoodName());
						response.sendRedirect(request.getContextPath() + "/showFoodList.jsp");
					}
				}

			} catch (FileUploadException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
