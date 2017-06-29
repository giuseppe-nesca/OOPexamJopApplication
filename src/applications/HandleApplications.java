package applications;

import java.util.*;
import java.util.stream.Collectors;

public class HandleApplications {
	
	private Map<String,Skill> skills = new HashMap<String, Skill>();
	private Map<String, Position> positions = new HashMap<String, Position>();
	private Map<String, Applicant> applicants = new HashMap<String, Applicant>();


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
		Map<String, Skill> appSkills = new HashMap<String, Skill>();
		Map<String, Integer> skillLv = new HashMap<String, Integer>();
		if(applicants.containsKey(name)){
			throw new ApplicationException();
		}
		String[] splittedStrings = capabilities.split(",");
		for (String capability : splittedStrings) {
			String[] ss = capability.split(":");
			if (!skills.containsKey(ss[0])){throw new ApplicationException();}
			Skill skill = skills.get(ss[0]);
			int lv = new Integer(ss[1]);
			if (lv < 1 || lv > 10) {throw new ApplicationException();}
			appSkills.put(skill.getName(), skill);
			skillLv.put(skill.getName(), lv);
		}
		applicants.put(name,new Applicant(name, appSkills, skillLv));
	}
	
	public String getCapabilities(String applicantName) throws ApplicationException {
		if(!applicants.containsKey(applicantName)){throw new ApplicationException();}
		Set<String> resultSet = applicants.get(applicantName).getskills().stream()
		.sorted(Comparator.comparing(Skill::getName))
		.map(Skill::getName)
		.collect(Collectors.toSet());
		if (resultSet.isEmpty()) {
			return "";
		}
		return resultSet.toString();
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

