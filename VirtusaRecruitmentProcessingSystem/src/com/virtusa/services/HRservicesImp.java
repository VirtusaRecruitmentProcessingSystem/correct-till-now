package com.virtusa.services;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.virtusa.dao.HRDAO;
import com.virtusa.dao.HrDAOImp;
import com.virtusa.entities.JobseekerEntity;
import com.virtusa.helper.FactoryHrHelper;
import com.virtusa.model.ASLModel;
import com.virtusa.model.JobseekerModel;

public class HRservicesImp {
	private HrDAOImp hrdao;
	public HRservicesImp()
	{
		this.hrdao=FactoryHrHelper.createHRDAO();
		
	}
	/*	public List<JobseekerModel> getTrShortlistedList(){
			List<JobseekerModel>jobseekerModelList=new ArrayList<>();
			List<JobseekerEntity>jobseekerList;
			try {
				jobseekerList=hrdao.getTrShortlistedList();
				for(JobseekerEntity jobseekermodel :jobseekerList)
				{
					JobseekerModel jobseekerModel=new JobseekerModel();
					jobseekerModel.setFname(jobseekermodel.getFirst_name());
					jobseekerModel.setMname(jobseekermodel.getMiddle_name()); 
					jobseekerModel.setLname(jobseekermodel.getLast_name());
					//jobseekerModel.setDatex(jobseekermodel.getDatex());
					jobseekerModel.setEmail(jobseekermodel.getEmailid());
					//jobseekerModel.setPassYear(jobseekermodel.getPassYear());
					//jobseekerModel.setPercentage(jobseekermodel. getPercentage());
					//jobseekerModel.setQualification(jobseekermodel. getQualification());
					//jobseekerModel.setPhone(jobseekermodel.getPhone());
					jobseekerModelList.add(jobseekerModel);
				}
			}catch(ClassNotFoundException |SQLException e) {
				e.printStackTrace();
			}
			return jobseekerModelList;
			// TODO Auto-generated method stub
			
		}
	
		public List<JobseekerEntity> HrShortlist() {
			List<ASLModel>shortlist=new ArrayList<>();
			List<JobseekerEntity>jobseekerList;
	try {
		jobseekerList=hrdao.HrShortlist();
		for(JobseekerEntity jobseekersssss:jobseekerList)
		{
			ASLModel aslmodel=new ASLModel();
			aslmodel.setJobseekerId(jobseekers.getJobseekerId());
			aslmodel.setHrStatus(jobseekers.getHrStatus());
			shortlist.add(aslmodel);
		} 

	}catch(ClassNotFoundException |SQLException e) {
		e.printStackTrace();
	}

			return shortlist;

	}

	public void rate_comment() {
		// TODO Auto-generated method stub
		
	}
*/
}
 