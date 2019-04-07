package com.practice.dao.impl;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.practice.dao.FoodDao;
import com.practice.domain.Food;
import com.practice.utils.UploadUtils;

public class FoodDaoImpl implements FoodDao {

	private static final List<Food> db = new ArrayList<Food>(); // 存放菜品信息的List

	public static List<Food> getDb() {
		return db;
	}

	@Override
	// 添加菜品
	public void addFood(Food food) {
		FoodDaoImpl.getDb().add(food);
	}

	@Override
	// 返回所有菜谱
	public List<Food> getAllFood() {

		return db;
	}

	@Override
	// 通过菜名进行查找
	public Food getFoodByName(String foodName) {
		Food food = null;
		for (Food f : FoodDaoImpl.getDb()) {
			if (f.getFoodName().equals(foodName)) {
				food = f;
			}
		}
		return food;
	}

	@Override
	// 通过id进行查找
	public Food getFoodById(String id) {
		Food food = null;
		for (Food f : FoodDaoImpl.getDb()) {
			if (f.getId().equals(id)) {
				food = f;
				break;
			}
		}
		return food;
	}

	@Override
	// 修改菜品
	public void updateFood(Food newFood) {
		for (Food f : FoodDaoImpl.getDb()) {
			if (newFood.getId().equals(f.getId())) {
				FoodDaoImpl.getDb().remove(f);
				FoodDaoImpl.getDb().add(newFood);
				break;
			} else {
				return;
			}
		}

	}

	@Override
	public void deleteFoodById(String id) {
		if (getFoodById(id) != null) {
			FoodDaoImpl.getDb().remove(getFoodById(id));
		}
	}

}
