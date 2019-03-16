package transportation.test;

import org.junit.Test;
import static org.junit.Assert.assertTrue; // !

import java.util.*;

import transportation.line.TransportationController;
import transportation.line.TransportationException;

public class TransportationTest {
    @Test
    public void noLines() throws TransportationException {
        Scanner s = new Scanner("0");
        TransportationController.readLines(s);
        assertTrue(TransportationController.getNumberOfLines() == 0);
    }

    @Test
    public void exampleLines() throws TransportationException {
        String input = "4\n29Y 4 5\nGamma 7 8\n29Y 2 3\nGamma 11 11";
        Scanner s = new Scanner(input).useDelimiter("\n");
        TransportationController.readLines(s);
        assertTrue(TransportationController.getNumberOfLines() == 2);
    }

    @Test
    public void exampleLineSize_29Y() throws TransportationException {
        String input = "4\n29Y 4 5\nGamma 7 8\n29Y 2 3\nGamma 11 11";
        Scanner s = new Scanner(input).useDelimiter("\n");
        TransportationController.readLines(s);
        assertTrue(TransportationController.sizeOf("29Y") == 4);
    }

    @Test
    public void exampleLineSize_Gamma() throws TransportationException {
        String input = "4\n29Y 4 5\nGamma 7 8\n29Y 2 3\nGamma 11 11";
        Scanner s = new Scanner(input).useDelimiter("\n");
        TransportationController.readLines(s);
        assertTrue(TransportationController.sizeOf("Gamma") == 4);
    }

    @Test
    public void wrongLine() throws TransportationException { // InvalidLine -> TransportationException
        String input = "4\nInvalidLine 4 5\nGamma 7 8\n29Y 2 3\nGamma 11 11";
        Scanner s = new Scanner(input).useDelimiter("\n");
        TransportationController.readLines(s);
        assertTrue(TransportationController.sizeOf("InvalidLine") == 0);
    }
}

/*
4
29Y 4 5
Gamma 7 8
29Y 2 3
Gamma 11 11

javac -cp .;junit-4.12.jar;hamcrest-core-1.3.jar transportation/test/TransportationTest.java

java  -cp .;junit-4.12.jar;hamcrest-core-1.3.jar org.junit.runner.JUnitCore transportation/test/TransportationTest
*/