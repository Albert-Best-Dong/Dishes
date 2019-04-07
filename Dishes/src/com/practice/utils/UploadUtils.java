package com.practice.utils;

import java.util.UUID;

/**
 * 文件上传的工具类
 * @author jt
 *
 */
public class UploadUtils {

	/**
	 * 生成唯一的文件名:
	 */
	public static String getUUIDFileName(String fileName){

		int idx = fileName.lastIndexOf(".");
		String extention = fileName.substring(idx);
		String uuidFileName = UUID.randomUUID().toString().replace("-", "")+extention;
		return uuidFileName;
	}
	

}
