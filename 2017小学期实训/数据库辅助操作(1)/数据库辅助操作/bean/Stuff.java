package bean;

public class Stuff {
	private int sid;
	private String  sname;
	private String  sphoto;
	private Float   price;
	private int num=0;
	private int did=0;
	/*private String  stype;
	private String  taste;*/
	public int getSid() {
		return sid;
	}
	public int getDid() {
		return did;
	}
/*	public void setSid(int sid) {
		this.sid = sid;
	}*/
	public String getSname() {
		return sname;
	}
/*	public void setSname(String sname) {
		this.sname = sname;
	}*/
	public String getSphoto() {
		return sphoto;
	}
/*	public void setSphoto(String sphoto) {
		this.sphoto = sphoto;
	}*/
	public Float getPrice() {
		return price;
	}
	public int getNum(){
		return num;
	}
/*	public void setPrice(Float price) {
		this.price = price;
	}*/
/*	public String getStype() {
		return stype;
	}
	public void setStype(String stype) {
		this.stype = stype;
	}
	public String getTaste() {
		return taste;
	}
	public void setTaste(String taste) {
		this.taste = taste;
	}*/

	public Stuff(int sid, String sname,String sphoto,Float price){
		this.sid=sid;
		this.sname=sname;
		this.sphoto=sphoto;
		this.price=price;
	}
	public Stuff(int sid, String sname,String sphoto,Float price,int num){
		this.sid=sid;
		this.sname=sname;
		this.sphoto=sphoto;
		this.price=price;
		this.num=num;
	}
	public Stuff(int sid, String sname,String sphoto,Float price,int num,int did){
		this.sid=sid;
		this.sname=sname;
		this.sphoto=sphoto;
		this.price=price;
		this.num=num;
		this.did=did;
	}
	//后台添加商品
/*	public Stuff(String sname,String sphoto,Float price){
		this.sid=0;
		this.sname=sname;
		this.sphoto=sphoto;
		this.price=price;
	}*/
}
