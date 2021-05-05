package com.greedy.section01.javaconfig;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;


//스프링 컨테이너가 스캐닝 기능을 이용하여 해당 클래스를 bean으로 등록할 수 있는 어노테이션을 설정한다
//value 속성을사용하여 bean의 id를 설정할 수 있으며, value는 생략 가능하다.
//이름(id)를 설정하지 않으면 class의 앞 글자를 소문자로 하여 bean을 생성한다.

//@Controller, @Service, @Repository와 동일한 기능을 가지지만 각 계층을 표현하는 어노테이션은 특정 용도에 맞는
//부가 혜택이 있으므로 계층별로 구분하여 사용하는 것이 좋다.
//@Component : 스프링에서 관리되는 객체임을 표시하기 위해 사용되는 가장 기본적인 어노테이션이다.
//@Controller : WebMVC에서 사용되는 어노테이션으로 @RequestMapping 어노테이션이 작성되는 클래스에서만 사용 가능하다.
//@Service : 비지니스 로직이 작성된 클래스에서 사용된다. 추가적인 기능은 없지만 향후 제공할 가능성이 있으니 게층을 명시해서 사용한다.
//@Repository : 플랫폼별 예외를 포착하여 PersistenceExceptionranlatePostProcessor가 DataAccessException으로 변환해서 발생시킨다.

@Component(value="memberDAO")
public class MemberDAOImpl implements MemberDAO{

	private final Map<Integer, MemberDTO> memberMap;
	
	public MemberDAOImpl() {
		memberMap = new HashMap<>();
		
		memberMap.put(1, new MemberDTO(1, "user01", "pass01", "홍길동"));
		memberMap.put(2, new MemberDTO(2, "user02", "pass02", "유관순"));
	}
	
	@Override
	public MemberDTO selectMember(int sequence) {
		
		return memberMap.get(sequence);
	}

	
	@Override
	public boolean insertMember(MemberDTO newMember) {
		
		int before = memberMap.size();
		
		memberMap.put(newMember.getSequence(), newMember);
		
		int after = memberMap.size();
		
		return after > before? true : false;
	}

}
