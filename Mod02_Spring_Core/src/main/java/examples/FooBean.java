package examples;

import java.util.List;

public class FooBean {
	private List<Integer> intList;

	public List<Integer> getIntList() {
		return intList;
	}

	public void setIntList(List<Integer> intList) {
		this.intList = intList;
	}
	
	public void init() {
		System.out.println("FooBean.init");
	}

	public void destroy() {
		System.out.println("FooBean.destroy");
	}
}
