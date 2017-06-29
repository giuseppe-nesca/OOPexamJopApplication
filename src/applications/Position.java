package applications;

import java.util.*;
import java.util.stream.Collectors;

import com.sun.javafx.geom.AreaOp.AddOp;

public class Position {
	
	private String name;
	private Map<String, Skill> skills = new HashMap<String, Skill>();
	private Map<String, Applicant> applicants = new HashMap<String, Applicant>();

	public Position(String name, Collection<Skill>skills){
		this.name = name;
		for (Skill skill : skills) {
			skill.addPosition(this);
			this.skills.put(skill.getName(), skill);
		}
	}
	
	public String getName() {return name;}
	
	public List<String> getApplicants() {
		return applicants.values().stream()
				.map(Applicant::getName)
				.sorted()
				.collect(Collectors.toList());
	}
	
	public void addApplicant(Applicant applicant){
		applicants.put(applicant.getName(), applicant);
	}
	
	public String getWinner() {
		return null; 
	}
	
	public boolean checkSkills(Map<String, Skill>appSkills){
		for (Skill skill : this.skills.values()) {
			if (!appSkills.containsKey(skill.getName())) {
				return false;
			}
		}
		return true;
	}
}