package com.han.adminlogin.xml;

import org.apache.commons.lang.StringUtils;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *@author sunq
 *@date2021/3/4 15:24
 *@Description
 */
public class TextDemo2 {

	public static void main(String[] args) throws IOException {

		FileInputStream is = new FileInputStream("C:\\user\\project\\han_admin\\admin-login\\src\\main\\resources\\labelResultAll(1).txt");

		BufferedReader br = new BufferedReader(new InputStreamReader(is));

		String str = null;

		int neutralCount = 0,positiveCount = 0, negativeCount = 0;

		int total = 0;
		while ((str = br.readLine()) != null){

			if (StringUtils.isEmpty(str))
				continue;

//			System.out.println(str);
			String[] data = str.split("'");
//			System.out.println();

			total++;
			String[] p1 = data[1].split(",");

			if ("neutral".equalsIgnoreCase(p1[0])){
				neutralCount++;
			}

			if ("positive".equalsIgnoreCase(p1[0])){
				positiveCount++;
			}

			if ("negative".equalsIgnoreCase(p1[0])){
				negativeCount++;
			}

		}


		System.out.println("total：" + total);
		System.out.println("positive：" + positiveCount);	// 5
		System.out.println("negative：" + negativeCount);	// 0
		System.out.println("neutral：" + neutralCount);	// 3

		is.close();
		br.close();


	}

}
