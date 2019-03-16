package snake.tests;

import java.util.List;
import java.util.ArrayList;

import snake.*;

import org.junit.Test;
import static org.junit.Assert.*;

public class ToApplesTest {
    @Test(expected = IllegalArgumentException.class)
    public void testNullParameter() {
        ArrayList<String> wrongInput = null;
        ArrayList<Apple> nullParameter = Game.toApples(wrongInput);
        assertTrue(nullParameter.size() == 0);
    }

    @Test
    public void testEmptyList() {
        ArrayList<Apple> emptyList = Game.toApples(new ArrayList<String>());
        assertTrue(emptyList.size() == 0);
    }

    @Test
    public void testBeginsWithWhitespace() {
        ArrayList<String> list = new ArrayList<>();
        list.add(" 1 2");
        ArrayList<Apple> beginsWithWhitespace = Game.toApples(list);
        assertTrue(beginsWithWhitespace.size() == 0);
    }

    @Test
    public void testEndsWithWhitespace() {
        ArrayList<String> list = new ArrayList<>();
        list.add("1 2 ");
        ArrayList<Apple> endsWithWhitespace = Game.toApples(list);
        assertTrue(endsWithWhitespace.size() == 0);
    }

    @Test
    public void testContiansMultipleWhitespaces() {
        ArrayList<String> list = new ArrayList<>();
        list.add("1  2");
        list.add("1   2");
        ArrayList<Apple> containsMultipleWhitespaces = Game.toApples(list);
        assertTrue(containsMultipleWhitespaces.size() == 0);
    }

    @Test
    public void testIndexNaN() {
        ArrayList<String> list = new ArrayList<>();
        list.add("a 2");
        list.add("1 b");
        list.add("a b");
        ArrayList<Apple> indexNaN = Game.toApples(list);
        assertTrue(indexNaN.size() == 0);
    }

    @Test
    public void testIndexNegative() {
        ArrayList<String> list = new ArrayList<>();
        list.add("-1 2");
        list.add("1 -2");
        ArrayList<Apple> indexNegative = Game.toApples(list);
        assertTrue(indexNegative.size() == 0);
    }

    @Test
    public void testIndexTooBig() {
        ArrayList<String> list = new ArrayList<>();
        list.add("10 2");
        list.add("1 11");
        ArrayList<Apple> indexTooBig = Game.toApples(list);
        assertTrue(indexTooBig.size() == 0);
    }

    @Test
    public void testLowerLimit() {
        ArrayList<String> list = new ArrayList<>();
        list.add("0 0");
        ArrayList<Apple> lowerLimit = Game.toApples(list);
        assertTrue(lowerLimit.size() == 1);
    }

    @Test
    public void testUpperLimit() {
        ArrayList<String> list = new ArrayList<>();
        list.add("9 9");
        ArrayList<Apple> upperLimit = Game.toApples(list);
        assertTrue(upperLimit.size() == 1);
    }

    @Test
    public void testTenLimit() {
        ArrayList<String> list = new ArrayList<>();
        list.add("10 10");
        ArrayList<Apple> tenLimit = Game.toApples(list);
        assertTrue(tenLimit.size() == 0);
    }

    @Test
    public void testCorrectInput() {
        List<String> correctInputs = new ArrayList<>();
        correctInputs.add("1 1");
        correctInputs.add(" ");
        correctInputs.add("-1 4");
        correctInputs.add("10 10");
        correctInputs.add("2 1");
        correctInputs.add("5 1 7");
        correctInputs.add("3 1");
        correctInputs.add("one zero");
        correctInputs.add("4 1");
        correctInputs.add("9 9");
        List<Apple> output = Game.toApples(correctInputs);
        assertTrue(output.size() == 5);
    }
}