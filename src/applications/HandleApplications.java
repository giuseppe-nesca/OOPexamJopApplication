package applications;

import java.util.*;

public class HandleApplications {
	
	private Map<String,Skill> skills = new HashMap<String, Skill>();
	private Map<String, Position> positions = new HashMap<String, Position>();


	public void addSkills(String... names) throws ApplicationException {
		for (String n : names) {
			if (skills.containsKey(n)){
				throw new ApplicationException();
			}else{
				skills.put(n, new Skill(n));
			}
		}
	}
	public void addPosition(String name, String... skillNames) throws ApplicationException {
		Map<String, Skill> requirements = new HashMap<String, Skill>();
		if (positions.containsKey(name)){
			throw new ApplicationException();
		}
		for (String skillName : skillNames) {
			if(!skills.containsKey(skillName)){
				throw new ApplicationException();
			}else{
				requirements.put(skillName, skills.get(skillName));
			}
		}
		positions.put(name, new Position(name, requirements.values()));
	}
	public Skill getSkill(String name) {return skills.get(name);}
	
	public Position getPosition(String name) {return positions.get(name);}
	
	public void addApplicant(String name, String capabilities) throws ApplicationException {
		
	}
	public String getCapabilities(String applicantName) throws ApplicationException {
		return null;
	}
	
	public void enterApplication(String applicantName, String positionName) throws ApplicationException {
		
	}
	
	public int setWinner(String applicantName, String positionName) throws ApplicationException {
		return 0;
	}
	
	public SortedMap<String, Long> skill_nApplicants() {
		return null;
	}
	public String maxPosition() {
		return null;
	}
}

