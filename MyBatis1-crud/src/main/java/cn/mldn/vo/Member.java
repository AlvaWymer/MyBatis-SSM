package cn.mldn.vo;

import java.io.Serializable;
import java.util.Date;

public class Member implements Serializable {
	private Long mid;
	private String name;
	private Integer age;
	private Date birthday;
	private Double salary;
	private String note;
	public void setMid(Long mid) {
		this.mid = mid;
	}
	public Long getMid() {
		return mid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	@Override
	public String toString() {
		return "member [mid=" + mid + ", name=" + name + ", age=" + age + ", birthday=" + birthday + ", salary="
				+ salary + ", note=" + note + "]";
	}
	

}
