package transportation.test;
import org.junit.Test;
import static org.junit.Assert.assertTrue;
import java.util.Scanner;
import transportation.line.TransportationController;
import transportation.line.TransportationException;

public class TransportationTest {
	
	TransportationController transportationController = new TransportationController();
	
	@Test
	public void noLines() throws Exception{
		System.out.println("NOLINES");
		String input = "0";
		Scanner sc = new Scanner(input);
		transportationController.readLines(sc);
		assertTrue(transportationController.getNumberOfLines() == 0);
	}
	
	@Test
	public void exampleLines() throws Exception{
		System.out.println("EXAMPLELINES");
		String input = "4\n29Y 4 5\nGamma 7 8\n29Y 2 3\nGamma 11 11\n";
		Scanner sc = new Scanner(input);
		transportationController.readLines(sc);
		assertTrue(transportationController.getNumberOfLines() == 2);
	}
	
	@Test
	public void exampleLineSize_29Y() throws Exception{
		System.out.println("EXAMPLELINESIZE_29Y");
		String input = "4\n29Y 4 5\nGamma 7 8\n29Y 2 3\nGamma 11 11\n";
		Scanner sc = new Scanner(input);
		transportationController.readLines(sc);
		assertTrue(transportationController.sizeOf("29Y") == 4);
	}
	
	@Test
	public void exampleLineSize_Gamma() throws Exception{
		System.out.println("EXAMPLELINESIZE_GAMMA");
		String input = "4\n29Y 4 5\nGamma 7 8\n29Y 2 3\nGamma 11 11";
		Scanner sc = new Scanner(input);
		transportationController.readLines(sc);
		assertTrue(transportationController.sizeOf("Gamma") == 3);
	}

	@Test(expected = TransportationException.class)
	public void wrongLine() throws Exception{
		System.out.println("WRONGLINE");
		String input = "4\n29Y 4 5\nGamma 7 8\n29Y 2 3\nGamma 11 11\n";
		Scanner sc = new Scanner(input);
		transportationController.readLines(sc);
		transportationController.sizeOf("InvalidLine");
	}
}