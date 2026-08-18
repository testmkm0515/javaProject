package datastructure.collection.properties;

import java.io.FileReader;
import java.net.URLDecoder;
import java.util.Properties;

public class PropertiesExample {

	public static void main(String[] args) throws Exception {
		// Properties 파일 읽어오기
		Properties properties = new Properties();
		//읽어오려는 property 파일의 경로 
		String path = PropertiesExample.class.getResource("database.properties").getPath();
		path = URLDecoder.decode(path,"utf-8");
		properties.load(new FileReader(path));
		
		String driver = properties.getProperty("driver");
		String url = properties.getProperty("url");
		String username = properties.getProperty("username");
		String password = properties.getProperty("password");
		
		System.out.println("driver : " + driver);
		System.out.println("url : " + url);
		System.out.println("username : " + username);
		System.out.println("password : " + password);

	}

}








