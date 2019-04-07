<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page
	import="com.practice.dao.impl.FoodDaoImpl,com.practice.domain.Food,java.util.*"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<base href="/dishes">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>菜品信息展示</title>
<style type="text/css">
</style>
</head>

<body>

	<center>
		<h1>菜品查询</h1>
		<table border="1px" cellspacing="0px" cellpadding="0px" width="800px">
			<thead>
				<tr>
					<th>菜品ID</th>
					<th>菜名</th>
					<th>口味</th>
					<th>菜品图片</th>
					<th>价格</th>
					<th>菜品描述</th>
				</tr>
			</thead>
			<tbody>
		
				<% 
					List<Food> tempList = null;
					Food selectFood = (Food)request.getAttribute("food");
					if(selectFood == null){
						tempList = FoodDaoImpl.getDb();
					}else{
						tempList = new ArrayList<Food>();
						tempList.add(selectFood);
					}
					for(Food f: tempList){
						String fileName = null;
						if(f.getFoodImage() != null){
							int idx = f.getFoodImage().lastIndexOf("\\");
							// 获得文件上传的唯一文件名：
							fileName = f.getFoodImage().substring(idx+1);
						}
					    
				%>
				<tr>
					<td><%=f.getId() %></td>
					<td><%=f.getFoodName() %></td>
					<td><%=f.getTaste() %></td>
					<td><img src="/dishes/upload/<%= fileName %>" /></td>
					<td><%=f.getPrice() %></td>
					<td><c:out value="<%=f.getDescription() %>" default="无"></c:out></td>
				</tr>
				<%
					}
				%>
			</tbody>
		</table>
	</center>
</body>
</html>