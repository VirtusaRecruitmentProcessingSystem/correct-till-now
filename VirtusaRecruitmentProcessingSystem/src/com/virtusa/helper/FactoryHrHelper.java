package com.virtusa.helper;

import com.virtusa.dao.HRDAO;
import com.virtusa.dao.HrDAOImp;
import com.virtusa.services.HRServices;
import com.virtusa.services.HRservicesImp;

public class FactoryHrHelper {

	public static  HrDAOImp createHRDAO(){
		//HrDAOImp hrDAO=new HrDAOImp();
		return new HrDAOImp();
		
	}


	public static HRServices createHRService() {
		// TODO Auto-generated method stub
		//HRservicesImp hrsi=new HRservicesImp();
		return new HRservicesImp();
	}

}
