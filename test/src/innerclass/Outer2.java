package innerclass;

public class Outer2 { 
    public static void main(String[] args) { 
        Outer2 outer2 = new Outer2(); 
        Inner inner = outer2.getInner("Inner", "gz"); 
        System.out.println(inner.getName()); 
    } 
 
    public Inner getInner(final String name, String city) { 
        return new Inner() { 
            private String nameStr = name; 
 
            public String getName() { 
                return nameStr; 
            } 
        }; 
    } 
}

interface Inner { 
    String getName(); 
}