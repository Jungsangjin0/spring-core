package com.greedy.section02.reflection;

public class Account {

	private String bankCode;
	private String accNo;
	private String accPwd;
	private int balance;
	
	public Account() {}
	
	public Account(String bankCode, String accNo, String accPwd)  {
		this.bankCode = bankCode;
		this.accNo = accNo;
		this.accPwd = accPwd;
	}

	public Account(String bankCode, String accNo, String accPwd, int balance) {
		this(bankCode, accNo, accPwd);
		this.balance= balance;
	}

	public String getBalance() {
		
		return accNo + "계좌의 현재 잔액은 " + this.balance + "원 입니다.";
	}
	
	public String deposit(int money) {
		String str = "";
		
		if(money >= 0) {
			this.balance += money;
			str = money + " 원이 입급됨";
		}else {
			str = " 금액을 잘못 입력함";
		}
		return str;
	}
	
	public String withDraw(int money) {
		String str = "";
		
		if(this.balance >= money) {
			this.balance -= money;
			str = money + " 원 출금";
		}else {
			str = "잔액이 부족합ㄴ니다,. ㅎ확인해주세요";
		}
		return str;
	}
	
	
}
