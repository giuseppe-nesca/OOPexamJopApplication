package applications;

import java.util.Collection;
import java.util.Map;

import jdk.nashorn.internal.ir.RuntimeNode.Request;


public class Applicant {

	private String name;
	private Map<String, Skill> skills;
	private Map<String, Integer> lvls;
	private Position requestedPosition = null;
	
	public Applicant(String name, Map<String, Skill>skills, Map<String,Integer>lvls){
		this.name = name;
		this.skills = skills;
		this.lvls = lvls;
	}
	
	public String getName(){return name;}
	
	public Collection<Skill> getskills(){
		return skills.values();
	}
	
	public Map<String,Skill> getSkillsMap(){
		return skills;
	}
	
	public Map<String, Integer> getLvlsMap(){
		return lvls;
	}
	
	public Position getRequestedPosition(){
		return requestedPosition;
	}
	
	public void setRequestedPosition(Position p){
		requestedPosition = p;
	}
}
