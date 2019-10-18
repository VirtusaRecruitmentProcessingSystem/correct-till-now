package com.virtusa.services;

import java.util.List;

import com.virtusa.entities.JobseekerEntity;
import com.virtusa.model.JobseekerModel;

public interface TRServices {
	
	public List<JobseekerModel> getAllJobSeekers();
	public void TrShortlist();
	public void rate_comment();


}
