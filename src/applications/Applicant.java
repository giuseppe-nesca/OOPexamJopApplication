package applications;

import java.util.Collection;
import java.util.Map;

import javax.management.loading.PrivateMLet;

public class Applicant {

	private String name;
	private Map<String, Skill> skills;
	private Map<String, Integer> lvls;
	
	public Applicant(String name, Map<String, Skill>skills, Map<String,Integer>lvls){
		this.name = name;
		this.skills = skills;
		this.lvls = lvls;
	}
	
	public Collection<Skill> getskills(){
		return skills.values();
	}
}
