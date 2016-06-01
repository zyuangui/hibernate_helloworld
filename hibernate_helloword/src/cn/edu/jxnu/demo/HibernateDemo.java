package cn.edu.jxnu.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import cn.edu.jxnu.entity.User;

public class HibernateDemo {

	public static void main(String[] args) {
		User user = new User();
		//user.setUid(1);
		user.setName("sili");
		user.setAge(23);
		user.setSex("男");
		
		Configuration cfg = new Configuration().configure();
		//该处buildSessionFactory画了一根删除线，说明在这个版本中该接口已经过期，不建议使用，如果使用了那么程序里面可能会有debug
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
		session.close();
				
	}
}
