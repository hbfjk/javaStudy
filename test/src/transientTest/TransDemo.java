package transientTest;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
 
/**
 * transient是用来防止变量被序列化的
 * 这个例子显示在对象被序列化成到x.ser，然后从x.ser反序列化, 成员变量is并没有被显示出来 
 * @author fangjk
 *
 */
class ClassLib implements Serializable {
    private transient InputStream is;
 
    private int majorVer;
    private int minorVer;
 
    ClassLib(InputStream is) throws IOException {
        System.out.println("ClassLib(InputStream) called");
        this.is = is;
        DataInputStream dis;
        if (is instanceof DataInputStream)
            dis = (DataInputStream) is;
        else
            dis = new DataInputStream(is);
        if (dis.readInt() != 0xcafebabe)
            throw new IOException("not a .class file");
        minorVer = dis.readShort();
        majorVer = dis.readShort();
    }
 
    int getMajorVer() {
        return majorVer;
    }
 
    int getMinorVer() {
        return minorVer;
    }
 
    void showIS() {
        System.out.println(is);
    }
}
 
public class TransDemo {
    public static void main(String[] args) throws IOException {
        if (args.length != 1) {
            System.err.println("usage: java TransDemo classfile");
            return;
        }
        ClassLib cl = new ClassLib(new FileInputStream(args[0]));
        System.out.printf("Minor version number: %d%n", cl.getMinorVer());
        System.out.printf("Major version number: %d%n", cl.getMajorVer());
        cl.showIS();
 
        try (FileOutputStream fos = new FileOutputStream("x.ser");
                ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(cl);
        }
 
        cl = null;
 
        try (FileInputStream fis = new FileInputStream("x.ser");
                ObjectInputStream ois = new ObjectInputStream(fis)) {
            System.out.println();
            cl = (ClassLib) ois.readObject();
            System.out.printf("Minor version number: %d%n", cl.getMinorVer());
            System.out.printf("Major version number: %d%n", cl.getMajorVer());
            cl.showIS();
        } catch (ClassNotFoundException cnfe) {
            System.err.println(cnfe.getMessage());
        }
    }
}
