package model;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;


public class Chronometer implements ActionListener{
	private int seconds;
	private Timer chronometer;
	
	public Chronometer(){
		seconds = 0;		
		chronometer = new Timer(1000, this);
	}	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		seconds ++;
	}
	
	public int getSeconds() {
		return this.seconds;
	}
	
	public void start() {
		chronometer.start();
	}
	
	public void stop() {
		chronometer.stop();
	}
}