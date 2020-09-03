package com.han.adminlogin.lamda;

import com.alibaba.fastjson.JSONObject;
import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.stream.Collectors;

/**
 *@author sunq
 *@date2020/8/5 17:19
 *@Description
 */
public class LamdaMain {

	public static void main(String[] args) {

		List<String> ladderArray = new LinkedList<>();
		ladderArray.add("2;1");
		ladderArray.add("3;2");
		ladderArray.add("4;3");
		ladderArray.add("5;4");

		// 阶梯校验通过。记录阶梯规则
		List<Object> ruleObject = new ArrayList<>();
		JSONObject param = null;
		JSONObject rule = new JSONObject();
		for (String ladder : ladderArray) {
			String[] ladders = ladder.split(";");
			param = new JSONObject();
			param.put("leastQty", ladders[0]);
			param.put("giftQty", ladders[1]);
			rule.put("param", param);
			ruleObject.add(rule);
		}
		System.out.println(ruleObject);

		// 阶梯校验通过。记录阶梯规则
		List<Object> ruleObject2 = new ArrayList<>();
		JSONObject param2 = null;
		for (String ladder : ladderArray) {
			String[] ladders = ladder.split(";");
			param2 = new JSONObject();
			param2.put("leastQty", ladders[0]);
			param2.put("giftQty", ladders[1]);
			ruleObject2.add(new JSONObject().put("param", param2));
		}
		System.out.println(ruleObject2);

		// 阶梯校验通过。记录阶梯规则
		List<Object> ruleObject3 = new ArrayList<>();
		JSONObject param3 = null;
		JSONObject rule3 = null;
		for (String ladder : ladderArray) {
			String[] ladders = ladder.split(";");
			param3 = new JSONObject();
			param3.put("leastQty", ladders[0]);
			param3.put("giftQty", ladders[1]);
			rule3 = new JSONObject();
			rule3.put("param", param3);
			ruleObject3.add(rule3);
		}
		System.out.println(ruleObject3);




	}

}
