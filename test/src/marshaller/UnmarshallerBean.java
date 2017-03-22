package marshaller;

public class UnmarshallerBean {
	private String name;
	private int age;
	private ClassBean classBean;

	public ClassBean getClassBean() {
		return classBean;
	}
	public void setClassBean(ClassBean classBean) {
		this.classBean = classBean;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
}
