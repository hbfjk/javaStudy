package test;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;

import Utils.Printer;

public class Test {
	
	public static void main(String[] args) {
		
		String arraysToString = Arrays.toString(new String[]{"1","2"});
		Printer.print(arraysToString);
		
		File file = new File("/opt");
		if(file.exists()) {
			Printer.println("file exist");
		} else {
			Printer.println("file not exist");
		}
		
		int a=3;
		int b;
		setInt(b=a);
		
		HashSet<String> set = new LinkedHashSet();
		set.add("a");
		set.add("a");
		
		String[] strings = new String[19];
		
		for(String str : strings) {
			Printer.print(str);
		}
		
		List<String> list = new ArrayList<String>();
		list.add("1");
		list.add("2");
		list.add("3");
		list.add("4");
		list.add("5");
		list.add("6");
		list.add("7");
		list.add("8");
		list.add("9");
		
		for(String temp : list) {
			if("1".equals(temp)) {
				list.remove(temp);
			}
		}
		
		Iterator<String> itr = list.iterator();
		while(itr.hasNext()) {
			Printer.println((String) itr.next());
		}
		
		Boolean.getBoolean("com.ibm.bpm.config.model.simpleType.ComponentType.ProductInsights.isDbCapability");
		
		"key099".hashCode();
		int r = 8 % 4;
		String key="key099";
		int h;
		System.out.println(key.hashCode());
		System.out.println("key099".hashCode()>>>16);
		int hash = (h = key.hashCode()) ^ (h >>> 16);
		System.out.println(15 & hash);
		System.out.println((h = key.hashCode()));
	}

	private static void setInt(int i) {
		Printer.print(i);
	}

//	public static void main(String[] args) {
//		StringBuffer a = new StringBuffer("A");
//		StringBuffer b = new StringBuffer("B");
//		operate(a,b);
//		System.out.println("a:" + a);
//		System.out.println("b:" + b);
//	}
	
	public static void operate(StringBuffer x, StringBuffer y) {
		x.append("C");
		y.append("C");
		y.append(x);
		y=x	;
		System.out.println("x:" + x);
		System.out.println("y:" + y);
	}

}
