package com.socket;

import org.apache.commons.lang.ArrayUtils;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.stream.Collectors;

/**
 *@author sunq
 *@date2020/10/27 17:05
 *@Description
 */
public class TestAddress {


	public static void main(String[] args) throws UnknownHostException, SocketException {


		/*InetAddress address = InetAddress.getByName("www.baidu.com");
		System.out.println(address);

		InetAddress[] allByName = InetAddress.getAllByName("www.baidu.com");
		System.out.println(ArrayUtils.toString(allByName));

		Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();

		while (networkInterfaces.hasMoreElements()){
			NetworkInterface networkInterface = networkInterfaces.nextElement();
			System.out.println(networkInterfaces + "--------------------------------");
			Enumeration<InetAddress> inetAddresses = networkInterface.getInetAddresses();
			while (inetAddresses.hasMoreElements()){
				System.out.println(networkInterface.getDisplayName() + " - " + inetAddresses.nextElement());
			}
		}*/

		/*String str = "pages/home/home?type=live&roomId=15";
		System.out.println(str);*/


		List<String> list = new ArrayList();
		list.add("1111");
		list.add("2222");
		list.add("3333");
		list.add("4444");
		String a = "";
		System.out.println(a);


		/*List<Long> idList = Arrays.asList(1L, 2L, 3L);
		String idString = String.join(",", idList.stream().map(String::valueOf).collect(Collectors.toList()));
		System.out.println(idString);
		console--------------------------------------------------------------------------------
		1,2,3*/
//		a = list.stream().reduce(",", String::concat);
		a = String.join(",", list.stream().map(String :: valueOf).collect(Collectors.toList()));

		System.out.println(a);

	}


}
