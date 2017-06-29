package applications;

import java.util.*;
import java.util.stream.Collectors;

public class Position {
	
	private String name;
	private Map<String, Skill> skills = new HashMap<String, Skill>();
	private Map<String, Applicant> applicants = new HashMap<String, Applicant>();
	private String winner = null;

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
		return winner; 
	}
	
	public boolean checkSkills(Map<String, Skill>appSkills){
		for (Skill skill : this.skills.values()) {
			if (!appSkills.containsKey(skill.getName())) {
				return false;
			}
		}
		return true;
	}
	
	public int checkPossibleWinner(String applicantName){
		int n = 0;
		Applicant applicant = applicants.get(applicantName);
		
		for (String key : skills.keySet()) {
			n += applicant.getLvlsMap().get(key);
		}
		
		return n;
	}
	
	public boolean checkApplicant(String applicantName){
		if(applicants.containsKey(applicantName))return true;
		else return false;
	}
	
	public int getSkillsNumber(){
		return skills.size();
	}
	
	public int getApplicantsNumber(){
		return applicants.size();
	}
	
	public void setWinner(String winner){
		this.winner = winner;
	}
}