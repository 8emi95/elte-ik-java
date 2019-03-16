package snake.tests;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.*;
import java.lang.*;

import snake.exception.*;
import snake.Game;
import snake.Apple;
import snake.util.Position;

public class ToApplesTest{
	
	@Test(expected = IllegalArgumentException.class)
	public void testNullParam() {
		List<String> nullParam = null;
		List<Apple> outNull = Game.toApples(nullParam);
	}

	@Test
	public void testEmptyList(){
		List<String> emptyList = new ArrayList<>();
		List<Apple> outEmpty = Game.toApples(emptyList);
		assertTrue(outEmpty.isEmpty());
	}
	
	@Test
	public void testStartsWithSpace(){
		List<String> spaceList = new ArrayList<>();
		spaceList.add(" 5");
		List<Apple> outSpace = Game.toApples(spaceList);
		assertTrue(outSpace.isEmpty());
	}

	@Test
	public void testRowNotInt(){
		List<String> notIntList = new ArrayList<>();
		notIntList.add("rossz 5");
		List<Apple> outNotInt = Game.toApples(notIntList);
		assertTrue(outNotInt.isEmpty());
	}
	
	@Test
	public void testColumnNotInt(){
		List<String> notIntList = new ArrayList<>();
		notIntList.add("5 rossz");
		List<Apple> outNotInt = Game.toApples(notIntList);
		assertTrue(outNotInt.isEmpty());
	}
	
	@Test
	public void testRowNegative(){
		List<String> negativeRow = new ArrayList<>();
		negativeRow.add("-5 5");
		List<Apple> outNegative = Game.toApples(negativeRow);
		assertTrue(outNegative.isEmpty());
	}

	@Test
	public void testRowUpperLimit(){
		List<String> upperLimitList = new ArrayList<>();
		upperLimitList.add("10 5");
		List<Apple> outLimit = Game.toApples(upperLimitList);
		assertTrue(outLimit.isEmpty());
	}
	
	@Test
	public void testLowerLimit(){
		List<String> lowerLimitList = new ArrayList<>();
		lowerLimitList.add("0 0");
		List<Apple> outLimit = Game.toApples(lowerLimitList);
		assertTrue(outLimit.size() == 1);
	}
	
	@Test
	public void testLoopTwiceRun(){
		List<String> twiceRun = new ArrayList<>();
		twiceRun.add("5 5");
		twiceRun.add("6 6");
		List<Apple> outRun = Game.toApples(twiceRun);
		assertTrue(outRun.size() == 2);
	}
	
	@Test
	public void testLoopRepeatedlyRun(){
		List<String> runList = new ArrayList<>();
		runList.add("5 5");
		runList.add("6 6");
		runList.add("7 7");
		List<Apple> outRun = Game.toApples(runList);
		assertTrue(outRun.size() == 3);
	}
}