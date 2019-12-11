package network;

import java.util.ArrayList;

public class Task {
    private Service service;
    private Member beneficiary;
	private ArrayList<Member> participants;
    private double duration;
    private int cost; // Save the cost if the task is executed
    private boolean volunteer;
    private boolean finished; // The admin can finish it when participants are found

    public Task(Service service, Member beneficiary, ArrayList<Member> participants, double duration, boolean volunteer) {
        this.service = service;
        this.beneficiary = beneficiary;
        this.participants = participants;
        this.duration = duration;
        this.volunteer = volunteer;
        this.finished = false;
    }

    // Return cost of the task according to beneficiary's class, duration and number of participants
    // If finished doesn't recalculate
    public int getCost() {
        return (volunteer) ? 0 : this.beneficiary.getSocialClass().calc((int)Math.ceil(this.duration * this.participants.size()));
    }

	public Service getService() {
		return service;
	}

	public Member getBeneficiary() {
		return beneficiary;
	}

	public ArrayList<Member> getParticipants() {
		return participants;
	}

	public double getDuration() {
		return duration;
	}

	public boolean isVolunteer() {
		return volunteer;
	}

	public boolean isFinished() {
		return finished;
	}

	/**
	 * Find all participants in the Beneficiary's Network
	 * */
	public void findParticipants(){
		
	}

    // Executes the task, pay the participants and debits the beneficiary
	// Only done by admin
    // Change status : finished = true
    public void execute() {

    }
}
