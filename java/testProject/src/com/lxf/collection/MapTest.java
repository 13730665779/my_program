package com.lxf.collection;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * map测试，map的<key value>是entry类对象的实例
 * @author lxf
 *
 */

public class MapTest {

	//定义用来承装学生类型的对象
	public Map<String,Student> students;
	//构造器中初始化students属性
	public MapTest()
	{
		this.students = new HashMap <String,Student> ();
	}
	/**
	 * 测试添加：输入学生ID,判断是否被占用
	 * 若未被占用，则输入姓名，创建新学生对象，并且添加到students中
	 */
	public void testPut()
	{
		//创建一个Scanner对象，用来活取输入的学生ID和姓名
		Scanner console = new Scanner(System.in);
		int i = 0;
		while(i < 3)
		{
			System.out.println("请输入学生ID:");
			String ID = console.next();
			//判断该ID是否被占用
			Student st = students.get(ID);
			if(st == null)
			{
				//提示输入学生姓名
				System.out.println("请输入学生姓名：");
				String name = console.next();
				//创建新学生对象
				Student newStudent = new Student(ID,name);
				//通过调用student的put方法，添加ID-学生映射
				students.put(ID, newStudent);
				System.out.println("成功添加学生：" + students.get(ID).name);
				i++;
			}else
			{
				System.out.println("该学生ID已经被占用;");
				continue;
			}
		}
	}
	/**
	 * 测试Map的KeySet方法
	 */
	public void testKeySet()
	{
		//通过KeySet方法，返回Map中的所有　“键”　的集合
		Set<String> keySet = students.keySet();
		//取得students容量
		System.out.println("总计有：" + students.size() + "个学生");
		//遍历KeySet, 取得每一个键，再调用get方法取得每个键对应的value
		for (String stuId : keySet) {
			Student st = students.get(stuId);
			if(st != null)
			{
				System.out.println("学生：" + st.name);
			}
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MapTest mt = new MapTest();
		mt.testPut();
		mt.testKeySet();
	}

}
