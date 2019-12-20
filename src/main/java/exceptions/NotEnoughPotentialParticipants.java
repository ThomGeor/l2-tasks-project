package exceptions;

import network.Service;

/* Exception when there aren't enough participants to do the task in the Network
* */
public class NotEnoughPotentialParticipants extends Exception {
    private int neededParticipants;
    private int missingParticipants;
    private Service service;

    public NotEnoughPotentialParticipants(int neededParticipants, int missingParticipants, Service service, String message){
        super(message);
        this.neededParticipants = neededParticipants;
        this.missingParticipants = missingParticipants;
        this.service = service;
    }

    public int getNeededParticipants() {
        return neededParticipants;
    }

    public int getMissingParticipants() {
        return missingParticipants;
    }

    public Service getService() {
        return service;
    }
}
