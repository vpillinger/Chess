package Chess;


import info.gridworld.world.ChessWorld;

import java.util.ArrayList;
import java.util.Observer;
import java.util.TimerTask;
import java.util.Timer;
public class ChessClock extends TimerTask{
	private long timeLeft;
	private Timer selfTimer;
	private boolean running;
	private ArrayList<ChessPlayer> observers;
	/**
	 * 
	 * @param seconds the number of seconds on the clock
	 */
	public ChessClock(long milliseconds){
		super();
		init(milliseconds);
	}
	public ChessClock(long milliseconds, ArrayList<ChessPlayer> observers){
		super();
		init(milliseconds);
		this.observers = observers;
	}
	private void init(long milliseconds){
		timeLeft = milliseconds;
		selfTimer = new Timer();
		running = false;
		observers = new ArrayList<ChessPlayer>();
	}
	/**
	 * Get the remaining time left on a chessClock
	 * @return the time left in milliseconds
	 */
	public long getTimeLeft(){
		return timeLeft;
	}
	/**
	 * Start the chessClock
	 */
	public void start(){
		if(!running){
			selfTimer.scheduleAtFixedRate(this,1000, 1000);//update time every 1 second
			running = true;
		}
	}
	/**
	 * Stop the chessClock
	 */
	public ChessClock stop(){
		if(running){
			selfTimer.cancel();
			return new ChessClock(timeLeft, observers);
		}
		return this;
	}
	public void addTime(){
		
	}
	@Override
	public void run() {
		timeLeft -= 1000;
		for(ChessPlayer o:observers){
			o.updateClock(timeLeft);
		}
	}
	
	public void addObserver(ChessPlayer o){
		observers.add(o);
	}
	public void removeObserver(ChessPlayer o){
		observers.remove(o);
	}
}
