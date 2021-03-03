package com.han.adminlogin.xml;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.Iterator;
import java.util.List;

/**
 *@author sunq
 *@date2021/3/2 16:03
 *@Description
 */
public class XmlDemo {

	public static void main(String[] args) throws DocumentException {
		SAXReader reader = new SAXReader();

		Document document = reader.read(new File("C:\\user\\project\\han_admin\\admin-login\\src\\main\\resources\\Training data for Emotion Classification.xml"));


		Element rootElement = document.getRootElement();

		Iterator iterator = rootElement.elementIterator();

		int happiness = 0;
		int sadness = 0;
		int like = 0;
		int anger = 0;
		int disgust = 0;
		int fear = 0;
		int surprise = 0;
		int none = 0;


		while (iterator.hasNext()){

			Element next = (Element) iterator.next();

			List<Attribute> attributes = next.attributes();
			for (Attribute attribute : attributes) {
				if (attribute.getName().equalsIgnoreCase("emotion-type1")){
					if ("happiness".equalsIgnoreCase(attribute.getValue())){
						happiness++;
					}else if ("sadness".equalsIgnoreCase(attribute.getValue())){
						sadness++;
					}else if ("like".equalsIgnoreCase(attribute.getValue())){
						like++;
					}else if ("anger".equalsIgnoreCase(attribute.getValue())){
						anger++;
					}else if ("disgust".equalsIgnoreCase(attribute.getValue())){
						disgust++;
					}else if ("fear".equalsIgnoreCase(attribute.getValue())){
						fear++;
					}else if ("surprise".equalsIgnoreCase(attribute.getValue())){
						surprise++;
					}else {
						none++;
					}
				}
			}
		}

		System.out.println("happiness ==== " + happiness);
		System.out.println("sadness ==== " + sadness);
		System.out.println("like ==== " + like);
		System.out.println("anger ==== " + anger);
		System.out.println("disgust ==== " + disgust);
		System.out.println("fear ==== " + fear);
		System.out.println("surprise ==== " + surprise);
		System.out.println("none ==== " + none);


	}

}
