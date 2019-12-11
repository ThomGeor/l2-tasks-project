package network;

import java.util.ArrayList;
import java.util.Random;

public class Task {
    private Service service;
    private Member beneficiary;
	private ArrayList<Member> participants;
	private int numberParticipants;
    private double duration;
    private int cost; // Save the cost if the task is executed
    private boolean volunteer;
    private boolean finished; // The admin can finish it when participants are found

    public Task(Service service, Member beneficiary, int numberParticipants, double duration, boolean volunteer) {
        this.service = service;
        this.beneficiary = beneficiary;
        this.numberParticipants = numberParticipants;
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

	public int getNumberParticipants() {
		return numberParticipants;
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
	public void findParticipants() throws NotEnoughPotentielParticipants{
		// Construct the list of Members that can do this Service
		ArrayList<Member> potentialParticipants = new ArrayList<Member>();
		for(Member member : this.beneficiary.getNetwork().getNetworkList()){
			// The member can do the Service
			if(member.getServices().contains(this.service)){
				potentialParticipants.add(member);
			}
		}

		// If not enough Members purposing the Service in the Network
		if(potentialParticipants.size() < this.numberParticipants){
			throw new NotEnoughPotentielParticipants();
		}

		// Choose the number of participants
		Random rand = new Random();
		for(int i=0; i<this.numberParticipants; i++){
			// Get ID of chosen Member
			int potPartId = rand.nextInt(potentialParticipants.size());

			// Add to participants and remove from potential participants
			this.participants.add(potentialParticipants.get(potPartId));
			potentialParticipants.remove(potPartId);
		}
	}

    // Executes the task, pay the participants and debits the beneficiary
	// Only done by admin
    // Change status : finished = true
    public void execute() {

    }
}
