package bean;

public class Address {
	private String address;//��ַ��Ϣ
	private Boolean deft;//�Ƿ�ΪĬ�ϵ�ַ
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
