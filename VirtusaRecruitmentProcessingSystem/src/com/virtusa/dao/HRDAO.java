package com.virtusa.dao;

import java.sql.SQLException;
import java.util.List;

import com.virtusa.entities.JobseekerEntity;

public interface HRDAO {
	//public  List<JobseekerEntity> getTRShortlistcandidates()throws ClassNotFoundException, SQLException;

	List<JobseekerEntity> getTrShortlistedList() throws ClassNotFoundException, SQLException;

	List<JobseekerEntity> HrShortlist();

}
//