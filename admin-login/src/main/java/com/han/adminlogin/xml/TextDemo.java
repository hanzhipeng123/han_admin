package com.han.adminlogin.xml;

import org.apache.commons.lang.StringUtils;

import java.io.*;

/**
 *@author sunq
 *@date2021/3/4 15:24
 *@Description
 */
public class TextDemo {

	public static void main(String[] args) throws IOException {

		FileInputStream is = new FileInputStream("C:\\user\\project\\han_admin\\admin-login\\src\\main\\resources\\labelResultAll.txt");

		BufferedReader br = new BufferedReader(new InputStreamReader(is));

		String str = null;

		int neutralCount = 0,positiveCount = 0, negativeCount = 0;
		int neutral = 0,positive = 0, negative = 0;

		int total = 0;
		while ((str = br.readLine()) != null){

			if (StringUtils.isEmpty(str))
				continue;

//			System.out.println(str);
			String[] data = str.split("'");
//			System.out.println();

			total++;
			String[] p1 = data[1].split(",");
			String[] p2 = data[2].split(",");
			String[] p3 = data[3].split(",");

			if ("neutral".equalsIgnoreCase(p1[0])){
				neutral++;
			}
			if ("neutral".equalsIgnoreCase(p2[0])){
				neutral++;
			}
			if ("neutral".equalsIgnoreCase(p3[0])){
				neutral++;
			}

			if ("positive".equalsIgnoreCase(p1[0])){
				positive++;
			}
			if ("positive".equalsIgnoreCase(p2[0])){
				positive++;
			}
			if ("positive".equalsIgnoreCase(p3[0])){
				positive++;
			}

			if ("negative".equalsIgnoreCase(p1[0])){
				negative++;
			}
			if ("negative".equalsIgnoreCase(p2[0])){
				negative++;
			}
			if ("negative".equalsIgnoreCase(p3[0])){
				negative++;
			}


			if (positive > 1){
				positiveCount++;
			}else if (negative > 1){
				negativeCount++;
			}else {
				neutralCount++;
			}
			neutral = 0;
			positive = 0;
			negative = 0;
		}


		System.out.println("total：" + total);
		System.out.println("positive：" + positiveCount);	// 5
		System.out.println("negative：" + negativeCount);	// 0
		System.out.println("neutral：" + neutralCount);	// 3

		is.close();
		br.close();


	}

}
