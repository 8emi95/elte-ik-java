package tracker;


import java.util.LinkedList;
import java.io.*;

public class Tracker{
	LinkedList<Label> labels=new LinkedList<Label>();
	LinkedList<Issue> issues=new LinkedList<Issue>();
	
	public Tracker(String fileName){
		try(BufferedReader br = new BufferedReader(new FileReader(fileName))){
			String line=br.readLine();
			String[] newLabels=line.split(",");
			for(String s : newLabels){
				labels.add(new Label(s));
			}
			while(null!=(line=br.readLine())){
				Issue i = Issue.createIssue(line);
				if(i!=null){
					boolean allLabelsPresent=true;
					for(Label l: i.getLabels()){
						if(allLabelsPresent){
							allLabelsPresent=this.hasLabel(l);
						}
					}
					if(allLabelsPresent) issues.add(i);
				}
			}
		}catch(Exception e){
			
		}
	}
	
	public LinkedList<Issue> listByLabel(Label l){
		if(this.hasLabel(l)){
			LinkedList<Issue> outList=new LinkedList<Issue>();
			for(Issue i : issues){
				if(i.hasLabel(l.getName())){
					outList.add(i);
				}
			}
			return outList;
		}else return null;
	}
	
	public boolean isMilestoneComplete(int milestone){
		for(Issue i : issues){
			if(milestone==i.getMilestone()){
				return false;
			}
		}
		return true;
	}
	
	public int getNumberOfIssues(){
		return issues.size();
	}
	
	public int getNumberOfLabels(){
		return labels.size();
	}
	
	private boolean hasLabel(Label l){
		for(Label i : labels){
			if(i.isSame(l)){
				return true;
			}
		}
		return false;
	}
	
	public Issue find(String description){
		for(Issue i:issues){
			if(i.getDescription().equals(description)){
				return i;
			}
		}
		return null;
	}
}