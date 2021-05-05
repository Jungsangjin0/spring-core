package com.greedy.section01.advice.xmlconfig;


public class NormalStudent implements Student{

	@Override
	public AchievementResult study(Passion passion) throws Exception {
		
		if(passion.getScore() <= 0) {
			//열정이 없다면
			throw new Exception("열정이 부족합니다! 다시 열정을 가지고 오세요!");
		}
		
		int understandingScore = 0;
		int satisfactionScore = 0;
		double employeementRate = 0;
		
		int passionScore = passion.getScore();
		
		int difficulty = 5; //수업의 난이도
		for(int i = 1; i <= 8; i++) {
			//1 ~ 8교시
			System.out.println(i + "교시 수업을 열심히 듣습니다. 오 ~ 프로그래밍이 뭔지 알 것 같습니다.");
			System.out.println("이해도와 만족도가 열정에 비례하여 올라갑니다.");
			understandingScore += difficulty + passionScore;
			satisfactionScore += difficulty + passionScore;
			
			System.out.println("하지만 신기하게 취업율은 생각보다 오르지 않습니다. 취업난이 심각하다.");
			employeementRate += difficulty + passionScore;
			
			if(i == 3) {
				System.out.println("식사하러 갑니다. 역시 밥은 당구장에서 짜장면이죠 ~ 스트레스가 풀립니다.");
				System.out.println("난 당구의 신! 자바 따윈 잊어버련");
				understandingScore  /= 2;
				satisfactionScore *= 2;
				employeementRate /= 2;
			}
		}
		
		
		return new AchievementResult(understandingScore, satisfactionScore, employeementRate);
	}

}
