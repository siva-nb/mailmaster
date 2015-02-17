package com.bliss.mailmaster.utils;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.log4j.Logger;

public class DatabaseManager {

	private static DataSource datasource = null;
	private static Logger logger = Logger.getLogger(DatabaseManager.class);
	
	public static void init() throws NamingException, SQLException
	{
		logger.info("Connection Pool Init Begins");
		Context envContext = null;
		envContext = new InitialContext();
		datasource = (DataSource)envContext.lookup("java:/comp/env/jdbc/mailmasterDB");
		logger.info("Connection Pool Init End");
	}
	
	public static Connection getConnection() throws SQLException, NamingException
	{
		if(datasource == null)
		{
			logger.debug("Connection Pool Datasource is null");
			return null;
		}
		
		Connection connection = datasource.getConnection();
		if(connection == null)
		{
			logger.debug("Connection Pool Connection is null");
			return null;
		}
		
		logger.info("Connection Pool Connected successfully");
		return connection;
	}
	
	public static void closeConnection(Connection connection) throws SQLException
	{
		if(connection != null)
		{
			connection.close();
			logger.info("Connection Pool terminated successfully");
		}
	}
}
