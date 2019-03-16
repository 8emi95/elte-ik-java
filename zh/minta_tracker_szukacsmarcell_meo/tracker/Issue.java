package tracker;

import java.util.LinkedList;

public class Issue{
	private String description;
	private LinkedList<Label> labels;
	private int milestone;
	
	public Issue(String description, Label[] labels, int milestone){
		this.labels=new LinkedList<Label>();
		this.description=description;
		for(Label l : labels){
			this.labels.add(l);
		}
		this.milestone=milestone;
	}
	
	public static Issue createIssue(String text){
		String[] splitText= text.split("@");
		String newDescription;
		LinkedList<Label> newLabels=new LinkedList<Label>();
		int newMilestone;
		String newMilestoneString;
		if(splitText.length == 1){
			String[] twoParameters=text.split(":");
			if(twoParameters.length == 2){
				newDescription=twoParameters[0];
				newMilestoneString=twoParameters[1];
			}else return null;
		}else if(splitText.length == 2){
			newDescription=splitText[0];
			String[] labelsAndMilestone=splitText[1].split(":");
			if(labelsAndMilestone.length == 2){
				newMilestoneString=labelsAndMilestone[1];
				String[] splitLabels=labelsAndMilestone[0].split(",");
				for(String s : splitLabels){
					newLabels.add(new Label(s));
				}
			}else return null;
		}else return null;
		try{
			newMilestone=Integer.parseInt(newMilestoneString);
			return new Issue(newDescription,newLabels.toArray(new Label[0]),newMilestone);
		}catch(NumberFormatException e){
			return null;
		}
	}
	
	public boolean hasLabel(String name){
		for(Label l : labels){
			if(l.getName().equals(name)){
				return true;
			}
		}
		return false;
	}
	
	public String getDescription(){
		return description;
	}
	
	public LinkedList<Label> getLabels(){
		return labels;
	}
	
	public int getMilestone(){
		return milestone;
	}
}