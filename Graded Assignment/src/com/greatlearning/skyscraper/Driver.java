package com.greatlearning.skyscraper;

import java.util.Scanner;
import java.util.Stack;

public class Driver {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Stack<Integer> floorsInput = new Stack<Integer>();
		Service s = new Service();
		int numberOfFloors;

		System.out.println("Enter the total no of floors in the building");
		numberOfFloors = sc.nextInt();

		for (int i = 1; i <= numberOfFloors; i++) {
			System.out.println("Enter the floor size given on day: " + i);
			int input = sc.nextInt();
			floorsInput.push(input);
		}

		s.calculateFloorOrder(floorsInput, numberOfFloors);
		sc.close();
	}

}
