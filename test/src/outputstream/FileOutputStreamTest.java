package outputstream;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class FileOutputStreamTest {

	public static void main(String[] args) {
		Properties prop = new Properties();
		prop.put("key1","key2");
		try {
			String outputDir = "/Users/fangjk/git/javaStudy/test/resources/properties";
			if(!(new File(outputDir).exists())) {
				new File(outputDir).mkdir();
			}
			prop.store(new FileOutputStream(outputDir+File.separator+"output.properties"),"output");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
