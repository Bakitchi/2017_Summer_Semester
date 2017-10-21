package bean;

public class User {
	private String uid;
	private String password;
	private String phone;
	private String headphoto;
	private String text;
	public String getUid() {
		return uid;
	}
	/*public void setUid(String uid) {
		this.uid = uid;
	}*/
	public String getPassword() {
		return password;
	}
	/*public void setPassword(String password) {
		this.password = password;
	}*/
	public String getPhone() {
		return phone;
	}
	/*public void setPhone(String phone) {
		this.phone = phone;
	}*/
	public String getHeadphoto() {
		return headphoto;
	}
	/*public void setHeadphoto(String headphoto) {
		this.headphoto = headphoto;
	}*/
	public String getText() {
		return text;
	}
	/*public void setText(String text) {
		this.text = text;
	}	*/
	public User(String uid,String password,String phone,String headphoto,String text){
		this.uid=uid;
		this.password=password;
		this.phone=phone;
		this.headphoto=headphoto;
		this.text=text;
	}
}
