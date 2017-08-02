package innerclass;

import Utils.Printer;

public class Outer {
	private String outerPrivateField = "outerPrivateField";
    // 个人推荐使用getxxx()来获取成员内部类，尤其是该内部类的构造函数无参数时 
    public Inner getInner() { 
        return new Inner(); 
    }
 
    public class Inner { 
    	public String innerPublicField = "innerPublicField";
        public void print(String str) { 
            System.out.println(str); 
        } 
        private void printOuter() {
        	System.out.println(outerPrivateField);
        }
    } 
    
    public static void main(String[] args) { 
        Outer outer = new Outer(); 
        Outer.Inner inner = outer.new Inner(); 
        inner.print("Outer.new"); 
        Printer.println(inner.innerPublicField);
        inner.printOuter();
 
        inner = outer.getInner(); 
        inner.print("Outer.get"); 
    }
}
