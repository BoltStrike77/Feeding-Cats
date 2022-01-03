package feed;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FeedCats {	
	private int testCases;
	private ArrayList<Integer> numberOfCats;
	private ArrayList<Integer> amountOfFood;
	private ArrayList<Integer> orderList;
	int[] catsEaten;
	int temp;
	Boolean fair;
	
	FeedCats() {
		numberOfCats = new ArrayList<Integer>();
		amountOfFood = new ArrayList<Integer>();
		orderList = new ArrayList<Integer>();
		
	}
	
	public static void main(String[] args) {
		FeedCats cats = new FeedCats();
		cats.retrieveTestCases();
		for (int i = 0; i < cats.testCases; i++) {
			if (cats.processInput(i).equals(true)) {
				System.out.println("YES");
			} else if (cats.processInput(i).equals(false)){
				System.out.println("NO");
			}
			cats.reset(i);
		}
	}
	
	private void retrieveTestCases() {
		try {
			File file = new File("src\\input\\plan.txt");
			Scanner input = new Scanner(file);
			testCases = input.nextInt();
			for (int i = 0; i < testCases; i++) {
				numberOfCats.add(input.nextInt());
				amountOfFood.add(input.nextInt());
				for (int j = 0; j < amountOfFood.get(i); j++) {
					orderList.add(input.nextInt());
				}
			}
			input.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	private Boolean processInput(int i) {
		catsEaten = new int[numberOfCats.get(i)];
		for(int x = 0; x < amountOfFood.get(i); x++)
		{
			temp = orderList.get(x);
			temp--;
			catsEaten[temp]++;
			for (int y = 0; y < numberOfCats.get(i); y++)
			{
				if(catsEaten[temp] - 1 > catsEaten[y])
				{
					return false;
				}
			}
		}
		return true;	
	}
	
	private void reset(int i) {
		for (int g = 0; g < amountOfFood.get(i); g++) {
			orderList.remove(0);
		}
		
		for (int j = 0; j < catsEaten.length; j++) {
			catsEaten[j] = 0;
		}
	}	
}	
	
	