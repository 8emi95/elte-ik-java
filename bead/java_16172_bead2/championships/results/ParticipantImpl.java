package championships.results;

import java.lang.*;

public class ParticipantImpl implements Participant {
	private String name;
	private String nation;

	public ParticipantImpl(String name, String nation) {
		if (name != null && 
			nation != null && 
			name.length() > 0 && 
			nation.length() > 0) {
			this.name = name;
			this.nation = nation;
		} else {
			throw new IllegalArgumentException();
		}
	}

	public String getName() {
		return name;
	}

	public String getNation() {
		return nation;
	}
}