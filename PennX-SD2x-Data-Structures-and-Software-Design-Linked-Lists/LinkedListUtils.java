
import java.util.ArrayList;
import java.util.LinkedList;

/*
 * SD2x Homework #1
 * Implement the methods below according to the specification in the assignment description.
 * Please be sure not to change the signature of any of the methods!
 */

public class LinkedListUtils {

	/*
	 * This method assumes the input LinkedList is already sorted in non-descending
	 * order (i.e.,such that each element is greater than or equal to the one that
	 * is before it, and inserts the input int value into the correct location of
	 * the list. Note that the method does not return anything, but rather modifies
	 * the input LinkedList as a side effect. If the input LinkedList is null, this
	 * method should simply terminate.
	 */
	public static void insertSorted(LinkedList<Integer> list, int input) {
		if (list == null)
			return;
		if (list.isEmpty()) {
			list.add(input);
			return;
		}

		if (input <= list.getFirst()) {
			list.addFirst(input);
			return;
		}

		if (input >= list.getLast()) {
			list.addLast(input);
			return;
		}

		if (list.contains(input)) {
			list.add(list.indexOf(input) + 1, input);
			return;
		}

		int i = 0;
		while (!(input >= list.indexOf(i))) {
			i++;
		}
		list.add(i, input);
		return;

	}

	/*
	 * This method removes all instances of the N largest values in the LinkedList.
	 * Because the values are Strings, you will need to use the String class’
	 * compareTo method to find the largest elements; see the Java API for help with
	 * that method. If the input LinkedList is null or if N is non-positive, this
	 * method should simply return without any modifications to the input
	 * LinkedList. Keep in mind that if any of the N largest values appear more than
	 * once in the LinkedList, this method should return remove all instances, so it
	 * may remove more than N elements overall. The other elements in the LinkedList
	 * should not be modified and their order must not be changed.
	 */


	public static void removeMaximumValues(LinkedList<String> list , int N) {
		if (list ==null)return; 
		if (list.isEmpty())return; 
		if (N < 0 )return; 
		int elements =0;
		if (N > list.size())  elements = list.size();
		if (N == list.size())  elements = list.size();
		if (N < list.size())  elements = N;


		for (int i = 0 ; i < elements; i++) {
			String largest = "";

			for (String word : list ) {
				if (word.compareTo(largest) > 0) {
					largest= word; 

				}
			}
			list.remove(largest);

			for (int j = 0 ; j < list.size(); j++) {
				if (list.get(j).compareTo(largest) == 0) {
					list.remove(list.get(j)); 

				}
			}


		}




	}





	/*
	 * This method determines whether any part of the first LinkedList contains all
	 * elements of the second in the same order with no other elements in the
	 * sequence, i.e. it should return true if the second LinkedList is a
	 * subsequence of the first, and false if it is not. The method should return
	 * false if either input is null or empty.
	 */


	public static <E> boolean containsSubsequence(LinkedList<E> list1  , LinkedList<E> list2 ){
		if (list1 == null || list2 == null || list1.isEmpty() || list2.isEmpty())return false; 

		for (int i = 0 ; i <  list2.size(); i++) {
			int k =i ; 
			int l = 0;
			if (list1.get(i).equals(list2.get(l))) {

				while ( list1.get(k).equals(list2.get(l)) ) {					

					if (k == list1.size()-1  ||  l == list2.size() -1) {
						for (E key : list2) {
							if (!list1.contains(key)) return false;
						}
						return true;
					}
					k++;
					l++;

				} return false; 
			}
		}
		return false;		
	}


	/*public static boolean containsSubsequence(LinkedList<Integer> one, LinkedList<Integer> two) {


		int j;
		if (one == null || two == null || one.isEmpty() || two.isEmpty())
			return false;
		for (int i = 0; i < two.size(); i++) {
			try {
				if (!(one.contains(two.get(i))))
					return false;
			} catch (Exception e) {
				continue;
			}
		}
		j = one.indexOf(two.peek());
		for (int i = j; i < two.size() + j; i++) {
			try {
				if (!(one.get(i) == two.get(i - j)))
					return false;
			} catch (Exception e) {
				continue;
			}
		}

		return true; // this line is here only so this code will compile if you don't modify it

	}*/
}
