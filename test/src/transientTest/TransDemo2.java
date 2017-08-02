package transientTest;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * staic的transient变量是在类初始化时被set的，与序列化反序列化无关
 * @author fangjk
 *
 */
class Foo implements Serializable
{
   public static int w = 1;
   public static transient int x = 2;
   public int y = 3;
   public transient int z = 4;
}

public class TransDemo2
{
   public static void main(String[] args) throws IOException
   {
      Foo foo = new Foo();
      System.out.printf("w: %d%n", Foo.w);
      System.out.printf("x: %d%n", Foo.x);
      System.out.printf("y: %d%n", foo.y);
      System.out.printf("z: %d%n", foo.z);
      try (FileOutputStream fos = new FileOutputStream("x.ser");
           ObjectOutputStream oos = new ObjectOutputStream(fos))
      {
         oos.writeObject(foo);
      }

      foo = null;

      try (FileInputStream fis = new FileInputStream("x.ser");
           ObjectInputStream ois = new ObjectInputStream(fis))
      {
         System.out.println();
         foo = (Foo) ois.readObject();
         System.out.printf("w: %d%n", Foo.w);
         System.out.printf("x: %d%n", Foo.x);
         System.out.printf("y: %d%n", foo.y);
         System.out.printf("z: %d%n", foo.z);
      }
      catch (ClassNotFoundException cnfe)
      {
         System.err.println(cnfe.getMessage());
      }
   }
}
