package network;

import java.util.ArrayList;

public class Task {
	private Service service; 
	private Member beneficiary;
	private ArrayList<Member> participants;
	private double duration;
	private int cost; // Save the cost if the task is executed
	private boolean volunteer;
	private boolean finished;
	
	public Task (Service service, Member beneficiary, ArrayList<Member> participants, double duration, boolean volunteer) {
		this.service        = service; 
		this.beneficiary    = beneficiary; 
		this.participants   = participants;
		this.duration       = duration;
    this.volunteer      = volunteer;
    this.finished       = false;
	}
  
  // Return cost of the task according to beneficiary's class, duration and number of participants
  // If finished doesn't recalculate
	public int getCost() {
		return (volunteer) ? 0 : Math.ceil(this.beneficiary.getSocialClass().calcPrice(this.duration * this.participants.size()));
  }
  
  // Executes the task, pay the participants and debits the beneficiary
  // Change status
  public void execute(){

  }
}
