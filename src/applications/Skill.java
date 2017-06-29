package applications;

import java.util.*;
import java.util.stream.Collectors;


public class Skill {

	String name;
	public Map<String, Position> positions = new HashMap<>();
	
	public Skill(String name){
		this.name = name;
	}
	
	public String getName() {return name;}
	
	public List<Position> getPositions() {
		return 
				positions.values().stream()
				.sorted(Comparator.comparing(Position::getName))
				.collect(Collectors.toList())
				;		
	}
	
	public void addPosition(Position position){
		positions.put(position.getName(), position);
	}
}