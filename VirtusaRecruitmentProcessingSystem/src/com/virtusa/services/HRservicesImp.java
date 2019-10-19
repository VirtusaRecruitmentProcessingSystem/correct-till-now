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

public class HRservicesImp implements HRServices{
	private HrDAOImp hrdao;
	boolean result=false;
	
	public HRservicesImp()
	{
		this.hrdao=FactoryHrHelper.createHRDAO();
		
	}

	public boolean HrShortlist() {

		
		List<ASLModel>jobseekerModelList=new ArrayList<>();

		jobseekerModelList=hrdao.getAllJobSeekers();
		if(jobseekerModelList.isEmpty()) 
		{
			System.out.println(" Sorry,there are no Applications to ShortList\n Contact Admin or Please wait for further Instructions");
			result=false;
		}
	else
		{
		result=hrdao.HrShortlist();
		}
		return result;
	}
	
	@Override
	public boolean getTrShortlistedList() {
		// TODO Auto-generated method stub
		List<ASLModel>jobseekerModelList=new ArrayList<>();
		jobseekerModelList=hrdao.getAllJobSeekers();
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
	public void rate_comment() {
		// TODO Auto-generated method stub
		
	}


}
 