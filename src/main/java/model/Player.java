package model;

public class Player {

	private String nickname;
	private Step steps;
	
	public Player(String nickname) {
		this.nickname = nickname;
		this.steps = new Step(0);
	}
	
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public Step getSteps() {
		return steps;
	}
	public void setSteps(Step steps) {
		this.steps = steps;
	}
	
	public void move() {
		
	}
}
