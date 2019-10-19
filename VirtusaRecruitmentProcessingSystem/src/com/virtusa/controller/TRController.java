package com.virtusa.controller;

import java.util.List;

import com.virtusa.helper.FactoryTrHelper;

import com.virtusa.model.JobseekerModel;

import com.virtusa.services.TRServices;

import com.virtusa.services.TRservicesImpl;
import com.virtusa.ui.VRPSHome;
import com.virtusa.view.JobseekerView;
import com.virtusa.view.TRView;

public class TRController
{
		private TRServices trServices;
		TRView trview=new TRView();
		public TRController() 
		{
			this.trServices=FactoryTrHelper.createTRService();
		}
		
			public  void getAllJobSeekers() {

				boolean bx=trServices.getAllJobSeekers();
			//	TRServices trservicesimp=new TRservicesImpl();
			//	trservicesimp.getAllJobSeekers();
				if(bx || !bx)
					trview.mainMenu();
					
			}

			public  void TrShortlist() {

				boolean bx=trServices.TrShortlist();
				if(bx || !bx)
					trview.mainMenu();
				
				
			}

			public  void rate_comment() {
				// TODO Auto-generated method stub
				TRServices rateandcomment=new TRservicesImpl();
				rateandcomment.rate_comment();
			}
		//

}
