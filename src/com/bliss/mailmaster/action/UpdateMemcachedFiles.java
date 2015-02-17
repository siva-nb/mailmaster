package com.bliss.mailmaster.action;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.bliss.mailmaster.MailMasterApp;
import com.bliss.mailmaster.utils.CacheManager;
import com.bliss.mailmaster.utils.Constants;

public class UpdateMemcachedFiles extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	static final Logger logger = Logger.getLogger(UpdateMemcachedFiles.class);
	CacheManager mMemcached;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/plain");
		List<String> fileList = new ArrayList<String>();
		fileList.add(Constants.FILE_NAME_INDEX);
		fileList.add(Constants.FILE_NAME_CONTACTS);
		
		initMemcache(fileList);
		response.getWriter().print("Done");
	}

	private void initMemcache(List<String> fileList)
	{
		InputStream schemaIS;
		try {
			mMemcached = CacheManager.getInstance();
			mMemcached.clear();
			for(int i=0; i< fileList.size();i++){
				logger.info("Reading the template :"+fileList.get(i));

				schemaIS = this.getClass().getClassLoader()
						.getResourceAsStream(fileList.get(i));

				if(schemaIS == null){
					logger.info(fileList.get(i)+ " Stream is null");
				}else{
					logger.info(fileList.get(i)+ " Stream is not null");
					mMemcached.add(fileList.get(i), 2592000, readFromFile(schemaIS));
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String readFromFile(InputStream inputStream) {
		StringBuilder fileData = new StringBuilder();
		String currentLine = "";
		BufferedReader bufferedReader = new BufferedReader(
				new InputStreamReader(inputStream));
		try {
			while ((currentLine = bufferedReader.readLine()) != null) {
				fileData.append(currentLine).append("\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return fileData.toString();
	}
}