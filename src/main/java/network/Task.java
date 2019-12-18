package network;

import exceptions.MissAmountException;
import exceptions.NotEnoughPotentielParticipants;
import exceptions.TaskAlreadyExecuted;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Task {
    private Service service;
    private Member beneficiary;
	private Set<Member> participants;
	private int numberParticipants;
    private double duration;
    private int cost; // Save the cost if the task is executed, cost is given when asked
    private boolean volunteer;
    private boolean executed; // The admin can finish it when participants are found

    public Task(Service service, Member beneficiary, int numberParticipants, double duration, boolean volunteer) throws TaskAlreadyExecuted, NotEnoughPotentielParticipants {
        this.service = service;
        this.beneficiary = beneficiary;
        this.numberParticipants = numberParticipants;
        this.duration = duration;
        this.volunteer = volunteer;
        this.executed = false;
        this.participants = new HashSet<Member>();
		this.findParticipants();
		// Cost of the task according to beneficiary's class, duration and number of participants, free if volunteer
        this.cost = (volunteer) ? 0 : this.beneficiary.getSocialClass().calc((int)Math.ceil(service.getCost() * this.duration * numberParticipants));
    }

    public int getCost() { return this.cost; }

	public Service getService() {
		return service;
	}

	public Member getBeneficiary() {
		return beneficiary;
	}

	public int getNumberParticipants() {
		return numberParticipants;
	}

	public Set<Member> getParticipants() {
		return participants;
	}

	public double getDuration() {
		return duration;
	}

	public boolean isVolunteer() {
		return volunteer;
	}

	public boolean isExecuted() {
		return executed;
	}

	/**
	 * Find all participants in the Beneficiary's Network
	 * Allows to regenerate the participant list
	 *
	 * @throws NotEnoughPotentielParticipants
	 * @throws TaskAlreadyExecuted
	 * */
	public void findParticipants() throws NotEnoughPotentielParticipants, TaskAlreadyExecuted {
		if(executed){
			throw new TaskAlreadyExecuted("Can't find new participants if executed", this);
		}

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
			throw new NotEnoughPotentielParticipants(
					this.numberParticipants,
					this.numberParticipants-potentialParticipants.size(),
					this.service,
					""
			);
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

	/**
	 *  Executes the task
	* Pay the participants
	* Debits the beneficiary
	* this.finished = true
	*
	* Has normally to be executed by Admin
	 *
	 * @throws MissAmountException If the beneficiary doesn't have enough coins anymore
	 * @throws TaskAlreadyExecuted
	* */
    public void execute() throws MissAmountException, TaskAlreadyExecuted {
    	if(this.executed){
			throw new TaskAlreadyExecuted("Task already executed", this);
		}

    	// Debit the beneficiary
		// Throws MissAmountException if doesn't have enough
		this.beneficiary.debitWallet(this.cost);

		// Pay the participants
		for(Member participant : this.participants){
			participant.creditWallet(this.cost/this.numberParticipants);
		}

		// Change the status
		this.executed = true;
	}
}
