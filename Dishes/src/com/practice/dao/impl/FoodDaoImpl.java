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

public class FoodDaoImpl implements FoodDao{
	
	private static final List<Food> db = new ArrayList<Food>();
	
	
	public static List<Food> getDb() {
		return db;
	}

	@Override
	public void addFood(Food food) {
		FoodDaoImpl.getDb().add(food);
	}

	@Override
	public List<Food> getAllFood() {
		
		return db;
	}

	@Override
	public Food getFoodByName(String foodName) {
		Food food = null;
		for(Food f : FoodDaoImpl.getDb()) {
			if(f.getFoodName().equals(foodName)) {
				food = f;
			}
		}
		return food;
	}

	@Override
	public Food getFoodById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateFood(Food newFood) {
		for(Food f : FoodDaoImpl.getDb()) {
			if(newFood.getId().equals(f.getFoodName())) {
				FoodDaoImpl.getDb().add(newFood);
			}else {
				return;
			}
		}
		
	}

	@Override
	public void deleteFoodById(String id) {
		for(Food f: FoodDaoImpl.getDb()) {
			if(f.getId().equals(id)) {
				FoodDaoImpl.getDb().remove(f);			
				break;
			}
		}
		
	}

}
