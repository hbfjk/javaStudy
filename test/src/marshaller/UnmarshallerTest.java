package marshaller;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.exolab.castor.xml.MarshalException;
import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.Unmarshaller;
import org.exolab.castor.xml.ValidationException;

public class UnmarshallerTest {

	public static void main(String[] args) {
			
            try {
            	UnmarshallerBean bean = new UnmarshallerBean();
            	bean.setName("Fangjieke");
            	bean.setAge(33);
            	ClassBean classBean = new ClassBean();
            	classBean.setClassName("class1");
            	classBean.setClasssStudentNumber(54);
            	bean.setClassBean(classBean);
            	
            	File file = new File("/Users/fangjk/workspace_eclipse/test/resources/test.xml");  
				Marshaller marshaller = new Marshaller(new FileWriter(file));
				marshaller.marshal(bean);
				
				File file2 = new File("/Users/fangjk/workspace_eclipse/test/resources/test2.xml");  
				Unmarshaller unMarshaller = new Unmarshaller(UnmarshallerBean.class);
				UnmarshallerBean bean2 = (UnmarshallerBean) unMarshaller.unmarshal(new FileReader(file2));
				System.out.println(bean2.getName());
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (MarshalException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ValidationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}


	}

}
