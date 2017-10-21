
import java.sql.SQLException;
import java.util.ArrayList;

import dao.*;
import bean.*;
public class test {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
      try {
		DaoSql db = new DaoSql();
		
		//��ȡ������Ʒ
		System.out.println("��ȡ������Ʒ");
		
		ArrayList<Stuff> stuffList=db.getStuffsAll();
		for (int i = 0; i < stuffList.size(); i++) {
			Stuff tempStuff=stuffList.get(i);
		System.out.println("��Ʒid��"+tempStuff.getSid()+"  ��Ʒ��"+tempStuff.getSname()+"   ��Ʒ�۸�"+tempStuff.getPrice());	
		}
		
		//��ȡ�ʺ�Ϊ�׾����ղ���Ʒ��
		System.out.println("��ȡ�ʺ�Ϊ�׾����ղ���Ʒ��");
		
		String uid="baijing";
		
		ArrayList<Stuff> stuffListcs=db.getStuffsSC(uid);
		for (int i = 0; i < stuffListcs.size(); i++) {
			Stuff tempStuff=stuffListcs.get(i);
		System.out.println("��Ʒid��"+tempStuff.getSid()+"  ��Ʒ��:"+tempStuff.getSname()+"   ��Ʒ�۸�"+tempStuff.getPrice());	
		}
		
		//��ȡ�ʺ�Ϊbaijing�Ĺ��ﳵ��Ʒ��
		System.out.println("��ȡ�ʺ�Ϊ�׾��Ĺ��ﳵ��Ʒ��");
		ArrayList<Stuff> stuffListgwc=db.getStuffsGWC(uid);
		for (int i = 0; i < stuffListgwc.size(); i++) {
			Stuff tempStuff=stuffListgwc.get(i);
		System.out.println("��Ʒid��"+tempStuff.getSid()+"  ��Ʒ��:"+tempStuff.getSname()+"   ��Ʒ�۸�"+tempStuff.getPrice()+"  ����������"+tempStuff.getNum());	
		}
		
		//��ȡ��ݮζ��Ʒ
		String taste="��ݮ";
		System.out.println("��ȡ��ݮζ��Ʒ��");
		ArrayList<Stuff> stuffListTaste=db.getStuffsByTaste(taste);
		for (int i = 0; i < stuffListTaste.size(); i++) {
			Stuff tempStuff=stuffListTaste.get(i);
		System.out.println("��Ʒid��"+tempStuff.getSid()+"  ��Ʒ��:"+tempStuff.getSname()+"   ��Ʒ�۸�"+tempStuff.getPrice()+"  ����������"+tempStuff.getNum());	
		}
		
		//��ȡyoghourt������Ʒ
		String type="yoghourt";
		System.out.println("��ȡyoghourt������Ʒ");
		ArrayList<Stuff> stuffListType=db.getStuffsByType(type);
		for (int i = 0; i < stuffListType.size(); i++) {
			Stuff tempStuff=stuffListType.get(i);
		System.out.println("��Ʒid��"+tempStuff.getSid()+"  ��Ʒ��:"+tempStuff.getSname()+"   ��Ʒ�۸�"+tempStuff.getPrice()+"  ����������"+tempStuff.getNum());	
		}
				
		//����baijing�ʺ��Ƿ��Ѵ���
		System.out.println("\n����׾��ʺ��Ƿ��Ѵ���\n");
		uid="baijing";
		if(db.checkRegister(uid))
			System.out.println("�ʺ�baijing�Ѵ���");
		else 
			System.out.println("�ʺ�baijing������");
		
		//����baijing�ʺ������Ƿ���ȷ
		System.out.println("\n�����ʺ�baijing����baijing111�Ƿ���ȷ\n");
		uid="baijing";
		String password ="baijing111";
		if(db.checkLogin(uid, password))
		System.out.println("�ʺź�������ȷ");
		else 
		System.out.println("�ʺŻ����벻��ȷ");
		
		//��ȡbaijing�ʺ���Ϣ
		System.out.println("\n��ȡbaijing�ʺ���Ϣ\n");
		if(db.checkLogin(uid, password)){
		User user = db.getUser(uid, password);
		System.out.println("   �ʺţ�    "+user.getUid()+"  ���룺    "+user.getPassword()+"   �绰��    "+user.getPhone()+"   ͷ��·�� ��    "+user.getHeadphoto()+"   ǩ����    "+user.getText());
		}
		else 
		System.out.println("�ʺŻ����벻��ȷ");
		
		//��ȡbaijing�ʺŵ�ַ��Ϣ
		System.out.println("\n��ȡbaijing�ʺŵ�ַ��Ϣ\n");
		ArrayList<Address> addressesList=db.getAddressesByUid(uid);
		for (int i = 0; i < addressesList.size(); i++) {
			int j=i+1;
			if (addressesList.get(i).getDeft())
			System.out.println("��"+j+"����ַΪ��"+addressesList.get(i).getAddress()+"  ��Ĭ�ϵ�ַ");
			else 
			System.out.println("��"+j+"����ַΪ��"+addressesList.get(i).getAddress()+"  ����Ĭ�ϵ�ַ");	
		
		}
		
		//��ȡ������Ʒ����Ϣ
		System.out.println("\n��ȡ������Ʒ����Ϣ\n");
		Stuff tempStuff =db.getStuffBySid(1);
		System.out.println("��Ʒid��"+tempStuff.getSid()+"  ��Ʒ��:"+tempStuff.getSname()+"   ��Ʒ�۸�"+tempStuff.getPrice()+"  ����������"+tempStuff.getNum());	
		
		//����һ���ղؼ�¼
		System.out.println("\n����һ���ղؼ�¼\n");
		if(db.setScById(2, "xinghy"))
			System.out.println("\n�����ղسɹ�\n");
		else 
			System.out.println("\n�����ղ�ʧ��\n");
		
		//���붩����¼
		System.out.println("\n���붩����¼\n");
		db.setDdById(2, "xinghy", 3);
		System.out.println("\n���붩���ɹ�\n");
		//����һ�����ﳵ��¼
		System.out.println("\n����һ�����ﳵ��¼\n");
		db.setGwcById(2, "xinghy", 3);
		System.out.println("\n���빺�ﳵ�ɹ�\n");
		//����һ�����ﳵ��¼
		System.out.println("\n����һ�����ﳵ��¼\n");
		db.setGwcNum(2, "xinghy", 3);
		System.out.println("\n���ĳɹ�\n");
		//ɾ��һ���ղؼ�¼
		System.out.println("\nɾ��һ���ղؼ�¼\n");
		db.deletScById(2, "xinghy");
		System.out.println("\nɾ���ɹ�\n");
		//ɾ��һ�����ﳵ��¼
		System.out.println("\nɾ��һ�����ﳵ��¼\n");
		db.deletGwcById(2, "xinghy");
		System.out.println("\nɾ���ɹ�\n");
		
		//����ղؼ�¼
		System.out.println("\n����ղؼ�¼\n");
		if(db.checkScById(20, "xinghy"))
			System.out.println("\n�ղش���\n");
		else
			System.out.println("\n�ղز�����\n");
		

		//��ȡ�ʺ�Ϊbaijing�Ķ�����Ʒ��
		System.out.println("��ȡ�ʺ�Ϊ�׾��Ķ�����Ʒ��");
		ArrayList<Stuff> stuffListdd=db.getStuffsDd(uid);
		for (int i = 0; i < stuffListdd.size(); i++) {
			 tempStuff=stuffListdd.get(i);
		System.out.println("��Ʒid��"+tempStuff.getSid()+"  ��Ʒ��:"+tempStuff.getSname()+"   ��Ʒ�۸�"+tempStuff.getPrice()+"  ����������"+tempStuff.getNum()+"  ������ţ� "+tempStuff.getDid());	
		}
		
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		System.out.print("����س���");
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		System.out.print("���ݿ���ʳ���");
		e.printStackTrace();
	}     
 }
}
