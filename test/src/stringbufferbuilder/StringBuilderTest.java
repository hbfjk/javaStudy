package stringbufferbuilder;

/**
 * 10个线程，每个线程循环1000次，如果线程安全则全部执行完成后字符串长度应该都是 10 * 1000 = 10000
 * 测试结果中显示StringBuffer最终长度的确是10000
 * StringBuilder最大长度小于10000,说明StringBuilder非线程安全 
 * @author fangjk
 */
public class StringBuilderTest {

	public static void main(String[] args) {
		StringBuffer buffer = new StringBuffer();
	    StringBuilder builder = new StringBuilder();
	    for (int i = 0; i < 10; i++) {
	        new CustomThread(buffer, builder).start();
	    }
	}
	
}
class CustomThread extends Thread {
	StringBuffer buffer;
    StringBuilder builder;
	
	public CustomThread(StringBuffer buffer, StringBuilder builder) {
		this.buffer = buffer;
		this.builder = builder;
	}

	public void run() {
		for (int i = 0; i < 1000; i++) {
            buffer.append("A");
            builder.append("Z");
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("StringBuffer Size:" + buffer.length() 
            + " | "
            + "StringBuilder Size:" + builder.length());
	}
}
