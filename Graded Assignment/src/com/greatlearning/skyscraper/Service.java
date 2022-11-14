package com.greatlearning.skyscraper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class Service {
	ArrayList<Integer> al = new ArrayList<Integer>();

	public int findLargestNumberIndex(int start, int end, int initialNumber, Stack<Integer> searchStack) {
		int largestNumberIndex = start - 1;

		for (int i = start; i < end; i++) {
			if (searchStack.elementAt(i) > initialNumber) {
				initialNumber = searchStack.elementAt(i);
				largestNumberIndex = i;
			}
		}
		return largestNumberIndex;
	}

	public void calculateFloorOrder(Stack<Integer> floorStack, int size) {
		int start = 0, end = size;
		boolean loopStatus = true;
		Service s = new Service();

		while (loopStatus) {
			int largestNumberIndex = s.findLargestNumberIndex(start + 1, end, floorStack.elementAt(start), floorStack);
			s.displayDays(start, largestNumberIndex, floorStack);
			start = largestNumberIndex + 1;

			if (start == end || start > end) {
				loopStatus = false;
			}
		}
	}

	public void displayDays(int startIndex, int largestIndex, Stack<Integer> floorStack) {

		for (int i = startIndex; i <= largestIndex; i++) {
			al.add(floorStack.elementAt(i));

			if (i == largestIndex) {
				Collections.sort(al, Collections.reverseOrder());
				ArrayList<Integer> floorsToPrint = new ArrayList<Integer>();
				int j = 0;
				boolean printedFloor = true;
				while (printedFloor) {

					if (j + 1 < al.size() && al.get(j + 1) + 1 == al.get(j)) {
						floorsToPrint.add(al.get(j));
						j++;
					} else {
						floorsToPrint.add(al.get(j));
						System.out.println("Day: " + (largestIndex + 1) + " \n"
								+ floorsToPrint.toString().replace("[", "").replace("]", "").replace(",", ""));
						floorsToPrint.clear();
						printedFloor = false;
					}
				}

				for (int k = j; k >= 0; k--) {
					al.remove(k);
				}

				break;

			} else {
				System.out.println("Day: " + (i + 1));
			}

		}
	}
}
