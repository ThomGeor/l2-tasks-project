package exceptions;

import network.Member;
import network.Service;

/**
 * Thrown when the Member doesn't have the Exception
 * */
public class DontHaveService extends Exception {
    private Member member;
    private Service service;

    public DontHaveService(String message, Member member, Service service){
        super(message);
        this.member = member;
        this.service = service;
    }

    public Member getMember() {
        return member;
    }

    public Service getService() {
        return service;
    }
}
