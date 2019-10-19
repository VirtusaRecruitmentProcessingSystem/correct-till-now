package com.virtusa.controller;

import java.util.List;

import com.virtusa.helper.FactoryHrHelper;
import com.virtusa.helper.FactoryTrHelper;

import com.virtusa.model.JobseekerModel;
import com.virtusa.services.HRServices;
import com.virtusa.services.TRServices;

import com.virtusa.services.TRservicesImpl;
import com.virtusa.ui.VRPSHome;
import com.virtusa.view.HRView;
import com.virtusa.view.JobseekerView;
import com.virtusa.view.TRView;

public class HRController
{
		private HRServices hrServices;
		HRView hrview=new HRView();
		public HRController() 
		{
			this.hrServices=FactoryHrHelper.createHRService();
		}
		
			public  void getAllJobSeekers() {

				boolean bx=hrServices. getTrShortlistedList();
			//	TRServices trservicesimp=new TRservicesImpl();
			//	trservicesimp.getAllJobSeekers();
				if(bx || !bx)
					hrview.mainMenu();
					
			}

			public  void HrShortlist() {

				boolean bx=hrServices.HrShortlist();
				if(bx || !bx)
					hrview.mainMenu();
				
				
			}

			public  void rate_comment() {
				// TODO Auto-generated method stub
				//TRServices rateandcomment=new TRservicesImpl();
				hrServices.rate_comment();
			}
		//

}
