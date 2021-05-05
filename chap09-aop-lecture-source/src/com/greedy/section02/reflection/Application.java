package com.greedy.section02.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.function.DoublePredicate;

public class Application {

	public static void main(String[] args) {
		
		//리플렉션이란?
		//컴파일 된 자바 코드에서(.class) 역으로 클래스륿 ㅜㄹ러 메소드 및 필드 정보를 구해오는 방법으로 반사, 투영이라는 의미를 가진다.
		//리플렉션은 JVM에서 실행되는 어플리케이션의 런타임 동작을 검사하거나 수정할 수 있는 기능이 필요한 경우 사용한다
		//스프링프레임워크, 마이바티스, 하이버네이트, jackson 등의 라이브러리에서 사용한다.
		//Reflection을 사용해서 스프링에서는 런타임 시에 개발자가 등록한 빈을 어플리케이션 내에 사용할 수 있게 하는 것이다.
		
		//reflcetion은 강력한 도구이지만 무분별하게 사용해서는 안된다.
		//주의 사항
		//1. 오버헤드 발생 : 성능 저하를 발생할 수 있기 때문에 성능이 민감한 어플리케이션에서는 사용하지 않는다.
		//2. 캡슐화 저해 :private 로 설정한 member에 접근 가능하기 때문에 코드 ㄱ기능이 저하되며 여러 가지 문제를 발생시킬 수 있다.
		
		//.class
		//해당 클래스의 메타정보를 갖고 있다.
		Class class1 = Account.class;
		//account의 메타정보를 가진 class타입의 class 반환
		System.out.println(class1);
		//.class를 사용하여 인스턴스 생성 가능
		//메타정보 : class 구성되어 있는 정보를 갖고있는 class
		Class class2 = new Account().getClass();
		System.out.println(class2);
		
		//실행을 해서 동적으로  class를 갖고 로드 하면서 그 메타 정보를 class 타입으로 반환받음
		//클래스를 사용할 수 있게 메모리에 로드하면서 이줄이실행되면서 동적로딩//
		//런타임시 로딩을 지원하는게 자바의 특징
		try {
			Class class3 = Class.forName("com.greedy.section02.reflection.Account");
			System.out.println(class3);
			
			Class class4 = Class.forName("[I"); //정수배열
			Class class5 = double[].class; //실수배열
			System.out.println(class4);
			System.out.println(class5);
			
			Class class6 = Class.forName("[Ljava.lang.String;");
			System.out.println(class6);
			Class class7 = String[].class; //string 배열타입
			System.out.println(class7);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
//		double d = 1.0;
//		Class class8 = d.getClass(); //원시 자료형에선 사용 불가능
		
		 Class class8 = Double.TYPE; //type:: 클래스타입의 인스턴스를 갖고있는 필드
		 System.out.println(class8);
		 
		 Class class9 = Void.TYPE;
		 System.out.println(class9); 
		 
		 //class 메타정보를 갖고 여러가지 정보를 반환받는 메소드
		 Class superClass = class1.getSuperclass();
		 //부모 클래스 정보를 class정보를 class타입 인스턴스로 반환
		 //상속받은것을 알게 됨
		 System.out.println(superClass);
		 
		 //필드를 알아보는 법
		 //java.lang.reflect
		 Field[] fields = Account.class.getDeclaredFields();
		 for(Field field : fields) {
			 //구체적인 필드 
			 //접근제한자 :: Modifier 클래스 toString 안에 field.getModifiers() 
			 //field.getModifiers :: 필드가 갖고있는 접근제한자를 정수로 반환해줌| 
			 //반환된 정수값을 modifier의 toString에 넣으면 문자열로바꿔줌
			 //private 도 알 수 있음
			 System.out.println("modifires : " + Modifier.toString(field.getModifiers()) + ", type : " + field.getType() + ", name : " + field.getName());
		 }
		 
		 //생성자
		 Constructor[] constructors = Account.class.getConstructors();
		 for(Constructor con : constructors) {
			 
			 System.out.println("name : " + con.getName());
			 //생성자가 갖고 있는 파라미터타입 class타입 반환
			 Class[] params = con.getParameterTypes();
			 for(Class param : params) {
				 System.out.println("parameterType : " + param.getTypeName());
			 }
		 }
		 
		 //생성자를 알아와 인스턴스 생성 가능
		 //생성자를 이용해 인스턴스를 생성 후 반환 object
		 
		 try {
			 
			Account acc = (Account)constructors[0].newInstance("20", "110-123-45678", "1234", 1000);
			System.out.println(acc.getBalance());
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			e.printStackTrace();
		}
		 
		 //ioc 컨테이너 getbean .class 로 정보를 넘김 
		 
		 Method[] methods = Account.class.getMethods();
		 Method getBalanceMethod = null;
		 for(Method method : methods) {
			 //object메소드도 출력
			 System.out.println(Modifier.toString(method.getModifiers()) + " " + 
					 			method.getReturnType().getSimpleName() + " " + 
					 			method.getName());
			 //getBalance 
			 if("getBalance".equals(method.getName())) {
				 getBalanceMethod = method;
			 }
		 }
		 
		 //invoke라는 메소드로 호출하ㄷ기
		 //인스턴스를 생성 후 호출 arg0 ->인스턴스 , arg1 -> 메소드 매개변수 없으면 null
		 try {
			System.out.println(getBalanceMethod.invoke((Account)constructors[2].newInstance(), null));
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| InstantiationException e) {
			e.printStackTrace();
		}
		 
	}
}
