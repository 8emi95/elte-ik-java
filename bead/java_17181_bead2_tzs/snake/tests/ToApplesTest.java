package snake.tests;

import org.junit.Test;
import snake.Apple;
import snake.Game;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class ToApplesTest
{
    @Test(expected = IllegalArgumentException.class)
    public void nullParam() {
        List<String> nullInput = null;
        List<Apple> output = Game.toApples(nullInput);
    }

    @Test
    public void emptyList() {
        List<String> emptyInput = new ArrayList<>();
        List<Apple> output = Game.toApples(emptyInput);
        assertTrue(output.isEmpty());
    }


    @Test
    public void beginWithWhitespace() {
        List<String> wrongInput = new ArrayList<>();
        wrongInput.add(" 1 2");
        List<Apple> output = Game.toApples(wrongInput);
        assertTrue(output.isEmpty());
    }

    @Test
    public void endWithWhitespace() {
        List<String> wrongInput = new ArrayList<>();
        wrongInput.add("3 4 ");
        List<Apple> output = Game.toApples(wrongInput);
        assertTrue(output.isEmpty());
    }

    @Test
    public void moreWhitespace() {
        List<String> wrongInput = new ArrayList<>();
        wrongInput.add("5  6");
        List<Apple> output = Game.toApples(wrongInput);
        assertTrue(output.isEmpty());
    }

    @Test
    public void rowOrColumnNaN() {
        List<String> wrongInput = new ArrayList<>();
        wrongInput.add("nemszam nemszam");
        List<Apple> output = Game.toApples(wrongInput);
        assertTrue(output.isEmpty());
    }

    @Test
    public void rowOrColumnNegative() {
        List<String> wrongInput = new ArrayList<>();
        wrongInput.add("-1 4");
        wrongInput.add("5  -5");
        List<Apple> output = Game.toApples(wrongInput);
        assertTrue(output.isEmpty());
    }

    @Test
    public void rowOrColumnBiggerThanNine() {
        List<String> wrongInput = new ArrayList<>();
        wrongInput.add("1 10");
        wrongInput.add("10 1");
        List<Apple> output = Game.toApples(wrongInput);
        assertTrue(output.isEmpty());
    }

    @Test
    public void lowerLimit() {
        List<String> limitInput = new ArrayList<>();
        limitInput.add("0 0");
        List<Apple> output = Game.toApples(limitInput);
        assertTrue(output.size() == 1);
    }

    @Test
    public void higherLimit() {
        List<String> limitInput = new ArrayList<>();
        limitInput.add("9 9");
        List<Apple> output = Game.toApples(limitInput);
        assertTrue(output.size() == 1);
    }

    @Test
    public void outOfLimit() {
        List<String> limitInput = new ArrayList<>();
        limitInput.add("10 10");
        List<Apple> output = Game.toApples(limitInput);
        assertTrue(output.isEmpty());
    }

    @Test
    public void correctInput() {
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
