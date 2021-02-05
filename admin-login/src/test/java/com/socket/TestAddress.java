package com.socket;

import io.netty.buffer.ByteBuf;
import org.apache.commons.lang.ArrayUtils;
import sun.misc.Cleaner;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.*;
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

		Date date = new Date(System.currentTimeMillis());
		int hours = date.getHours();
		System.out.println(hours);

		Calendar cleaner = Calendar.getInstance();
		cleaner.setTimeInMillis(System.currentTimeMillis());
		int h1 = cleaner.get(Calendar.HOUR_OF_DAY);
		System.out.println(h1);
		int h2 = cleaner.get(Calendar.HOUR);
		System.out.println(h2);

	}


}
