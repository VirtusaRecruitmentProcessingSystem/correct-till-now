package com.virtusa.services;

import java.util.List;

import com.virtusa.model.JobseekerModel;

public interface HRServices {
	public List<JobseekerModel> getTrShortlistedList();
	public void updateHRstatus();
	public void rate_comment();
}
