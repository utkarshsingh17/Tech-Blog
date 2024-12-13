/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tech.blog.util;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import java.sql.Connection;

/**
 *
 * @author kali
 */
public class JdbcUtil {

    
    private JdbcUtil() {
	}

	static {
		// Step1: loading and register the Driver
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException ce) {
			ce.printStackTrace();
		}
	}

    public static Connection getJdbcConnection(){
       	// Take the data from properties file
        Connection connection =null;
        try{
//		FileInputStream fis = new FileInputStream("/home/kali/Downloads/Tech-Blog-master/src/main/resources/application.properties");
//		Properties properties = new Properties();
//		properties.load(fis);
                String configFile="/home/kali/Downloads/Tech-Blog/src/main/resources/application.properties";
                HikariConfig config=new HikariConfig(configFile);
                config.setJdbcUrl("jdbc:postgresql://localhost:5432/techblog");
		// Step2. Establish the Connection
//		 connection = DriverManager.getConnection(properties.getProperty("url"),
//				properties.getProperty("username"), properties.getProperty("password"));
                 HikariDataSource dataSource=new HikariDataSource(config);
                 connection=dataSource.getConnection();
		System.out.println("CONNECTION object created...");
        }catch(Exception e){
            e.printStackTrace();
            
        }
		return connection;
    }
}
