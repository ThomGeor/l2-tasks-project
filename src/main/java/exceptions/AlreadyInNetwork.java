package exceptions;

import network.Member;
import network.Network;

/**
 * Exception when Member already in a Network
 * If Admin, he already created one
 * */
public class AlreadyInNetwork extends Exception {
    private Member member; // Member who threw Exception
    private Network network; // In which Network the Member is

    public AlreadyInNetwork(String message, Member member, Network network) {
        super(message);
        this.member = member;
        this.network = network;
    }

    public Member getMember() {
        return member;
    }

    public Network getNetwork() {
        return network;
    }
}
