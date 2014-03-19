package examples;

public class BarBean {
	private BazBean bazBean;
	
	public void setBazBean(BazBean bazBean) {
		this.bazBean = bazBean;
	}
	
	public void init() {
		System.out.println("BarBean.init");
	}

	public void destroy() {
		System.out.println("BarBean.destroy");
	}
}
