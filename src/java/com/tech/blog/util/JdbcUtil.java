/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tech.blog.util;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.postgresql.ds.PGPoolingDataSource;

/**
 *
 * @author kali
 */
public class JdbcUtil {

    private static HikariDataSource dataSource;
    private JdbcUtil() {
	}

	static {
		// Step1: loading and register the Driver
		try {
			Class.forName("org.postgresql.Driver");
              String loc="/home/kali/Tech-Blog/src/main/resources/application.properties";          
        HikariConfig config = new HikariConfig(loc);
//        config.setJdbcUrl("jdbc:postgresql://localhost:5432/techblog");  // Replace with your database URL
//        config.setUsername("postgres");  // Replace with your database username
//        config.setPassword("admin");  // Replace with your database password
        config.setMaximumPoolSize(20);  // Set the max pool size based on your needs
        config.setIdleTimeout(30000);  // Timeout for idle connections
        config.setMaxLifetime(1800000);  // Maximum connection lifetime
        config.setConnectionTimeout(30000);  // Timeout for getting a connection from the pool
        
        dataSource = new HikariDataSource(config);
		} catch (ClassNotFoundException ce) {
			ce.printStackTrace();
		}
	}

    public static Connection getJdbcConnection(){
       	// Take the data from properties file
        Connection connection =null;
        try{
//		FileInputStream fis = new FileInputStream("/home/kali/Tech-Blog/src/main/resources/application.properties");
//		Properties properties = new Properties();
//		properties.load(fis);
//
//
//        HikariConfig config = new HikariConfig(loc);
// Timeout after 30 seconds if no connection available

//                config.setJdbcUrl("jdbc:postgresql://localhost:5432/techblog");
		// Step2. Establish the Connection
//		 connection = DriverManager.getConnection(properties.getProperty("url"),
//				properties.getProperty("username"), properties.getProperty("password"));
//                 HikariDataSource dataSource=new HikariDataSource(config);
//                 
//                 
//               PGPoolingDataSource source = new PGPoolingDataSource();
//source.setDataSourceName("A Data Source");
//source.setServerNames(new String[] {
//    "localhost"
//});
//source.setDatabaseName("test");
//source.setUser("testuser");
//source.setPassword("testpassword");
//source.setMaxConnections(10);
                 connection=dataSource.getConnection();
		System.out.println("CONNECTION object created...");
        }catch(Exception e){
            e.printStackTrace();
            
        }
		return connection;
    }
    public static void cleanUp(Connection con, Statement statement, ResultSet resultSet) throws SQLException {
		// Step6. Close the resources
		if (con != null) {
			con.close();
		}
		if (statement != null) {
			statement.close();
		}
		if (resultSet != null) {
			resultSet.close();
		}
	}
}
