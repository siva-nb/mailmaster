package com.bliss.mailmaster;

import java.sql.SQLException;
import java.util.concurrent.ExecutorService;

import javax.naming.NamingException;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import com.bliss.mailmaster.asynctask.WorkerThread;
import com.bliss.mailmaster.utils.DatabaseManager;

public class MailMasterApp implements ServletContextListener {

	static final Logger logger = Logger.getLogger(MailMasterApp.class);

	private WorkerThread mWorkerThread;
	
	private ExecutorService mThreadPoolExecutor;
	
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		BasicConfigurator.configure();
		logger.info("Initializing...");

		try {
			
			DatabaseManager.init();
			initWorkerThread();
			
		} catch (NamingException e1) {
			e1.printStackTrace();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

	}
	
	private void initWorkerThread()
	{
		logger.info("Init Worker Thread : Begin");
		mWorkerThread = WorkerThread.getInstance();
		mWorkerThread.initThreadPool();
		
		mThreadPoolExecutor = mWorkerThread.getThreadPoolExecutor();
		
		logger.debug("Init Worker Thread : Thread Pool is awaiting tasks");
		
		logger.info("Init Worker Thread : Ends");
	}

}
