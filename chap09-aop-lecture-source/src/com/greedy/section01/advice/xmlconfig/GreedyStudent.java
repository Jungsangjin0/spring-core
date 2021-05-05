package com.greedy.section01.advice.xmlconfig;


public class GreedyStudent implements Student{

	@Override
	public AchievementResult study(Passion passion) throws Exception {
		
		if(passion.getScore() != 10) {
			throw new Exception("그리뒤 학생은 열정이 만따잉여야 한다! 다시 오세용");
		}
		

		int understandingScore = 0;
		int satisfactionScore = 0;
		double employeementRate = 0.0;
		
		int passionScore = passion.getScore();
		
		int difficulty = 10; //수업의 난이도
		for(int i = 1; i <= 8; i++) {
			//1 ~ 8교시
			System.out.println(i + "교시 수업을 열심히 듣습니다. 어렶습니다..");
			System.out.println("이해도와 만족도가 열정에 비례하여 올라갑니다.");
			understandingScore -= difficulty * passionScore;
			satisfactionScore -= difficulty * passionScore;
			
			System.out.println("취업률은 올라간다..");
			employeementRate += difficulty * passionScore;
			
			if(i == 3) {
				System.out.println("어디로 들어가는지 모르겟따요..");
				employeementRate += difficulty * passionScore;
			}
		}
		return new AchievementResult(understandingScore, satisfactionScore, employeementRate);
	}

}
