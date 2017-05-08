package dynamicProxy;

import java.lang.reflect.Proxy;
import java.util.Random;

public class SortingTest {

	public static void main(String[] args) {

		Sorting sort = new Sorting();
		SortingI sortProxy = (SortingI) Proxy.newProxyInstance(SortingI.class.getClassLoader(),
				new Class[] { SortingI.class }, new StopWatchHandler(sort));
		
		int length = 10000; // 随机生成的数字个数
		/**
		 * 0: 冒泡排序
		 * 1: 插入排序
		 * 2: 红黑树排序
		 */
		int whichSort = 1;
		
		int a[] = new int[length];
		for(int i=0; i< length; i++) {
			a[i] = new Random().nextInt() % 100;
		}
		//print("排序前：");
		//print(a);
		
		/**
		 * 冒泡排序
		 */
		if (whichSort==0) {
			sortProxy.bubbleSort(a);
		}
			
		/**
		 * 插入排序
		 */
		if (whichSort==1) {
			sortProxy.insertSort(a);
		}

		/**
		 * 使用红黑树排序，注意:TreeSet和TreeMap里不支持重复数字
		 */
		if (whichSort==2) {
			sortProxy.redBlackTreeSort(a);
		}
		
		//print("排序后：");
		//print(a);
	}

}
