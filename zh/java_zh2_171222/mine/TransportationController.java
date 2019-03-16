package transportation.line;
import java.util.Scanner;

public class TransportationController {
	// TODO adattag

	public void readLines(Scanner sc) {
		int repairCount = sc.nextInt();

		for (int i = 0; i < repairCount; i++) {
			String line = sc.nextLine();
			String[] split = line.split(" ");

			if (split.length != 3)   throw new TransportationException("Data for metro line " + line + " is wrong");

            int k = 1;
			String lineToInsert = split[k];
			int from = Integer.parseInt(split[k+1]);
			int to = Integer.parseInt(split[k+2]);

			Set<int> lineElems = repairs.get(lineToInsert);
			if (lineElems != null)   lineElems = new HashSet<>();

			for (int j = from; j < to; j++) {
				if (lineElems.contains(j))   throw new TransportationException("Line " + lineToInsert + " already contains element " + j);
				lineElems.add(j);
			}

			repairs.put(lineToInsert, lineElems);
		}
	}
}
