package com.greedy.section02.xmlconfig;

//행위를 강제화 놓을 목적으로 사용
public interface MemberDAO {
	
	//회원 번호로 회원 정보를 조회하는 메소드
	MemberDTO selectMember(int sequence);
	
	//회원 정보를 저장하고 결과를 리턴하는 메소드
	boolean insertMember(MemberDTO newMember);
}
