package transportation.line;
import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;
import java.util.HashMap;
import transportation.line.TransportationException;

public class TransportationController {
	// TODO adattag
	private HashMap<String,Set<Integer>> repairs = new HashMap<>();

	public void readLines(Scanner sc) throws TransportationException {
		int repairCount = Integer.parseInt(sc.nextLine());

		for (int i = 0; i < repairCount; i++) {
			String line = sc.nextLine();
			System.out.println(line);
			
			String[] split = line.split(" ");

			if (split.length == 3) {

				int k = 0;
				String lineToInsert = split[k];
				int from = Integer.parseInt(split[k+1]);
				int to = Integer.parseInt(split[k+2]);
				
				if(!repairs.containsKey(lineToInsert)) {
					repairs.put(lineToInsert,new HashSet<Integer>());
				}
				
				Set<Integer> lineElems = repairs.get(lineToInsert);

				for (int j = from; j <= to; j++) {
					if (lineElems.contains(j))   throw new TransportationException("Line " + lineToInsert + " already contains element " + j);
					lineElems.add(j);
				}
				
				repairs.put(lineToInsert, lineElems);
			}
		}
		
		/*for(int i = 0; i < repairs.size(); i++) {
			System.out.println(repairs.get("Gamma"));
		}*/
	}
	
	public int getNumberOfLines() {
		return repairs.size();
	}
	
	public int sizeOf(String lineName) throws TransportationException {
		if(!repairs.containsKey(lineName)) throw new TransportationException("Line " + lineName + " is unknown");
		else return repairs.get(lineName).size();
	}
}
