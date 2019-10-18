package com.virtusa.helper;

import com.virtusa.dao.HRDAO;
import com.virtusa.dao.HrDAOImp;
import com.virtusa.services.HRServices;

public class FactoryHrHelper {

	public static  HrDAOImp createHRDAO(){
		HrDAOImp hrDAO=new HrDAOImp();
		return hrDAO;
		
	}


	public static HRServices createHRService() {
		// TODO Auto-generated method stub
		return null;
	}

}
