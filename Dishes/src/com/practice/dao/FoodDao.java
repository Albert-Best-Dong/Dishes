package com.practice.dao;

import java.util.List;

import com.practice.domain.Food;

public interface FoodDao {
	public void addFood(Food food);	//添加菜品
	public List<Food> getAllFood();	//查询所有菜品信息
	public Food getFoodByName(String foodName); //根据菜品名称查询菜品信息
	public Food getFoodById(String id);	//根据菜品id查询菜品信息
	public void updateFood(Food newFood); //菜品修改
	public void deleteFoodById(String id); //根据菜品ID进行删除
}
