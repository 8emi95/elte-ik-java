package championships.results;

import java.lang.Object;

public final class Factory extends Object {
	public static Results createResults() {
		Results results = new ResultsImpl();
		return results;
	}
}