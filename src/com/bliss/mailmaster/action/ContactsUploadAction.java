package com.bliss.mailmaster.action;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.bliss.mailmaster.service.ContactService;
import com.bliss.mailmaster.utils.MailMasterException;
import com.bliss.mailmaster.utils.MailMasterUtils;
import com.bliss.mailmaster.vo.ContactsUploadVO;
import com.opensymphony.xwork2.ActionSupport;

public class ContactsUploadAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private File param_file;
	private String param_fileContentType;
	private String param_fileFileName;
	
	private String param_result;
	
	public File getParam_file() {
		return param_file;
	}
	public void setParam_file(File param_file) {
		this.param_file = param_file;
	}
	public String getParam_fileContentType() {
		return param_fileContentType;
	}
	public void setParam_fileContentType(String param_fileContentType) {
		this.param_fileContentType = param_fileContentType;
	}
	public String getParam_fileFileName() {
		return param_fileFileName;
	}
	public void setParam_fileFileName(String param_fileFileName) {
		this.param_fileFileName = param_fileFileName;
	}

	public String getParam_result() {
		return param_result;
	}
	public void setParam_result(String param_result) {
		this.param_result = param_result;
	}
	
	public String execute() throws MailMasterException {
		invokeContactsUpload();
		return "SUCCESS";
	}
	
	Logger logger = Logger.getLogger(ContactsUploadVO.class);

	private void invokeContactsUpload() throws MailMasterException
	{
		BufferedReader bufferedReader = null;
		String line = "";
		String cvsSplitBy = ",";
		ContactsUploadVO contactsUploadVO;
		List<ContactsUploadVO> contactList = new ArrayList<ContactsUploadVO>();
		String[] contactdetails;
		
		try{
			contactsUploadVO = new ContactsUploadVO();
			bufferedReader = new BufferedReader(new FileReader(param_file));

			while ((line = bufferedReader.readLine()) != null) {

				contactdetails = line.split(cvsSplitBy);
				if(MailMasterUtils.isValidEmail(contactdetails[0])){
					contactsUploadVO = new ContactsUploadVO();
					contactsUploadVO.setContact_email(contactdetails[0]);
					contactsUploadVO.setContact_firstname(contactdetails[1]);
					if(contactdetails.length == 3)
						contactsUploadVO.setContact_lastname(contactdetails[2]);
					contactList.add(contactsUploadVO);
				}
			}
			
			ContactService contactService = new ContactService();
			int insertCount = contactService.addContactBulkUpload(contactList);
			
			logger.info("Insert Count "+insertCount);
			
			if(insertCount == contactList.size()){
				param_result = "Inserted Successfully";
			}else{
				param_result = "Not Inserted Successfully";
			}

		}catch(FileNotFoundException e){
			e.printStackTrace();
			throw new MailMasterException("File Not Found");
		}catch (IOException e1) {
			e1.printStackTrace();
			throw new MailMasterException(e1.getMessage());
		}catch (Exception e2) {
			e2.printStackTrace();
		}finally{
			if (bufferedReader != null) {
				try {
					bufferedReader.close();
				} catch (IOException e) {
					e.printStackTrace();
					throw new MailMasterException(e.getMessage());
				}
			}
		}
	}
}
