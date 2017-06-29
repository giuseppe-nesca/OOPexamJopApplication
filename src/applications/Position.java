package applications;

import java.util.*;

public class Position {
	
	private String name;
	Map<String, Skill> skills = new HashMap<String, Skill>();

	public Position(String name, Collection<Skill>skills){
		this.name = name;
		for (Skill skill : skills) {
			skill.addPosition(this);
			this.skills.put(skill.getName(), skill);
		}
	}
	
	public String getName() {return name;}
	
	public List<String> getApplicants() {
		return null;
	}
	
	public String getWinner() {
		return null; 
	}
}