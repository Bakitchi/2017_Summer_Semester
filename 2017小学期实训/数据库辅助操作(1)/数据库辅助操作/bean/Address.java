package bean;

public class Address {
	private String address;//地址信息
	private Boolean deft;//是否为默认地址
	public Address(String address,Boolean deft) {
		this.address=address;
		this.deft=deft;
	}
	public String getAddress() {
		return address;
	}
	public Boolean getDeft() {
		return deft;
	}
	
}
