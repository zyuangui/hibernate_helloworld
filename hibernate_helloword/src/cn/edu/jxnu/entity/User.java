package cn.edu.jxnu.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import org.hibernate.annotations.GenericGenerator;

@Entity
//@GenericGenerator(name="_uuid",strategy="uuid") //这是使用了hibernate的方式中uuid,推荐使用
@Table(name="t_user")
public class User {

	private int uid;
	@Id
	
	//@GeneratedValue(generator="_uuid") //hibernate的方式
	
	//使用的是jpn的方式   jdk  注意引入的包与使用hibernate方式是不一样的
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "table")
	@TableGenerator(name = "table", //
		table = "mid_table", //
		pkColumnName = "gen_name", //
		pkColumnValue = "t_user", //
		valueColumnName = "gen_value", //
		allocationSize = 10)
	
	@Column(name="Id")
	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}
	
	private String name;
	@Column(name="Name",length=30)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	private int age;
	@Column(name="Age")
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	private String sex;
	@Column(name="Sex")
	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}
	
	
}
