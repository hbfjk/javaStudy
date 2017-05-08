package dynamicProxy;

import static Utils.Printer.print;

import java.util.Iterator;
import java.util.TreeSet;

public class Sorting implements SortingI {

	public void redBlackTreeSort(int a[]) {
		TreeSet<Integer> treeSet = new TreeSet<Integer>();
		for (int i : a) {
			treeSet.add(i);
		}
		Iterator<Integer> itr = treeSet.iterator();
		while (itr.hasNext()) {
			print(" " + itr.next().toString());
		}
	}

	public void insertSort(int a[]) {
		print("Start insert sorting");
		for (int i = 0; i < a.length; i++) {
			for (int j = i; j > 0; j--) {
				if (a[j - 1] < a[j]) {
					int temp = a[j - 1];
					a[j - 1] = a[j];
					a[j] = temp;
				}
			}
			// print(a);
		}
	}

	public void bubbleSort(int a[]) {
		print("Start bubble sorting");
		for (int i = 0; i < a.length; i++) {
			for (int j = i + 1; j < a.length; j++) {
				if (a[j] > a[i]) {
					int temp = a[i];
					a[i] = a[j];
					a[j] = temp;
				}
			}
			// print(a);
		}
	}

}
