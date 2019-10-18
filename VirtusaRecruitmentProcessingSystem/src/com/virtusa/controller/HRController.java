package com.virtusa.controller;
import java.util.List;
import com.virtusa.helper.FactoryHrHelper;
//import com.virtusa.helper.RequestType;
import com.virtusa.model.JobseekerModel;
import com.virtusa.services.HRServices;
import com.virtusa.services.HRservicesImp;
//import com.virtusa.services.TRservicesImp;
import com.virtusa.ui.VRPSHome;
import com.virtusa.view.JobseekerView;

public class HRController
{
		private HRServices hrServices;
	
	//
		public HRController() 
		{
			this.hrServices=FactoryHrHelper.createHRService();
		}
		
	//	public void handleRetrieveJobseeker(RequestType request) 
		public void handleRetrieveJobseeker(){
			
			JobseekerView jobseekerView=new JobseekerView();
			//List<JobseekerModel> models=hrServices.retrieveJobseekers();
			VRPSHome vrpshome=new VRPSHome();
	
			
		}
		
			public void userAuthentication(String userName, String password) {
			// TODO Auto-generated method stub
			
			
			
		}
/*
			public static void getTrShortlistedList() {
				// TODO Auto-generated method stub
				HRservicesImp hrservicesimp=new HRservicesImp();
				hrservicesimp.getTrShortlistedList();
			}

			public static void updateHRstatus() {
				// TODO Auto-generated method stub
				HRservicesImp hrstatus=new HRservicesImp();
				hrstatus.updateHRstatus();
		
			}

			public static void rate_comment() {
				// TODO Auto-generated method stub
				HRservicesImp hrstatus=new HRservicesImp();
				hrstatus.rate_comment();
		
				
			}
		
*/
}
