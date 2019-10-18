package com.virtusa.model;

import java.util.List;
import java.util.ArrayList;

public class SkillsModel {
	String s;
	List<String> skills=new ArrayList<>();
	public void setSkill(String s) {
		this.s=s;
		skills.add(s);
	}
	public void getSkill() {
		for(int i=0;i<skills.size();i++){
		return;
		//return s;
	}
}
}