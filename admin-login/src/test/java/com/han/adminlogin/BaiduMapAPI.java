package com.han.adminlogin;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpResponse;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 *@author sunq
 *@date2020/1/6 10:50
 *@Description  	私人ak：ETxb1hztGnWuAFsLLnINcMg6k2U1YXkG
 *  			  	私人sk：vgeejOqI6h0Tk8egEnzD0NNlKVkMuhPw
 */
public class BaiduMapAPI {

	public static void main(String[] args) throws UnsupportedEncodingException {

		// 构造请求数据map集合，key-value键值对，
		Map<String, String> paramMap = new LinkedHashMap<>(16);
		paramMap.put("address", "连云港市赣榆区青口镇西关路74号老供电公司园内 成华 13675273998");
		paramMap.put("output", "json");
		paramMap.put("ak", "ckm3XfBTKglMeCU12ncMoGNxmLyfPXEe");





		System.out.println("原始收货地址：" + paramMap.get("address"));
		String regEx = "[`~!@#$%^&*()\\-+={}':;,\\[\\].<>/?￥%…（）_+|【】‘；：”“’。，、？\\s]";
		paramMap.put("address", paramMap.get("address").replaceAll(regEx,""));
		System.out.println("去空后的地址：" + paramMap.get("address"));
		System.out.println("去空后的地址长度：" + paramMap.get("address").length());
		System.out.println(Arrays.toString(paramMap.get("address").toCharArray()));


		// 对value做 utd-8 编码，得到拼接的参数
		String paramStr = toQueryString(paramMap);
//		System.out.println("拼接后的参数：" + paramStr);
		System.out.println();
		// 拼接url
		String wholeUrlStr = new String("/geocoding/v3/?" + paramStr + "FZKHmxV9GUkzla8Qt05PsMr3ehWUvrDh");
		System.out.println("拼接后的url："+ wholeUrlStr);
		System.out.println();
		// 整个请求url做 utf8编码
		String tempStr = URLEncoder.encode(wholeUrlStr, "UTF-8");
//		System.out.println("加密之后的url："+ tempStr);
		System.out.println();
		// 获取最后的签名
		String sn = MD5(tempStr);
//		System.out.println(sn);
//		System.out.println("---------------------------");
		paramMap.put("sn", sn);

		// 手动对地址进行 utf-8 url编码。
		String encodeAddress = URLEncoder.encode(paramMap.get("address"), "UTF-8");
		RestTemplate template = new RestTemplate();

		// 构造请求url
		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl("http://api.map.baidu.com/geocoding/v3/")
				.queryParam("address", encodeAddress)
				.queryParam("output", "json")
				.queryParam("ak", "ckm3XfBTKglMeCU12ncMoGNxmLyfPXEe")
				.queryParam("sn", sn);

		URI uri = builder.build(true).toUri();
		System.out.println(uri);
		System.out.println();
		String resultStr = template.getForObject(uri, String.class);
		System.out.println(resultStr);


		if (resultStr != null){
			try {
				JSONObject jsonObject = JSONObject.parseObject(resultStr);
				if (jsonObject != null && 0 == jsonObject.getInteger("status")){
					// 调用成功，获取经纬度
					JSONObject result = (JSONObject)jsonObject.get("result");
					JSONObject location = (JSONObject)result.get("location");
					System.out.println("lng====" +  location.getDoubleValue("lng"));
					System.out.println("lat====" +  location.getDoubleValue("lat"));

				}else {
					System.out.println("调用百度地图接口失败，错误码："+ jsonObject.getInteger("status") +"，错误信息：" + jsonObject.getInteger("message") + "");
				}
			}catch (Exception e){
				e.printStackTrace();
				System.out.println("经纬度解析失败，错误信息：" + e.getLocalizedMessage());

			}
		}




	}


	/**
	 *  请求参数转换成 utf-8字符串编码
	 * @param data
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public static String toQueryString(Map<?, ?> data) throws UnsupportedEncodingException {
		StringBuffer queryString = new StringBuffer();

		for (Map.Entry<?, ?> entry : data.entrySet()) {
			queryString.append(entry.getKey() + "=");
			queryString.append(URLEncoder.encode((String)entry.getValue(), "UTF-8") + "&");
		}

		if (queryString.length() > 0){
			queryString.deleteCharAt(queryString.length() - 1);
		}

		return queryString.toString();
	}

	/**
	 *  md5方法得到sn的签名
	 * @param md5
	 * @return
	 */
	public static String MD5(String md5){

		try {
			MessageDigest md = MessageDigest.getInstance("MD5");

			byte[] array = md.digest(md5.getBytes());
			StringBuffer sb = new StringBuffer();

			for (int i = 0; i < array.length; i++) {
				sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1, 3));
			}
			return sb.toString();

		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}

		return null;


	}



}
