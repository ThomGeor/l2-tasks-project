package exceptions;

import network.Member;

/**
 * Member isn't in a Network
 * */
public class NotInNetwork extends Exception {
    private Member member; // Member who threw Exception

    public NotInNetwork(String message, Member member) {
        super(message);
        this.member = member;
    }

    public Member getMember() {
        return member;
    }
}
