package main;

import auction.Genre;
import auction.Auction;
import auction.Book;
import java.lang.Object;
import java.lang.NullPointerException;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;


public class Main{
	
	// Auction a = new Auction();
	private ArrayList<Book> books = new ArrayList<>();
	
	public static ArrayList<Book> readStock(String fileName){
		 
		 try{
			 Scanner sc = new Scanner(new File(fileName));
			while(sc.hasNext()){
			String[] tmp = sc.nextLine().split(":");
			if(tmp.length == 2){
				switch(tmp[0]) {
					case("Book") : 
					String[] books = sc.nextLine().split(";");
					for(int i = 0; i < books.length;i++){
						books.add(i);
					}
					break;
					/*case("Bid") : Main.simulate();
					break;*/
				}
			}
			}
			sc.close();
		 }
		 catch(NullPointerException e){}
 
	}
	public static void simulate(Auction a, String fileName){}
	
	/*@Override
	public String print(Auction a, String fileName){
			
	}*/
	
	public static void main(String[] args){
		if(args.length != 2){
			System.out.println("Not enough parameter");
			System.exit(1);
		} else {
			System.out.println("everything is happy");
		}
		
	}
	
}