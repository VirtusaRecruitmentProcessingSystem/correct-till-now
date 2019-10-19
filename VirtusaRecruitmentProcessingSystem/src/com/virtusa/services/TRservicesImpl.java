package com.virtusa.services;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.virtusa.dao.TrDAOImp;
import com.virtusa.entities.JobseekerEntity;
import com.virtusa.helper.FactoryTrHelper;
import com.virtusa.model.ASLModel;
import com.virtusa.model.JobseekerModel;
import com.virtusa.model.RateAndCommentModel;

public class TRservicesImpl implements TRServices {

	TrDAOImp trdao;
	boolean result=false;
public TRservicesImpl()
{
	FactoryTrHelper frtr=new FactoryTrHelper();
	trdao=frtr.createTRDAO();	
}

@Override
public boolean getAllJobSeekers() {
		List<ASLModel>jobseekerModelList=new ArrayList<>();
		jobseekerModelList=trdao.getAllJobSeekers();
		if(jobseekerModelList.isEmpty()) {
			System.out.println(" Sorry,there are no Applications to view\n Contact Admin or Please wait for further Instructions");
			result=false;
		}
	else
	{
		for(ASLModel jobseekermodel :jobseekerModelList)
		{
			System.out.println("\n|REFERENCE_ID|JOBSEEKER_ID||jobpost_id||admin_status||tr_status||hr_status|" );
			System.out.println(jobseekermodel.getReference_id()+"|"+jobseekermodel.getJobseekerId()+"|"+jobseekermodel.getJobpostId()+"|"+jobseekermodel.getAdminStatus()+"|"+jobseekermodel.getTrStatus()+"|"+jobseekermodel.getHrStatus()+"|");
			result=true;
		}	
	}
		return result;	
	}

	
@Override
public boolean TrShortlist() {

		//result=trdao.TrShortlist();
		
		List<ASLModel>jobseekerModelList=new ArrayList<>();

		jobseekerModelList=trdao.getAllJobSeekers();
		if(jobseekerModelList.isEmpty()) 
		{
			System.out.println(" Sorry,there are no Applications to ShortList\n Contact Admin or Please wait for further Instructions");
			result=false;
		}
	else
		{
		result=trdao.TrShortlist();
		}
		return result;
			
		
	}

@Override
public void rate_comment() {
		// TODO Auto-generated method stub
		List<RateAndCommentModel>ratecomment=new ArrayList<>();
 		List<JobseekerEntity>jobseekerList;
 		
		
	}

}


