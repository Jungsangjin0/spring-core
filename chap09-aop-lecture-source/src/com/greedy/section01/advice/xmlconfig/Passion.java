package com.greedy.section01.advice.xmlconfig;

public class Passion {

	//열정의 정도
	private int score;

	//열정의 정도 없이  열정 생성 불가
	public Passion(int score) {
		this.score = score;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return "Passion [score=" + score + "]";
	}
	
}
