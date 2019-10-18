package com.virtusa.services;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.virtusa.entities.JobseekerEntity;
import com.virtusa.helper.FactoryTrHelper;
import com.virtusa.model.ASLModel;
import com.virtusa.model.JobseekerModel;
import com.virtusa.model.RateAndCommentModel;

public class TRservicesImpl implements TRServices {

/*public TRservicesImpl()
{
	this.trdao=FactoryTrHelper.createTRDAO();
	
}
*/
	public List<JobseekerModel> getAllJobSeekers() {
		List<JobseekerModel>jobseekerModelList=new ArrayList<>();
		/*		List<JobseekerEntity>jobseekerList;
		try {
			jobseekerList=trdao.getAllJobSeekers();
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
*/		return jobseekerModelList;
		// TODO Auto-generated method stub
		
	}

	public void TrShortlist() {
/*		List<ASLModel>shortlist=new ArrayList<>();
		List<JobseekerEntity>jobseekerList;
try {
	jobseekerList=trdao.TrShortlist();
	for(JobseekerEntity jobseekers1:jobseekerList)
	{
		ASLModel aslmodel=new ASLModel();
		aslmodel.setJobseekerId(jobseekers1.getJobseekerId());
		aslmodel.setHrStatus(jobseekers1.getHrStatus());
		shortlist.add(aslmodel);
	} 

}catch(ClassNotFoundException |SQLException e) {
	e.printStackTrace();
}

	
		// TODO Auto-generated method stub
		
	}
*/
	}

	public void rate_comment() {
		// TODO Auto-generated method stub
		List<RateAndCommentModel>ratecomment=new ArrayList<>();
 		List<JobseekerEntity>jobseekerList;
 		/*
try
{
	//jobseekerList=trdao.TrShortlist();
	for(JobseekerEntity jobseekers:jobseekerList)
	{
		RateAndCommentModel rateandcommentmodel=new RateAndCommentModel();
		rateandcommentmodel.setTr_rating(jobseekers.getTr_rating());
		rateandcommentmodel.setTr_comment(jobseekers.getTr_comment());
		ratecomment.add(rateandcommentmodel);
	} 

}catch(ClassNotFoundException |SQLException e) {
	e.printStackTrace();
}

		//return ratecomment;
*/
		
	}

}


