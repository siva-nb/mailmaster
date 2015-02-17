package com.bliss.mailmaster.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import org.apache.log4j.Logger;

import com.bliss.mailmaster.dao.CampaignDAO;
import com.bliss.mailmaster.utils.Constants;
import com.bliss.mailmaster.utils.Constants.CampaignStatus;
import com.bliss.mailmaster.utils.DatabaseManager;
import com.bliss.mailmaster.utils.SQL;
import com.bliss.mailmaster.vo.CampaignGroupVO;
import com.bliss.mailmaster.vo.CampaignVO;

public class CampaignDAOImpl implements CampaignDAO{

	Connection dbConnection;
	PreparedStatement preparedStatement;
	ResultSet resultSet;

	Logger logger = Logger.getLogger(CampaignDAOImpl.class);

	/***
	 * Inserts a Campaign in DB
	 * @param campaignVO
	 * returns number of affected rows
	 */
	@Override
	public int addNewCampaign(CampaignVO campaignVO) {
		int no_of_affected_rows;

		try{

			dbConnection = DatabaseManager.getConnection();

			logger.info("Add New Campaign : Database connected");

			preparedStatement = dbConnection.prepareStatement(SQL.ADD_NEW_CAMPAIGN);
			preparedStatement.setString(1, campaignVO.getCampaignName());
			preparedStatement.setInt(2, campaignVO.getContentId());
			preparedStatement.setString(3, campaignVO.getCampaignContent());
			preparedStatement.setInt(4, CampaignStatus.NASCENT.getValue());
			preparedStatement.setInt(5, campaignVO.getGroupId());
			preparedStatement.setInt(6, campaignVO.getUserId());

			no_of_affected_rows = preparedStatement.executeUpdate();
			
			return no_of_affected_rows;

		}catch(SQLException | NamingException e){
			logger.fatal("Add New Contact: SQLException "+e.getMessage(), e);
			return Constants.ERROR_RESPONSE;
		}finally{
			try{
				closeGracefully();
			}catch(SQLException e){
				logger.fatal("Add New Contact: SQLException "+e.getMessage(), e);
				return Constants.ERROR_RESPONSE;
			}
		}
	}

	private void closeGracefully() throws SQLException
	{
		DatabaseManager.closeConnection(dbConnection);

		if(preparedStatement != null){
			preparedStatement.close();
		}

		if(resultSet != null){
			resultSet.close();
		}
	}

	@Override
	public int updateCampaignStatus(int campaignId, int status) {
		int no_of_updated_rows;
		
		try{

			dbConnection = DatabaseManager.getConnection();
			
			preparedStatement = dbConnection.prepareStatement(SQL.UPDATE_CAMPAIGN);
			preparedStatement.setInt(1, CampaignStatus.START.getValue());
			preparedStatement.setInt(2, campaignId);
			
			no_of_updated_rows = preparedStatement.executeUpdate();
			
			if(no_of_updated_rows == 1){
				
			}
			
			return no_of_updated_rows;
			
		}catch(SQLException | NamingException e){
			logger.fatal("Async Send Mail: SQLException "+e.getMessage(), e);
			return Constants.ERROR_RESPONSE;
		}finally{
			try{
				closeGracefully();
			}catch(SQLException e){
				logger.fatal("Async Send Mail: SQLException "+e.getMessage(), e);
				return Constants.ERROR_RESPONSE;
			}
		}
	}

	@Override
	public String fetchRawCampaignContent(int campaignId) {
		
		String campaignName;
		String campaignContent;
		
		try{

			dbConnection = DatabaseManager.getConnection();
			
			preparedStatement = dbConnection.prepareStatement(SQL.SELECT_CAMPAIGN_DETAILS);
			preparedStatement.setInt(1, campaignId);
			
			resultSet = preparedStatement.executeQuery();
			
			if(resultSet != null && resultSet.next()){
				campaignName = resultSet.getString(1);
				campaignContent = resultSet.getString(2);
				
				return campaignName + Constants.DELIMITER + campaignContent;

			}
			
			return null;
		}catch(SQLException | NamingException e){
			logger.fatal("Async Send Mail: SQLException "+e.getMessage(), e);
			return String.valueOf(Constants.ERROR_RESPONSE);
		}finally{
			try{
				closeGracefully();
			}catch(SQLException e){
				logger.fatal("Async Send Mail: SQLException "+e.getMessage(), e);
				return String.valueOf(Constants.ERROR_RESPONSE);
			}
		}
	}

	@Override
	public int updateCredits(int userid) {
		int no_of_updated_rows;
		
		try{

			dbConnection = DatabaseManager.getConnection();
			
			preparedStatement = dbConnection.prepareStatement(SQL.UPDATE_CREDITS);
			preparedStatement.setInt(1, userid);
			
			no_of_updated_rows = preparedStatement.executeUpdate();
			
			return no_of_updated_rows;
			
		}catch(SQLException | NamingException e){
			logger.fatal("Update Credits: SQLException "+e.getMessage(), e);
			return Constants.ERROR_RESPONSE;
		}finally{
			try{
				closeGracefully();
			}catch(SQLException e){
				logger.fatal("Update Credits: SQLException "+e.getMessage(), e);
				return Constants.ERROR_RESPONSE;
			}
		}
	}

	@Override
	public List<CampaignGroupVO> fetchCampaignForDashboard(int pageid) {
		List<CampaignGroupVO> campaignGroupList;
		
		CampaignGroupVO campaignGroupVO = null;
		
		int offset;
		
		try{

			dbConnection = DatabaseManager.getConnection();
			
			offset = pageid * Constants.CONTACT_PAGE_SIZE; 
			
			preparedStatement = dbConnection.prepareStatement(SQL.SELECT_CAMPAIGN_DASHBOARD);
			preparedStatement.setInt(1, offset);
			
			resultSet = preparedStatement.executeQuery();
			
			campaignGroupList = new ArrayList<CampaignGroupVO>();
			
			while(resultSet.next()){
				campaignGroupVO = new CampaignGroupVO();
				campaignGroupVO.setCampaignId(resultSet.getInt(SQL.COL_TBL_CAMPAIGN_ID));
				campaignGroupVO.setCampaignName(resultSet.getString(SQL.COL_TBL_CAMPAIGN_NAME));
				campaignGroupVO.setGroupDescription(resultSet.getString(SQL.COL_TBL_GROUP_DESCRIPTION));
				campaignGroupVO.setGroupId(resultSet.getInt(SQL.COL_TBL_CONTACT_GRP_ID));
				campaignGroupVO.setGroupName(resultSet.getString(SQL.COL_TBL_ALIAS_GRP_NAME));
				campaignGroupVO.setCampaignStatus(resultSet.getInt(SQL.COL_TBL_CAMPAIGN_STATUS));
				
				campaignGroupList.add(campaignGroupVO);
			}
			
			return campaignGroupList;
			
		}catch(SQLException | NamingException e){
			logger.fatal("Fetch Campaign For Dashboard: SQLException "+e.getMessage(), e);
			return null;
		}finally{
			try{
				closeGracefully();
			}catch(SQLException e){
				logger.fatal("Fetch Campaign For Dashboard: SQLException "+e.getMessage(), e);
				return null;
			}
		}
	}
	
}
