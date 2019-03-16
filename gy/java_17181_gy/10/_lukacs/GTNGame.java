import java.util.Random;
import java.util.Scanner;

public class GTNGame {

	public static void main(String[] args) {
		Integer maxNum = parseMaxNum(args);
		if(maxNum != null){
			int solution = new Random().nextInt(maxNum - 1) + 1;	
			GTNGame game = 
					new GTNGame(
							new Scanner(System.in), 
							maxNum, 
							solution);
			game.mainLoop();
		}
	}

	private Scanner sc;
	private int maxNum;
	private int solution;
	
	public GTNGame(Scanner sc, int maxNum, int solution){
		this.sc = sc;
		this.maxNum = maxNum;
		this.solution = solution;
	}
	
	// 3 path 
	public static Integer parseMaxNum(String[] args) {
		if (args.length != 1) {
			System.out.println("length args should be 1");
			return null;
		} else {
			int maxNum;
			try{
				maxNum = Integer.parseInt(args[0]); 
			} catch(NumberFormatException e){			
				System.out.println("args[0] should be int type");
				return null;
			}
			return maxNum;
		}
	}

	// 0,1,2
	public void mainLoop() {	
		Integer guess;
		do {
			System.out.println("waiting for input");
			guess = readUntilInt(sc);
		} while (!evalGuess(guess));
	}

	// 2 + 4 (null is!)
	public boolean evalGuess(Integer guess) {
		if (guess < 1 || guess > maxNum) {
			System.out.println("input out of bounds");
			return false;
		} else if (guess < solution) {
			System.out.println("input < solution");
			return false;
		} else if (guess > solution) {
			System.out.println("input > solution");
			return false;
		} else {
			System.out.println("victory");
			return true;			
		}
		
	}

	// 0,1,2
	public static Integer readUntilInt(Scanner sc) {
		if(sc == null) return null;
		
		Integer guess = null;		
		while (!sc.hasNextInt()) {
			sc.nextLine();
		}		
		return sc.nextInt();
	}


}
