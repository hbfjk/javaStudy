package innerclass;

public class Parcel4 { 
    public Destination destination(String s) { 
        class PDestination implements Destination { 
            private String label; 
 
            private PDestination(String whereTo) { 
                label = whereTo; 
            } 
 
            public String readLabel() { 
                return label; 
            } 
        } 
        return new PDestination(s); 
    } 
 
    public static void main(String[] args) { 
        Parcel4 p = new Parcel4(); 
        Destination d = p.destination("Tasmania"); 
    } 
}
