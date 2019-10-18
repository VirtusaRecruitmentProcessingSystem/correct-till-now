package com.virtusa.helper;

import com.virtusa.dao.TrDAOImp;
import com.virtusa.services.TRServices;
import com.virtusa.services.TRservicesImpl;

public class FactoryTrHelper {
			
			public  TrDAOImp createTRDAO(){
				TrDAOImp trDAO=new TrDAOImp();
				return trDAO;
				
			}
			public static TRServices createTRService(){
				TRServices trService=new TRservicesImpl();
				return trService;
			}

		

	}


