package com.bliss.mailmaster.asynctask;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;

import com.bliss.mailmaster.utils.MailMasterException;

public class WorkerThread {

	int  corePoolSize  =    5;
	int  maxPoolSize   =   10;
	long keepAliveTime = 5000;

	private ExecutorService threadPoolExecutor;

	private static WorkerThread mWorkerThread;

	Logger logger = Logger.getLogger(WorkerThread.class);

	private WorkerThread(){

	}

	public static WorkerThread getInstance()
	{
		if(mWorkerThread == null){
			mWorkerThread = new WorkerThread();
		}

		return mWorkerThread;
	}

	public void initThreadPool(){

		threadPoolExecutor = new ThreadPoolExecutor(
				corePoolSize,
				maxPoolSize,
				keepAliveTime,
				TimeUnit.MILLISECONDS,
				new LinkedBlockingQueue<Runnable>()
				);
	}

	public void shutdown() throws MailMasterException
	{
		try {
			while (!threadPoolExecutor.awaitTermination(10, TimeUnit.SECONDS)) {
				logger.debug("Awaiting completion of threads.");
			}
		} catch (InterruptedException e) {
			logger.fatal("Awaiting completion of threads.");
			throw new MailMasterException(e.getMessage());
		}
	}

	public ExecutorService getThreadPoolExecutor() {
		return threadPoolExecutor;
	}

	public void setThreadPoolExecutor(ExecutorService threadPoolExecutor) {
		this.threadPoolExecutor = threadPoolExecutor;
	}
}
