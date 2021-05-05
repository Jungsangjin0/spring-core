package com.greedy.section01.javaconfig;

import org.springframework.stereotype.Repository;

@Repository
public class PersonalAccount implements Account{

	private int backCode;
	private String accNo;
	private String accPwd;
	private int balance;
	
	public PersonalAccount(int backCode, String accNo, String accPwd) {
		this.backCode = backCode;
		this.accNo = accNo;
		this.accPwd = accPwd;
	}

	public PersonalAccount(int backCode, String accNo, String accPwd, int balance) {
		this(backCode, accNo, accPwd);
		this.balance = balance;
	}




	//잔액조회
	@Override
	public String getBalance() {
		
		return this.accNo + "계좌의 잔액은 " + this.balance + "원 입니다.";
	}

	//입금
	@Override
	public String deposit(int money) {
		
		String str = "";
		
		if(money >= 0) {
			this.balance += money;
			str = money + "원이 입금 되었습니다.";
		} else {
			str = "금액을 잘못 입력하셨습니다.";
		}
		return str;
	}

	//출금
	@Override
	public String withDraw(int money) {
		
		String str = "";
		
		if(this.balance >= money) {
			this.balance -= money;
			str = money + "원이 출금되었습니다.";
		}else {
			str = "잔액이 부족합니다. 잔액을 확인해 주세요";
		}
		
		return str;
	}

}
